package co.edu.unbosque.model;

public class PinturaDTO extends ProductoDTO {

	private String color;
	private float contenidoMl;
	private boolean esVinilo;
	private boolean esOleo;

	public PinturaDTO() {
		// TODO Auto-generated constructor stub
	}

	public PinturaDTO(String color, float contenidoMl, boolean esVinilo, boolean esOleo) {
		super();
		this.color = color;
		this.contenidoMl = contenidoMl;
		this.esVinilo = esVinilo;
		this.esOleo = esOleo;
	}

	public PinturaDTO(double precioCompra, double precioVenta, int cantidad, String nombre, String tamanio,
			String marca, String color, float contenidoMl, boolean esVinilo, boolean esOleo) {
		super(precioCompra, precioVenta, cantidad, nombre, tamanio, marca);
		this.color = color;
		this.contenidoMl = contenidoMl;
		this.esVinilo = esVinilo;
		this.esOleo = esOleo;
	}

	public PinturaDTO(double precioCompra, double precioVenta, int cantidad, String nombre, String tamanio,
			String marca) {
		super(precioCompra, precioVenta, cantidad, nombre, tamanio, marca);
		// TODO Auto-generated constructor stub
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public float getContenidoMl() {
		return contenidoMl;
	}

	public void setContenidoMl(float contenidoMl) {
		this.contenidoMl = contenidoMl;
	}

	public boolean isEsVinilo() {
		return esVinilo;
	}

	public void setEsVinilo(boolean esVinilo) {
		this.esVinilo = esVinilo;
	}

	public boolean isEsOleo() {
		return esOleo;
	}

	public void setEsOleo(boolean esOleo) {
		this.esOleo = esOleo;
	}

	@Override
	public String toString() {
		return super.toString() + "\nColor: " + color + "\nContenido Ml: " + contenidoMl + "\nEs Vinilo: " + esVinilo
				+ "\nEs Oleo" + esOleo;
	}

}
