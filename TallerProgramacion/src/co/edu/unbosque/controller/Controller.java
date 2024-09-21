package co.edu.unbosque.controller;

import co.edu.unbosque.view.ViewFacade;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.Pincel;
import co.edu.unbosque.model.PincelDTO;
import co.edu.unbosque.model.PinturaDTO;
import co.edu.unbosque.model.ProyectoMaderaDTO;
import co.edu.unbosque.util.exception.ExceptionChecker;
import co.edu.unbosque.util.exception.InvalidPaintColorException;
import co.edu.unbosque.util.exception.NegativeIntNumberException;
import co.edu.unbosque.util.exception.NotValidBooleanException;
import co.edu.unbosque.util.exception.NotValidStringException;

/**
 * Clase controladora que gestiona la lógica de la aplicación y la interacción
 * entre la vista y el modelo. Implementa ActionListener para manejar eventos de
 * los componentes de la interfaz gráfica.
 * 
 * @author Mario Rodríguez
 */

public class Controller implements ActionListener {

	private ViewFacade vf;
	private ModelFacade mf;

	// Variables necesarias para ejecutar el programa
	private boolean pincel = false;
	private boolean pintura = false;
	private boolean proyecto = false;

	private boolean btnAgregar = false;
	private boolean btnActualizar = false;
	private boolean btnEliminar = false;

	private double inversionField = 0;
	private double inversionPincelField = 0;
	private double inversionPinturaField = 0;
	private double inversionProyectoField = 0;

	private double gananciaField = 0;
	private double gananciaPincelField = 0;
	private double gananciaPinturaField = 0;
	private double gananciaProyectoField = 0;

	private int cantidadField = 0;
	private int cantidadPincelField = 0;
	private int cantidadPinturaField = 0;
	private int cantidadProyectoField = 0;

	private String nombreA = "";

	/**
	 * Constructor de la clase Controller. Inicializa las instancias de ViewFacade y
	 * ModelFacade, asigna los lectores de eventos y muestra un mensaje de
	 * bienvenida.
	 */
	public Controller() {
		vf = new ViewFacade();
		mf = new ModelFacade();
		asignarLectores();
		fillHomeGaps();
		vf.getCon().mostrarMensajeEmergente("BIENVENIDA(O)!");

	}

	/**
	 * Asigna los listeners a los botones de la interfaz de usuario.
	 */
	public void asignarLectores() {

		// portada
		vf.getPrincipal().getCoverPanel().getContinuar().addActionListener(this);
		vf.getPrincipal().getCoverPanel().getContinuar().setActionCommand("CONTINUAR");

		// INICIO
		vf.getPrincipal().getHomePanel().getPincelButton().addActionListener(this);
		vf.getPrincipal().getHomePanel().getPincelButton().setActionCommand("PINCELES");

		vf.getPrincipal().getHomePanel().getPinturaButton().addActionListener(this);
		vf.getPrincipal().getHomePanel().getPinturaButton().setActionCommand("PINTURAS");

		vf.getPrincipal().getHomePanel().getProyectoButton().addActionListener(this);
		vf.getPrincipal().getHomePanel().getProyectoButton().setActionCommand("PROYECTOS");

		// LOBBY
		vf.getPrincipal().getLobbyPanel().getInicioButton().addActionListener(this);
		vf.getPrincipal().getLobbyPanel().getInicioButton().setActionCommand("INICIOLOBBY");

		vf.getPrincipal().getLobbyPanel().getPincelButton().addActionListener(this);
		vf.getPrincipal().getLobbyPanel().getPincelButton().setActionCommand("PINCELESLOBBY");

		vf.getPrincipal().getLobbyPanel().getPinturaButton().addActionListener(this);
		vf.getPrincipal().getLobbyPanel().getPinturaButton().setActionCommand("PINTURASLOBBY");

		vf.getPrincipal().getLobbyPanel().getProyectoButton().addActionListener(this);
		vf.getPrincipal().getLobbyPanel().getProyectoButton().setActionCommand("PROYECTOSLOBBY");

		vf.getPrincipal().getLobbyPanel().getAddButton().addActionListener(this);
		vf.getPrincipal().getLobbyPanel().getAddButton().setActionCommand("AGREGARLOBBY");

		vf.getPrincipal().getLobbyPanel().getUpdateButton().addActionListener(this);
		vf.getPrincipal().getLobbyPanel().getUpdateButton().setActionCommand("ACTUALIZARLOBBY");

		vf.getPrincipal().getLobbyPanel().getRemoveButton().addActionListener(this);
		vf.getPrincipal().getLobbyPanel().getRemoveButton().setActionCommand("ELIMINARLOBBY");

		vf.getPrincipal().getLobbyPanel().getShowButton().addActionListener(this);
		vf.getPrincipal().getLobbyPanel().getShowButton().setActionCommand("MOSTRARLOBBY");

		// INPUT
		vf.getPrincipal().getInputPanel().getInicioButtonInput().addActionListener(this);
		vf.getPrincipal().getInputPanel().getInicioButtonInput().setActionCommand("INICIOINPUT");

		vf.getPrincipal().getInputPanel().getPincelButtonInput().addActionListener(this);
		vf.getPrincipal().getInputPanel().getPincelButtonInput().setActionCommand("PINCELESINPUT");

		vf.getPrincipal().getInputPanel().getPinturaButtonInput().addActionListener(this);
		vf.getPrincipal().getInputPanel().getPinturaButtonInput().setActionCommand("PINTURASINPUT");

		vf.getPrincipal().getInputPanel().getProyectoButtonInput().addActionListener(this);
		vf.getPrincipal().getInputPanel().getProyectoButtonInput().setActionCommand("PROYECTOSINPUT");

		vf.getPrincipal().getInputPanel().getAddButtonInput().addActionListener(this);
		vf.getPrincipal().getInputPanel().getAddButtonInput().setActionCommand("AGREGARINPUT");

		vf.getPrincipal().getInputPanel().getUpdateButtonInput().addActionListener(this);
		vf.getPrincipal().getInputPanel().getUpdateButtonInput().setActionCommand("ACTUALIZARINPUT");

		vf.getPrincipal().getInputPanel().getRemoveButtonInput().addActionListener(this);
		vf.getPrincipal().getInputPanel().getRemoveButtonInput().setActionCommand("ELIMINARINPUT");

		vf.getPrincipal().getInputPanel().getShowButtonInput().addActionListener(this);
		vf.getPrincipal().getInputPanel().getShowButtonInput().setActionCommand("MOSTRARINPUT");

	}

