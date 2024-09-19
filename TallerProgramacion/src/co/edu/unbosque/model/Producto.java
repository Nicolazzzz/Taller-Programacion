package co.edu.unbosque.model;

/**
 * La clase abstracta Producto representa un producto genérico con atributos
 * básicos como precio de compra, precio de venta, cantidad, nombre, tamaño y
 * marca. Esta clase sirve como base para otros productos más específicos.
 * 
 * @author MARIO RODRIGUEZ
 * @version 1.0
 * @since 2024-04-27
 */
public abstract class Producto {

	private double precioCompra;
	private double precioVenta;
	private int cantidad;
	private String nombre;
	private String tamanio;
	private String marca;

	/**
	 * Constructor por defecto de la clase Producto.
	 */
	public Producto() {
		// Constructor vacío
	}

	/**
	 * Constructor que inicializa un Producto con los atributos proporcionados.
	 * 
	 * @param precioCompra el precio de compra del producto.
	 * @param precioVenta  el precio de venta del producto.
	 * @param cantidad     la cantidad disponible del producto.
	 * @param nombre       el nombre del producto.
	 * @param tamanio      el tamaño del producto.
	 * @param marca        la marca del producto.
	 */
	public Producto(double precioCompra, double precioVenta, int cantidad, String nombre, String tamanio,
			String marca) {
		super();
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.cantidad = cantidad;
		this.nombre = nombre;
		this.tamanio = tamanio;
		this.marca = marca;
	}

	/**
	 * Obtiene el precio de compra del producto.
	 * 
	 * @return el precio de compra del producto.
	 */
	public double getPrecioCompra() {
		return precioCompra;
	}

	/**
	 * Establece el precio de compra del producto.
	 * 
	 * @param precioCompra el precio de compra a asignar.
	 */
	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}

	/**
	 * Obtiene el precio de venta del producto.
	 * 
	 * @return el precio de venta del producto.
	 */
	public double getPrecioVenta() {
		return precioVenta;
	}

	/**
	 * Establece el precio de venta del producto.
	 * 
	 * @param precioVenta el precio de venta a asignar.
	 */
	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	/**
	 * Obtiene la cantidad disponible del producto.
	 * 
	 * @return la cantidad disponible del producto.
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * Establece la cantidad disponible del producto.
	 * 
	 * @param cantidad la cantidad a asignar.
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Obtiene el nombre del producto.
	 * 
	 * @return el nombre del producto.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del producto.
	 * 
	 * @param nombre el nombre a asignar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el tamaño del producto.
	 * 
	 * @return el tamaño del producto.
	 */
	public String getTamanio() {
		return tamanio;
	}

	/**
	 * Establece el tamaño del producto.
	 * 
	 * @param tamanio el tamaño a asignar.
	 */
	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}

	/**
	 * Obtiene la marca del producto.
	 * 
	 * @return la marca del producto.
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Establece la marca del producto.
	 * 
	 * @param marca la marca a asignar.
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Devuelve una representación en cadena de los atributos del producto.
	 * 
	 * @return una cadena que representa al producto con sus atributos.
	 */
	@Override
	public String toString() {
		return "\nPrecio Compra: " + precioCompra + "\nPrecio Venta: " + precioVenta + "\nCantidad: " + cantidad
				+ "\nNombre: " + nombre + "\nTamaño: " + tamanio + "\nMarca: " + marca;
	}

}
