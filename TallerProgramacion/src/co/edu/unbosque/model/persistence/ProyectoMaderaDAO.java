package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.ProyectoMadera;
import co.edu.unbosque.model.ProyectoMaderaDTO;

/**
 * La clase {@code ProyectoMaderaDAO} implementa las operaciones CRUD (Crear,
 * Leer, Actualizar, Eliminar) para objetos {@link ProyectoMaderaDTO} utilizando
 * un archivo de texto plano para la persistencia de datos. Esta clase gestiona
 * una lista de proyectos de madera y proporciona métodos para manipular dicha
 * lista, asegurando la sincronización con el almacenamiento persistente.
 * <p>
 * La clase utiliza {@link FileHandler} para manejar las operaciones de lectura
 * y escritura en el archivo {@code madera.csv}. Además, emplea
 * {@link DataMapper} para convertir entre objetos {@code ProyectoMadera} y
 * {@code ProyectoMaderaDTO}.
 * </p>
 * <p>
 * Esta clase no está diseñada para ser heredada.
 * </p>
 * 
 * @author NICOLAS ZAMBRANO
 * @version 1.0
 * @since 2024-04-27
 */
public class ProyectoMaderaDAO implements CRUDOperation<ProyectoMaderaDTO, ProyectoMadera> {

	private ArrayList<ProyectoMadera> listaMadera;
	private final String FILE_NAME = "madera.csv";

	/**
	 * Constructor de la clase {@code ProyectoMaderaDAO}. Inicializa la carpeta de
	 * datos y lee los datos existentes desde el archivo {@code madera.csv}.
	 */
	public ProyectoMaderaDAO() {
		FileHandler.checkFolder();
		readFile();
	}

	/**
	 * Muestra todos los proyectos de madera almacenados en {@code listaMadera} como
	 * una cadena de texto. Si no hay datos, retorna un mensaje indicando que no hay
	 * proyectos creados en la lista.
	 *
	 * @return una cadena con la representación de todos los proyectos de madera o
	 *         un mensaje indicando la ausencia de datos
	 */
	@Override
	public String showAll() {
		StringBuilder rta = new StringBuilder();
		if (listaMadera.isEmpty()) {
			return "No hay proyectos de madera creados en la lista";
		} else {
			for (ProyectoMadera pm : listaMadera) {
				rta.append(pm).append("\n");
			}
			return rta.toString();
		}
	}

	/**
	 * Obtiene una lista de todos los proyectos de madera como objetos
	 * {@link ProyectoMaderaDTO}.
	 *
	 * @return un {@code ArrayList} de {@code ProyectoMaderaDTO} que representa
	 *         todos los proyectos de madera almacenados
	 */
	@Override
	public ArrayList<ProyectoMaderaDTO> getAll() {
		return DataMapper.listaProyectosMaderaToListaProyectosMaderaDTO(listaMadera);
	}