	/**
	 * Maneja los eventos de acción generados por los componentes de la interfaz
	 * gráfica. Dependiendo del comando de acción, realiza la operación
	 * correspondiente.
	 *
	 * @param e El evento de acción que se ha producido.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {

		// PORTADA

		case "CONTINUAR":
			vf.getPrincipal().mostrarPanelInicio();

			break;

		// INICIO

		case "PINCELES":
			pincel = true;
			pintura = false;
			proyecto = false;

			checkearBooleanInicioToLobby();
			vf.getPrincipal().mostrarPanelLobby();
			break;

		case "PINTURAS":
			pincel = false;
			pintura = true;
			proyecto = false;

			checkearBooleanInicioToLobby();
			vf.getPrincipal().mostrarPanelLobby();
			break;

		case "PROYECTOS":
			pincel = false;
			pintura = false;
			proyecto = true;

			checkearBooleanInicioToLobby();
			vf.getPrincipal().mostrarPanelLobby();
			break;

		// LOBBY

		case "INICIOLOBBY":
			vf.getPrincipal().mostrarPanelInicio();

			break;

		case "PINCELESLOBBY":
			pincel = true;
			pintura = false;
			proyecto = false;

			checkearBooleanInicioToLobby();
			vf.getPrincipal().mostrarPanelLobby();
			break;

		case "PINTURASLOBBY":
			pincel = false;
			pintura = true;
			proyecto = false;

			checkearBooleanInicioToLobby();
			vf.getPrincipal().mostrarPanelLobby();
			break;

		case "PROYECTOSLOBBY":
			pincel = false;
			pintura = false;
			proyecto = true;

			checkearBooleanInicioToLobby();
			vf.getPrincipal().mostrarPanelLobby();
			break;

		case "AGREGARLOBBY":

			btnAgregar = true;
			btnActualizar = false;
			btnEliminar = false;

			setearTextInputAdd();
			checkearBooleanLobbyToAdd();
			vf.getPrincipal().mostrarPanelInput();
			break;

		case "ACTUALIZARLOBBY":
			btnAgregar = false;
			btnActualizar = true;
			btnEliminar = false;
			setearTextInputUpdateAndRemove();
			checkearBooleanLobbyToUpdate();
			vf.getPrincipal().mostrarPanelInput();
			break;

		case "ELIMINARLOBBY":
			btnAgregar = false;
			btnActualizar = false;
			btnEliminar = true;
			setearTextInputUpdateAndRemove();
			checkearBooleanLobbyToRemove();
			vf.getPrincipal().mostrarPanelInput();
			break;

		case "MOSTRARLOBBY":
			mostrarProducto();
			break;

		// INPUT
		case "INICIOINPUT":
			vf.getPrincipal().mostrarPanelInicio();
			break;

		case "PINCELESINPUT":
			pincel = true;
			pintura = false;
			proyecto = false;

			checkearBooleanInicioToLobby();
			vf.getPrincipal().mostrarPanelLobby();
			break;

		case "PINTURASINPUT":
			pincel = false;
			pintura = true;
			proyecto = false;

			checkearBooleanInicioToLobby();
			vf.getPrincipal().mostrarPanelLobby();
			break;

		case "PROYECTOSINPUT":
			pincel = false;
			pintura = false;
			proyecto = true;

			checkearBooleanInicioToLobby();
			vf.getPrincipal().mostrarPanelLobby();
			break;

		case "AGREGARINPUT":

			if (btnAgregar == false) {
				vf.getCon().mostrarAlerta("Opción no disponible, accede nuevamente al producto y seleccionar");
				break;
			} else
				agregarProducto();

			break;

		case "ACTUALIZARINPUT":
			if (btnActualizar == false) {
				vf.getCon().mostrarAlerta("Opción no disponible, accede nuevamente al producto y seleccionar");
				break;
			} else
				actualizarProducto();
			break;

		case "ELIMINARINPUT":
			if (btnEliminar == false) {
				vf.getCon().mostrarAlerta("Opción no disponible, accede nuevamente al producto y seleccionar");
				break;
			} else
				eliminarProducto();
			break;

		case "MOSTRARINPUT":
			mostrarProducto();
			break;

		}

	}

	/**
	 * Agrega un nuevo producto a la base de datos, ya sea un pincel, pintura o
	 * proyecto de madera, dependiendo del estado de las variables.
	 */
	public void agregarProducto() {

		if (pincel == true && pintura == false && proyecto == false) {
			try {

				double precioCompra = Double
						.parseDouble(vf.getPrincipal().getInputPanel().getPrecioCompraField().getText());
				ExceptionChecker.chequearNumeroNegativo((int) precioCompra);

				double precioVenta = Double
						.parseDouble(vf.getPrincipal().getInputPanel().getPrecioVentaField().getText());
				ExceptionChecker.chequearNumeroNegativo((int) precioVenta);

				int cantidad = Integer.parseInt(vf.getPrincipal().getInputPanel().getCantidadField().getText());
				ExceptionChecker.chequearNumeroNegativo(cantidad);

				String nombre = vf.getPrincipal().getInputPanel().getNameField().getText();
				ExceptionChecker.chequearStringValida(nombre);

				String tamanio = vf.getPrincipal().getInputPanel().getTamanioField().getText();
				ExceptionChecker.chequearStringValida(tamanio);

				String marca = vf.getPrincipal().getInputPanel().getMarcaField().getText();
				ExceptionChecker.chequearStringValida(marca);

				String grosorCerda = vf.getPrincipal().getInputPanel().getPropioField1().getText();
				ExceptionChecker.chequearStringValida(grosorCerda);

				String material = vf.getPrincipal().getInputPanel().getPropioField2().getText();
				ExceptionChecker.chequearStringValida(material);

				String tipoPincel = vf.getPrincipal().getInputPanel().getPropioField3().getText();
				ExceptionChecker.chequearStringValida(tipoPincel);

				// Si todos los valores son válidos, agregar la pintura
				if (mf.getPincelDAO().add(new PincelDTO(precioCompra, precioVenta, cantidad, nombre, tamanio, marca,
						grosorCerda, material, tipoPincel)) == true) {
					vf.getCon().mostrarMensajeEmergente("Producto creado exitosamente");
				} else {
					vf.getCon().mostrarMensajeEmergente(
							"No se pudo completar la operación, verifique que otro producto no tenga el mismo nombre");

				}

			} catch (NegativeIntNumberException e) {
				vf.getCon().mostrarError("No puede ingresar letras / numeros negativos");
			} catch (NotValidStringException e) {
				vf.getCon().mostrarError("Formato de palabra no valido, no incluya caracteres especiales ni numeros");
			} catch (InputMismatchException e) {
				vf.getCon().mostrarError("Revise los datos numericos ingresados, solo la cantidad es numero entero");
			} catch (NumberFormatException j) {
				vf.getCon().mostrarError("Verifique el formato de los datos ingresados");
			}
		}

		if (pincel == false && pintura == true && proyecto == false) {
			try {

				double precioCompra = Double
						.parseDouble(vf.getPrincipal().getInputPanel().getPrecioCompraField().getText());
				ExceptionChecker.chequearNumeroNegativo((int) precioCompra);

				double precioVenta = Double
						.parseDouble(vf.getPrincipal().getInputPanel().getPrecioVentaField().getText());
				ExceptionChecker.chequearNumeroNegativo((int) precioVenta);

				int cantidad = Integer.parseInt(vf.getPrincipal().getInputPanel().getCantidadField().getText());
				ExceptionChecker.chequearNumeroNegativo(cantidad);

				String nombre = vf.getPrincipal().getInputPanel().getNameField().getText();
				ExceptionChecker.chequearStringValida(nombre);

				String tamanio = vf.getPrincipal().getInputPanel().getTamanioField().getText();
				ExceptionChecker.chequearStringValida(tamanio);

				String marca = vf.getPrincipal().getInputPanel().getMarcaField().getText();
				ExceptionChecker.chequearStringValida(marca);

				String color = vf.getPrincipal().getInputPanel().getPropioField1().getText();
				ExceptionChecker.chequearColorPintura(color);

				float contenido = Float.parseFloat(vf.getPrincipal().getInputPanel().getPropioField2().getText());
				ExceptionChecker.chequearNumeroNegativo((int) contenido);

				boolean esVinilo = false;
				if (vf.getPrincipal().getInputPanel().getPropioField3().getText().toLowerCase().equals("si"))
					esVinilo = true;
				else if (vf.getPrincipal().getInputPanel().getPropioField3().getText().toLowerCase().equals("no"))
					esVinilo = false;
				ExceptionChecker.chequearBooleanoValido(esVinilo);

				if (mf.getPinturaDAO().add(new PinturaDTO(precioCompra, precioVenta, cantidad, nombre, tamanio, marca,
						color, contenido, esVinilo)) == true) {
					vf.getCon().mostrarMensajeEmergente("Producto creado exitosamente");

				} else {
					vf.getCon().mostrarMensajeEmergente(
							"No se pudo completar la operación, verifique que otro producto no tenga el mismo nombre");

				}
			} catch (NegativeIntNumberException e) {
				vf.getCon().mostrarError("No puede ingresar letras / numeros negativos");
			} catch (NotValidStringException e) {
				vf.getCon().mostrarError("Formato de palabra no valido, no incluya caracteres especiales ni numeros");
			} catch (InvalidPaintColorException e) {
				vf.getCon().mostrarError("Formato de palabra no valido, no incluya caracteres especiales ni numeros");
			} catch (NotValidBooleanException e) {
				vf.getCon()
						.mostrarError("Revise los datos ingresados en campos de SI/NO, solo se admite un si o un no");
			} catch (InputMismatchException e) {
				vf.getCon().mostrarError("Revise los datos numericos ingresados, solo la cantidad es numero entero");
			} catch (NumberFormatException j) {
				vf.getCon().mostrarError("Verifique el formato de los datos ingresados");
			}
		}

		if (pincel == false && pintura == false && proyecto == true) {
			try {

				double precioCompra = Double
						.parseDouble(vf.getPrincipal().getInputPanel().getPrecioCompraField().getText());
				ExceptionChecker.chequearNumeroNegativo((int) precioCompra);

				double precioVenta = Double
						.parseDouble(vf.getPrincipal().getInputPanel().getPrecioVentaField().getText());
				ExceptionChecker.chequearNumeroNegativo((int) precioVenta);

				int cantidad = Integer.parseInt(vf.getPrincipal().getInputPanel().getCantidadField().getText());
				ExceptionChecker.chequearNumeroNegativo(cantidad);

				String nombre = vf.getPrincipal().getInputPanel().getNameField().getText();
				ExceptionChecker.chequearStringValida(nombre);

				String tamanio = vf.getPrincipal().getInputPanel().getTamanioField().getText();
				ExceptionChecker.chequearStringValida(tamanio);

				String marca = vf.getPrincipal().getInputPanel().getMarcaField().getText();
				ExceptionChecker.chequearStringValida(marca);

				boolean esCortadoMano = false;
				if (vf.getPrincipal().getInputPanel().getPropioField1().getText().toLowerCase().equals("si"))
					esCortadoMano = true;
				else if (vf.getPrincipal().getInputPanel().getPropioField1().getText().toLowerCase().equals("no"))
					esCortadoMano = false;
				ExceptionChecker.chequearBooleanoValido(esCortadoMano);

				boolean esCortadoLaser = false;
				if (vf.getPrincipal().getInputPanel().getPropioField2().getText().toLowerCase().equals("si"))
					esCortadoLaser = true;
				else if (vf.getPrincipal().getInputPanel().getPropioField2().getText().toLowerCase().equals("no"))
					esCortadoLaser = false;
				ExceptionChecker.chequearBooleanoValido(esCortadoLaser);

				boolean esGrabado = false;
				if (vf.getPrincipal().getInputPanel().getPropioField3().getText().toLowerCase().equals("si"))
					esGrabado = true;
				else if (vf.getPrincipal().getInputPanel().getPropioField3().getText().toLowerCase().equals("no"))
					esGrabado = false;
				ExceptionChecker.chequearBooleanoValido(esGrabado);

				if (mf.getpMaderaDAO().add(new ProyectoMaderaDTO(precioCompra, precioVenta, cantidad, nombre, tamanio,
						marca, esCortadoMano, esCortadoLaser, esGrabado)) == true) {
					vf.getCon().mostrarMensajeEmergente("Producto creado exitosamente");
				} else {
					vf.getCon().mostrarMensajeEmergente(
							"No se pudo completar la operación, verifique que otro producto no tenga el mismo nombre");
				}
			} catch (NegativeIntNumberException e) {
				vf.getCon().mostrarError("No puede ingresar letras / numeros negativos");
			} catch (NotValidStringException e) {
				vf.getCon().mostrarError("Formato de palabra no valido, no incluya caracteres especiales ni numeros");
			} catch (NotValidBooleanException e) {
				vf.getCon()
						.mostrarError("Revise los datos ingresados en campos de SI/NO, solo se admite un si o un no");
			} catch (InputMismatchException e) {
				vf.getCon().mostrarError("Revise los datos numericos ingresados, solo la cantidad es numero entero");
			} catch (NumberFormatException j) {
				vf.getCon().mostrarError("Verifique el formato de los datos ingresados");
			}
		}

	}

