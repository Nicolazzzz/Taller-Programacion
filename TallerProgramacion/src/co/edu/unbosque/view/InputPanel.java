package co.edu.unbosque.view;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Clase que representa un panel de entrada en la interfaz gráfica. Este panel
 * incluye botones y campos de texto para gestionar pinceles, pinturas y
 * proyectos. Proporciona la funcionalidad para agregar, actualizar, eliminar y
 * mostrar elementos.
 * 
 * @author Mario Rodríguez and Nicolas
 */
public class InputPanel extends JPanel {

	// Etiquetas para las imágenes relacionadas con pinceles, pinturas y proyectos
	private JLabel imgAddPincel, imgUpdatePincel, imgRemovePincel, imgAddPintura, imgUpdatePintura, imgRemovePintura,
			imgAddProyecto, imgUpdateProyecto, imgRemoveProyecto;

	// Botones para la interfaz
	private JButton inicioButtonInput, pincelButtonInput, pinturaButtonInput, proyectoButtonInput, addButtonInput,
			updateButtonInput, removeButtonInput, showButtonInput;

	// Campos de texto para ingresar datos
	private JTextField nameField, precioCompraField, precioVentaField, cantidadField, tamanioField, marcaField,
			propioField1, propioField2, propioField3;

	/**
	 * Constructor de la clase InputPanel. Inicializa el panel, sus botones y
	 * etiquetas de imágenes.
	 */
	public InputPanel() {
		// Configuración del panel
		setSize(1280, 720);
		setLayout(null);
		setVisible(true);

		// Inicialización y configuración de botones
		inicioButtonInput = new JButton("Inicio"); // volver al inicio
		inicioButtonInput.setOpaque(false);
		inicioButtonInput.setBounds(10, 195, 190, 50);
		inicioButtonInput.setActionCommand("INICIOINPUT");

		pincelButtonInput = new JButton("Pinceles");
		pincelButtonInput.setOpaque(false);
		pincelButtonInput.setBounds(10, 250, 190, 50);
		pincelButtonInput.setActionCommand("PINCELESINPUT");

		pinturaButtonInput = new JButton("Pinturas");
		pinturaButtonInput.setOpaque(false);
		pinturaButtonInput.setBounds(10, 305, 190, 50);
		pinturaButtonInput.setActionCommand("PINTURASINPUT");

		proyectoButtonInput = new JButton("Proyectos");
		proyectoButtonInput.setOpaque(false);
		proyectoButtonInput.setBounds(10, 360, 190, 50);
		proyectoButtonInput.setActionCommand("PROYECTOSINPUT");

		addButtonInput = new JButton("Agregar");
		addButtonInput.setOpaque(false);
		addButtonInput.setBounds(239, 75, 215, 80);
		addButtonInput.setActionCommand("AGREGARINPUT");

		updateButtonInput = new JButton("Actualizar");
		updateButtonInput.setOpaque(false);
		updateButtonInput.setBounds(772, 75, 215, 80);
		updateButtonInput.setActionCommand("ACTUALIZARINPUT");

		removeButtonInput = new JButton("Eliminar");
		removeButtonInput.setOpaque(false);
		removeButtonInput.setBounds(1042, 75, 215, 80);
		removeButtonInput.setActionCommand("ELIMINARINPUT");

		showButtonInput = new JButton("Mostrar");
		showButtonInput.setOpaque(false);
		showButtonInput.setBounds(505, 75, 215, 80);
		showButtonInput.setActionCommand("MOSTRARINPUT");

		// Inicialización de etiquetas de imágenes con escalado
		imgAddPincel = new JLabel();
		ImageIcon addPincel = new ImageIcon("src/media/AddPincel.png");
		Image pincelA = addPincel.getImage().getScaledInstance(1270, 720, Image.SCALE_SMOOTH);
		imgAddPincel.setIcon(new ImageIcon(pincelA));
		imgAddPincel.setBounds(0, 0, 1270, 720);
		imgAddPincel.setVisible(false);

		imgUpdatePincel = new JLabel();
		ImageIcon updatePincel = new ImageIcon("src/media/UpdatePincel.png");
		Image pincelU = updatePincel.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		imgUpdatePincel.setIcon(new ImageIcon(pincelU));
		imgUpdatePincel.setBounds(0, 0, 1280, 720);
		imgUpdatePincel.setVisible(false);

		imgRemovePincel = new JLabel();
		ImageIcon deletePincel = new ImageIcon("src/media/RemovePincel.png");
		Image pincelD = deletePincel.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		imgRemovePincel.setIcon(new ImageIcon(pincelD));
		imgRemovePincel.setBounds(0, 0, 1280, 720);
		imgRemovePincel.setVisible(false);

		// Inicialización de etiquetas de imágenes para pinturas
		imgAddPintura = new JLabel();
		ImageIcon imagenPortada1 = new ImageIcon("src/media/AddPintura.png");
		Image portadaRedimensionada = imagenPortada1.getImage().getScaledInstance(1270, 720, Image.SCALE_SMOOTH);
		imgAddPintura.setIcon(new ImageIcon(portadaRedimensionada));
		imgAddPintura.setBounds(0, 0, 1270, 720);
		imgAddPintura.setVisible(false);

		imgUpdatePintura = new JLabel();
		ImageIcon updatePintura = new ImageIcon("src/media/UpdatePintura.png");
		Image pinturaU = updatePintura.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		imgUpdatePintura.setIcon(new ImageIcon(pinturaU));
		imgUpdatePintura.setBounds(0, 0, 1280, 720);
		imgUpdatePintura.setVisible(false);

		imgRemovePintura = new JLabel();
		ImageIcon removePintura = new ImageIcon("src/media/RemovePintura.png");
		Image pinturaR = removePintura.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		imgRemovePintura.setIcon(new ImageIcon(pinturaR));
		imgRemovePintura.setBounds(0, 0, 1280, 720);
		imgRemovePintura.setVisible(false);

		// Inicialización de etiquetas de imágenes para proyectos
		imgAddProyecto = new JLabel();
		ImageIcon addProyecto = new ImageIcon("src/media/AddProyecto.png");
		Image proyectoA = addProyecto.getImage().getScaledInstance(1270, 720, Image.SCALE_SMOOTH);
		imgAddProyecto.setIcon(new ImageIcon(proyectoA));
		imgAddProyecto.setBounds(0, 0, 1270, 720);
		imgAddProyecto.setVisible(false);

		imgUpdateProyecto = new JLabel();
		ImageIcon updateProyecto = new ImageIcon("src/media/UpdateProyecto.png");
		Image proyectoU = updateProyecto.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		imgUpdateProyecto.setIcon(new ImageIcon(proyectoU));
		imgUpdateProyecto.setBounds(0, 0, 1280, 720);
		imgUpdateProyecto.setVisible(false);

		imgRemoveProyecto = new JLabel();
		ImageIcon removeProyecto = new ImageIcon("src/media/RemoveProyecto.png");
		Image proyectoR = removeProyecto.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		imgRemoveProyecto.setIcon(new ImageIcon(proyectoR));
		imgRemoveProyecto.setBounds(0, 0, 1280, 720);
		imgRemoveProyecto.setVisible(false);

		// Inicialización de campos de texto
		nameField = new JTextField();
		nameField.setBounds(248, 255, 300, 60);
		nameField.setOpaque(true);
		nameField.setVisible(false);

		precioCompraField = new JTextField();
		precioCompraField.setBounds(248, 368, 300, 60);
		precioCompraField.setOpaque(true);
		precioCompraField.setVisible(false);

		precioVentaField = new JTextField();
		precioVentaField.setBounds(248, 485, 300, 60);
		precioVentaField.setOpaque(true);
		precioVentaField.setVisible(false);

		cantidadField = new JTextField();
		cantidadField.setBounds(248, 600, 300, 60);
		cantidadField.setOpaque(true);
		cantidadField.setVisible(false);

		tamanioField = new JTextField();
		tamanioField.setBounds(606, 255, 300, 60);
		tamanioField.setOpaque(true);
		tamanioField.setVisible(false);

		marcaField = new JTextField();
		marcaField.setBounds(606, 368, 300, 60);
		marcaField.setOpaque(true);
		marcaField.setVisible(false);

		propioField1 = new JTextField();
		propioField1.setBounds(606, 485, 300, 60);
		propioField1.setOpaque(true);
		propioField1.setVisible(false);

		propioField2 = new JTextField();
		propioField2.setBounds(606, 602, 300, 60);
		propioField2.setOpaque(true);
		propioField2.setVisible(false);

		propioField3 = new JTextField();
		propioField3.setBounds(968, 255, 290, 60);
		propioField3.setOpaque(true);
		propioField3.setVisible(false);

		// Agregar las imágenes al panel
		add(imgUpdatePincel);
		add(imgUpdatePintura);
		add(imgUpdateProyecto);
		add(imgAddPincel);
		add(imgAddPintura);
		add(imgAddProyecto);
		add(imgRemovePincel);
		add(imgRemovePintura);
		add(imgRemoveProyecto);

		// Agregar botones al panel
		add(inicioButtonInput);
		add(pincelButtonInput);
		add(pinturaButtonInput);
		add(proyectoButtonInput);
		add(addButtonInput);
		add(updateButtonInput);
		add(removeButtonInput);
		add(showButtonInput);

		// Agregar campos de texto al panel
		add(nameField);
		add(precioCompraField);
		add(precioVentaField);
		add(cantidadField);
		add(tamanioField);
		add(marcaField);
		add(propioField1);
		add(propioField2);
		add(propioField3);
	}

