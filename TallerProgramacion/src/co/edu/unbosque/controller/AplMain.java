package co.edu.unbosque.controller;

/**
 * La clase AplMain sirve como punto de entrada a la aplicación. Inicializa la
 * clase Controller, que es responsable de gestionar el flujo del programa.
 * <p>
 * Cuando se inicia la aplicación, se ejecuta el método main, creando una
 * instancia de la clase Controller.
 * </p>
 * 
 * @author MARIO RODRIGUEZ
 * @version 1.0
 * @since 2024-04-27
 */
public class AplMain {

    /**
     * El método main es el punto de entrada de la aplicación. Crea una instancia
     * de la clase Controller, que gestiona la ejecución general del programa.
     *
     * @param args Argumentos de la línea de comandos (no utilizados en esta aplicación)
     */
    public static void main(String[] args) {
        Controller controlador = new Controller();
    }

}
