package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Pincel;
import co.edu.unbosque.model.PincelDTO;

/**
 * La clase {@code PincelDAO} implementa las operaciones CRUD (Crear, Leer,
 * Actualizar, Eliminar) para objetos {@link PincelDTO} utilizando un archivo de
 * texto plano para la persistencia de datos. Esta clase gestiona una lista de
 * pinceles y proporciona métodos para manipular dicha lista, asegurando la
 * sincronización con el almacenamiento persistente.
 * <p>
 * La clase utiliza {@link FileHandler} para manejar las operaciones de lectura
 * y escritura en el archivo {@code pinceles.csv}. Además, emplea
 * {@link DataMapper} para convertir entre objetos {@code Pincel} y
 * {@code PincelDTO}.
 * </p>
 * <p>
 * Esta clase no está diseñada para ser heredada.
 * </p>
 * 
 * @author MARIO RODRIGUEZ
 * @version 1.0
 * @since 2024-04-27
 */
public class PincelDAO implements CRUDOperation<PincelDTO, Pincel> {

	private ArrayList<Pincel> listaPinceles;
	private final String FILE_NAME = "pinceles.csv";

	/**
	 * Constructor de la clase {@code PincelDAO}. Inicializa la carpeta de datos y
	 * lee los datos existentes desde el archivo {@code pinceles.csv}.
	 */
	public PincelDAO() {
		FileHandler.checkFolder();
		readFile();
	}

	/**
	 * Muestra todos los pinceles almacenados en {@code listaPinceles} como una
	 * cadena de texto. Si no hay datos, retorna un mensaje indicando que no hay
	 * datos para mostrar.
	 *
	 * @return una cadena con la representación de todos los pinceles o un mensaje
	 *         indicando la ausencia de datos
	 */
	@Override
	public String showAll() {
		String rta = "";
		if (listaPinceles.isEmpty()) {
			return "No hay datos para mostrar";
		} else {
			for (Pincel pincel : listaPinceles) {
				rta += pincel + "\n";
			}
			return rta;
		}
	}

	/**
	 * Obtiene una lista de todos los pinceles como objetos {@link PincelDTO}.
	 *
	 * @return un {@code ArrayList} de {@code PincelDTO} que representa todos los
	 *         pinceles almacenados
	 */
	@Override
	public ArrayList<PincelDTO> getAll() {
		return DataMapper.listaPincelesToListaPincelesDTO(listaPinceles);
	}

	/**
	 * Agrega un nuevo pincel a la lista si no existe previamente. Utiliza
	 * {@link DataMapper} para convertir el {@code PincelDTO} a un objeto
	 * {@code Pincel}. Después de agregar, actualiza el archivo de almacenamiento
	 * persistente.
	 *
	 * @param newData el {@code PincelDTO} que se desea agregar
	 * @return {@code true} si el pincel se agregó exitosamente, {@code false} si ya
	 *         existe un pincel con el mismo nombre
	 */
	@Override
	public boolean add(PincelDTO newData) {
		if (find(DataMapper.pincelDTOToPincel(newData)) == null) {
			listaPinceles.add(DataMapper.pincelDTOToPincel(newData));
			writeFile();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Elimina un pincel de la lista si existe. Utiliza {@link DataMapper} para
	 * convertir el {@code PincelDTO} a un objeto {@code Pincel} y luego lo busca en
	 * la lista. Si se encuentra, lo elimina y actualiza el archivo de
	 * almacenamiento persistente.
	 *
	 * @param toDelete el {@code PincelDTO} que se desea eliminar
	 * @return {@code true} si el pincel se eliminó exitosamente, {@code false} si
	 *         no se encontró el pincel
	 */
	@Override
	public boolean delete(PincelDTO toDelete) {
		Pincel found = find(DataMapper.pincelDTOToPincel(toDelete));
		if (found != null) {
			listaPinceles.remove(found);
			writeFile();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Busca un pincel en la lista basado en el nombre, ignorando mayúsculas y
	 * minúsculas.
	 *
	 * @param toFind el objeto {@code Pincel} que se desea encontrar
	 * @return el objeto {@code Pincel} encontrado, o {@code null} si no se
	 *         encuentra
	 */
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
		}
		return null;
	}

	/**
	 * Actualiza un pincel existente con nuevos datos. Busca el pincel previo y, si
	 * lo encuentra, lo reemplaza con el nuevo pincel proporcionado. Luego,
	 * actualiza el archivo de almacenamiento persistente.
	 *
	 * @param previous el {@code PincelDTO} que representa el pincel a actualizar
	 * @param newData  el {@code PincelDTO} con los nuevos datos
	 * @return {@code true} si la actualización fue exitosa, {@code false} si no se
	 *         encontró el pincel previo
	 */
	@Override
	public boolean update(PincelDTO previous, PincelDTO newData) {
		Pincel found = find(DataMapper.pincelDTOToPincel(previous));
		if (found != null) {
			listaPinceles.remove(found);
			listaPinceles.add(DataMapper.pincelDTOToPincel(newData));
			writeFile();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Lee los datos de pinceles desde el archivo {@code pinceles.csv} y los carga
	 * en {@code listaPinceles}. Si el archivo está vacío o no existe, inicializa
	 * una lista vacía.
	 * <p>
	 * Nota: Hay un error en el código original donde se utiliza
	 * {@code content.split(";")} en lugar de {@code row.split(";")} dentro del
	 * bucle. Esto debe corregirse para que la separación de columnas se realice
	 * correctamente por fila.
	 * </p>
	 */
	@Override
	public void readFile() {
		String content = FileHandler.readFile(FILE_NAME);
		if (content == null || content.equals("")) {
			listaPinceles = new ArrayList<>();
		} else {
			listaPinceles = new ArrayList<>();
			String[] rows = content.split("\n");
			for (String row : rows) {
				String[] cols = row.split(";"); // Corrección: usar 'row' en lugar de 'content'
				if (cols.length < 9) {
					// Manejar filas incompletas o inválidas
					continue;
				}
				Pincel tmp = new Pincel();
				try {
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
				} catch (NumberFormatException e) {
					System.out.println("Error al parsear los datos del pincel: " + e.getMessage());
					// Continuar con la siguiente fila
				}
			}
		}
	}

	/**
	 * Escribe los datos actuales de {@code listaPinceles} en el archivo
	 * {@code pinceles.csv} en formato CSV. Cada propiedad del pincel se separa por
	 * un punto y coma (;), y cada pincel se escribe en una nueva línea.
	 */
	@Override
	public void writeFile() {
		StringBuilder content = new StringBuilder();
		for (Pincel pincel : listaPinceles) {
			content.append(pincel.getPrecioCompra()).append(";");
			content.append(pincel.getPrecioVenta()).append(";");
			content.append(pincel.getCantidad()).append(";");
			content.append(pincel.getNombre()).append(";");
			content.append(pincel.getTamanio()).append(";");
			content.append(pincel.getMarca()).append(";");
			content.append(pincel.getGrosorCerda()).append(";");
			content.append(pincel.getMaterial()).append(";");
			content.append(pincel.getTipoPincel()).append("\n");
		}
		FileHandler.writeFile(FILE_NAME, content.toString());
	}
}
