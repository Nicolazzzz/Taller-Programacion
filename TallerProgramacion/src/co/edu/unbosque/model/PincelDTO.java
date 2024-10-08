package co.edu.unbosque.model;

/**
 * La clase PincelDTO es una clase de transferencia de datos (DTO, Data Transfer
 * Object) que extiende la clase ProductoDTO. Se utiliza para transferir los
 * datos de un pincel, incluyendo atributos específicos como grosor de la cerda,
 * material y tipo de pincel, entre distintas capas de la aplicación.
 * 
 * @author MARIO RODRIGUEZ
 * @version 1.0
 * @since 2024-04-27
 */
public class PincelDTO extends ProductoDTO {

	private String grosorCerda;
	private String material;
	private String tipoPincel;

	/**
	 * Constructor por defecto de la clase PincelDTO.
	 */
	public PincelDTO() {
		// Constructor vacío
	}

	/**
	 * Constructor que inicializa un PincelDTO con los atributos específicos del
	 * pincel.
	 * 
	 * @param grosorCerda el grosor de las cerdas del pincel.
	 * @param material    el material del pincel.
	 * @param tipoPincel  el tipo de pincel.
	 */
	public PincelDTO(String grosorCerda, String material, String tipoPincel) {
		super();
		this.grosorCerda = grosorCerda;
		this.material = material;
		this.tipoPincel = tipoPincel;
	}

	/**
	 * Constructor que inicializa un PincelDTO con atributos heredados de
	 * ProductoDTO y atributos específicos del pincel.
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
	public PincelDTO(double precioCompra, double precioVenta, int cantidad, String nombre, String tamanio, String marca,
			String grosorCerda, String material, String tipoPincel) {
		super(precioCompra, precioVenta, cantidad, nombre, tamanio, marca);
		this.grosorCerda = grosorCerda;
		this.material = material;
		this.tipoPincel = tipoPincel;
	}

	/**
	 * Constructor que inicializa un PincelDTO con los atributos de ProductoDTO.
	 * 
	 * @param precioCompra el precio de compra del pincel.
	 * @param precioVenta  el precio de venta del pincel.
	 * @param cantidad     la cantidad disponible del pincel.
	 * @param nombre       el nombre del pincel.
	 * @param tamanio      el tamaño del pincel.
	 * @param marca        la marca del pincel.
	 */
	public PincelDTO(double precioCompra, double precioVenta, int cantidad, String nombre, String tamanio,
			String marca) {
		super(precioCompra, precioVenta, cantidad, nombre, tamanio, marca);
	}

	/**
	 * Obtiene el grosor de las cerdas del pincel.
	 * 
	 * @return el grosor de las cerdas del pincel.
	 */
	public String getGrosorCerda() {
		return grosorCerda;
	}

	/**
	 * Establece el grosor de las cerdas del pincel.
	 * 
	 * @param grosorCerda el grosor de las cerdas del pincel a asignar.
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
	 * la información heredada de la clase ProductoDTO.
	 * 
	 * @return una cadena que representa al pincel con sus atributos.
	 */
	@Override
	public String toString() {
		return super.toString() + "\nGrosor Cerdas: " + grosorCerda + "\nMaterial: " + material + "\nTipo Pincel: "
				+ tipoPincel;
	}
}
