package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.ProyectoMadera;
import co.edu.unbosque.model.ProyectoMaderaDTO;

/**
 * La clase {@code ProyectoMaderaDAO} implementa la interfaz
 * {@code CRUDOperation} para realizar operaciones de acceso a datos sobre
 * objetos {@code ProyectoMadera}. Esta clase maneja la persistencia de datos
 * utilizando archivos CSV y archivos serializados.
 * 
 * <p>
 * Autor: MARIO RODRIGUEZ
 * </p>
 * 
 * @param <ProyectoMaderaDTO> el tipo de objeto de transferencia de datos
 * @param <ProyectoMadera>    el tipo de objeto que se va a almacenar
 */
public class ProyectoMaderaDAO implements CRUDOperation<ProyectoMaderaDTO, ProyectoMadera> {

	private ArrayList<ProyectoMadera> listaMadera;
	private final String FILE_NAME = "madera.csv";
	private final String SERIAL_NAME = "madera.bat";

	/**
	 * Constructor de la clase {@code ProyectoMaderaDAO}. Inicializa la lista de
	 * proyectos de madera y verifica la existencia de la carpeta para los archivos
	 * de datos.
	 */
	public ProyectoMaderaDAO() {
		FileHandler.checkFolder();
		readSerialized();
	}

	@Override
	public String showAll() {
		String rta = "";
		int pos = 1;
		if (listaMadera.isEmpty()) {
			return "No hay proyectos de madera creados en la lista";
		} else {
			for (ProyectoMadera pm : listaMadera) {
				rta += "Producto " + pos;
				pos++;
				rta += pm + "\n" + "\n";
			}
			return rta;
		}
	}

	@Override
	public ArrayList<ProyectoMaderaDTO> getAll() {
		return DataMapper.listaProyectosMaderaToListaProyectosMaderaDTO(listaMadera);
	}

	@Override
	public boolean add(ProyectoMaderaDTO newData) {
		if (find(DataMapper.proyectoMaderaDTOToProyectoMadera(newData)) == null) {
			listaMadera.add(DataMapper.proyectoMaderaDTOToProyectoMadera(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean delete(ProyectoMaderaDTO toDelete) {
		ProyectoMadera found = find(DataMapper.proyectoMaderaDTOToProyectoMadera(toDelete));
		if (found != null) {
			listaMadera.remove(found);
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public ProyectoMadera find(ProyectoMadera toFind) {
		ProyectoMadera found = null;
		if (!listaMadera.isEmpty()) {
			for (ProyectoMadera madera : listaMadera) {
				if (madera.getNombre().toLowerCase().equals(toFind.getNombre().toLowerCase())) {
					found = madera;
					return found;
				}
			}
		}
		return null;
	}

	@Override
	public boolean update(ProyectoMaderaDTO previous, ProyectoMaderaDTO newData) {
		ProyectoMadera found = find(DataMapper.proyectoMaderaDTOToProyectoMadera(previous));
		if (found != null) {
			listaMadera.remove(found);
			listaMadera.add(DataMapper.proyectoMaderaDTOToProyectoMadera(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Lee el contenido de un archivo CSV y carga los proyectos de madera en la
	 * lista.
	 */
	@Override
	public void readFile() {
		String content = FileHandler.readFile(FILE_NAME);
		if (content.equals("") || content == null) {
			listaMadera = new ArrayList<>();
		} else {
			listaMadera = new ArrayList<>();
			String[] rows = content.split("\n");
			for (String row : rows) {
				String[] cols = row.split(";");
				ProyectoMadera pm = new ProyectoMadera();
				pm.setPrecioCompra(Double.parseDouble(cols[0]));
				pm.setPrecioVenta(Double.parseDouble(cols[1]));
				pm.setCantidad(Integer.parseInt(cols[2]));
				pm.setNombre(cols[3]);
				pm.setTamanio(cols[4]);
				pm.setMarca(cols[5]);
				pm.setEsCortadoMano(Boolean.parseBoolean(cols[6]));
				pm.setEsCortadoLaser(Boolean.parseBoolean(cols[7]));
				pm.setEsGrabado(Boolean.parseBoolean(cols[8]));
				listaMadera.add(pm);
			}
		}
	}

	/**
	 * Escribe el contenido de la lista de proyectos de madera en un archivo CSV.
	 */
	@Override
	public void writeFile() {
		StringBuilder content = new StringBuilder();
		for (ProyectoMadera pm : listaMadera) {
			content.append(pm.getPrecioCompra()).append(";");
			content.append(pm.getPrecioVenta()).append(";");
			content.append(pm.getCantidad()).append(";");
			content.append(pm.getNombre()).append(";");
			content.append(pm.getTamanio()).append(";");
			content.append(pm.getMarca()).append(";");
			content.append(pm.isEsCortadoMano()).append(";");
			content.append(pm.isEsCortadoLaser()).append(";");
			content.append(pm.isEsGrabado()).append("\n");
		}
		FileHandler.writeFile(FILE_NAME, content.toString());
	}

	/**
	 * Escribe la lista de proyectos de madera en un archivo serializado.
	 */
	public void writeSerialized() {
		FileHandler.writeSerialized(SERIAL_NAME, listaMadera);
	}

	/**
	 * Lee la lista de proyectos de madera desde un archivo serializado.
	 */
	@SuppressWarnings("unchecked")
	public void readSerialized() {
		Object content = FileHandler.readSerialized(SERIAL_NAME);
		if (content == null) {
			listaMadera = new ArrayList<>();
		} else {
			listaMadera = (ArrayList<ProyectoMadera>) content;
		}
	}

	/**
	 * Calcula la inversión total basada en el precio de compra de todos los
	 * proyectos de madera.
	 * 
	 * @return la inversión total
	 */
	public double calculateInversion() {
		double inversion = 0;
		for (ProyectoMadera p : listaMadera) {
			inversion += p.getPrecioCompra();
		}
		return inversion;
	}

	/**
	 * Calcula la ganancia total basada en el precio de venta de todos los proyectos
	 * de madera.
	 * 
	 * @return la ganancia total
	 */
	public double calculateGanancia() {
		double ganancia = 0;
		for (ProyectoMadera p : listaMadera) {
			ganancia += p.getPrecioVenta();
		}
		return ganancia;
	}

	/**
	 * Calcula la cantidad total de proyectos de madera en la lista.
	 * 
	 * @return la cantidad total
	 */
	public int calculateCantidad() {
		int cantidad = 0;
		for (ProyectoMadera p : listaMadera) {
			cantidad += p.getCantidad();
		}
		return cantidad;
	}
}
