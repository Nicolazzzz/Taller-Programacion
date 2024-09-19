package co.edu.unbosque.model;

public class Pincel extends Producto {

	private String grosorCerdas;
	private String material;
	private String tipoPincel;

	public Pincel() {
		// TODO Auto-generated constructor stub
	}

	public Pincel(String grosorCerdas, String material, String tipoPincel) {
		super();
		this.grosorCerdas = grosorCerdas;
		this.material = material;
		this.tipoPincel = tipoPincel;
	}

	public Pincel(double precioCompra, double precioVenta, int cantidad, String nombre, String tamanio, String marca,
			String grosorCerdas, String material, String tipoPincel) {
		super(precioCompra, precioVenta, cantidad, nombre, tamanio, marca);
		this.grosorCerdas = grosorCerdas;
		this.material = material;
		this.tipoPincel = tipoPincel;
	}

	public Pincel(double precioCompra, double precioVenta, int cantidad, String nombre, String tamanio, String marca) {
		super(precioCompra, precioVenta, cantidad, nombre, tamanio, marca);
		// TODO Auto-generated constructor stub
	}

	public String getGrosorCerdas() {
		return grosorCerdas;
	}

	public void setGrosorCerdas(String grosorCerdas) {
		this.grosorCerdas = grosorCerdas;
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
		return super.toString() + "\nGrosor Cerdas: " + grosorCerdas + "\nMaterial: " + material + "\nTipo Pincel: "
				+ tipoPincel;
	}

}