	/**
	 * Verifica y actualiza un producto según su tipo (pincel, pintura o proyecto).
	 * Si se encuentra el producto, se preparan los campos para la actualización.
	 */
	public void verificarActualizarProducto() {
		if (pincel == true && pintura == false && proyecto == false) {
			try {
				nombreA = vf.getPrincipal().getInputPanel().getNameField().getText();
				ExceptionChecker.chequearStringValida(nombreA);

				if (mf.getPincelDAO().find(new Pincel(0, 0, 0, nombreA, null, null, null, null, null)) == null) {
					vf.getCon().mostrarAlerta("No es posible encontrar el producto a actualizar, verifique el nombre");
				} else {
					vf.getCon().mostrarAlerta("Producto encontrado, ingrese los datos a actualizar");
					setearAddPincel();
					vf.getPrincipal().mostrarPanelInput();
				}
			} catch (NotValidStringException e) {
				vf.getCon().mostrarError("Formato de palabra no valido, no incluya caracteres especiales ni numeros");
			}
		}
		// Código similar para pintura y proyecto...
	}

	/**
	 * Actualiza un producto según su tipo (pincel, pintura o proyecto). Verifica
	 * los campos ingresados y lanza excepciones si los datos no son válidos.
	 */
	public void actualizarProducto() {
		if (pincel == true && pintura == false && proyecto == false) {
			try {
				double precioCompraA = Double
						.parseDouble(vf.getPrincipal().getInputPanel().getPrecioCompraField().getText());
				ExceptionChecker.chequearNumeroNegativo((int) precioCompraA);

				double precioVentaA = Double
						.parseDouble(vf.getPrincipal().getInputPanel().getPrecioVentaField().getText());
				ExceptionChecker.chequearNumeroNegativo((int) precioVentaA);

				int cantidadA = Integer.parseInt(vf.getPrincipal().getInputPanel().getCantidadField().getText());
				ExceptionChecker.chequearNumeroNegativo(cantidadA);

				String nombreAA = vf.getPrincipal().getInputPanel().getNameField().getText();
				ExceptionChecker.chequearStringValida(nombreA);

				String tamanioA = vf.getPrincipal().getInputPanel().getTamanioField().getText();
				ExceptionChecker.chequearStringValida(tamanioA);

				String marcaA = vf.getPrincipal().getInputPanel().getMarcaField().getText();
				ExceptionChecker.chequearStringValida(marcaA);

				String grosorCerdaA = vf.getPrincipal().getInputPanel().getPropioField1().getText();
				ExceptionChecker.chequearStringValida(grosorCerdaA);

				String materialA = vf.getPrincipal().getInputPanel().getPropioField2().getText();
				ExceptionChecker.chequearStringValida(materialA);

				String tipoPincelA = vf.getPrincipal().getInputPanel().getPropioField3().getText();
				ExceptionChecker.chequearStringValida(tipoPincelA);

				// Si todos los valores son válidos, agregar la pintura
				if (mf.getPincelDAO().update(new PincelDTO(0, 0, 0, nombreA, null, null, null, null, null),
						new PincelDTO(precioCompraA, precioVentaA, cantidadA, nombreAA, tamanioA, marcaA, grosorCerdaA,
								materialA, tipoPincelA)) == true) {
					vf.getCon().mostrarMensajeEmergente("Producto actualizado exitosamente");
				} else {
					vf.getCon().mostrarAlerta("Error inesperado, contactarse con mario o nicolas");
				}

			} catch (NegativeIntNumberException e) {
				vf.getCon().mostrarError("No puede ingresar letras / numeros negativos");
			} catch (NotValidStringException e) {
				vf.getCon().mostrarError("Formato de palabra no valido, no incluya caracteres especiales ni numeros");
			} catch (InputMismatchException e) {
				vf.getCon().mostrarError("Revise los datos numericos ingresados, solo la cantidad es numero entero");
			} catch (NumberFormatException j) {
				vf.getCon().mostrarError("Verifique el formato de los datos ingresados");
			}
		}
		// Código similar para pintura y proyecto...
	}

