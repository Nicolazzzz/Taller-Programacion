package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputPanel extends JPanel {

	private JLabel imgAddPincel, imgUpdatePincel, imgRemovePincel, imgAddPintura, imgUpdatePintura, imgRemovePintura,
			imgAddProyecto, imgUpdateProyecto, imgRemoveProyecto;

	private JButton inicioButtonInput, pincelButtonInput, pinturaButtonInput, proyectoButtonInput, addButtonInput,
			updateButtonInput, removeButtonInput, showButtonInput;

	private JTextField nameField, precioCompraField, precioVentaField, cantidadField, tamanioField, marcaField,
			propioField1, propioField2, propioField3;

	public InputPanel() {

		setSize(1280, 720);
		setLayout(null);
		setVisible(true);
		
		imgAddPincel = new JLabel();
		ImageIcon addPincel = new ImageIcon("src/media/AddPincel.png");
		Image pincelA = addPincel.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		imgAddPincel.setIcon(new ImageIcon(pincelA));
		imgAddPincel.setBounds(0, 0, 1280, 720);
		
		imgUpdatePincel = new JLabel();
		ImageIcon updatePincel = new ImageIcon("src/media/UpdatePincel.png");
		Image pincelU = updatePincel.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		imgUpdatePincel.setIcon(new ImageIcon(pincelU));
		imgUpdatePincel.setBounds(0, 0, 1280, 720);
		
		imgRemovePincel = new JLabel();
		ImageIcon deletePincel = new ImageIcon("src/media/RemovePincel.png");
		Image pincelD = deletePincel.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		imgRemovePincel.setIcon(new ImageIcon(pincelD));
		imgRemovePincel.setBounds(0, 0, 1280, 720);
		
		imgAddPintura = new JLabel();
		ImageIcon imagenPortada1 = new ImageIcon("src/media/AddPintura.png");
		Image portadaRedimensionada = imagenPortada1.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		imgAddPintura.setIcon(new ImageIcon(portadaRedimensionada));
		imgAddPintura.setBounds(0, 0, 1280, 720);
		
		imgUpdatePintura = new JLabel();
		ImageIcon updatePintura = new ImageIcon("src/media/UpdatePintura.png");
		Image pinturaU = updatePintura.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		imgUpdatePintura.setIcon(new ImageIcon(pinturaU));
		imgUpdatePintura.setBounds(0, 0, 1280, 720);
		
		imgRemovePintura = new JLabel();
		ImageIcon removePintura = new ImageIcon("src/media/RemovePintura.png");
		Image pinturaR = removePintura.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		imgRemovePintura.setIcon(new ImageIcon(pinturaR));
		imgRemovePintura.setBounds(0, 0, 1280, 720);
		
		imgAddProyecto = new JLabel();
		ImageIcon addProyecto = new ImageIcon("src/media/AddProyecto.png");
		Image proyectoA = addProyecto.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		imgAddProyecto.setIcon(new ImageIcon(proyectoA));
		imgAddProyecto.setBounds(0, 0, 1280, 720);
		
		imgUpdateProyecto = new JLabel();
		ImageIcon updateProyecto = new ImageIcon("src/media/UpdateProyecto.png");
		Image proyectoU = updateProyecto.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		imgUpdateProyecto.setIcon(new ImageIcon(proyectoU));
		imgUpdateProyecto.setBounds(0, 0, 1280, 720);
		
		
		imgRemoveProyecto = new JLabel();
		ImageIcon removeProyecto = new ImageIcon("src/media/RemoveProyecto.png");
		Image proyectoR = removeProyecto.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		imgRemoveProyecto.setIcon(new ImageIcon(proyectoR));
		imgRemoveProyecto.setBounds(0, 0, 1280, 720);
		
		inicioButtonInput = new JButton("Inicio"); //volver al inicio
		inicioButtonInput.setOpaque(true);
		inicioButtonInput.setBounds(10, 195, 190, 50);
		inicioButtonInput.setActionCommand("INICIOINPUT");
		
		pincelButtonInput = new JButton("Pinceles");
		pincelButtonInput.setOpaque(true);
		pincelButtonInput.setBounds(10, 250, 190, 50);
		pincelButtonInput.setActionCommand("PINCELESINPUT");
		
		pinturaButtonInput = new JButton("Pinturas");
		pinturaButtonInput.setOpaque(true);
		pinturaButtonInput.setBounds(10, 305, 190, 50);
		pinturaButtonInput.setActionCommand("PINTURASINPUT");
		
		proyectoButtonInput = new JButton("Proyectos");
		proyectoButtonInput.setOpaque(true);
		proyectoButtonInput.setBounds(10, 360, 190, 50);
		proyectoButtonInput.setActionCommand("PROYECTOSINPUT");
		
		addButtonInput = new JButton("Agregar");
		addButtonInput.setOpaque(true);
		addButtonInput.setBounds(239, 75, 215, 80);
		addButtonInput.setActionCommand("AGREGARINPUT");
//		addButtonInput.setBackground(new Color(255, 222, 89));//AMARILLO
//		addButtonInput.setBackground(new Color(90, 114, 126));//GRIS
		
		updateButtonInput = new JButton("Actualizar");
		updateButtonInput.setOpaque(true);
		updateButtonInput.setBounds(772, 75, 215, 80);
		updateButtonInput.setActionCommand("AGREGARINPUT");
//		updateButtonInput.setBackground(new Color(255, 222, 89));//AMARILLO
//		updateButtonInput.setBackground(new Color(90, 114, 126));//GRIS
		
		removeButtonInput = new JButton("Eliminar");
		removeButtonInput.setOpaque(true);
		removeButtonInput.setBounds(1042, 75, 215, 80);
		removeButtonInput.setActionCommand("AGREGARINPUT");
//		removeButtonInput.setBackground(new Color(255, 222, 89));//AMARILLO
//		removeButtonInput.setBackground(new Color(90, 114, 126));//GRIS
		
		showButtonInput = new JButton("Mostrar");
		showButtonInput.setOpaque(true);
		showButtonInput.setBounds(505, 75, 215, 80);
		showButtonInput.setActionCommand("AGREGARINPUT");
//		showButtonInput.setBackground(new Color(255, 222, 89));//AMARILLO
//		showButtonInput.setBackground(new Color(90, 114, 126));//GRIS
		
		//TEXTFIELDS ADD
		nameField = new JTextField();
		nameField.setBounds(248, 255, 300, 60);
		nameField.setOpaque(true);
		
		precioCompraField = new JTextField();
		precioCompraField.setBounds(248, 368, 300, 60);
		precioCompraField.setOpaque(true);

		precioVentaField = new JTextField();
		precioVentaField.setBounds(248, 485, 300, 60);
		precioVentaField.setOpaque(true);

		cantidadField = new JTextField();
		cantidadField.setBounds(248, 600, 300, 60);
		cantidadField.setOpaque(true);

		tamanioField = new JTextField();
		tamanioField.setBounds(606, 255, 300, 60);
		tamanioField.setOpaque(true);
		
		marcaField = new JTextField();
		marcaField.setBounds(606, 368, 300, 60);
		marcaField.setOpaque(true);
		
		propioField1 = new JTextField();
		propioField1.setBounds(606, 485, 300, 60);
		propioField1.setOpaque(true);
		
		propioField2 = new JTextField();
		propioField2.setBounds(606, 602, 300, 60);
		propioField2.setOpaque(true);
		
		propioField3 = new JTextField();
		propioField3.setBounds(968, 255, 300, 60);
		propioField3.setOpaque(true);
		//AQUI ACABAN LOS TEXTFIELDS PARA ADD
		
		//TEXTFIELDS UPDATE
		
		
		add(imgUpdatePincel);
		add(imgUpdatePintura);
		add(imgUpdateProyecto);
		add(imgAddPincel);
		add(imgAddPintura);
		add(imgAddProyecto);
		add(imgRemovePincel);
		add(imgRemovePintura);
		add(imgRemoveProyecto);
		add(inicioButtonInput);
		add(pincelButtonInput);
		add(pinturaButtonInput);
		add(proyectoButtonInput);
		add(addButtonInput);
		add(updateButtonInput);
		add(removeButtonInput);
		add(showButtonInput);
//		add(nameField);
//		add(nameField);
//		add(precioCompraField);
//		add(precioVentaField);
//		add(cantidadField);
//		add(tamanioField);
//		add(marcaField);
//		add(propioField1);
//		add(propioField2);
//		add(propioField3);
		
	}

}
