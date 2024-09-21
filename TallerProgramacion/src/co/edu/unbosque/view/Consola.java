package co.edu.unbosque.view;

import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Consola {

	private Scanner sc;

	public Consola() {
		sc = new Scanner(System.in);
	}

	public void printLine(String txt) {
		System.out.println(txt);
	}

	public void printWord(String txt) {
		System.out.print(txt);
	}

	public void burnLine() {
		sc.nextLine();
	}

	public int readInt() {
		return sc.nextInt();
	}

	public double readDouble() {
		return sc.nextDouble();
	}

	public float readFloat() {
		return sc.nextFloat();
	}

	public String readLine() {
		return sc.nextLine();
	}

	public String readWord() {
		return sc.nextLine();
	}

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

	public void mostrarMensajeEmergente(String texto) {
		JOptionPane.showMessageDialog(null, texto, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
	}

	public void mostrarAlerta(String texto) {
		JOptionPane.showMessageDialog(null, texto, "Alerta", JOptionPane.WARNING_MESSAGE);
	}

	public void mostrarError(String texto) {
		JOptionPane.showMessageDialog(null, texto, "Error", JOptionPane.ERROR_MESSAGE);
	}

	public void mostrarListado(String texto) {
		JOptionPane.showMessageDialog(null, texto, "Lista productos registrados", JOptionPane.INFORMATION_MESSAGE);
	}

}