	/**
	 * Elimina un producto según su tipo (pincel, pintura o proyecto). Verifica si
	 * el producto a eliminar existe antes de proceder.
	 */
	public void eliminarProducto() {
		if (pincel == true && pintura == false && proyecto == false) {
			try {
				String delete = vf.getPrincipal().getInputPanel().getNameField().getText();
				ExceptionChecker.chequearStringValida(delete);

				if (mf.getPincelDAO().delete(new PincelDTO(0, 0, 0, delete, null, null, null, null, null)) == false) {
					vf.getCon().mostrarAlerta("No es posible encontrar el producto a eliminar, verifique el nombre");
				} else {
					vf.getCon().mostrarMensajeEmergente("Producto " + delete + " eliminado");
				}
			} catch (NotValidStringException e) {
				vf.getCon().mostrarError("Formato de palabra no valido, no incluya caracteres especiales ni numeros");
			} catch (InputMismatchException e) {
				vf.getCon().mostrarError("Error: Entrada no válida.");
			}
		}
		// Código similar para pintura y proyecto...
	}

	/**
	 * Muestra todos los productos según su tipo (pincel, pintura o proyecto).
	 */
	public void mostrarProducto() {
		if (pincel == true && pintura == false && proyecto == false) {
			vf.getCon().mostrarMensajeEmergenteConScroll(mf.getPincelDAO().showAll());
		}
		if (pincel == false && pintura == true && proyecto == false) {
			vf.getCon().mostrarMensajeEmergenteConScroll(mf.getPinturaDAO().showAll());
		}
		if (pincel == false && pintura == false && proyecto == true) {
			vf.getCon().mostrarMensajeEmergenteConScroll(mf.getpMaderaDAO().showAll());
		}
	}

