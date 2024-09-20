package co.edu.unbosque.view;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {

	private CoverPanel coverPanel;
	private HomePanel homePanel;
	private InputPanel inputPanel;
	private LobbyPanel lobbyPanel;

	public VentanaPrincipal() {

		setLocation(70, 70);
		setSize(1280, 720);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setVisible(true);

		setTitle("BIENVENIDA!");

		coverPanel = new CoverPanel();
		homePanel = new HomePanel();
		inputPanel = new InputPanel();
		lobbyPanel = new LobbyPanel();

	}

	public void mostrarPanelBienvenida() {
		setContentPane(coverPanel);
	}

	public void mostrarPanelInicio() {
		setContentPane(homePanel);
	}

	public void mostrarPanelInput() {
		setContentPane(inputPanel);
	}

	public void mostrarPanelLobbys() {
		setContentPane(lobbyPanel);
	}

	public CoverPanel getCoverPanel() {
		return coverPanel;
	}

	public HomePanel getHomePanel() {
		return homePanel;
	}

	public InputPanel getInputPanel() {
		return inputPanel;
	}

	public LobbyPanel getLobbyPanel() {
		return lobbyPanel;
	}

}
