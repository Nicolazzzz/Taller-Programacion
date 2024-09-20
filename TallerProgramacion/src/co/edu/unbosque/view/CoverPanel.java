package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CoverPanel extends JPanel {

    private JLabel imagenPortada;
    private JButton continuar;

    public CoverPanel() {
        setSize(1280, 720);
        setLayout(null);
        setVisible(true);

        imagenPortada = new JLabel();
        ImageIcon imagenPortada1 = new ImageIcon("src/media/Portada.png");
        Image portadaRedimensionada = imagenPortada1.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
        imagenPortada.setIcon(new ImageIcon(portadaRedimensionada));
        imagenPortada.setBounds(0, 0, 1280, 720);
        
        continuar = new JButton("Ingresar");
        continuar.setOpaque(true);
        continuar.setBounds(1030, 45, 200, 79);
        continuar.setActionCommand("CONTINUAR");

        add(imagenPortada);
        add(continuar);
    }

	public JButton getContinuar() {
		return continuar;
	}

	public void setContinuar(JButton continuar) {
		this.continuar = continuar;
	}

	public JLabel getImagenPortada() {
		return imagenPortada;
	}

	public void setImagenPortada(JLabel imagenPortada) {
		this.imagenPortada = imagenPortada;
	}
    
    
}