	/**
	 * Verifica los estados de los booleanos de pincel, pintura y proyecto para
	 * actualizar la visibilidad de los componentes en el panel del lobby.
	 */
	public void checkearBooleanInicioToLobby() {
		if (pincel == true && pintura == false && proyecto == false) {
			vf.getPrincipal().getLobbyPanel().getLobbyPincel().setVisible(true);
			vf.getPrincipal().getLobbyPanel().getLobbyPintura().setVisible(false);
			vf.getPrincipal().getLobbyPanel().getLobbyProyecto().setVisible(false);
		}
		if (pincel == false && pintura == true && proyecto == false) {
			vf.getPrincipal().getLobbyPanel().getLobbyPincel().setVisible(false);
			vf.getPrincipal().getLobbyPanel().getLobbyPintura().setVisible(true);
			vf.getPrincipal().getLobbyPanel().getLobbyProyecto().setVisible(false);
		}
		if (pincel == false && pintura == false && proyecto == true) {
			vf.getPrincipal().getLobbyPanel().getLobbyPincel().setVisible(false);
			vf.getPrincipal().getLobbyPanel().getLobbyPintura().setVisible(false);
			vf.getPrincipal().getLobbyPanel().getLobbyProyecto().setVisible(true);
		}
	}

	/**
	 * Verifica los estados de los booleanos de pincel, pintura y proyecto para
	 * realizar la configuración necesaria para añadir un nuevo elemento.
	 */
	public void checkearBooleanLobbyToAdd() {
		if (pincel == true && pintura == false && proyecto == false)
			setearAddPincel();
		if (pincel == false && pintura == true && proyecto == false)
			setearAddPintura();
		if (pincel == false && pintura == false && proyecto == true)
			setearAddProyecto();
	}

