package co.edu.unbosque.view;

import javax.swing.JFrame;

/**
 * Clase que representa la ventana principal de la aplicación. Esta clase
 * extiende JFrame y actúa como contenedor para diferentes paneles de la
 * interfaz de usuario, permitiendo la navegación entre ellos.
 * 
 * @author Mario Rodríguez
 */
public class VentanaPrincipal extends JFrame {

	private CoverPanel coverPanel;
	private HomePanel homePanel;
	private InputPanel inputPanel;
	private LobbyPanel lobbyPanel;

	/**
	 * Constructor que inicializa la ventana principal. Se configuran las
	 * propiedades de la ventana y se establece el panel de portada como el
	 * contenido inicial.
	 */
	public VentanaPrincipal() {
		setLocation(30, 30);
		setSize(1280, 720);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setTitle("BIENVENIDA!");

		homePanel = new HomePanel();
		coverPanel = new CoverPanel();
		inputPanel = new InputPanel();
		lobbyPanel = new LobbyPanel();
		setContentPane(coverPanel); // Muestra el panel de portada al inicio

		setVisible(true); // Asegúrate de que la ventana sea visible
	}

	/**
	 * Muestra el panel de inicio en la ventana principal.
	 */
	public void mostrarPanelInicio() {
		setContentPane(homePanel);
	}

	/**
	 * Muestra el panel de entrada en la ventana principal.
	 */
	public void mostrarPanelInput() {
		setContentPane(inputPanel);
	}

	/**
	 * Muestra el panel de lobby en la ventana principal.
	 */
	public void mostrarPanelLobby() {
		setContentPane(lobbyPanel);
	}

	/**
	 * Obtiene el panel de portada.
	 * 
	 * @return CoverPanel correspondiente al panel de portada.
	 */
	public CoverPanel getCoverPanel() {
		return coverPanel;
	}

	/**
	 * Obtiene el panel de inicio.
	 * 
	 * @return HomePanel correspondiente al panel de inicio.
	 */
	public HomePanel getHomePanel() {
		return homePanel;
	}

	/**
	 * Obtiene el panel de entrada.
	 * 
	 * @return InputPanel correspondiente al panel de entrada.
	 */
	public InputPanel getInputPanel() {
		return inputPanel;
	}

	/**
	 * Obtiene el panel de lobby.
	 * 
	 * @return LobbyPanel correspondiente al panel de lobby.
	 */
	public LobbyPanel getLobbyPanel() {
		return lobbyPanel;
	}
}
