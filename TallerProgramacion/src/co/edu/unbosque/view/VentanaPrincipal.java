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
        setTitle("BIENVENIDA!");

        homePanel = new HomePanel();
        coverPanel = new CoverPanel();
        inputPanel = new InputPanel();
        lobbyPanel = new LobbyPanel();
        setContentPane(inputPanel); // Muestra el panel de portada al inicio

        
        setVisible(true); // Asegúrate de que la ventana sea visible
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