	/**
	 * Verifica los estados de los booleanos de pincel, pintura y proyecto para
	 * realizar la configuración necesaria para actualizar un elemento existente.
	 */
	public void checkearBooleanLobbyToUpdate() {
		if (pincel == true && pintura == false && proyecto == false)
			setearUpdatePincel();
		if (pincel == false && pintura == true && proyecto == false)
			setearUpdatePintura();
		if (pincel == false && pintura == false && proyecto == true)
			setearUpdateProyecto();
	}

	/**
	 * Verifica los estados de los booleanos de pincel, pintura y proyecto para
	 * realizar la configuración necesaria para eliminar un elemento.
	 */
	public void checkearBooleanLobbyToRemove() {
		if (pincel == true && pintura == false && proyecto == false) {
			setearRemovePincel();
		}
		if (pincel == false && pintura == true && proyecto == false) {
			setearRemovePintura();
		}
		if (pincel == false && pintura == false && proyecto == true) {
			setearRemoveProyecto();
		}
	}

	/**
	 * Configura los campos de entrada necesarios para añadir un nuevo elemento.
	 */
	public void setearTextInputAdd() {
		vf.getPrincipal().getInputPanel().getNameField().setVisible(true);
		vf.getPrincipal().getInputPanel().getPrecioCompraField().setVisible(true);
		vf.getPrincipal().getInputPanel().getPrecioVentaField().setVisible(true);
		vf.getPrincipal().getInputPanel().getCantidadField().setVisible(true);
		vf.getPrincipal().getInputPanel().getTamanioField().setVisible(true);
		vf.getPrincipal().getInputPanel().getMarcaField().setVisible(true);
		vf.getPrincipal().getInputPanel().getPropioField1().setVisible(true);
		vf.getPrincipal().getInputPanel().getPropioField2().setVisible(true);
		vf.getPrincipal().getInputPanel().getPropioField3().setVisible(true);
	}

