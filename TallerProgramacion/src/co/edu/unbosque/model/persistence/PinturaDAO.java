package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Pintura;
import co.edu.unbosque.model.PinturaDTO;

public class PinturaDAO implements CRUDOperation<PinturaDTO, Pintura> {

	private ArrayList<Pintura> listaPinturas;
	private final String FILE_NAME = "pinturas.csv";

	public PinturaDAO() {
		listaPinturas = new ArrayList<>();
	}

	@Override
	public String showAll() {
		String rta = "";
		if (listaPinturas.isEmpty()) {
			return "No hay pinturas en la lista";
		} else {
			for (Pintura pintura : listaPinturas) {
				rta += pintura;
			}
			return rta;
		}
	}

	@Override
	public ArrayList<PinturaDTO> getAll() {
		return DataMapper.listaPinturasToListaPinturasDTO(listaPinturas);
	}

	@Override
	public boolean add(PinturaDTO newData) {
		if (find(DataMapper.pinturaDTOToPintura(newData)) == null) {
			listaPinturas.add(DataMapper.pinturaDTOToPintura(newData));
			writeFile();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean delete(PinturaDTO toDelete) {
		Pintura found = find(DataMapper.pinturaDTOToPintura(toDelete));
		if (found != null) {
			listaPinturas.remove(found);
			writeFile();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Pintura find(Pintura toFind) { // elimina por color de pintura
		Pintura found = null;
		if (!listaPinturas.isEmpty()) {
			for (Pintura pintura : listaPinturas) {
				if (pintura.getColor().equals(toFind.getColor())) {
					found = pintura;
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
	public boolean update(PinturaDTO previous, PinturaDTO newData) {
		Pintura found = find(DataMapper.pinturaDTOToPintura(previous));
		if (found != null) {
			listaPinturas.remove(found);
			listaPinturas.add(DataMapper.pinturaDTOToPintura(newData));
			writeFile();
			return true;
		} else {
			return false;
		}
	}

	public void writeFile() {
		String content = "";
		for (Pintura pintura : listaPinturas) {
			content += pintura.getPrecioCompra() + ";";
			content += pintura.getPrecioVenta() + ";";
			content += pintura.getCantidad() + ";";
			content += pintura.getNombre() + ";";
			content += pintura.getTamanio();
			content += pintura.getMarca() + ";";
			content += pintura.getColor() + ";";
			content += pintura.getContenidoMl() + ";";
			content += pintura.isEsVinilo() + ";";
			content += pintura.isEsOleo();
			content += "\n";
		}
		FileHandler.writeFile(FILE_NAME, content);
	}

	@Override
	public void readFile() {
		String content = FileHandler.readFile(FILE_NAME);
		if (content.equals("") || content == null) {
			listaPinturas = new ArrayList<>();
		} else {
			listaPinturas = new ArrayList<>();
			String[] rows = content.split("\n");
			for (String row : rows) {
				String[] cols = content.split(";");
				Pintura pin = new Pintura();
				pin.setPrecioCompra(Double.parseDouble(cols[0]));
				pin.setPrecioVenta(Double.parseDouble(cols[1]));
				pin.setCantidad(Integer.parseInt(cols[2]));
				pin.setNombre(cols[3]);
				pin.setTamanio(cols[4]);
				pin.setMarca(cols[5]);
				pin.setColor(cols[6]);
				pin.setContenidoMl(Float.parseFloat(cols[7]));
				pin.setEsVinilo(Boolean.parseBoolean(cols[8]));
				pin.setEsOleo(Boolean.parseBoolean(cols[9]));
				listaPinturas.add(pin);
			}
		}
	}
}
