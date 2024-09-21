package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * La clase {@code HomePanel} representa el panel principal de la aplicación,
 * mostrando información sobre ganancias, inversiones e inventarios, así como
 * botones para acceder a diferentes secciones.
 * 
 * <p>
 * Autor: Mario Rodríguez and Nicolas
 * </p>
 */
public class HomePanel extends JPanel {

	private JLabel img, ganancia, retornoPincel, retornoPintura, retornoProyecto, inversion, inversionPincel,
			inversionPintura, inversionProyecto, inventario, inventarioPincel, inventarioPintura, inventarioProyecto;

	private JButton pincelButton, pinturaButton, proyectoButton;

	/**
	 * Constructor que inicializa el panel principal y sus componentes.
	 */
	public HomePanel() {
		setSize(1280, 720);
		setLayout(null);
		setVisible(true);

		ganancia = new JLabel("0", SwingConstants.CENTER);
		ganancia.setFont(new Font("SansSerif", Font.BOLD, 30));
		ganancia.setForeground(Color.white);
		ganancia.setBounds(258, 130, 170, 50);

		retornoPincel = new JLabel("0", SwingConstants.CENTER);
		retornoPincel.setFont(new Font("SansSerif", Font.BOLD, 30));
		retornoPincel.setForeground(Color.white);
		retornoPincel.setBounds(347, 284, 170, 50);

		retornoPintura = new JLabel("0", SwingConstants.CENTER);
		retornoPintura.setFont(new Font("SansSerif", Font.BOLD, 30));
		retornoPintura.setForeground(Color.white);
		retornoPintura.setBounds(347, 427, 170, 50);

		retornoProyecto = new JLabel("0", SwingConstants.CENTER);
		retornoProyecto.setFont(new Font("SansSerif", Font.BOLD, 30));
		retornoProyecto.setForeground(Color.white);
		retornoProyecto.setBounds(347, 570, 170, 50);

		inversion = new JLabel("0", SwingConstants.CENTER);
		inversion.setFont(new Font("SansSerif", Font.BOLD, 30));
		inversion.setForeground(Color.white);
		inversion.setBounds(620, 130, 150, 50);

		inversionPincel = new JLabel("0", SwingConstants.CENTER);
		inversionPincel.setFont(new Font("SansSerif", Font.BOLD, 30));
		inversionPincel.setForeground(Color.white);
		inversionPincel.setBounds(709, 284, 170, 50);

		inversionPintura = new JLabel("0", SwingConstants.CENTER);
		inversionPintura.setFont(new Font("SansSerif", Font.BOLD, 30));
		inversionPintura.setForeground(Color.white);
		inversionPintura.setBounds(709, 427, 170, 50);

		inversionProyecto = new JLabel("0", SwingConstants.CENTER);
		inversionProyecto.setFont(new Font("SansSerif", Font.BOLD, 30));
		inversionProyecto.setForeground(Color.white);
		inversionProyecto.setBounds(709, 570, 170, 50);

		inventario = new JLabel("0", SwingConstants.CENTER);
		inventario.setFont(new Font("SansSerif", Font.BOLD, 30));
		inventario.setForeground(Color.white);
		inventario.setBounds(980, 130, 140, 50);

		inventarioPincel = new JLabel("0", SwingConstants.CENTER);
		inventarioPincel.setFont(new Font("SansSerif", Font.BOLD, 30));
		inventarioPincel.setForeground(Color.white);
		inventarioPincel.setBounds(1069, 284, 170, 50);

		inventarioPintura = new JLabel("0", SwingConstants.CENTER);
		inventarioPintura.setFont(new Font("SansSerif", Font.BOLD, 30));
		inventarioPintura.setForeground(Color.white);
		inventarioPintura.setBounds(1069, 427, 170, 50);

		inventarioProyecto = new JLabel("0", SwingConstants.CENTER);
		inventarioProyecto.setFont(new Font("SansSerif", Font.BOLD, 30));
		inventarioProyecto.setForeground(Color.white);
		inventarioProyecto.setBounds(1069, 570, 170, 50);

		pincelButton = new JButton("Pinceles");
		pincelButton.setOpaque(false);
		pincelButton.setBounds(10, 250, 190, 50);
		pincelButton.setActionCommand("PINCELES");

		pinturaButton = new JButton("Pinturas");
		pinturaButton.setOpaque(false);
		pinturaButton.setBounds(10, 305, 190, 50);
		pinturaButton.setActionCommand("PINTURAS");

		proyectoButton = new JButton("Proyectos");
		proyectoButton.setOpaque(true);
		proyectoButton.setBounds(10, 360, 190, 50);
		proyectoButton.setActionCommand("PROYECTOS");

		img = new JLabel();
		ImageIcon imagenPortada1 = new ImageIcon("src/media/Inicio.png");
		Image portadaRedimensionada = imagenPortada1.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		img.setIcon(new ImageIcon(portadaRedimensionada));
		img.setBounds(0, 0, 1280, 720);
		img.setVisible(true);

		add(ganancia);
		add(retornoPincel);
		add(retornoPintura);
		add(retornoProyecto);
		add(inversion);
		add(inversionPincel);
		add(inversionPintura);
		add(inversionProyecto);
		add(inventario);
		add(inventarioPincel);
		add(inventarioPintura);
		add(inventarioProyecto);
		add(img);
		add(pincelButton);
		add(pinturaButton);
		add(proyectoButton);
	}

