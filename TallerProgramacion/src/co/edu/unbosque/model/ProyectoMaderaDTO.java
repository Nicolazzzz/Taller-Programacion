package co.edu.unbosque.model;

public class ProyectoMaderaDTO extends Producto {

	private boolean esCortadoMano;
	private boolean esCortadoLaser;
	private boolean esGrabado;

	public ProyectoMaderaDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProyectoMaderaDTO(boolean esCortadoMano, boolean esCortadoLaser, boolean esGrabado) {
		super();
		this.esCortadoMano = esCortadoMano;
		this.esCortadoLaser = esCortadoLaser;
		this.esGrabado = esGrabado;
	}

	public ProyectoMaderaDTO(double precioCompra, double precioVenta, int cantidad, String nombre, String tamanio,
			String marca, boolean esCortadoMano, boolean esCortadoLaser, boolean esGrabado) {
		super(precioCompra, precioVenta, cantidad, nombre, tamanio, marca);
		this.esCortadoMano = esCortadoMano;
		this.esCortadoLaser = esCortadoLaser;
		this.esGrabado = esGrabado;
	}

	public ProyectoMaderaDTO(double precioCompra, double precioVenta, int cantidad, String nombre, String tamanio,
			String marca) {
		super(precioCompra, precioVenta, cantidad, nombre, tamanio, marca);
		// TODO Auto-generated constructor stub
	}

	public boolean isEsCortadoMano() {
		return esCortadoMano;
	}

	public void setEsCortadoMano(boolean esCortadoMano) {
		this.esCortadoMano = esCortadoMano;
	}

	public boolean isEsCortadoLaser() {
		return esCortadoLaser;
	}

	public void setEsCortadoLaser(boolean esCortadoLaser) {
		this.esCortadoLaser = esCortadoLaser;
	}

	public boolean isEsGrabado() {
		return esGrabado;
	}

	public void setEsGrabado(boolean esGrabado) {
		this.esGrabado = esGrabado;
	}

	@Override
	public String toString() {
		return super.toString() + "\nEs Cortado a Mano: " + esCortadoMano + "\nEs Cortado a Laser: " + esCortadoLaser
				+ "\nEs Grabado: " + esGrabado;
	}

}
