package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Pintura;
import co.edu.unbosque.model.PinturaDTO;

/**
 * La clase {@code PinturaDAO} implementa las operaciones CRUD (Crear, Leer,
 * Actualizar, Eliminar) para objetos {@link PinturaDTO} utilizando un archivo
 * de texto plano para la persistencia de datos. Esta clase gestiona una lista
 * de pinturas y proporciona métodos para manipular dicha lista, asegurando la
 * sincronización con el almacenamiento persistente.
 * <p>
 * La clase utiliza {@link FileHandler} para manejar las operaciones de lectura
 * y escritura en el archivo {@code pinturas.csv}. Además, emplea
 * {@link DataMapper} para convertir entre objetos {@code Pintura} y
 * {@code PinturaDTO}.
 * </p>
 * <p>
 * Esta clase no está diseñada para ser heredada.
 * </p>
 * 
 * @author NICOLAS ZAMBRANO
 * @version 1.0
 * @since 2024-04-27
 */
public class PinturaDAO implements CRUDOperation<PinturaDTO, Pintura> {

	private ArrayList<Pintura> listaPinturas;
	private final String FILE_NAME = "pinturas.csv";

	/**
	 * Constructor de la clase {@code PinturaDAO}. Inicializa la carpeta de datos y
	 * lee los datos existentes desde el archivo {@code pinturas.csv}.
	 */
	public PinturaDAO() {
		FileHandler.checkFolder();
		readFile();
	}

	/**
	 * Muestra todas las pinturas almacenadas en {@code listaPinturas} como una
	 * cadena de texto. Si no hay datos, retorna un mensaje indicando que no hay
	 * pinturas en la lista.
	 *
	 * @return una cadena con la representación de todas las pinturas o un mensaje
	 *         indicando la ausencia de datos
	 */
	@Override
	public String showAll() {
		String rta = "";
		if (listaPinturas.isEmpty()) {
			return "No hay pinturas en la lista";
		} else {
			for (Pintura pintura : listaPinturas) {
				rta += pintura + "\n";
			}
			return rta;
		}
	}

	/**
	 * Obtiene una lista de todas las pinturas como objetos {@link PinturaDTO}.
	 *
	 * @return un {@code ArrayList} de {@code PinturaDTO} que representa todas las
	 *         pinturas almacenadas
	 */
	@Override
	public ArrayList<PinturaDTO> getAll() {
		return DataMapper.listaPinturasToListaPinturasDTO(listaPinturas);
	}

