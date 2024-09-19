package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * La clase Pincel representa un producto específico que hereda de la clase
 * Producto. Esta clase añade atributos particulares de un pincel, como el
 * grosor de la cerda, el material del pincel y el tipo de pincel.
 * 
 * @author MARIO RODRIGUEZ
 * @version 1.0
 * @since 2024-04-27
 */
public class Pincel extends Producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String grosorCerda;
	private String material;
	private String tipoPincel;

	/**
	 * Constructor por defecto de la clase Pincel.
	 */
	public Pincel() {
		// Constructor vacío
	}

	/**
	 * Constructor que inicializa un Pincel con sus atributos específicos: grosor de
	 * la cerda, material y tipo de pincel.
	 * 
	 * @param grosorCerda el grosor de las cerdas del pincel.
	 * @param material    el material del pincel.
	 * @param tipoPincel  el tipo de pincel.
	 */
	public Pincel(String grosorCerda, String material, String tipoPincel) {
		super();
		this.grosorCerda = grosorCerda;
		this.material = material;
		this.tipoPincel = tipoPincel;
	}

	/**
	 * Constructor que inicializa un Pincel con atributos del Producto y sus
	 * atributos específicos.
	 * 
	 * @param precioCompra el precio de compra del pincel.
	 * @param precioVenta  el precio de venta del pincel.
	 * @param cantidad     la cantidad disponible del pincel.
	 * @param nombre       el nombre del pincel.
	 * @param tamanio      el tamaño del pincel.
	 * @param marca        la marca del pincel.
	 * @param grosorCerda  el grosor de las cerdas del pincel.
	 * @param material     el material del pincel.
	 * @param tipoPincel   el tipo de pincel.
	 */
	public Pincel(double precioCompra, double precioVenta, int cantidad, String nombre, String tamanio, String marca,
			String grosorCerda, String material, String tipoPincel) {
		super(precioCompra, precioVenta, cantidad, nombre, tamanio, marca);
		this.grosorCerda = grosorCerda;
		this.material = material;
		this.tipoPincel = tipoPincel;
	}

	/**
	 * Constructor que inicializa un Pincel con los atributos de un Producto.
	 * 
	 * @param precioCompra el precio de compra del pincel.
	 * @param precioVenta  el precio de venta del pincel.
	 * @param cantidad     la cantidad disponible del pincel.
	 * @param nombre       el nombre del pincel.
	 * @param tamanio      el tamaño del pincel.
	 * @param marca        la marca del pincel.
	 */
	public Pincel(double precioCompra, double precioVenta, int cantidad, String nombre, String tamanio, String marca) {
		super(precioCompra, precioVenta, cantidad, nombre, tamanio, marca);
	}

	/**
	 * Obtiene el grosor de las cerdas del pincel.
	 * 
	 * @return el grosor de las cerdas.
	 */
	public String getGrosorCerda() {
		return grosorCerda;
	}

	/**
	 * Establece el grosor de las cerdas del pincel.
	 * 
	 * @param grosorCerda el grosor de las cerdas a asignar.
	 */
	public void setGrosorCerda(String grosorCerda) {
		this.grosorCerda = grosorCerda;
	}

	/**
	 * Obtiene el material del pincel.
	 * 
	 * @return el material del pincel.
	 */
	public String getMaterial() {
		return material;
	}

	/**
	 * Establece el material del pincel.
	 * 
	 * @param material el material del pincel a asignar.
	 */
	public void setMaterial(String material) {
		this.material = material;
	}

	/**
	 * Obtiene el tipo de pincel.
	 * 
	 * @return el tipo de pincel.
	 */
	public String getTipoPincel() {
		return tipoPincel;
	}

	/**
	 * Establece el tipo de pincel.
	 * 
	 * @param tipoPincel el tipo de pincel a asignar.
	 */
	public void setTipoPincel(String tipoPincel) {
		this.tipoPincel = tipoPincel;
	}

	/**
	 * Devuelve una representación en cadena de los atributos del pincel, incluyendo
	 * la información heredada de la clase Producto.
	 * 
	 * @return una cadena que representa al pincel con sus atributos.
	 */
	@Override
	public String toString() {
		return super.toString() + "\nGrosor Cerdas: " + grosorCerda + "\nMaterial: " + material + "\nTipo Pincel: "
				+ tipoPincel;
	}

}
