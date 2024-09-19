package co.edu.unbosque.model;

/**
 * La clase ProyectoMadera representa un producto hecho de madera que puede ser
 * cortado a mano, cortado con láser y/o grabado. Extiende la clase abstracta
 * Producto, que contiene los atributos generales de un producto.
 * 
 * @author MARIO RODRIGUEZ
 * @version 1.0
 * @since 2024-04-27
 */
public class ProyectoMadera extends Producto {

	private boolean esCortadoMano;
	private boolean esCortadoLaser;
	private boolean esGrabado;

	/**
	 * Constructor por defecto de la clase ProyectoMadera.
	 */
	public ProyectoMadera() {
		// Constructor vacío
	}

	/**
	 * Constructor que inicializa un ProyectoMadera con los atributos indicados.
	 * 
	 * @param esCortadoMano  indica si el proyecto de madera es cortado a mano.
	 * @param esCortadoLaser indica si el proyecto de madera es cortado con láser.
	 * @param esGrabado      indica si el proyecto de madera está grabado.
	 */
	public ProyectoMadera(boolean esCortadoMano, boolean esCortadoLaser, boolean esGrabado) {
		super();
		this.esCortadoMano = esCortadoMano;
		this.esCortadoLaser = esCortadoLaser;
		this.esGrabado = esGrabado;
	}

	/**
	 * Constructor que inicializa un ProyectoMadera con los atributos del producto y
	 * las características específicas de corte y grabado.
	 * 
	 * @param precioCompra   el precio de compra del producto.
	 * @param precioVenta    el precio de venta del producto.
	 * @param cantidad       la cantidad disponible del producto.
	 * @param nombre         el nombre del producto.
	 * @param tamanio        el tamaño del producto.
	 * @param marca          la marca del producto.
	 * @param esCortadoMano  indica si el proyecto de madera es cortado a mano.
	 * @param esCortadoLaser indica si el proyecto de madera es cortado con láser.
	 * @param esGrabado      indica si el proyecto de madera está grabado.
	 */
	public ProyectoMadera(double precioCompra, double precioVenta, int cantidad, String nombre, String tamanio,
			String marca, boolean esCortadoMano, boolean esCortadoLaser, boolean esGrabado) {
		super(precioCompra, precioVenta, cantidad, nombre, tamanio, marca);
		this.esCortadoMano = esCortadoMano;
		this.esCortadoLaser = esCortadoLaser;
		this.esGrabado = esGrabado;
	}

	/**
	 * Constructor que inicializa un ProyectoMadera con los atributos generales de
	 * producto.
	 * 
	 * @param precioCompra el precio de compra del producto.
	 * @param precioVenta  el precio de venta del producto.
	 * @param cantidad     la cantidad disponible del producto.
	 * @param nombre       el nombre del producto.
	 * @param tamanio      el tamaño del producto.
	 * @param marca        la marca del producto.
	 */
	public ProyectoMadera(double precioCompra, double precioVenta, int cantidad, String nombre, String tamanio,
			String marca) {
		super(precioCompra, precioVenta, cantidad, nombre, tamanio, marca);
	}

	/**
	 * Verifica si el proyecto de madera es cortado a mano.
	 * 
	 * @return true si es cortado a mano, false en caso contrario.
	 */
	public boolean isEsCortadoMano() {
		return esCortadoMano;
	}

	/**
	 * Establece si el proyecto de madera es cortado a mano.
	 * 
	 * @param esCortadoMano valor booleano que indica si el proyecto es cortado a
	 *                      mano.
	 */
	public void setEsCortadoMano(boolean esCortadoMano) {
		this.esCortadoMano = esCortadoMano;
	}

	/**
	 * Verifica si el proyecto de madera es cortado con láser.
	 * 
	 * @return true si es cortado con láser, false en caso contrario.
	 */
	public boolean isEsCortadoLaser() {
		return esCortadoLaser;
	}

	/**
	 * Establece si el proyecto de madera es cortado con láser.
	 * 
	 * @param esCortadoLaser valor booleano que indica si el proyecto es cortado con
	 *                       láser.
	 */
	public void setEsCortadoLaser(boolean esCortadoLaser) {
		this.esCortadoLaser = esCortadoLaser;
	}

	/**
	 * Verifica si el proyecto de madera está grabado.
	 * 
	 * @return true si está grabado, false en caso contrario.
	 */
	public boolean isEsGrabado() {
		return esGrabado;
	}

	/**
	 * Establece si el proyecto de madera está grabado.
	 * 
	 * @param esGrabado valor booleano que indica si el proyecto está grabado.
	 */
	public void setEsGrabado(boolean esGrabado) {
		this.esGrabado = esGrabado;
	}

	/**
	 * Devuelve una representación en cadena de los atributos del proyecto de
	 * madera.
	 * 
	 * @return una cadena que representa los detalles del proyecto de madera.
	 */
	@Override
	public String toString() {
		return super.toString() + "\nEs Cortado a Mano: " + esCortadoMano + "\nEs Cortado a Laser: " + esCortadoLaser
				+ "\nEs Grabado: " + esGrabado;
	}

}