	/**
	 * Obtiene la etiqueta de la imagen de fondo.
	 * 
	 * @return La etiqueta de la imagen.
	 */
	public JLabel getImg() {
		return img;
	}

	/**
	 * Establece la etiqueta de la imagen de fondo.
	 * 
	 * @param img La etiqueta a establecer.
	 */
	public void setImg(JLabel img) {
		this.img = img;
	}

	/**
	 * Obtiene la etiqueta de ganancia.
	 * 
	 * @return La etiqueta de ganancia.
	 */
	public JLabel getGanancia() {
		return ganancia;
	}

	/**
	 * Establece la etiqueta de ganancia.
	 * 
	 * @param ganancia La etiqueta a establecer.
	 */
	public void setGanancia(JLabel ganancia) {
		this.ganancia = ganancia;
	}

	/**
	 * Obtiene la etiqueta de retorno de pincel.
	 * 
	 * @return La etiqueta de retorno de pincel.
	 */
	public JLabel getRetornoPincel() {
		return retornoPincel;
	}

	/**
	 * Establece la etiqueta de retorno de pincel.
	 * 
	 * @param retornoPincel La etiqueta a establecer.
	 */
	public void setRetornoPincel(JLabel retornoPincel) {
		this.retornoPincel = retornoPincel;
	}

	/**
	 * Obtiene la etiqueta de retorno de pintura.
	 * 
	 * @return La etiqueta de retorno de pintura.
	 */
	public JLabel getRetornoPintura() {
		return retornoPintura;
	}

	/**
	 * Establece la etiqueta de retorno de pintura.
	 * 
	 * @param retornoPintura La etiqueta a establecer.
	 */
	public void setRetornoPintura(JLabel retornoPintura) {
		this.retornoPintura = retornoPintura;
	}

	/**
	 * Obtiene la etiqueta de retorno de proyecto.
	 * 
	 * @return La etiqueta de retorno de proyecto.
	 */
	public JLabel getRetornoProyecto() {
		return retornoProyecto;
	}

	/**
	 * Establece la etiqueta de retorno de proyecto.
	 * 
	 * @param retornoProyecto La etiqueta a establecer.
	 */
	public void setRetornoProyecto(JLabel retornoProyecto) {
		this.retornoProyecto = retornoProyecto;
	}

	/**
	 * Obtiene la etiqueta de inversión total.
	 * 
	 * @return La etiqueta de inversión.
	 */
	public JLabel getInversion() {
		return inversion;
	}

	/**
	 * Establece la etiqueta de inversión total.
	 * 
	 * @param inversion La etiqueta a establecer.
	 */
	public void setInversion(JLabel inversion) {
		this.inversion = inversion;
	}

	/**
	 * Obtiene la etiqueta de inversión de pincel.
	 * 
	 * @return La etiqueta de inversión de pincel.
	 */
	public JLabel getInversionPincel() {
		return inversionPincel;
	}

	/**
	 * Establece la etiqueta de inversión de pincel.
	 * 
	 * @param inversionPincel La etiqueta a establecer.
	 */
	public void setInversionPincel(JLabel inversionPincel) {
		this.inversionPincel = inversionPincel;
	}

