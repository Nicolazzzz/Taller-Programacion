package co.edu.unbosque.model;

public class PinturaDTO extends ProductoDTO {

	private boolean esOleo;
	private boolean esVinilo;

	private float contenidoML;
	private String color;

	public PinturaDTO() {
		// TODO Auto-generated constructor stub
	}

	public PinturaDTO(boolean esOleo, boolean esVinilo, float contenidoML, String color) {
		super();
		this.esOleo = esOleo;
		this.esVinilo = esVinilo;
		this.contenidoML = contenidoML;
		this.color = color;
	}

	public PinturaDTO(double precio, int cantidad, String nombreProducto, String marca, boolean esOleo,
			boolean esVinilo, float contenidoML, String color) {
		super(precio, cantidad, nombreProducto, marca);
		this.esOleo = esOleo;
		this.esVinilo = esVinilo;
		this.contenidoML = contenidoML;
		this.color = color;
	}

	public PinturaDTO(double precio, int cantidad, String nombreProducto, String marca) {
		super(precio, cantidad, nombreProducto, marca);
		// TODO Auto-generated constructor stub
	}

	public boolean isEsOleo() {
		return esOleo;
	}

	public void setEsOleo(boolean esOleo) {
		this.esOleo = esOleo;
	}

	public boolean isEsVinilo() {
		return esVinilo;
	}

	public void setEsVinilo(boolean esVinilo) {
		this.esVinilo = esVinilo;
	}

	public float getContenidoML() {
		return contenidoML;
	}

	public void setContenidoML(float contenidoML) {
		this.contenidoML = contenidoML;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "\nesOleo= " + esOleo + "\nesVinilo= " + esVinilo + "\ncontenidoML= " + contenidoML + "\nColor: "
				+ color;
	}

}