	/**
	 * Agrega una nueva pintura a la lista si no existe previamente. Utiliza
	 * {@link DataMapper} para convertir el {@code PinturaDTO} a un objeto
	 * {@code Pintura}. Después de agregar, actualiza el archivo de almacenamiento
	 * persistente.
	 *
	 * @param newData el {@code PinturaDTO} que se desea agregar
	 * @return {@code true} si la pintura se agregó exitosamente, {@code false} si
	 *         ya existe una pintura con el mismo nombre
	 */
	@Override
	public boolean add(PinturaDTO newData) {
		Pintura pintura = DataMapper.pinturaDTOToPintura(newData);
		if (find(pintura) == null) {
			listaPinturas.add(pintura);
			writeFile();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Elimina una pintura existente de la lista si existe. Utiliza
	 * {@link DataMapper} para convertir el {@code PinturaDTO} a un objeto
	 * {@code Pintura} y luego lo busca en la lista. Si se encuentra, lo elimina y
	 * actualiza el archivo de almacenamiento persistente.
	 *
	 * @param toDelete el {@code PinturaDTO} que se desea eliminar
	 * @return {@code true} si la pintura se eliminó exitosamente, {@code false} si
	 *         no se encontró la pintura
	 */
	@Override
	public boolean delete(PinturaDTO toDelete) {
		Pintura pintura = DataMapper.pinturaDTOToPintura(toDelete);
		Pintura found = find(pintura);
		if (found != null) {
			listaPinturas.remove(found);
			writeFile();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Busca una pintura en la lista basada en el nombre, ignorando mayúsculas y
	 * minúsculas.
	 *
	 * @param toFind el objeto {@code Pintura} que se desea encontrar
	 * @return el objeto {@code Pintura} encontrado, o {@code null} si no se
	 *         encuentra
	 */
	@Override
	public Pintura find(Pintura toFind) {
		if (!listaPinturas.isEmpty()) {
			for (Pintura pintura : listaPinturas) {
				if (pintura.getNombre().equalsIgnoreCase(toFind.getNombre())) {
					return pintura;
				}
			}
		}
		return null;
	}

	/**
	 * Actualiza una pintura existente con nuevos datos. Busca la pintura previa y,
	 * si la encuentra, la reemplaza con la nueva pintura proporcionada. Luego,
	 * actualiza el archivo de almacenamiento persistente.
	 *
	 * @param previous el {@code PinturaDTO} que representa la pintura a actualizar
	 * @param newData  el {@code PinturaDTO} con los nuevos datos
	 * @return {@code true} si la actualización fue exitosa, {@code false} si no se
	 *         encontró la pintura previa
	 */
	@Override
	public boolean update(PinturaDTO previous, PinturaDTO newData) {
		Pintura pinturaPrev = DataMapper.pinturaDTOToPintura(previous);
		Pintura found = find(pinturaPrev);
		if (found != null) {
			listaPinturas.remove(found);
			listaPinturas.add(DataMapper.pinturaDTOToPintura(newData));
			writeFile();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Lee los datos de pinturas desde el archivo {@code pinturas.csv} y los carga
	 * en {@code listaPinturas}. Si el archivo está vacío o no existe, inicializa
	 * una lista vacía.
	 * <p>
	 * <strong>Nota:</strong> Hay un error en el código original donde se utiliza
	 * {@code content.split(";")} en lugar de {@code row.split(";")} dentro del
	 * bucle. Esto debe corregirse para que la separación de columnas se realice
	 * correctamente por fila.
	 * </p>
	 */
	@Override
	public void readFile() {
		String content = FileHandler.readFile(FILE_NAME);
		if (content == null || content.equals("")) {
			listaPinturas = new ArrayList<>();
		} else {
			listaPinturas = new ArrayList<>();
			String[] rows = content.split("\n");
			for (String row : rows) {
				String[] cols = row.split(";"); // Corrección: usar 'row' en lugar de 'content'
				if (cols.length < 10) {
					// Manejar filas incompletas o inválidas
					System.out.println("Fila incompleta o inválida: " + row);
					continue;
				}
				Pintura pin = new Pintura();
				try {
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
				} catch (NumberFormatException e) {
					System.out.println("Error al parsear los datos de la pintura: " + e.getMessage());
					// Continuar con la siguiente fila
				}
			}
		}
	}

	/**
	 * Escribe los datos actuales de {@code listaPinturas} en el archivo
	 * {@code pinturas.csv} en formato CSV. Cada propiedad de la pintura se separa
	 * por un punto y coma (;), y cada pintura se escribe en una nueva línea.
	 * <p>
	 * <strong>Corrección:</strong> Se ha añadido un punto y coma después de
	 * {@code getTamanio()} para asegurar la correcta separación de campos.
	 * </p>
	 */
	@Override
	public void writeFile() {
		StringBuilder content = new StringBuilder();
		for (Pintura pintura : listaPinturas) {
			content.append(pintura.getPrecioCompra()).append(";");
			content.append(pintura.getPrecioVenta()).append(";");
			content.append(pintura.getCantidad()).append(";");
			content.append(pintura.getNombre()).append(";");
			content.append(pintura.getTamanio()).append(";"); // Corrección: añadir ';' después de 'tamanio'
			content.append(pintura.getMarca()).append(";");
			content.append(pintura.getColor()).append(";");
			content.append(pintura.getContenidoMl()).append(";");
			content.append(pintura.isEsVinilo()).append(";");
			content.append(pintura.isEsOleo()).append("\n");
		}
		FileHandler.writeFile(FILE_NAME, content.toString());
	}
}
