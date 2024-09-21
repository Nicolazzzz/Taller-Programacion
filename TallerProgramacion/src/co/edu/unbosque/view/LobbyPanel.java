package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Clase que representa el panel principal del lobby en la interfaz de usuario.
 * Este panel contiene botones y etiquetas que permiten a los usuarios navegar y
 * realizar acciones dentro de la aplicación.
 * 
 * @author Mario Rodríguez
 */
public class LobbyPanel extends JPanel {

	private JLabel lobbyPincel, lobbyPintura, lobbyProyecto;
	private JButton addButton, updateButton, removeButton, showButton, inicioButton, pincelButton, pinturaButton,
			proyectoButton;

	/**
	 * Constructor que inicializa el panel de lobby. Se configuran los componentes
	 * visuales, incluyendo botones y etiquetas.
	 */
	public LobbyPanel() {
		setSize(1280, 720);
		setLayout(null);
		setVisible(true);

		inicioButton = new JButton("Inicio"); // volver al inicio
		inicioButton.setOpaque(false);
		inicioButton.setBounds(10, 195, 190, 50);
		inicioButton.setActionCommand("INICIOLOBBY");

		pincelButton = new JButton("Pinceles");
		pincelButton.setOpaque(false);
		pincelButton.setBounds(10, 250, 190, 50);
		pincelButton.setActionCommand("PINCELESLOBBY");

		pinturaButton = new JButton("Pinturas");
		pinturaButton.setOpaque(false);
		pinturaButton.setBounds(10, 305, 190, 50);
		pinturaButton.setActionCommand("PINTURASLOBBY");

		proyectoButton = new JButton("Proyectos");
		proyectoButton.setOpaque(false);
		proyectoButton.setBounds(10, 360, 190, 50);
		proyectoButton.setActionCommand("PROYECTOSLOBBY");

		addButton = new JButton("Agregar");
		addButton.setOpaque(false);
		addButton.setBounds(239, 75, 215, 80);
		addButton.setActionCommand("AGREGARLOBBY");
		addButton.setBackground(new Color(255, 222, 89)); // AMARILLO

		updateButton = new JButton("Actualizar");
		updateButton.setOpaque(false);
		updateButton.setBounds(772, 75, 215, 80);
		updateButton.setActionCommand("ACTUALIZARLOBBY");
		updateButton.setBackground(new Color(255, 222, 89)); // AMARILLO

		removeButton = new JButton("Eliminar");
		removeButton.setOpaque(false);
		removeButton.setBounds(1042, 75, 215, 80);
		removeButton.setActionCommand("ELIMINARLOBBY");
		removeButton.setBackground(new Color(255, 222, 89)); // AMARILLO

		showButton = new JButton("Mostrar");
		showButton.setOpaque(false);
		showButton.setBounds(505, 75, 215, 80);
		showButton.setActionCommand("MOSTRARLOBBY");
		showButton.setBackground(new Color(255, 222, 89)); // AMARILLO

		lobbyPincel = new JLabel();
		ImageIcon lobbyP = new ImageIcon("src/media/LobbyPincel.png");
		Image pLobby = lobbyP.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		lobbyPincel.setIcon(new ImageIcon(pLobby));
		lobbyPincel.setBounds(0, 0, 1280, 720);
		lobbyPincel.setVisible(false);

		lobbyPintura = new JLabel();
		ImageIcon lobbyPi = new ImageIcon("src/media/LobbyPintura.png");
		Image piLobby = lobbyPi.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		lobbyPintura.setIcon(new ImageIcon(piLobby));
		lobbyPintura.setBounds(0, 0, 1280, 720);
		lobbyPintura.setVisible(false);

		lobbyProyecto = new JLabel();
		ImageIcon lobbyPr = new ImageIcon("src/media/LobbyProyecto.png");
		Image prLobby = lobbyPr.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		lobbyProyecto.setIcon(new ImageIcon(prLobby));
		lobbyProyecto.setBounds(0, 0, 1280, 720);
		lobbyProyecto.setVisible(false);

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

	/**
	 * Obtiene la etiqueta del lobby de pincel.
	 * 
	 * @return JLabel correspondiente al lobby de pincel.
	 */
	public JLabel getLobbyPincel() {
		return lobbyPincel;
	}

	/**
	 * Establece la etiqueta del lobby de pincel.
	 * 
	 * @param lobbyPincel JLabel a establecer.
	 */
	public void setLobbyPincel(JLabel lobbyPincel) {
		this.lobbyPincel = lobbyPincel;
	}

	/**
	 * Obtiene la etiqueta del lobby de pintura.
	 * 
	 * @return JLabel correspondiente al lobby de pintura.
	 */
	public JLabel getLobbyPintura() {
		return lobbyPintura;
	}

	/**
	 * Establece la etiqueta del lobby de pintura.
	 * 
	 * @param lobbyPintura JLabel a establecer.
	 */
	public void setLobbyPintura(JLabel lobbyPintura) {
		this.lobbyPintura = lobbyPintura;
	}

	/**
	 * Obtiene la etiqueta del lobby de proyecto.
	 * 
	 * @return JLabel correspondiente al lobby de proyecto.
	 */
	public JLabel getLobbyProyecto() {
		return lobbyProyecto;
	}

	/**
	 * Establece la etiqueta del lobby de proyecto.
	 * 
	 * @param lobbyProyecto JLabel a establecer.
	 */
	public void setLobbyProyecto(JLabel lobbyProyecto) {
		this.lobbyProyecto = lobbyProyecto;
	}

	/**
	 * Obtiene el botón de agregar.
	 * 
	 * @return JButton correspondiente al botón de agregar.
	 */
	public JButton getAddButton() {
		return addButton;
	}

	/**
	 * Establece el botón de agregar.
	 * 
	 * @param addButton JButton a establecer.
	 */
	public void setAddButton(JButton addButton) {
		this.addButton = addButton;
	}

	/**
	 * Obtiene el botón de actualizar.
	 * 
	 * @return JButton correspondiente al botón de actualizar.
	 */
	public JButton getUpdateButton() {
		return updateButton;
	}

	/**
	 * Establece el botón de actualizar.
	 * 
	 * @param updateButton JButton a establecer.
	 */
	public void setUpdateButton(JButton updateButton) {
		this.updateButton = updateButton;
	}

	/**
	 * Obtiene el botón de eliminar.
	 * 
	 * @return JButton correspondiente al botón de eliminar.
	 */
	public JButton getRemoveButton() {
		return removeButton;
	}

	/**
	 * Establece el botón de eliminar.
	 * 
	 * @param removeButton JButton a establecer.
	 */
	public void setRemoveButton(JButton removeButton) {
		this.removeButton = removeButton;
	}

	/**
	 * Obtiene el botón de mostrar.
	 * 
	 * @return JButton correspondiente al botón de mostrar.
	 */
	public JButton getShowButton() {
		return showButton;
	}

	/**
	 * Establece el botón de mostrar.
	 * 
	 * @param showButton JButton a establecer.
	 */
	public void setShowButton(JButton showButton) {
		this.showButton = showButton;
	}

	/**
	 * Obtiene el botón de inicio.
	 * 
	 * @return JButton correspondiente al botón de inicio.
	 */
	public JButton getInicioButton() {
		return inicioButton;
	}

	/**
	 * Establece el botón de inicio.
	 * 
	 * @param inicioButton JButton a establecer.
	 */
	public void setInicioButton(JButton inicioButton) {
		this.inicioButton = inicioButton;
	}

	/**
	 * Obtiene el botón de pinceles.
	 * 
	 * @return JButton correspondiente al botón de pinceles.
	 */
	public JButton getPincelButton() {
		return pincelButton;
	}

	/**
	 * Establece el botón de pinceles.
	 * 
	 * @param pincelButton JButton a establecer.
	 */
	public void setPincelButton(JButton pincelButton) {
		this.pincelButton = pincelButton;
	}

	/**
	 * Obtiene el botón de pinturas.
	 * 
	 * @return JButton correspondiente al botón de pinturas.
	 */
	public JButton getPinturaButton() {
		return pinturaButton;
	}

	/**
	 * Establece el botón de pinturas.
	 * 
	 * @param pinturaButton JButton a establecer.
	 */
	public void setPinturaButton(JButton pinturaButton) {
		this.pinturaButton = pinturaButton;
	}

	/**
	 * Obtiene el botón de proyectos.
	 * 
	 * @return JButton correspondiente al botón de proyectos.
	 */
	public JButton getProyectoButton() {
		return proyectoButton;
	}

	/**
	 * Establece el botón de proyectos.
	 * 
	 * @param proyectoButton JButton a establecer.
	 */
	public void setProyectoButton(JButton proyectoButton) {
		this.proyectoButton = proyectoButton;
	}
}