	// Métodos de acceso para las propiedades
	public JLabel getImgAddPincel() {
		return imgAddPincel;
	}

	public void setImgAddPincel(JLabel imgAddPincel) {
		this.imgAddPincel = imgAddPincel;
	}

	public JLabel getImgUpdatePincel() {
		return imgUpdatePincel;
	}

	public void setImgUpdatePincel(JLabel imgUpdatePincel) {
		this.imgUpdatePincel = imgUpdatePincel;
	}

	public JLabel getImgRemovePincel() {
		return imgRemovePincel;
	}

	public void setImgRemovePincel(JLabel imgRemovePincel) {
		this.imgRemovePincel = imgRemovePincel;
	}

	public JLabel getImgAddPintura() {
		return imgAddPintura;
	}

	public void setImgAddPintura(JLabel imgAddPintura) {
		this.imgAddPintura = imgAddPintura;
	}

	public JLabel getImgUpdatePintura() {
		return imgUpdatePintura;
	}

	public void setImgUpdatePintura(JLabel imgUpdatePintura) {
		this.imgUpdatePintura = imgUpdatePintura;
	}

	public JLabel getImgRemovePintura() {
		return imgRemovePintura;
	}

	public void setImgRemovePintura(JLabel imgRemovePintura) {
		this.imgRemovePintura = imgRemovePintura;
	}

