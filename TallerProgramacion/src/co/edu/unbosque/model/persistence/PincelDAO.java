package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Pincel;
import co.edu.unbosque.model.PincelDTO;

/**
 * La clase {@code PincelDAO} implementa la interfaz {@code CRUDOperation} para
 * realizar operaciones de acceso a datos sobre objetos {@code Pincel}. Esta
 * clase maneja la persistencia de datos utilizando archivos CSV y archivos
 * serializados.
 * 
 * <p>
 * Autor: MARIO RODRIGUEZ
 * </p>
 * 
 * @param <PincelDTO> el tipo de objeto de transferencia de datos
 * @param <Pincel>    el tipo de objeto que se va a almacenar
 */
public class PincelDAO implements CRUDOperation<PincelDTO, Pincel> {

	private ArrayList<Pincel> listaPinceles;
	private final String FILE_NAME = "pinceles.csv";
	private final String SERIAL_NAME = "pinceles.bat";

	/**
	 * Constructor de la clase {@code PincelDAO}. Inicializa la lista de pinceles y
	 * verifica la existencia de la carpeta para los archivos de datos.
	 */
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

	/**
	 * Lee el contenido de un archivo CSV y carga los pinceles en la lista.
	 */
	@Override
	public void readFile() {
		String content = FileHandler.readFile(FILE_NAME);
		if (content.equals("") || content == null) {
			listaPinceles = new ArrayList<>();
		} else {
			listaPinceles = new ArrayList<>();
			String[] rows = content.split("\n");
			for (String row : rows) {
				String[] cols = row.split(";");
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

	/**
	 * Escribe el contenido de la lista de pinceles en un archivo CSV.
	 */
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

	/**
	 * Escribe la lista de pinceles en un archivo serializado.
	 */
	public void writeSerialized() {
		FileHandler.writeSerialized(SERIAL_NAME, listaPinceles);
	}

	/**
	 * Lee la lista de pinceles desde un archivo serializado.
	 */
	@SuppressWarnings("unchecked")
	public void readSerialized() {
		Object content = FileHandler.readSerialized(SERIAL_NAME);

		if (content == null) {
			listaPinceles = new ArrayList<>();
		} else {
			listaPinceles = (ArrayList<Pincel>) content;
		}
	}

	/**
	 * Calcula la inversión total basada en el precio de compra de todos los
	 * pinceles.
	 * 
	 * @return la inversión total
	 */
	public double calculateInversion() {
		double inversion = 0;
		for (Pincel pincel : listaPinceles) {
			inversion += pincel.getPrecioCompra();
		}
		return inversion;
	}

	/**
	 * Calcula la ganancia total basada en el precio de venta de todos los pinceles.
	 * 
	 * @return la ganancia total
	 */
	public double calculateGanancia() {
		double ganancia = 0;
		for (Pincel pincel : listaPinceles) {
			ganancia += pincel.getPrecioVenta();
		}
		return ganancia;
	}

	/**
	 * Calcula la cantidad total de pinceles en la lista.
	 * 
	 * @return la cantidad total
	 */
	public int calculateCantidad() {
		int cantidad = 0;
		for (Pincel pincel : listaPinceles) {
			cantidad += pincel.getCantidad();
		}
		return cantidad;
	}
}
