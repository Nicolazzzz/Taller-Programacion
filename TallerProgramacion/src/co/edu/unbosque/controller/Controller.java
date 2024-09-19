package co.edu.unbosque.controller;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.view.ViewFacade;

public class Controller {

	private ViewFacade vf;
	private ModelFacade mf;

	public Controller() {
		vf = new ViewFacade();
		mf = new ModelFacade();
		run();

	}

	public void run() {

	}

	public void mostrarMenuPpal() {

		mainloop: while (true) {
			String menuPpal = """

					1) Pincel
					2) Pintura
					3) Maderas
					4) Salir

					""";

			vf.getCon().printLine(menuPpal);
			int op = vf.getCon().readInt();
			vf.getCon().burnLine();
			switch (op) {
			case 1:
				mostrarMenuPincel();
				break;
			case 2:
				mostrarMenuPintura();
				break;
			case 3:
				mostrarMenuMaderas();
				break;
			case 4:
				break mainloop;

			default:
				vf.getCon().printLine("FALTA CEREBRO LLAVE");
				break;
			}

		}

	}

	public void mostrarMenuPincel() {

	}

	public void mostrarMenuPintura() {

	}

	public void mostrarMenuMaderas() {

	}
}