	public JLabel getImgAddProyecto() {
		return imgAddProyecto;
	}

	public void setImgAddProyecto(JLabel imgAddProyecto) {
		this.imgAddProyecto = imgAddProyecto;
	}

	public JLabel getImgUpdateProyecto() {
		return imgUpdateProyecto;
	}

	public void setImgUpdateProyecto(JLabel imgUpdateProyecto) {
		this.imgUpdateProyecto = imgUpdateProyecto;
	}

	public JLabel getImgRemoveProyecto() {
		return imgRemoveProyecto;
	}

	public void setImgRemoveProyecto(JLabel imgRemoveProyecto) {
		this.imgRemoveProyecto = imgRemoveProyecto;
	}

	public JButton getInicioButtonInput() {
		return inicioButtonInput;
	}

	public void setInicioButtonInput(JButton inicioButtonInput) {
		this.inicioButtonInput = inicioButtonInput;
	}

	public JButton getPincelButtonInput() {
		return pincelButtonInput;
	}

	public void setPincelButtonInput(JButton pincelButtonInput) {
		this.pincelButtonInput = pincelButtonInput;
	}

	public JButton getPinturaButtonInput() {
		return pinturaButtonInput;
	}

	public void setPinturaButtonInput(JButton pinturaButtonInput) {
		this.pinturaButtonInput = pinturaButtonInput;
	}

	public JButton getProyectoButtonInput() {
		return proyectoButtonInput;
	}

	public void setProyectoButtonInput(JButton proyectoButtonInput) {
		this.proyectoButtonInput = proyectoButtonInput;
	}

	public JButton getAddButtonInput() {
		return addButtonInput;
	}

	public void setAddButtonInput(JButton addButtonInput) {
		this.addButtonInput = addButtonInput;
	}

	public JButton getUpdateButtonInput() {
		return updateButtonInput;
	}

	public void setUpdateButtonInput(JButton updateButtonInput) {
		this.updateButtonInput = updateButtonInput;
	}

	public JButton getRemoveButtonInput() {
		return removeButtonInput;
	}

	public void setRemoveButtonInput(JButton removeButtonInput) {
		this.removeButtonInput = removeButtonInput;
	}

	public JButton getShowButtonInput() {
		return showButtonInput;
	}

	public void setShowButtonInput(JButton showButtonInput) {
		this.showButtonInput = showButtonInput;
	}

	public JTextField getNameField() {
		return nameField;
	}

	public void setNameField(JTextField nameField) {
		this.nameField = nameField;
	}

	public JTextField getPrecioCompraField() {
		return precioCompraField;
	}

	public void setPrecioCompraField(JTextField precioCompraField) {
		this.precioCompraField = precioCompraField;
	}

	public JTextField getPrecioVentaField() {
		return precioVentaField;
	}

	public void setPrecioVentaField(JTextField precioVentaField) {
		this.precioVentaField = precioVentaField;
	}

	public JTextField getCantidadField() {
		return cantidadField;
	}

	public void setCantidadField(JTextField cantidadField) {
		this.cantidadField = cantidadField;
	}

	public JTextField getTamanioField() {
		return tamanioField;
	}

	public void setTamanioField(JTextField tamanioField) {
		this.tamanioField = tamanioField;
	}

	public JTextField getMarcaField() {
		return marcaField;
	}

	public void setMarcaField(JTextField marcaField) {
		this.marcaField = marcaField;
	}

	public JTextField getPropioField1() {
		return propioField1;
	}

	public void setPropioField1(JTextField propioField1) {
		this.propioField1 = propioField1;
	}

	public JTextField getPropioField2() {
		return propioField2;
	}

	public void setPropioField2(JTextField propioField2) {
		this.propioField2 = propioField2;
	}

	public JTextField getPropioField3() {
		return propioField3;
	}

	public void setPropioField3(JTextField propioField3) {
		this.propioField3 = propioField3;
	}
}