	/**
	 * Agrega un nuevo proyecto de madera a la lista si no existe previamente.
	 * Utiliza {@link DataMapper} para convertir el {@code ProyectoMaderaDTO} a un
	 * objeto {@code ProyectoMadera}. Después de agregar, actualiza el archivo de
	 * almacenamiento persistente.
	 *
	 * @param newData el {@code ProyectoMaderaDTO} que se desea agregar
	 * @return {@code true} si el proyecto de madera se agregó exitosamente,
	 *         {@code false} si ya existe un proyecto con el mismo nombre
	 */
	@Override
	public boolean add(ProyectoMaderaDTO newData) {
		ProyectoMadera proyecto = DataMapper.proyectoMaderaDTOToProyectoMadera(newData);
		if (find(proyecto) == null) {
			listaMadera.add(proyecto);
			writeFile();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Elimina un proyecto de madera existente de la lista si existe. Utiliza
	 * {@link DataMapper} para convertir el {@code ProyectoMaderaDTO} a un objeto
	 * {@code ProyectoMadera} y luego lo busca en la lista. Si se encuentra, lo
	 * elimina y actualiza el archivo de almacenamiento persistente.
	 *
	 * @param toDelete el {@code ProyectoMaderaDTO} que se desea eliminar
	 * @return {@code true} si el proyecto de madera se eliminó exitosamente,
	 *         {@code false} si no se encontró el proyecto
	 */
	@Override
	public boolean delete(ProyectoMaderaDTO toDelete) {
		ProyectoMadera proyecto = DataMapper.proyectoMaderaDTOToProyectoMadera(toDelete);
		ProyectoMadera found = find(proyecto);
		if (found != null) {
			listaMadera.remove(found);
			writeFile();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Busca un proyecto de madera en la lista basado en el nombre, ignorando
	 * mayúsculas y minúsculas.
	 *
	 * @param toFind el objeto {@code ProyectoMadera} que se desea encontrar
	 * @return el objeto {@code ProyectoMadera} encontrado, o {@code null} si no se
	 *         encuentra
	 */
	@Override
	public ProyectoMadera find(ProyectoMadera toFind) {
		if (!listaMadera.isEmpty()) {
			for (ProyectoMadera madera : listaMadera) {
				if (madera.getNombre().equalsIgnoreCase(toFind.getNombre())) {
					return madera;
				}
			}
		}
		return null;
	}

	/**
	 * Actualiza un proyecto de madera existente con nuevos datos. Busca el proyecto
	 * previo y, si lo encuentra, lo reemplaza con el nuevo proyecto proporcionado.
	 * Luego, actualiza el archivo de almacenamiento persistente.
	 *
	 * @param previous el {@code ProyectoMaderaDTO} que representa el proyecto a
	 *                 actualizar
	 * @param newData  el {@code ProyectoMaderaDTO} con los nuevos datos
	 * @return {@code true} si la actualización fue exitosa, {@code false} si no se
	 *         encontró el proyecto previo
	 */
	@Override
	public boolean update(ProyectoMaderaDTO previous, ProyectoMaderaDTO newData) {
		ProyectoMadera proyectoPrev = DataMapper.proyectoMaderaDTOToProyectoMadera(previous);
		ProyectoMadera found = find(proyectoPrev);
		if (found != null) {
			listaMadera.remove(found);
			listaMadera.add(DataMapper.proyectoMaderaDTOToProyectoMadera(newData));
			writeFile();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Lee los datos de proyectos de madera desde el archivo {@code madera.csv} y
	 * los carga en {@code listaMadera}. Si el archivo está vacío o no existe,
	 * inicializa una lista vacía.
	 * <p>
	 * <strong>Nota:</strong> Se ha corregido un error en el código original donde
	 * se utilizaba {@code content.split(";")} en lugar de {@code row.split(";")}
	 * dentro del bucle. Esto asegura que la separación de columnas se realice
	 * correctamente por fila.
	 * </p>
	 */
	@Override
	public void readFile() {
		String content = FileHandler.readFile(FILE_NAME);
		if (content == null || content.equals("")) {
			listaMadera = new ArrayList<>();
		} else {
			listaMadera = new ArrayList<>();
			String[] rows = content.split("\n");
			for (String row : rows) {
				String[] cols = row.split(";"); // Corrección: usar 'row' en lugar de 'content'
				if (cols.length < 9) {
					// Manejar filas incompletas o inválidas
					System.out.println("Fila incompleta o inválida: " + row);
					continue;
				}
				ProyectoMadera pm = new ProyectoMadera();
				try {
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
				} catch (NumberFormatException e) {
					System.out.println("Error al parsear los datos del proyecto de madera: " + e.getMessage());
					// Continuar con la siguiente fila
				}
			}
		}
	}

	/**
	 * Escribe los datos actuales de {@code listaMadera} en el archivo
	 * {@code madera.csv} en formato CSV. Cada propiedad del proyecto de madera se
	 * separa por un punto y coma (;), y cada proyecto se escribe en una nueva
	 * línea.
	 * <p>
	 * <strong>Corrección:</strong> Se ha añadido un punto y coma después de
	 * {@code getTamanio()} para asegurar la correcta separación de campos.
	 * </p>
	 */
	@Override
	public void writeFile() {
		StringBuilder content = new StringBuilder();
		for (ProyectoMadera pm : listaMadera) {
			content.append(pm.getPrecioCompra()).append(";");
			content.append(pm.getPrecioVenta()).append(";");
			content.append(pm.getCantidad()).append(";");
			content.append(pm.getNombre()).append(";");
			content.append(pm.getTamanio()).append(";"); // Corrección: añadir ';' después de 'tamanio'
			content.append(pm.getMarca()).append(";");
			content.append(pm.isEsCortadoMano()).append(";");
			content.append(pm.isEsCortadoLaser()).append(";");
			content.append(pm.isEsGrabado()).append("\n");
		}
		FileHandler.writeFile(FILE_NAME, content.toString());
	}
}
