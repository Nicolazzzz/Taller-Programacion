package co.edu.unbosque.view;

import java.util.Scanner;

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

}
