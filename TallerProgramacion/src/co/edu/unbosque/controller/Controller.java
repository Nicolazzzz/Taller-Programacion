package co.edu.unbosque.controller;

import co.edu.unbosque.view.ViewFacade;

import java.util.InputMismatchException;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.PincelDTO;
import co.edu.unbosque.model.PinturaDTO;
import co.edu.unbosque.model.ProyectoMaderaDTO;
import co.edu.unbosque.model.persistence.PinturaDAO;
import co.edu.unbosque.util.exception.ExceptionChecker;
import co.edu.unbosque.util.exception.NegativeIntNumberException;
import co.edu.unbosque.util.exception.NotValidBooleanException;
import co.edu.unbosque.util.exception.NotValidStringException;
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
		mostrarMenuPpal();
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

		piLoop: while (true) {
			String menuPince = """

					PINCELES

					1) Agregar
					2) Mostrar
					3) Actualizar
					4) Eliminar
					5) Salir

					""";
			vf.getCon().printLine(menuPince);
			int op = vf.getCon().readInt();
			vf.getCon().burnLine();

			switch (op) {
			case 1:
				vf.getCon().printLine("CREANDO PINCEL");
				vf.getCon().printLine("compra");

				double precioCompra = vf.getCon().readDouble();
				try {
					ExceptionChecker.chequearNumeroNegativo((int) precioCompra);
				} catch (NegativeIntNumberException e) {
					e.printStackTrace();
					break;
				}

				vf.getCon().printLine("venta");
				double precioVenta = vf.getCon().readDouble();
				try {
					ExceptionChecker.chequearNumeroNegativo((int) precioVenta);
				} catch (NegativeIntNumberException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().printLine("cantidad");
				int cantidad = vf.getCon().readInt();
				try {
					ExceptionChecker.chequearNumeroNegativo(cantidad);
				} catch (NegativeIntNumberException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().burnLine();
				vf.getCon().printLine("nombre");
				String nombre = vf.getCon().readLine();
				try {
					ExceptionChecker.chequearStringValida(nombre);
				} catch (NotValidStringException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().printLine("tamaño");
				String tamanio = vf.getCon().readLine();
				try {
					ExceptionChecker.chequearStringValida(tamanio);
				} catch (NotValidStringException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().printLine("marca");
				String marca = vf.getCon().readLine();
				try {
					ExceptionChecker.chequearStringValida(marca);
				} catch (NotValidStringException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().printLine("grosor");
				String grosorCerda = vf.getCon().readLine();
				try {
					ExceptionChecker.chequearStringValida(grosorCerda);
				} catch (NotValidStringException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().printLine("material");
				String material = vf.getCon().readLine();
				try {
					ExceptionChecker.chequearStringValida(material);
				} catch (NotValidStringException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().printLine("tipoPincel");
				String tipoPincel = vf.getCon().readLine();
				try {
					ExceptionChecker.chequearStringValida(tipoPincel);
				} catch (NotValidStringException e) {
					e.printStackTrace();
					break;
				}
				if (mf.getPincelDAO().add(new PincelDTO(precioCompra, precioVenta, cantidad, nombre, tamanio, marca,
						grosorCerda, material, tipoPincel)) == true) {
					vf.getCon().printLine("Creado");
				} else {
					vf.getCon().printLine("Paila");
				}
				break;

			case 2:
				vf.getCon().printLine(mf.getPincelDAO().showAll());
				break;
			case 3:
				vf.getCon().printLine("Ingrese el nombre de pincel a actualizar");
				String name = vf.getCon().readLine();
				try {ExceptionChecker.chequearStringValida(name);
				} catch (NotValidStringException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().printLine("ACTUALIZANDO PINCEL");

				vf.getCon().printLine("compra");
				double precioCompraA = vf.getCon().readDouble();
				try {
					ExceptionChecker.chequearNumeroNegativo((int) precioCompraA);
				} catch (NegativeIntNumberException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().printLine("venta");
				double precioVentaA = vf.getCon().readDouble();
				try {
					ExceptionChecker.chequearNumeroNegativo((int) precioVentaA);
				} catch (NegativeIntNumberException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().printLine("cantidad");
				int cantidadA = vf.getCon().readInt();
				try {
					ExceptionChecker.chequearNumeroNegativo(cantidadA);
				} catch (NegativeIntNumberException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().burnLine();
				vf.getCon().printLine("nombre");
				String nombreA = vf.getCon().readLine();
				try {
					ExceptionChecker.chequearStringValida(nombreA);
				} catch (NotValidStringException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().printLine("tamaño");
				String tamanioA = vf.getCon().readLine();
				try {
					ExceptionChecker.chequearStringValida(tamanioA);
				} catch (NotValidStringException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().printLine("marca");
				String marcaA = vf.getCon().readLine();
				try {
					ExceptionChecker.chequearStringValida(marcaA);
				} catch (NotValidStringException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().printLine("grosor");
				String grosorCerdaA = vf.getCon().readLine();
				try {
					ExceptionChecker.chequearStringValida(grosorCerdaA);
				} catch (NotValidStringException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().printLine("material");
				String materialA = vf.getCon().readLine();
				try {
					ExceptionChecker.chequearStringValida(materialA);
				} catch (NotValidStringException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().printLine("tipoPincel");
				String tipoPincelA = vf.getCon().readLine();
				try {
					ExceptionChecker.chequearStringValida(tipoPincelA);
				} catch (NotValidStringException e) {
					e.printStackTrace();
					break;
				}
				mf.getPincelDAO().update(new PincelDTO(0, 0, 0, name, null, null, null, null, null),
						new PincelDTO(precioCompraA, precioVentaA, cantidadA, nombreA, tamanioA, marcaA, grosorCerdaA,
								materialA, tipoPincelA));
				break;
			case 4:
				vf.getCon().printLine("ELIMINANDO PINCEL");
				vf.getCon().printLine("Ingrese nombre pincel a eliminar");
				String delete = vf.getCon().readLine();
				try {
					ExceptionChecker.chequearStringValida(delete);
				} catch (NotValidStringException e) {
					e.printStackTrace();
					break;
				}
				if (mf.getPincelDAO().delete(new PincelDTO(0, 0, 0, delete, null, null, null, null, null)) == false) {
					vf.getCon().printLine("NO COINCIDE CON NINGUN DATO DEL INVENTARIO");
				}
				break;
			case 5:
				break piLoop;

			default:
				vf.getCon().printLine("CABEZA ES LO QUE NO TIENE MANO");
				break;
			}
		}

	}

	public void mostrarMenuPintura() {

		paintLoop: while (true) {
			String menuPintu = """

					PINTURAS

					1) Agregar
					2) Mostrar
					3) Actualizar
					4) Eliminar
					5) Salir

					""";
			vf.getCon().printLine(menuPintu);
			int op = vf.getCon().readInt();
			vf.getCon().burnLine();
			switch (op) {
			case 1:
				vf.getCon().printLine("CREANDO PINTURA");
				
				vf.getCon().printLine("compra");
				double precioCompra = vf.getCon().readDouble();
				try {
					ExceptionChecker.chequearNumeroNegativo((int) precioCompra);
				} catch (NegativeIntNumberException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().printLine("venta");
				double precioVenta = vf.getCon().readDouble();
				try {
					ExceptionChecker.chequearNumeroNegativo((int) precioVenta);
				} catch (NegativeIntNumberException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().printLine("cantidad");
				int cantidad = vf.getCon().readInt();
				try {
					ExceptionChecker.chequearNumeroNegativo(cantidad);
				} catch (NegativeIntNumberException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().burnLine();
				vf.getCon().printLine("nombre");
				String nombre = vf.getCon().readLine();
				try {
					ExceptionChecker.chequearStringValida(nombre);
				} catch (NotValidStringException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().printLine("tamaño");
				String tamanio = vf.getCon().readLine();
				try {
					ExceptionChecker.chequearStringValida(tamanio);
				} catch (NotValidStringException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().printLine("marca");
				String marca = vf.getCon().readLine();
				try {
					ExceptionChecker.chequearStringValida(marca);
				} catch (NotValidStringException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().printLine("color");
				String color = vf.getCon().readLine();
				try {
					ExceptionChecker.chequearStringValida(color);
				} catch (NotValidStringException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().burnLine();
				vf.getCon().printLine("contenido en ML");
				float contenido = vf.getCon().readFloat();
				try {
					ExceptionChecker.chequearNumeroNegativo((int) contenido);
				} catch (NegativeIntNumberException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().printLine("es vinilo");
				boolean esVinilo = vf.getCon().readBoolean();
				try {ExceptionChecker.chequearBooleanoValido(esVinilo);
				}catch(NotValidBooleanException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().printLine("es oleo");
				boolean esOleo = vf.getCon().readBoolean();
				try {ExceptionChecker.chequearBooleanoValido(esOleo);
				}catch(NotValidBooleanException e) {
					e.printStackTrace();
					break;
				}
				if (mf.getPinturaDAO().add(new PinturaDTO(precioCompra, precioVenta, cantidad, nombre, tamanio, marca,
						color, contenido, esVinilo, esOleo)) == true) {
					vf.getCon().printLine("Creado");
				} else {
					vf.getCon().printLine("Paila");
				}
				break;
			case 2:
				vf.getCon().printLine(mf.getPincelDAO().showAll());
				break;
			case 3:
				vf.getCon().printLine("Ingrese el nombre de pintura a actualizar");
				String name = vf.getCon().readLine();
				try {
					ExceptionChecker.chequearStringValida(name);
				} catch (NotValidStringException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().printLine("ACTUALIZANDO PINTURA");

				vf.getCon().printLine("compra");
				double precioCompraA = vf.getCon().readDouble();
				try {
					ExceptionChecker.chequearNumeroNegativo((int) precioCompraA);
				} catch (NegativeIntNumberException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().printLine("venta");
				double precioVentaA = vf.getCon().readDouble();
				try {
					ExceptionChecker.chequearNumeroNegativo((int) precioVentaA);
				} catch (NegativeIntNumberException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().printLine("cantidad");
				int cantidadA = vf.getCon().readInt();
				try {
					ExceptionChecker.chequearNumeroNegativo(cantidadA);
				} catch (NegativeIntNumberException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().burnLine();
				vf.getCon().printLine("nombre");
				String nombreA = vf.getCon().readLine();
				try {
					ExceptionChecker.chequearStringValida(nombreA);
				} catch (NotValidStringException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().printLine("tamaño");
				String tamanioA = vf.getCon().readLine();
				try {
					ExceptionChecker.chequearStringValida(tamanioA);
				} catch (NotValidStringException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().printLine("marca");
				String marcaA = vf.getCon().readLine();
				try {
					ExceptionChecker.chequearStringValida(marcaA);
				} catch (NotValidStringException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().printLine("color");
				String colorA = vf.getCon().readLine();
				try {
					ExceptionChecker.chequearStringValida(colorA);
				} catch (NotValidStringException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().burnLine();
				vf.getCon().printLine("contenido en ML");
				float contenidoA = vf.getCon().readFloat();
				try {
					ExceptionChecker.chequearNumeroNegativo((int) contenidoA);
				} catch (NegativeIntNumberException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().printLine("es vinilo");
				boolean esViniloA = vf.getCon().readBoolean();
				try {ExceptionChecker.chequearBooleanoValido(esViniloA);
				}catch(NotValidBooleanException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().printLine("es oleo");
				boolean esOleoA = vf.getCon().readBoolean();
				try {ExceptionChecker.chequearBooleanoValido(esOleoA);
				}catch(NotValidBooleanException e) {
					e.printStackTrace();
					break;
				}
				mf.getPinturaDAO().update(new PinturaDTO(0, 0, 0, name, null, null, null, 0, false, false),
						new PinturaDTO(precioCompraA, precioVentaA, cantidadA, nombreA, tamanioA, marcaA, colorA,
								contenidoA, esViniloA, esOleoA));
				break;
			case 4:
				vf.getCon().printLine("ELIMINANDO PINTURA");
				vf.getCon().printLine("Ingrese nombre pintura a eliminar");
				String delete = vf.getCon().readLine();
				try {
					ExceptionChecker.chequearStringValida(delete);
				} catch (NotValidStringException e) {
					e.printStackTrace();
					break;
				}
				if (mf.getPinturaDAO()
						.delete(new PinturaDTO(0, 0, 0, delete, null, null, null, 0, false, false)) == false) {
					vf.getCon().printLine("NO COINCIDE CON NINGUN DATO DEL INVENTARIO");
				}
				break;
			case 5:
				break paintLoop;

			default:
				vf.getCon().printLine("CABEZA ES LO QUE NO TIENE MANO");
				break;

			}
		}

	}

	public void mostrarMenuMaderas() {
		woodLoop: while (true) {
			String menuMadera = """

					MADERAS

					1) Agregar
					2) Mostrar
					3) Actualizar
					4) Eliminar
					5) Salir

					""";
			vf.getCon().printLine(menuMadera);
			int op = vf.getCon().readInt();
			vf.getCon().burnLine();
			switch (op) {
			case 1:
				vf.getCon().printLine("CREANDO P MADERA");

				vf.getCon().printLine("compra");
				double precioCompra = vf.getCon().readDouble();
				vf.getCon().printLine("venta");
				double precioVenta = vf.getCon().readDouble();
				vf.getCon().printLine("cantidad");
				int cantidad = vf.getCon().readInt();
				vf.getCon().burnLine();
				vf.getCon().printLine("nombre");
				String nombre = vf.getCon().readLine();
				try {
					ExceptionChecker.chequearStringValida(nombre);
				} catch (NotValidStringException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().printLine("tamaño");
				String tamanio = vf.getCon().readLine();
				try {
					ExceptionChecker.chequearStringValida(tamanio);
				} catch (NotValidStringException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().printLine("marca");
				String marca = vf.getCon().readLine();
				try {
					ExceptionChecker.chequearStringValida(marca);
				} catch (NotValidStringException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().printLine("Es cortado mano");
				boolean esCortadoMano = vf.getCon().readBoolean();
				vf.getCon().printLine("Es cortado laser");
				boolean esCortadoLaser = vf.getCon().readBoolean();
				vf.getCon().printLine("Es grabado");
				boolean esGrabado = vf.getCon().readBoolean();

				if (mf.getpMaderaDAO().add(new ProyectoMaderaDTO(precioCompra, precioVenta, cantidad, nombre, tamanio,
						marca, esCortadoMano, esCortadoLaser, esGrabado)) == true) {
					vf.getCon().printLine("Creado");
				} else {
					vf.getCon().printLine("Paila");
				}
				break;
			case 2:
				vf.getCon().printLine(mf.getPincelDAO().showAll());
				break;
			case 3:
				vf.getCon().printLine("Ingrese el nombre de pincel a actualizar");
				String name = vf.getCon().readLine();
				try {
					ExceptionChecker.chequearStringValida(name);
				} catch (NotValidStringException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().printLine("ACTUALIZANDO PINCEL");

				vf.getCon().printLine("compra");
				double precioCompraA = vf.getCon().readDouble();
				vf.getCon().printLine("venta");
				double precioVentaA = vf.getCon().readDouble();
				vf.getCon().printLine("cantidad");
				int cantidadA = vf.getCon().readInt();
				vf.getCon().burnLine();
				vf.getCon().printLine("nombre");
				String nombreA = vf.getCon().readLine();
				try {
					ExceptionChecker.chequearStringValida(nombreA);
				} catch (NotValidStringException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().printLine("tamaño");
				String tamanioA = vf.getCon().readLine();
				try {
					ExceptionChecker.chequearStringValida(tamanioA);
				} catch (NotValidStringException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().printLine("marca");
				String marcaA = vf.getCon().readLine();
				try {
					ExceptionChecker.chequearStringValida(marcaA);
				} catch (NotValidStringException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().printLine("Es cortado mano");
				boolean esCortadoManoA = vf.getCon().readBoolean();
				vf.getCon().printLine("Es cortado laser");
				boolean esCortadoLaserA = vf.getCon().readBoolean();
				try {ExceptionChecker.chequearBooleanoValido(esCortadoLaserA);
				}catch(NotValidBooleanException e) {
					e.printStackTrace();
					break;
				}
				vf.getCon().printLine("Es grabado");
				boolean esGrabadoA = vf.getCon().readBoolean();
				try {ExceptionChecker.chequearBooleanoValido(esGrabadoA);
				}catch(NotValidBooleanException e) {
					e.printStackTrace();
					break;
				}
				mf.getpMaderaDAO().update(new ProyectoMaderaDTO(0, 0, 0, name, null, null, false, false, false),
						new ProyectoMaderaDTO(precioCompraA, precioVentaA, cantidadA, nombreA, tamanioA, marcaA,
								esCortadoManoA, esCortadoLaserA, esGrabadoA));
				break;
			case 4:
				vf.getCon().printLine("ELIMINANDO MADERA");
				vf.getCon().printLine("Ingrese nombre madera a eliminar");
				String delete = vf.getCon().readLine();
				try {
					ExceptionChecker.chequearStringValida(delete);
				} catch (NotValidStringException e) {
					e.printStackTrace();
					break;
				}
				if (mf.getpMaderaDAO()
						.delete(new ProyectoMaderaDTO(0, 0, 0, delete, null, null, false, false, false)) == false) {
					vf.getCon().printLine("NO COINCIDE CON NINGUN DATO DEL INVENTARIO");
				}
				break;
			case 5:
				break woodLoop;

			default:
				vf.getCon().printLine("CABEZA ES LO QUE NO TIENE MANO");
				break;

			}
		}
	}
}