	/**
	 * Configura los campos de entrada necesarios para actualizar o eliminar un
	 * elemento.
	 */
	public void setearTextInputUpdateAndRemove() {
		vf.getPrincipal().getInputPanel().getNameField().setVisible(true);
		vf.getPrincipal().getInputPanel().getPrecioCompraField().setVisible(false);
		vf.getPrincipal().getInputPanel().getPrecioVentaField().setVisible(false);
		vf.getPrincipal().getInputPanel().getCantidadField().setVisible(false);
		vf.getPrincipal().getInputPanel().getTamanioField().setVisible(false);
		vf.getPrincipal().getInputPanel().getMarcaField().setVisible(false);
		vf.getPrincipal().getInputPanel().getPropioField1().setVisible(false);
		vf.getPrincipal().getInputPanel().getPropioField2().setVisible(false);
		vf.getPrincipal().getInputPanel().getPropioField3().setVisible(false);
	}

	/**
	 * Configura la interfaz para añadir un pincel, mostrando el icono
	 * correspondiente.
	 */
	public void setearAddPincel() {
		vf.getPrincipal().getInputPanel().getImgAddPincel().setVisible(true);
		vf.getPrincipal().getInputPanel().getImgAddPintura().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgAddProyecto().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgUpdatePincel().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgUpdatePintura().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgUpdateProyecto().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgRemovePincel().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgRemovePintura().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgRemoveProyecto().setVisible(false);
	}

	/**
	 * Configura la interfaz para añadir pintura, mostrando el icono
	 * correspondiente.
	 */
	public void setearAddPintura() {
		vf.getPrincipal().getInputPanel().getImgAddPincel().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgAddPintura().setVisible(true);
		vf.getPrincipal().getInputPanel().getImgAddProyecto().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgUpdatePincel().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgUpdatePintura().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgUpdateProyecto().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgRemovePincel().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgRemovePintura().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgRemoveProyecto().setVisible(false);
	}

	/**
	 * Configura la interfaz para añadir un proyecto, mostrando el icono
	 * correspondiente.
	 */
	public void setearAddProyecto() {
		vf.getPrincipal().getInputPanel().getImgAddPincel().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgAddPintura().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgAddProyecto().setVisible(true);
		vf.getPrincipal().getInputPanel().getImgUpdatePincel().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgUpdatePintura().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgUpdateProyecto().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgRemovePincel().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgRemovePintura().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgRemoveProyecto().setVisible(false);
	}

	/**
	 * Configura la interfaz para actualizar un pincel, mostrando el icono
	 * correspondiente.
	 */
	public void setearUpdatePincel() {
		vf.getPrincipal().getInputPanel().getImgAddPincel().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgAddPintura().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgAddProyecto().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgUpdatePincel().setVisible(true);
		vf.getPrincipal().getInputPanel().getImgUpdatePintura().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgUpdateProyecto().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgRemovePincel().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgRemovePintura().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgRemoveProyecto().setVisible(false);
	}

	/**
	 * Configura la interfaz para actualizar una pintura, mostrando el icono
	 * correspondiente.
	 */
	public void setearUpdatePintura() {
		vf.getPrincipal().getInputPanel().getImgAddPincel().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgAddPintura().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgAddProyecto().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgUpdatePincel().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgUpdatePintura().setVisible(true);
		vf.getPrincipal().getInputPanel().getImgUpdateProyecto().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgRemovePincel().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgRemovePintura().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgRemoveProyecto().setVisible(false);
	}

