package co.edu.unbosque.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputPanel extends JPanel {

	private JLabel img;

	private JButton inicioButtonInput, pincelButtonInput, pinturaButtonInput, proyectoButtonInput, addButtonInput,
			updateButtonInput, removeButtonInput, showButtonInput;

	private JTextField nameField, precioCompraField, precioVentaField, cantidadField, tamanioField, marcaField,
			propioField1, propioField2, propioField3;

	public InputPanel() {

		setSize(1280, 720);
		setLayout(null);
		setVisible(true);
	}

}
