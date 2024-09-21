package co.edu.unbosque.view;

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
	 * Imprime una línea de texto en la consola.
	 * 
	 * @param txt El texto a imprimir.
	 */
	public void printLine(String txt) {
		System.out.println(txt);
	}

	/**
	 * Imprime un texto en la misma línea de la consola.
	 * 
	 * @param txt El texto a imprimir.
	 */
	public void printWord(String txt) {
		System.out.print(txt);
	}

	/**
	 * Lee la siguiente línea de entrada del usuario y la consume.
	 */
	public void burnLine() {
		sc.nextLine();
	}

	/**
	 * Lee un número entero de la entrada del usuario.
	 * 
	 * @return El número entero ingresado.
	 */
	public int readInt() {
		return sc.nextInt();
	}

	/**
	 * Lee un número decimal de la entrada del usuario.
	 * 
	 * @return El número decimal ingresado.
	 */
	public double readDouble() {
		return sc.nextDouble();
	}

	/**
	 * Lee un número de punto flotante de la entrada del usuario.
	 * 
	 * @return El número de punto flotante ingresado.
	 */
	public float readFloat() {
		return sc.nextFloat();
	}

	/**
	 * Lee una línea completa de texto ingresada por el usuario.
	 * 
	 * @return La línea de texto ingresada.
	 */
	public String readLine() {
		return sc.nextLine();
	}

	/**
	 * Lee una palabra ingresada por el usuario.
	 * 
	 * @return La palabra ingresada.
	 */
	public String readWord() {
		return sc.nextLine();
	}

	/**
	 * Lee un valor booleano de la entrada del usuario.
	 * 
	 * @return {@code true} si el usuario ingresa "si", {@code false} si ingresa
	 *         "no".
	 */
	public boolean readBoolean() {
		String contenido = sc.next();

		if (contenido.toLowerCase().equals("si")) {
			return true;
		} else if (contenido.toLowerCase().equals("no")) {
			return false;
		} else {
			return false;
		}
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