	/**
	 * Configura la interfaz para actualizar un proyecto, mostrando el icono
	 * correspondiente.
	 */
	public void setearUpdateProyecto() {
		vf.getPrincipal().getInputPanel().getImgAddPincel().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgAddPintura().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgAddProyecto().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgUpdatePincel().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgUpdatePintura().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgUpdateProyecto().setVisible(true);
		vf.getPrincipal().getInputPanel().getImgRemovePincel().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgRemovePintura().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgRemoveProyecto().setVisible(false);
	}

	/**
	 * Configura la interfaz para eliminar un pincel, mostrando el icono
	 * correspondiente.
	 */
	public void setearRemovePincel() {
		vf.getPrincipal().getInputPanel().getImgAddPincel().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgAddPintura().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgAddProyecto().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgUpdatePincel().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgUpdatePintura().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgUpdateProyecto().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgRemovePincel().setVisible(true);
		vf.getPrincipal().getInputPanel().getImgRemovePintura().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgRemoveProyecto().setVisible(false);
	}

	/**
	 * Configura la interfaz para eliminar pintura, mostrando el icono
	 * correspondiente.
	 */
	public void setearRemovePintura() {
		vf.getPrincipal().getInputPanel().getImgAddPincel().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgAddPintura().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgAddProyecto().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgUpdatePincel().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgUpdatePintura().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgUpdateProyecto().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgRemovePincel().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgRemovePintura().setVisible(true);
		vf.getPrincipal().getInputPanel().getImgRemoveProyecto().setVisible(false);
	}

	/**
	 * Configura la interfaz para eliminar un proyecto, mostrando el icono
	 * correspondiente.
	 */
	public void setearRemoveProyecto() {
		vf.getPrincipal().getInputPanel().getImgAddPincel().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgAddPintura().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgAddProyecto().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgUpdatePincel().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgUpdatePintura().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgUpdateProyecto().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgRemovePincel().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgRemovePintura().setVisible(false);
		vf.getPrincipal().getInputPanel().getImgRemoveProyecto().setVisible(true);
	}

	/**
	 * Llena los campos de la interfaz principal con la información de inversión,
	 * ganancia y cantidad para pincel, pintura y proyecto, además de las totales.
	 */
	public void fillHomeGaps() {
		// PINCEL
		inversionPincelField = mf.getPincelDAO().calculateInversion();
		gananciaPincelField = mf.getPincelDAO().calculateGanancia();
		cantidadPincelField = mf.getPincelDAO().calculateCantidad();

		// PINTURA
		inversionPinturaField = mf.getPinturaDAO().calculateInversion();
		gananciaPinturaField = mf.getPinturaDAO().calculateGanancia();
		cantidadPinturaField = mf.getPinturaDAO().calculateCantidad();

		// PROYECTO
		inversionProyectoField = mf.getpMaderaDAO().calculateInversion();
		gananciaProyectoField = mf.getpMaderaDAO().calculateGanancia();
		cantidadProyectoField = mf.getpMaderaDAO().calculateCantidad();

		// TODOS
		inversionField = inversionPincelField + inversionPinturaField + inversionProyectoField;
		gananciaField = gananciaPincelField + gananciaPinturaField + gananciaProyectoField;
		cantidadField = cantidadPincelField + cantidadPinturaField + cantidadProyectoField;

		// TODOS
		vf.getPrincipal().getHomePanel().getInversion().setText(String.valueOf(inversionField));
		vf.getPrincipal().getHomePanel().getGanancia().setText(String.valueOf(gananciaField));
		vf.getPrincipal().getHomePanel().getInventario().setText(String.valueOf(cantidadField));

		// PINCEL
		vf.getPrincipal().getHomePanel().getInversionPincel().setText(String.valueOf(inversionPincelField));
		vf.getPrincipal().getHomePanel().getRetornoPincel().setText(String.valueOf(gananciaPincelField));
		vf.getPrincipal().getHomePanel().getInventarioPincel().setText(String.valueOf(cantidadPincelField));

		// PINTURA
		vf.getPrincipal().getHomePanel().getInversionPintura().setText(String.valueOf(inversionPinturaField));
		vf.getPrincipal().getHomePanel().getRetornoPintura().setText(String.valueOf(gananciaPinturaField));
		vf.getPrincipal().getHomePanel().getInventarioPintura().setText(String.valueOf(cantidadPinturaField));

		// PROYECTO
		vf.getPrincipal().getHomePanel().getInversionProyecto().setText(String.valueOf(inversionProyectoField));
		vf.getPrincipal().getHomePanel().getRetornoProyecto().setText(String.valueOf(gananciaProyectoField));
		vf.getPrincipal().getHomePanel().getInventarioProyecto().setText(String.valueOf(cantidadProyectoField));
	}
}