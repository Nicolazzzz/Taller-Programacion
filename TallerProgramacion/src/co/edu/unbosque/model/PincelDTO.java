package co.edu.unbosque.model;

public class PincelDTO extends ProductoDTO {

	private String grosorCerda;
	private String material;
	private String tipoPincel;

	public PincelDTO() {
		// TODO Auto-generated constructor stub
	}

	public PincelDTO(String grosorCerdas, String material, String tipoPincel) {
		super();
		this.grosorCerda = grosorCerdas;
		this.material = material;
		this.tipoPincel = tipoPincel;
	}

	public PincelDTO(double precioCompra, double precioVenta, int cantidad, String nombre, String tamanio, String marca,
			String grosorCerdas, String material, String tipoPincel) {
		super(precioCompra, precioVenta, cantidad, nombre, tamanio, marca);
		this.grosorCerda = grosorCerdas;
		this.material = material;
		this.tipoPincel = tipoPincel;
	}

	public PincelDTO(double precioCompra, double precioVenta, int cantidad, String nombre, String tamanio,
			String marca) {
		super(precioCompra, precioVenta, cantidad, nombre, tamanio, marca);
		// TODO Auto-generated constructor stub
	}

	public String getGrosorCerda() {
		return grosorCerda;
	}

	public void setGrosorCerda(String grosorCerda) {
		this.grosorCerda = grosorCerda;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getTipoPincel() {
		return tipoPincel;
	}

	public void setTipoPincel(String tipoPincel) {
		this.tipoPincel = tipoPincel;
	}

	@Override
	public String toString() {
		return super.toString() + "\nGrosor Cerdas: " + grosorCerda + "\nMaterial: " + material + "\nTipo Pincel: "
				+ tipoPincel;
	}

}
