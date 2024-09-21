package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class HomePanel extends JPanel {

	private JLabel img, ganancia, retornoPincel, retornoPintura, retornoProyecto, inversion, inversionPincel,
			inversionPintura, inversionProyecto, inventario, inventarioPincel, inventarioPintura, inventarioProyecto;

	private JButton pincelButton, pinturaButton, proyectoButton;

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

	public JLabel getImg() {
		return img;
	}

	public void setImg(JLabel img) {
		this.img = img;
	}

	public JLabel getGanancia() {
		return ganancia;
	}

	public void setGanancia(JLabel ganancia) {
		this.ganancia = ganancia;
	}

	public JLabel getRetornoPincel() {
		return retornoPincel;
	}

	public void setRetornoPincel(JLabel retornoPincel) {
		this.retornoPincel = retornoPincel;
	}

	public JLabel getRetornoPintura() {
		return retornoPintura;
	}

	public void setRetornoPintura(JLabel retornoPintura) {
		this.retornoPintura = retornoPintura;
	}

	public JLabel getRetornoProyecto() {
		return retornoProyecto;
	}

	public void setRetornoProyecto(JLabel retornoProyecto) {
		this.retornoProyecto = retornoProyecto;
	}

	public JLabel getInversion() {
		return inversion;
	}

	public void setInversion(JLabel inversion) {
		this.inversion = inversion;
	}

	public JLabel getInversionPincel() {
		return inversionPincel;
	}

	public void setInversionPincel(JLabel inversionPincel) {
		this.inversionPincel = inversionPincel;
	}

	public JLabel getInversionPintura() {
		return inversionPintura;
	}

	public void setInversionPintura(JLabel inversionPintura) {
		this.inversionPintura = inversionPintura;
	}

	public JLabel getInversionProyecto() {
		return inversionProyecto;
	}

	public void setInversionProyecto(JLabel inversionProyecto) {
		this.inversionProyecto = inversionProyecto;
	}

	public JLabel getInventario() {
		return inventario;
	}

	public void setInventario(JLabel inventario) {
		this.inventario = inventario;
	}

	public JLabel getInventarioPincel() {
		return inventarioPincel;
	}

	public void setInventarioPincel(JLabel inventarioPincel) {
		this.inventarioPincel = inventarioPincel;
	}

	public JLabel getInventarioPintura() {
		return inventarioPintura;
	}

	public void setInventarioPintura(JLabel inventarioPintura) {
		this.inventarioPintura = inventarioPintura;
	}

	public JLabel getInventarioProyecto() {
		return inventarioProyecto;
	}

	public void setInventarioProyecto(JLabel inventarioProyecto) {
		this.inventarioProyecto = inventarioProyecto;
	}

	public JButton getPincelButton() {
		return pincelButton;
	}

	public void setPincelButton(JButton pincelButton) {
		this.pincelButton = pincelButton;
	}

	public JButton getPinturaButton() {
		return pinturaButton;
	}

	public void setPinturaButton(JButton pinturaButton) {
		this.pinturaButton = pinturaButton;
	}

	public JButton getProyectoButton() {
		return proyectoButton;
	}

	public void setProyectoButton(JButton proyectoButton) {
		this.proyectoButton = proyectoButton;
	}

}
