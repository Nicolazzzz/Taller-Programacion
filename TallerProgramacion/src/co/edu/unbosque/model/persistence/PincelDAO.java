package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Pincel;
import co.edu.unbosque.model.PincelDTO;

public class PincelDAO implements CRUDOperation<PincelDTO, Pincel> {

	private ArrayList<Pincel> listaPinceles;
	private final String FILE_NAME = "pinceles.csv";
	private final String SERIAL_NAME = "pinceles.bat";

	public PincelDAO() {
		FileHandler.checkFolder();
		readSerialized();

	}

	@Override
	public String showAll() {

		String rta = "";
		int pos = 1;
		if (listaPinceles.isEmpty()) {
			return "No hay datos para mostrar";
		} else {
			for (Pincel pincel : listaPinceles) {
				rta += "Producto " + pos;
				pos++;
				rta += pincel + "\n" + "\n";
			}
			return rta;
		}

	}

	@Override
	public ArrayList<PincelDTO> getAll() {
		return DataMapper.listaPincelesToListaPincelesDTO(listaPinceles);
	}

	@Override
	public boolean add(PincelDTO newData) {
		if (find(DataMapper.pincelDTOToPincel(newData)) == null) {
			listaPinceles.add(DataMapper.pincelDTOToPincel(newData));
			writeFile();
			writeSerialized();
			return true;

		} else {
			return false;
		}
	}

	@Override
	public boolean delete(PincelDTO toDelete) {

		Pincel found = find(DataMapper.pincelDTOToPincel(toDelete));
		if (found != null) {
			listaPinceles.remove(found);
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Pincel find(Pincel toFind) {

		Pincel found = null;
		if (!listaPinceles.isEmpty()) {
			for (Pincel pincel : listaPinceles) {
				if (pincel.getNombre().toLowerCase().equals(toFind.getNombre().toLowerCase())) {
					found = pincel;
					return found;
				} else {
					continue;
				}
			}
		} else {
			return null;
		}
		return null;
	}

	@Override
	public boolean update(PincelDTO previous, PincelDTO newData) {
		Pincel found = find(DataMapper.pincelDTOToPincel(previous));

		if (found != null) {
			listaPinceles.remove(found);
			listaPinceles.add(DataMapper.pincelDTOToPincel(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void readFile() {
		String content = FileHandler.readFile(FILE_NAME);
		if (content.equals("") || content == null) {
			listaPinceles = new ArrayList<>();
		} else {
			listaPinceles = new ArrayList<>();
			String[] rows = content.split("\n");
			for (String row : rows) {
				String[] cols = content.split(";");
				Pincel tmp = new Pincel();
				tmp.setPrecioCompra(Double.parseDouble(cols[0]));
				tmp.setPrecioVenta(Double.parseDouble(cols[1]));
				tmp.setCantidad(Integer.parseInt(cols[2]));
				tmp.setNombre(cols[3]);
				tmp.setTamanio(cols[4]);
				tmp.setMarca(cols[5]);
				tmp.setGrosorCerda(cols[6]);
				tmp.setMaterial(cols[7]);
				tmp.setTipoPincel(cols[8]);
				listaPinceles.add(tmp);

			}
		}
	}

	@Override
	public void writeFile() {
		String content = "";
		for (Pincel pincel : listaPinceles) {
			content += pincel.getPrecioCompra() + ";";
			content += pincel.getPrecioVenta() + ";";
			content += pincel.getCantidad() + ";";
			content += pincel.getNombre() + ";";
			content += pincel.getTamanio() + ";";
			content += pincel.getMarca() + ";";
			content += pincel.getGrosorCerda() + ";";
			content += pincel.getMaterial() + ";";
			content += pincel.getTipoPincel();
			content += "\n";

		}
		FileHandler.writeFile(FILE_NAME, content);

	}

	public void writeSerialized() {
		FileHandler.writeSerialized(SERIAL_NAME, listaPinceles);
	}

	@SuppressWarnings("unchecked")
	public void readSerialized() {
		Object content = FileHandler.readSerialized(SERIAL_NAME);

		if (content == null) {
			listaPinceles = new ArrayList<>();

		} else {
			listaPinceles = (ArrayList<Pincel>) content;
		}
	}

	public double calculateInversion() {
		double inversion = 0;
		for (Pincel pincel : listaPinceles) {
			inversion += pincel.getPrecioCompra();
		}
		return inversion;
	}

	public double calculateGanancia() {
		double ganancia = 0;
		for (Pincel pincel : listaPinceles) {
			ganancia += pincel.getPrecioVenta();
		}
		return ganancia;
	}

	public int calculateCantidad() {
		int cantidad = 0;
		for (Pincel pincel : listaPinceles) {
			cantidad += pincel.getCantidad();
		}
		return cantidad;
	}

}