	/**
	 * Obtiene la etiqueta de inversión de pintura.
	 * 
	 * @return La etiqueta de inversión de pintura.
	 */
	public JLabel getInversionPintura() {
		return inversionPintura;
	}

	/**
	 * Establece la etiqueta de inversión de pintura.
	 * 
	 * @param inversionPintura La etiqueta a establecer.
	 */
	public void setInversionPintura(JLabel inversionPintura) {
		this.inversionPintura = inversionPintura;
	}

	/**
	 * Obtiene la etiqueta de inversión de proyecto.
	 * 
	 * @return La etiqueta de inversión de proyecto.
	 */
	public JLabel getInversionProyecto() {
		return inversionProyecto;
	}

	/**
	 * Establece la etiqueta de inversión de proyecto.
	 * 
	 * @param inversionProyecto La etiqueta a establecer.
	 */
	public void setInversionProyecto(JLabel inversionProyecto) {
		this.inversionProyecto = inversionProyecto;
	}

	/**
	 * Obtiene la etiqueta de inventario total.
	 * 
	 * @return La etiqueta de inventario.
	 */
	public JLabel getInventario() {
		return inventario;
	}

	/**
	 * Establece la etiqueta de inventario total.
	 * 
	 * @param inventario La etiqueta a establecer.
	 */
	public void setInventario(JLabel inventario) {
		this.inventario = inventario;
	}

	/**
	 * Obtiene la etiqueta de inventario de pincel.
	 * 
	 * @return La etiqueta de inventario de pincel.
	 */
	public JLabel getInventarioPincel() {
		return inventarioPincel;
	}

	/**
	 * Establece la etiqueta de inventario de pincel.
	 * 
	 * @param inventarioPincel La etiqueta a establecer.
	 */
	public void setInventarioPincel(JLabel inventarioPincel) {
		this.inventarioPincel = inventarioPincel;
	}

	/**
	 * Obtiene la etiqueta de inventario de pintura.
	 * 
	 * @return La etiqueta de inventario de pintura.
	 */
	public JLabel getInventarioPintura() {
		return inventarioPintura;
	}

	/**
	 * Establece la etiqueta de inventario de pintura.
	 * 
	 * @param inventarioPintura La etiqueta a establecer.
	 */
	public void setInventarioPintura(JLabel inventarioPintura) {
		this.inventarioPintura = inventarioPintura;
	}

	/**
	 * Obtiene la etiqueta de inventario de proyecto.
	 * 
	 * @return La etiqueta de inventario de proyecto.
	 */
	public JLabel getInventarioProyecto() {
		return inventarioProyecto;
	}

	/**
	 * Establece la etiqueta de inventario de proyecto.
	 * 
	 * @param inventarioProyecto La etiqueta a establecer.
	 */
	public void setInventarioProyecto(JLabel inventarioProyecto) {
		this.inventarioProyecto = inventarioProyecto;
	}

	/**
	 * Obtiene el botón de pinceles.
	 * 
	 * @return El botón de pinceles.
	 */
	public JButton getPincelButton() {
		return pincelButton;
	}

	/**
	 * Establece el botón de pinceles.
	 * 
	 * @param pincelButton El botón a establecer.
	 */
	public void setPincelButton(JButton pincelButton) {
		this.pincelButton = pincelButton;
	}

	/**
	 * Obtiene el botón de pinturas.
	 * 
	 * @return El botón de pinturas.
	 */
	public JButton getPinturaButton() {
		return pinturaButton;
	}

	/**
	 * Establece el botón de pinturas.
	 * 
	 * @param pinturaButton El botón a establecer.
	 */
	public void setPinturaButton(JButton pinturaButton) {
		this.pinturaButton = pinturaButton;
	}

	/**
	 * Obtiene el botón de proyectos.
	 * 
	 * @return El botón de proyectos.
	 */
	public JButton getProyectoButton() {
		return proyectoButton;
	}

	/**
	 * Establece el botón de proyectos.
	 * 
	 * @param proyectoButton El botón a establecer.
	 */
	public void setProyectoButton(JButton proyectoButton) {
		this.proyectoButton = proyectoButton;
	}

}
