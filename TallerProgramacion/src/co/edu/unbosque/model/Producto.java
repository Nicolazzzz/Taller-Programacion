package co.edu.unbosque.model;

public abstract class Producto {

	private double precio;
	private int cantidad;
	private String nombreProducto;
	private String marca;

	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public Producto(double precio, int cantidad, String nombreProducto, String marca) {
		super();
		this.precio = precio;
		this.cantidad = cantidad;
		this.nombreProducto = nombreProducto;
		this.marca = marca;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "\nPrecio: " + precio + "\nCantidad: " + cantidad + "\nNombre Producto: " + nombreProducto + "\nMarca: "
				+ marca;
	}

}
