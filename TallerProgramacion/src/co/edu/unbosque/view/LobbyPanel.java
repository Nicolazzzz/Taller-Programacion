package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LobbyPanel extends JPanel {

	private JLabel lobbyPincel, lobbyPintura, lobbyProyecto;
	private JButton addButton, updateButton, removeButton, showButton, inicioButton, pincelButton, pinturaButton,
			proyectoButton;

	public LobbyPanel() {
		setSize(1280, 720);
		setLayout(null);
		setVisible(true);

		lobbyPincel = new JLabel();
        ImageIcon lobbyP = new ImageIcon("src/media/LobbyPincel.png");
        Image pLobby = lobbyP.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
        lobbyPincel.setIcon(new ImageIcon(pLobby));
        lobbyPincel.setBounds(0, 0, 1280, 720);
        
        lobbyPintura = new JLabel();
        ImageIcon lobbyPi = new ImageIcon("src/media/LobbyPintura.png");
        Image piLobby = lobbyPi.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
        lobbyPintura.setIcon(new ImageIcon(piLobby));
        lobbyPintura.setBounds(0, 0, 1280, 720);
        
        lobbyProyecto = new JLabel();
        ImageIcon lobbyPr = new ImageIcon("src/media/LobbyProyecto.png");
        Image prLobby = lobbyPr.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
        lobbyProyecto.setIcon(new ImageIcon(prLobby));
        lobbyProyecto.setBounds(0, 0, 1280, 720);
        
        inicioButton = new JButton("Inicio"); //volver al inicio
		inicioButton.setOpaque(true);
		inicioButton.setBounds(10, 195, 190, 50);
		inicioButton.setActionCommand("INICIOLOBBY");
		
		pincelButton = new JButton("Pinceles");
		pincelButton.setOpaque(true);
		pincelButton.setBounds(10, 250, 190, 50);
		pincelButton.setActionCommand("PINCELESLOBBY");
		
		pinturaButton = new JButton("Pinturas");
		pinturaButton.setOpaque(true);
		pinturaButton.setBounds(10, 305, 190, 50);
		pinturaButton.setActionCommand("PINTURASLOBBY");
		
		proyectoButton = new JButton("Proyectos");
		proyectoButton.setOpaque(true);
		proyectoButton.setBounds(10, 360, 190, 50);
		proyectoButton.setActionCommand("PROYECTOSLOBBY");
		
		addButton = new JButton("Agregar");
		addButton.setOpaque(true);
		addButton.setBounds(239, 75, 215, 80);
		addButton.setActionCommand("AGREGARLOBBY");
		addButton.setBackground(new Color(255, 222, 89));//AMARILLO
//		addButtonInput.setBackground(new Color(90, 114, 126));//GRIS
		
		updateButton = new JButton("Actualizar");
		updateButton.setOpaque(true);
		updateButton.setBounds(772, 75, 215, 80);
		updateButton.setActionCommand("ACTUALIZARLOBBY");
		updateButton.setBackground(new Color(255, 222, 89));//AMARILLO
//		updateButtonInput.setBackground(new Color(90, 114, 126));//GRIS
		
		removeButton = new JButton("Eliminar");
		removeButton.setOpaque(true);
		removeButton.setBounds(1042, 75, 215, 80);
		removeButton.setActionCommand("ELIMINARLOBBY");
		removeButton.setBackground(new Color(255, 222, 89));//AMARILLO
//		removeButtonInput.setBackground(new Color(90, 114, 126));//GRIS
		
		showButton = new JButton("Mostrar");
		showButton.setOpaque(true);
		showButton.setBounds(505, 75, 215, 80);
		showButton.setActionCommand("MOSTRARLOBBY");
		showButton.setBackground(new Color(255, 222, 89));//AMARILLO
//		showButtonInput.setBackground(new Color(90, 114, 126));//GRIS
		
		
		
		add(lobbyProyecto);
		add(lobbyPintura);
		add(lobbyPincel);
		add(addButton);
		add(updateButton);
		add(removeButton);
		add(showButton);
		add(inicioButton);
		add(pincelButton);
		add(pinturaButton);
		add(proyectoButton);
	}

}
