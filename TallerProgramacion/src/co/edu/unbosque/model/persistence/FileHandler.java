package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * La clase {@code FileHandler} proporciona métodos estáticos para manejar
 * operaciones de archivos dentro de la carpeta designada. Esto incluye la
 * verificación de la existencia de la carpeta de datos, así como la lectura y
 * escritura de archivos de texto plano.
 * <p>
 * Esta clase no está diseñada para ser instanciada y actúa como una utilidad
 * para la gestión de archivos en el sistema de persistencia de datos.
 * </p>
 * 
 * @author MARIO RODRIGUEZ
 * @version 1.0
 * @since 2024-04-27
 */
public class FileHandler {

	private static Scanner sc;
	private static PrintWriter pw;
	private static File archivo;
	private static final String FOLDER_NAME = "data";

	private static FileOutputStream fos;
	private static ObjectOutputStream oos;

	private static FileInputStream fis;
	private static ObjectInputStream ois;

	/**
	 * Verifica si la carpeta especificada por {@code FOLDER_NAME} existe y es un
	 * directorio. Si no existe, crea la carpeta.
	 */
	public static void checkFolder() {
		archivo = new File(FOLDER_NAME);
		if (archivo.exists() && archivo.isDirectory()) {
			return;
		} else {
			archivo.mkdir();
		}
	}

	/**
	 * Escribe contenido en un archivo de texto dentro de la carpeta designada. Si
	 * el archivo no existe, lo crea.
	 *
	 * @param url     la ruta relativa del archivo dentro de la carpeta de datos
	 * @param content el contenido que se escribirá en el archivo
	 */
	public static void writeFile(String url, String content) {
		try {
			archivo = new File(FOLDER_NAME + "/" + url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			pw = new PrintWriter(archivo);
			pw.write(content);
			pw.close();
		} catch (FileNotFoundException e) {
			System.out.println("ERROR EN LA ESCRITURA DEL ARCHIVO (TEXTO PLANO)");
			// e.printStackTrace();
		} catch (IOException e) {
			System.out.println("ERROR EN LA CREACIÓN DEL ARCHIVO (TEXTO PLANO)");
			// e.printStackTrace();
		}
	}

	/**
	 * Lee el contenido de un archivo de texto dentro de la carpeta designada. Si el
	 * archivo no existe, lo crea y retorna {@code null}.
	 *
	 * @param url la ruta relativa del archivo dentro de la carpeta de datos
	 * @return una cadena con el contenido del archivo, o {@code null} si ocurre un
	 *         error
	 */
	public static String readFile(String url) {
		try {
			archivo = new File(FOLDER_NAME + "/" + url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			sc = new Scanner(archivo);
			StringBuilder content = new StringBuilder();
			while (sc.hasNext()) {
				content.append(sc.nextLine()).append("\n");
			}
			sc.close();
			return content.toString();

		} catch (IOException e) {
			System.out.println("ERROR EN LA LECTURA DEL ARCHIVO (TEXTO PLANO)");
		}

		return null;
	}

	/**
	 * Escribe un objeto en un archivo como un archivo serializado dentro de la
	 * carpeta designada. Si el archivo no existe, lo crea.
	 *
	 * @param url     la ruta relativa del archivo dentro de la carpeta de datos
	 * @param content el objeto que se escribirá en el archivo
	 */
	public static void writeSerialized(String url, Object content) {
		try {
			archivo = new File(FOLDER_NAME + "/" + url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			fos = new FileOutputStream(archivo);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(content);
			fos.close();
			oos.close();

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("ERROR EN CREAR ARCHIVO (Serialized)");
		}
	}

	/**
	 * Lee un objeto desde un archivo que contiene un objeto serializado dentro de
	 * la carpeta designada.
	 *
	 * @param url la ruta relativa del archivo dentro de la carpeta de datos
	 * @return el objeto leído del archivo, o {@code null} si ocurre un error
	 */
	public static Object readSerialized(String url) {
		try {
			archivo = new File(FOLDER_NAME + "/" + url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			fis = new FileInputStream(archivo);
			ois = new ObjectInputStream(fis);

			Object content = ois.readObject();

			fis.close();
			ois.close();
			return content;

		} catch (IOException e) {
			System.out.println("ERROR EN LECTURA DE ARCHIVO (SERIALIZED)");
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR AL LEER LOS DATOS DEL SERIALIZED(CLASS NOT FOUND)");
		}
		return null;
	}
}
