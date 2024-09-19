package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

/**
 * 
 * La interfaz CRUDOperation define las operaciones básicas de CRUD (Crear,
 * Leer, Actualizar, Eliminar) para cualquier tipo de entidad. Esta interfaz
 * está parametrizada por dos tipos:
 * 
 * @param <D> El tipo de los datos que se manejarán en las operaciones CRUD.
 * @param <E> El tipo que se utilizará para realizar la búsqueda.
 * @author MARIO RODRIGUEZ
 * @version 1.0
 * @since 2024-04-27
 */
public interface CRUDOperation<D, E> {

	/**
	 * Muestra una representación en cadena de todos los elementos almacenados.
	 * 
	 * @return una cadena con los detalles de todos los elementos.
	 */
	public String showAll();

	/**
	 * Devuelve una lista de todos los elementos almacenados.
	 * 
	 * @return un ArrayList que contiene todos los elementos.
	 */
	public ArrayList<D> getAll();

	/**
	 * Añade un nuevo elemento al almacenamiento.
	 * 
	 * @param newData el nuevo dato a añadir.
	 * @return true si la adición fue exitosa, false en caso contrario.
	 */
	public boolean add(D newData);

	/**
	 * Elimina un elemento específico del almacenamiento.
	 * 
	 * @param toDelete el dato a eliminar.
	 * @return true si la eliminación fue exitosa, false en caso contrario.
	 */
	public boolean delete(D toDelete);

	/**
	 * Busca un elemento en el almacenamiento según un criterio de búsqueda.
	 * 
	 * @param toFind el criterio o valor a buscar.
	 * @return el elemento encontrado, o null si no se encuentra.
	 */
	public E find(E toFind);

	/**
	 * Actualiza un elemento existente con nuevos datos.
	 * 
	 * @param previous el dato anterior a actualizar.
	 * @param newData  el nuevo dato que reemplazará al anterior.
	 * @return true si la actualización fue exitosa, false en caso contrario.
	 */
	public boolean update(D previous, D newData);

	/**
	 * Lee los datos desde un archivo y los carga en el almacenamiento.
	 */
	public void readFile();

	/**
	 * Escribe los datos actuales del almacenamiento en un archivo.
	 */
	public void writeFile();
}
