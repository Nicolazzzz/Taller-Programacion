package co.edu.unbosque.view;

/**
 * Clase que actúa como una fachada para la interfaz de usuario de la
 * aplicación. Esta clase encapsula las instancias de la consola y de la ventana
 * principal, proporcionando un punto de acceso unificado a los componentes de
 * visualización.
 * 
 * @author Mario Rodríguez
 */
public class ViewFacade {

	private Consola con;
	private VentanaPrincipal principal;

	/**
	 * Constructor que inicializa la fachada de vista. Se crean instancias de la
	 * consola y de la ventana principal.
	 */
	public ViewFacade() {
		con = new Consola();
		principal = new VentanaPrincipal();
	}

	/**
	 * Obtiene la instancia de la consola.
	 * 
	 * @return Consola correspondiente a la consola de la aplicación.
	 */
	public Consola getCon() {
		return con;
	}

	/**
	 * Establece la instancia de la consola.
	 * 
	 * @param con Consola a establecer.
	 */
	public void setCon(Consola con) {
		this.con = con;
	}

	/**
	 * Obtiene la instancia de la ventana principal.
	 * 
	 * @return VentanaPrincipal correspondiente a la ventana principal de la
	 *         aplicación.
	 */
	public VentanaPrincipal getPrincipal() {
		return principal;
	}

	/**
	 * Establece la instancia de la ventana principal.
	 * 
	 * @param principal VentanaPrincipal a establecer.
	 */
	public void setPrincipal(VentanaPrincipal principal) {
		this.principal = principal;
	}
}
