package co.edu.unbosque.model;

/**
 * La clase Pintura extiende la clase Producto e incorpora propiedades
 * adicionales específicas de una pintura, como su color, contenido en
 * mililitros, y si es vinilo o óleo.
 * 
 * @author MARIO RODRIGUEZ
 * @version 1.0
 * @since 2024-04-27
 */
public class Pintura extends Producto {

	private String color;
	private float contenidoMl;
	private boolean esVinilo;
	private boolean esOleo;

	/**
	 * Constructor por defecto de la clase Pintura.
	 */
	public Pintura() {
		// Constructor vacío
	}

	/**
	 * Constructor que inicializa una Pintura con los atributos específicos: color,
	 * contenido en mililitros, y si es vinilo o óleo.
	 * 
	 * @param color       el color de la pintura.
	 * @param contenidoMl el contenido de la pintura en mililitros.
	 * @param esVinilo    true si la pintura es de tipo vinilo, false en caso
	 *                    contrario.
	 * @param esOleo      true si la pintura es de tipo óleo, false en caso
	 *                    contrario.
	 */
	public Pintura(String color, float contenidoMl, boolean esVinilo, boolean esOleo) {
		super();
		this.color = color;
		this.contenidoMl = contenidoMl;
		this.esVinilo = esVinilo;
		this.esOleo = esOleo;
	}

	/**
	 * Constructor que inicializa una Pintura con los atributos heredados de
	 * Producto y los específicos de la pintura.
	 * 
	 * @param precioCompra el precio de compra de la pintura.
	 * @param precioVenta  el precio de venta de la pintura.
	 * @param cantidad     la cantidad disponible de pintura.
	 * @param nombre       el nombre de la pintura.
	 * @param tamanio      el tamaño del envase de la pintura.
	 * @param marca        la marca de la pintura.
	 * @param color        el color de la pintura.
	 * @param contenidoMl  el contenido de la pintura en mililitros.
	 * @param esVinilo     true si la pintura es de tipo vinilo, false en caso
	 *                     contrario.
	 * @param esOleo       true si la pintura es de tipo óleo, false en caso
	 *                     contrario.
	 */
	public Pintura(double precioCompra, double precioVenta, int cantidad, String nombre, String tamanio, String marca,
			String color, float contenidoMl, boolean esVinilo, boolean esOleo) {
		super(precioCompra, precioVenta, cantidad, nombre, tamanio, marca);
		this.color = color;
		this.contenidoMl = contenidoMl;
		this.esVinilo = esVinilo;
		this.esOleo = esOleo;
	}

	/**
	 * Constructor que inicializa una Pintura con los atributos de Producto.
	 * 
	 * @param precioCompra el precio de compra de la pintura.
	 * @param precioVenta  el precio de venta de la pintura.
	 * @param cantidad     la cantidad disponible de pintura.
	 * @param nombre       el nombre de la pintura.
	 * @param tamanio      el tamaño del envase de la pintura.
	 * @param marca        la marca de la pintura.
	 */
	public Pintura(double precioCompra, double precioVenta, int cantidad, String nombre, String tamanio, String marca) {
		super(precioCompra, precioVenta, cantidad, nombre, tamanio, marca);
	}

	/**
	 * Obtiene el color de la pintura.
	 * 
	 * @return el color de la pintura.
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Establece el color de la pintura.
	 * 
	 * @param color el color de la pintura a asignar.
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Obtiene el contenido de la pintura en mililitros.
	 * 
	 * @return el contenido de la pintura en mililitros.
	 */
	public float getContenidoMl() {
		return contenidoMl;
	}

	/**
	 * Establece el contenido de la pintura en mililitros.
	 * 
	 * @param contenidoMl el contenido de la pintura a asignar.
	 */
	public void setContenidoMl(float contenidoMl) {
		this.contenidoMl = contenidoMl;
	}

	/**
	 * Verifica si la pintura es de tipo vinilo.
	 * 
	 * @return true si la pintura es vinilo, false en caso contrario.
	 */
	public boolean isEsVinilo() {
		return esVinilo;
	}

	/**
	 * Establece si la pintura es de tipo vinilo.
	 * 
	 * @param esVinilo true para indicar que la pintura es vinilo, false en caso
	 *                 contrario.
	 */
	public void setEsVinilo(boolean esVinilo) {
		this.esVinilo = esVinilo;
	}

	/**
	 * Verifica si la pintura es de tipo óleo.
	 * 
	 * @return true si la pintura es óleo, false en caso contrario.
	 */
	public boolean isEsOleo() {
		return esOleo;
	}

	/**
	 * Establece si la pintura es de tipo óleo.
	 * 
	 * @param esOleo true para indicar que la pintura es óleo, false en caso
	 *               contrario.
	 */
	public void setEsOleo(boolean esOleo) {
		this.esOleo = esOleo;
	}

	/**
	 * Devuelve una representación en cadena de los atributos de la pintura,
	 * incluyendo la información heredada de la clase Producto.
	 * 
	 * @return una cadena que representa a la pintura con sus atributos.
	 */
	@Override
	public String toString() {
		return super.toString() + "\nColor: " + color + "\nContenido Ml: " + contenidoMl + "\nEs Vinilo: " + esVinilo
				+ "\nEs Oleo: " + esOleo;
	}

}
