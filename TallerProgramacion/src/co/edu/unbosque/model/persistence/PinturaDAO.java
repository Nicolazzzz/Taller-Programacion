package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Pintura;
import co.edu.unbosque.model.PinturaDTO;

/**
 * La clase {@code PinturaDAO} implementa la interfaz {@code CRUDOperation} para
 * realizar operaciones de acceso a datos sobre objetos {@code Pintura}. Esta
 * clase maneja la persistencia de datos utilizando archivos CSV y archivos
 * serializados.
 * 
 * <p>
 * Autor: MARIO RODRIGUEZ
 * </p>
 * 
 * @param <PinturaDTO> el tipo de objeto de transferencia de datos
 * @param <Pintura>    el tipo de objeto que se va a almacenar
 */
public class PinturaDAO implements CRUDOperation<PinturaDTO, Pintura> {

	private ArrayList<Pintura> listaPinturas;
	private final String FILE_NAME = "pinturas.csv";
	private final String SERIAL_NAME = "pinturas.bat";

	/**
	 * Constructor de la clase {@code PinturaDAO}. Inicializa la lista de pinturas y
	 * verifica la existencia de la carpeta para los archivos de datos.
	 */
	public PinturaDAO() {
		FileHandler.checkFolder();
		readSerialized();
	}

	@Override
	public String showAll() {
		String rta = "";
		int pos = 1;
		if (listaPinturas.isEmpty()) {
			return "No hay pinturas en la lista";
		} else {
			for (Pintura pintura : listaPinturas) {
				rta += "Producto " + pos;
				pos++;
				rta += pintura + "\n" + "\n";
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
			writeSerialized();
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
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Pintura find(Pintura toFind) {
		Pintura found = null;
		if (!listaPinturas.isEmpty()) {
			for (Pintura pintura : listaPinturas) {
				if (pintura.getNombre().toLowerCase().equals(toFind.getNombre().toLowerCase())) {
					found = pintura;
					return found;
				}
			}
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
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Escribe el contenido de la lista de pinturas en un archivo CSV.
	 */
	public void writeFile() {
		String content = "";
		for (Pintura pintura : listaPinturas) {
			content += pintura.getPrecioCompra() + ";";
			content += pintura.getPrecioVenta() + ";";
			content += pintura.getCantidad() + ";";
			content += pintura.getNombre() + ";";
			content += pintura.getTamanio() + ";";
			content += pintura.getMarca() + ";";
			content += pintura.getColor() + ";";
			content += pintura.getContenidoMl() + ";";
			content += pintura.isEsVinilo();
			content += "\n";
		}
		FileHandler.writeFile(FILE_NAME, content);
	}

	/**
	 * Lee el contenido de un archivo CSV y carga las pinturas en la lista.
	 */
	@Override
	public void readFile() {
		String content = FileHandler.readFile(FILE_NAME);
		if (content.equals("") || content == null) {
			listaPinturas = new ArrayList<>();
		} else {
			listaPinturas = new ArrayList<>();
			String[] rows = content.split("\n");
			for (String row : rows) {
				String[] cols = row.split(";");
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
				listaPinturas.add(pin);
			}
		}
	}

	/**
	 * Escribe la lista de pinturas en un archivo serializado.
	 */
	public void writeSerialized() {
		FileHandler.writeSerialized(SERIAL_NAME, listaPinturas);
	}

	/**
	 * Lee la lista de pinturas desde un archivo serializado.
	 */
	@SuppressWarnings("unchecked")
	public void readSerialized() {
		Object content = FileHandler.readSerialized(SERIAL_NAME);
		if (content == null) {
			listaPinturas = new ArrayList<>();
		} else {
			listaPinturas = (ArrayList<Pintura>) content;
		}
	}

	/**
	 * Calcula la inversión total basada en el precio de compra de todas las
	 * pinturas.
	 * 
	 * @return la inversión total
	 */
	public double calculateInversion() {
		double inversion = 0;
		for (Pintura p : listaPinturas) {
			inversion += p.getPrecioCompra();
		}
		return inversion;
	}

	/**
	 * Calcula la ganancia total basada en el precio de venta de todas las pinturas.
	 * 
	 * @return la ganancia total
	 */
	public double calculateGanancia() {
		double ganancia = 0;
		for (Pintura p : listaPinturas) {
			ganancia += p.getPrecioVenta();
		}
		return ganancia;
	}

	/**
	 * Calcula la cantidad total de pinturas en la lista.
	 * 
	 * @return la cantidad total
	 */
	public int calculateCantidad() {
		int cantidad = 0;
		for (Pintura p : listaPinturas) {
			cantidad += p.getCantidad();
		}
		return cantidad;
	}
}
