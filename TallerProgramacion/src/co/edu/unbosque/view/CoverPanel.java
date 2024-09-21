package co.edu.unbosque.view;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * La clase {@code CoverPanel} representa un panel que muestra la portada de la
 * aplicación junto con un botón para continuar.
 * 
 * <p>
 * Autor: Mario Rodríguez and Nicolas
 * </p>
 */
public class CoverPanel extends JPanel {

	/**
	 * 
	 */
	private JLabel imagenPortada;
	private JButton continuar;

	/**
	 * Constructor que inicializa el panel de la portada y sus componentes.
	 */
	public CoverPanel() {
		setSize(1280, 720);
		setLayout(null);
		setVisible(true);

		continuar = new JButton("Ingresar");
		continuar.setOpaque(false);
		continuar.setBounds(1030, 45, 200, 79);
		continuar.setActionCommand("CONTINUAR");

		imagenPortada = new JLabel();
		ImageIcon imagenPortada1 = new ImageIcon("src/media/Portada.png");
		Image portadaRedimensionada = imagenPortada1.getImage().getScaledInstance(1280, 690, Image.SCALE_SMOOTH);
		imagenPortada.setIcon(new ImageIcon(portadaRedimensionada));
		imagenPortada.setBounds(0, 0, 1280, 690);

		add(imagenPortada);
		add(continuar);
	}

	/**
	 * Obtiene el botón de continuar.
	 * 
	 * @return El botón de continuar.
	 */
	public JButton getContinuar() {
		return continuar;
	}

	/**
	 * Establece el botón de continuar.
	 * 
	 * @param continuar El botón a establecer.
	 */
	public void setContinuar(JButton continuar) {
		this.continuar = continuar;
	}

	/**
	 * Obtiene la etiqueta de la imagen de portada.
	 * 
	 * @return La etiqueta de la imagen de portada.
	 */
	public JLabel getImagenPortada() {
		return imagenPortada;
	}

	/**
	 * Establece la etiqueta de la imagen de portada.
	 * 
	 * @param imagenPortada La etiqueta a establecer.
	 */
	public void setImagenPortada(JLabel imagenPortada) {
		this.imagenPortada = imagenPortada;
	}

}
