package co.edu.unbosque.view;

import java.awt.Color;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * La clase {@code Consola} proporciona métodos para interactuar con el usuario
 * a través de la consola y cuadros de diálogo emergentes.
 * 
 * <p>
 * Autor: Mario Rodríguez
 * </p>
 */
public class Consola {

	private Scanner sc;

	/**
	 * Constructor que inicializa el objeto {@code Scanner} para la entrada del
	 * usuario.
	 */
	public Consola() {
		sc = new Scanner(System.in);
	}

	/**
	 * Muestra un mensaje emergente con desplazamiento para texto largo.
	 * 
	 * @param texto El texto a mostrar en el cuadro de diálogo.
	 */
	public void mostrarMensajeEmergenteConScroll(String texto) {
		JTextArea textArea = new JTextArea(30, 50);
		textArea.setText(texto);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setCaretPosition(0);
		textArea.setEditable(false);

		// Set dark background and light text color
		textArea.setBackground(Color.DARK_GRAY);
		textArea.setForeground(Color.WHITE);

		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		JOptionPane.showMessageDialog(null, scrollPane, "Listado de productos", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Muestra un mensaje emergente simple.
	 * 
	 * @param texto El texto a mostrar en el cuadro de diálogo.
	 */
	public void mostrarMensajeEmergente(String texto) {
		JOptionPane.showMessageDialog(null, texto, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Muestra una alerta emergente.
	 * 
	 * @param texto El texto de alerta a mostrar.
	 */
	public void mostrarAlerta(String texto) {
		JOptionPane.showMessageDialog(null, texto, "Alerta", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Muestra un mensaje de error emergente.
	 * 
	 * @param texto El mensaje de error a mostrar.
	 */
	public void mostrarError(String texto) {
		JOptionPane.showMessageDialog(null, texto, "Error", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Muestra un listado de productos en un cuadro de diálogo emergente.
	 * 
	 * @param texto El texto que representa el listado de productos.
	 */
	public void mostrarListado(String texto) {
		JOptionPane.showMessageDialog(null, texto, "Lista productos registrados", JOptionPane.INFORMATION_MESSAGE);
	}

}
