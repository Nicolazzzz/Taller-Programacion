package co.edu.unbosque.view;

public class ViewFacade {

	private Consola con;
	private VentanaPrincipal principal;

	public ViewFacade() {
		con = new Consola();
		principal = new VentanaPrincipal();
	}

	public Consola getCon() {
		return con;
	}

	public void setCon(Consola con) {
		this.con = con;
	}

	public VentanaPrincipal getPrincipal() {
		return principal;
	}

	public void setPrincipal(VentanaPrincipal principal) {
		this.principal = principal;
	}

}
