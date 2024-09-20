package co.edu.unbosque.view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePanel extends JPanel {

	private JLabel img, ganancia, retornoPincel, retornoPintura, retornoProyecto, inversion, inversionPincel,
			inversionPintura, inversionProyecto, inventario, inventarioPincel, inventarioPintura, inventarioProyecto;

	private JButton pincelButton, pinturaButton, proyectoButton, inicio;

	public HomePanel() {
		setSize(1280, 720);
		setLayout(null);
		setVisible(true);

		img = new JLabel();
		ImageIcon imagenPortada1 = new ImageIcon("src/media/Inicio.png");
		Image portadaRedimensionada = imagenPortada1.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		img.setIcon(new ImageIcon(portadaRedimensionada));
		img.setBounds(0, 0, 1280, 720);
		
		inicio = new JButton("Inicio"); //volver al inicio
		inicio.setOpaque(true);
		inicio.setBounds(10, 195, 190, 50);
		inicio.setActionCommand("INICIO");
		
		pincelButton = new JButton("Pinceles");
		pincelButton.setOpaque(true);
		pincelButton.setBounds(10, 250, 190, 50);
		pincelButton.setActionCommand("PINCELES");
		
		pinturaButton = new JButton("Pinturas");
		pinturaButton.setOpaque(true);
		pinturaButton.setBounds(10, 305, 190, 50);
		pinturaButton.setActionCommand("PINTURAS");
		
		proyectoButton = new JButton("Proyectos");
		proyectoButton.setOpaque(true);
		proyectoButton.setBounds(10, 360, 190, 50);
		proyectoButton.setActionCommand("PROYECTOS");
		
		add(inicio);
		add(pincelButton);
		add(pinturaButton);
		add(proyectoButton);
		add(img);
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

	public JButton getInicio() {
		return inicio;
	}

	public void setInicio(JButton inicio) {
		this.inicio = inicio;
	}
	
	

}
