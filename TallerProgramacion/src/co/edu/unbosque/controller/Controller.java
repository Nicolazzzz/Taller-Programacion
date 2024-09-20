package co.edu.unbosque.controller;

import co.edu.unbosque.view.ViewFacade;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.PincelDTO;
import co.edu.unbosque.model.Pintura;
import co.edu.unbosque.model.PinturaDTO;
import co.edu.unbosque.model.ProyectoMaderaDTO;
import co.edu.unbosque.model.persistence.PinturaDAO;
import co.edu.unbosque.util.exception.ExceptionChecker;
import co.edu.unbosque.util.exception.InvalidPaintColorException;
import co.edu.unbosque.util.exception.NegativeIntNumberException;
import co.edu.unbosque.util.exception.NotValidBooleanException;
import co.edu.unbosque.util.exception.NotValidStringException;
import co.edu.unbosque.view.ViewFacade;

public class Controller implements ActionListener{

	private ViewFacade vf;
	private ModelFacade mf;

	public Controller() {
		vf = new ViewFacade();
		mf = new ModelFacade();
		run();
		asignarLectores();
	}

	public void run() {
		mostrarMenuPpal();
		asignarLectores();
	}

	public void asignarLectores() {
		vf.getPrincipal().getCoverPanel().getContinuar().addActionListener(this);
		vf.getPrincipal().getCoverPanel().getContinuar().setActionCommand("CONTINUAR");
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {

		
		}
		
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
		try {

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
					try {
						vf.getCon().printLine("CREANDO PINTURA");

						vf.getCon().printLine("compra");
						double precioCompra = vf.getCon().readDouble();
						ExceptionChecker.chequearNumeroNegativo((int) precioCompra);

						vf.getCon().printLine("venta");
						double precioVenta = vf.getCon().readDouble();
						ExceptionChecker.chequearNumeroNegativo((int) precioVenta);

						vf.getCon().printLine("cantidad");
						int cantidad = vf.getCon().readInt();
						ExceptionChecker.chequearNumeroNegativo(cantidad);

						vf.getCon().burnLine();
						vf.getCon().printLine("nombre");
						String nombre = vf.getCon().readLine();
						ExceptionChecker.chequearStringValida(nombre);

						vf.getCon().printLine("tamaño");
						String tamanio = vf.getCon().readLine();
						ExceptionChecker.chequearStringValida(tamanio);

						vf.getCon().printLine("marca");
						String marca = vf.getCon().readLine();
						ExceptionChecker.chequearStringValida(marca);

						vf.getCon().printLine("color");
						String color = vf.getCon().readLine();
						ExceptionChecker.chequearColorPintura(color);

						vf.getCon().printLine("contenido en ML");
						float contenido = vf.getCon().readFloat();
						ExceptionChecker.chequearNumeroNegativo((int) contenido);

						vf.getCon().printLine("es vinilo");
						boolean esVinilo = vf.getCon().readBoolean();
						ExceptionChecker.chequearBooleanoValido(esVinilo);

						vf.getCon().printLine("es oleo");
						boolean esOleo = vf.getCon().readBoolean();
						ExceptionChecker.chequearBooleanoValido(esOleo);

						// Si todos los valores son válidos, agregar la pintura
						if (mf.getPinturaDAO().add(new PinturaDTO(precioCompra, precioVenta, cantidad, nombre, tamanio,
								marca, color, contenido, esVinilo)) == true) {
							vf.getCon().printLine("Creado");
						} else {
							vf.getCon().printLine("No se pudo crear la pintura.");
						}
					} catch (NegativeIntNumberException e) {
						vf.getCon().printLine("Error: Número negativo ingresado.");
					} catch (NotValidStringException e) {
						vf.getCon().printLine("Error: String con caracteres inválidos.");
					} catch (InvalidPaintColorException e) {
						vf.getCon().printLine("Error: Color de pintura inválido.");
					} catch (NotValidBooleanException e) {
						vf.getCon().printLine("Error: Valor booleano no válido.");
					} catch (InputMismatchException e) {
						vf.getCon().printLine("Error: Entrada inválida para el contenido en ML.");
						vf.getCon().burnLine(); // Limpiar el buffer en caso de error
						break;
					}
					break;
				case 2:
					vf.getCon().printLine(mf.getPincelDAO().showAll());
					break;
				case 3:
					try {
						vf.getCon().printLine("Ingrese el nombre de pincel a actualizar");
						String name = vf.getCon().readLine();
						ExceptionChecker.chequearStringValida(name); // Validación del nombre del pincel a actualizar

						vf.getCon().printLine("ACTUALIZANDO PINCEL");

						vf.getCon().printLine("compra");
						double precioCompraA = vf.getCon().readDouble();
						ExceptionChecker.chequearNumeroNegativo((int) precioCompraA); // Validación de número negativo

						vf.getCon().printLine("venta");
						double precioVentaA = vf.getCon().readDouble();
						ExceptionChecker.chequearNumeroNegativo((int) precioVentaA); // Validación de número negativo

						vf.getCon().printLine("cantidad");
						int cantidadA = vf.getCon().readInt();
						ExceptionChecker.chequearNumeroNegativo(cantidadA); // Validación de número negativo

						vf.getCon().burnLine();
						vf.getCon().printLine("nombre");
						String nombreA = vf.getCon().readLine();
						ExceptionChecker.chequearStringValida(nombreA); // Validación de String

						vf.getCon().printLine("tamaño");
						String tamanioA = vf.getCon().readLine();
						ExceptionChecker.chequearStringValida(tamanioA); // Validación de String

						vf.getCon().printLine("marca");
						String marcaA = vf.getCon().readLine();
						ExceptionChecker.chequearStringValida(marcaA); // Validación de String

						vf.getCon().printLine("grosor");
						String grosorCerdaA = vf.getCon().readLine();
						ExceptionChecker.chequearStringValida(grosorCerdaA); // Validación de String

						vf.getCon().printLine("material");
						String materialA = vf.getCon().readLine();
						ExceptionChecker.chequearStringValida(materialA); // Validación de String

						vf.getCon().printLine("tipoPincel");
						String tipoPincelA = vf.getCon().readLine();
						ExceptionChecker.chequearStringValida(tipoPincelA); // Validación de String

						// Si todas las validaciones son exitosas, se actualiza el pincel
						mf.getPincelDAO().update(new PincelDTO(0, 0, 0, name, null, null, null, null, null),
								new PincelDTO(precioCompraA, precioVentaA, cantidadA, nombreA, tamanioA, marcaA,
										grosorCerdaA, materialA, tipoPincelA));

					} catch (NegativeIntNumberException e) {
						vf.getCon().printLine("Error: Número negativo ingresado.");
					} catch (NotValidStringException e) {
						vf.getCon().printLine("Error: String con caracteres inválidos.");
					} catch (InputMismatchException e) {
						vf.getCon().printLine("Error: Entrada no válida.");
						vf.getCon().burnLine(); // Limpiar el buffer en caso de error
						break;
					} catch (Exception e) {
						vf.getCon().printLine("Ocurrió un error inesperado.");
						e.printStackTrace();
					} finally {
						// Acciones que siempre deben ejecutarse, si es necesario
					}

				case 4:
					try {
						vf.getCon().printLine("ELIMINANDO PINCEL");
						vf.getCon().printLine("Ingrese nombre pincel a eliminar");

						// Lectura y validación del nombre
						String delete = vf.getCon().readLine();
						ExceptionChecker.chequearStringValida(delete); // Validación del string

						// Intentar eliminar el pincel del inventario
						if (mf.getPincelDAO()
								.delete(new PincelDTO(0, 0, 0, delete, null, null, null, null, null)) == false) {
							vf.getCon().printLine("NO COINCIDE CON NINGUN DATO DEL INVENTARIO");
						}

					} catch (NotValidStringException e) {
						vf.getCon().printLine("Error: Nombre de pincel contiene caracteres inválidos.");
					} catch (InputMismatchException e) {
						vf.getCon().printLine("Error: Entrada no válida.");
						vf.getCon().burnLine(); // Limpiar el buffer en caso de error
					} catch (Exception e) {
						vf.getCon().printLine("Ocurrió un error inesperado.");
						e.printStackTrace();
					} finally {
						// Acciones que siempre deben ejecutarse, si es necesario
					}

				case 5:
					break piLoop;

				default:
					vf.getCon().printLine("CABEZA ES LO QUE NO TIENE MANO");
					break;
				}

			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void mostrarMenuPintura() {
		try {
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
					try {
						vf.getCon().printLine("CREANDO PINTURA");

						vf.getCon().printLine("compra");
						double precioCompra = vf.getCon().readDouble();
						ExceptionChecker.chequearNumeroNegativo((int) precioCompra);

						vf.getCon().printLine("venta");
						double precioVenta = vf.getCon().readDouble();
						ExceptionChecker.chequearNumeroNegativo((int) precioVenta);

						vf.getCon().printLine("cantidad");
						int cantidad = vf.getCon().readInt();
						ExceptionChecker.chequearNumeroNegativo(cantidad);

						vf.getCon().burnLine();
						vf.getCon().printLine("nombre");
						String nombre = vf.getCon().readLine();
						ExceptionChecker.chequearStringValida(nombre);

						vf.getCon().printLine("tamaño");
						String tamanio = vf.getCon().readLine();
						ExceptionChecker.chequearStringValida(tamanio);

						vf.getCon().printLine("marca");
						String marca = vf.getCon().readLine();
						ExceptionChecker.chequearStringValida(marca);

						vf.getCon().printLine("color");
						String color = vf.getCon().readLine();
						ExceptionChecker.chequearColorPintura(color);

						vf.getCon().burnLine();
						vf.getCon().printLine("contenido en ML");
						float contenido = vf.getCon().readFloat();
						ExceptionChecker.chequearNumeroNegativo((int) contenido);

						vf.getCon().printLine("es vinilo");
						boolean esVinilo = vf.getCon().readBoolean();
						ExceptionChecker.chequearBooleanoValido(esVinilo);

						vf.getCon().printLine("es oleo");
						boolean esOleo = vf.getCon().readBoolean();
						ExceptionChecker.chequearBooleanoValido(esOleo);

						if (mf.getPinturaDAO().add(new PinturaDTO(precioCompra, precioVenta, cantidad, nombre, tamanio,
								marca, color, contenido, esVinilo)) == true) {
							vf.getCon().printLine("Creado");
						} else {
							vf.getCon().printLine("Paila");
						}
					} catch (NegativeIntNumberException e) {
						vf.getCon().printLine("Error: Número negativo ingresado.");
					} catch (NotValidStringException e) {
						vf.getCon().printLine("Error: String con caracteres inválidos.");
					} catch (InvalidPaintColorException e) {
						vf.getCon().printLine("Error: Color de pintura inválido.");
					} catch (NotValidBooleanException e) {
						vf.getCon().printLine("Error: Valor booleano no válido.");
					} catch (InputMismatchException e) {
						vf.getCon().printLine("Error: Entrada no válida para el contenido en ML.");
						vf.getCon().burnLine();
					}
					break;

				case 2:
					vf.getCon().printLine(mf.getPincelDAO().showAll());
					break;

				case 3:
					try {
						vf.getCon().printLine("Ingrese el nombre de pintura a actualizar");
						String name = vf.getCon().readLine();
						ExceptionChecker.chequearStringValida(name);

						if (mf.getPinturaDAO()
								.find(new PinturaDTO(0, 0, 0, name, null, null, null, 0, false)) == null) {
							vf.getCon().printLine("No se puede actualizar, no coincide con ninguno");
							break;
						}

						vf.getCon().printLine("ACTUALIZANDO PINTURA");

						vf.getCon().printLine("compra");
						double precioCompraA = vf.getCon().readDouble();
						ExceptionChecker.chequearNumeroNegativo((int) precioCompraA);

						vf.getCon().printLine("venta");
						double precioVentaA = vf.getCon().readDouble();
						ExceptionChecker.chequearNumeroNegativo((int) precioVentaA);

						vf.getCon().printLine("cantidad");
						int cantidadA = vf.getCon().readInt();
						ExceptionChecker.chequearNumeroNegativo(cantidadA);

						vf.getCon().burnLine();
						vf.getCon().printLine("nombre");
						String nombreA = vf.getCon().readLine();
						ExceptionChecker.chequearStringValida(nombreA);

						vf.getCon().printLine("tamaño");
						String tamanioA = vf.getCon().readLine();
						ExceptionChecker.chequearStringValida(tamanioA);

						vf.getCon().printLine("marca");
						String marcaA = vf.getCon().readLine();
						ExceptionChecker.chequearStringValida(marcaA);

						vf.getCon().printLine("color");
						String colorA = vf.getCon().readLine();
						ExceptionChecker.chequearColorPintura(colorA);

						vf.getCon().burnLine();
						vf.getCon().printLine("contenido en ML");
						float contenidoA = vf.getCon().readFloat();
						ExceptionChecker.chequearNumeroNegativo((int) contenidoA);

						vf.getCon().printLine("es vinilo");
						boolean esViniloA = vf.getCon().readBoolean();
						ExceptionChecker.chequearBooleanoValido(esViniloA);

						mf.getPinturaDAO().update(new PinturaDTO(0, 0, 0, name, null, null, null, 0, false),
								new PinturaDTO(precioCompraA, precioVentaA, cantidadA, nombreA, tamanioA, marcaA,
										colorA, contenidoA, esViniloA));

					} catch (NegativeIntNumberException e) {
						vf.getCon().printLine("Error: Número negativo ingresado.");
					} catch (NotValidStringException e) {
						vf.getCon().printLine("Error: String con caracteres inválidos.");
					} catch (InvalidPaintColorException e) {
						vf.getCon().printLine("Error: Color de pintura inválido.");
					} catch (NotValidBooleanException e) {
						vf.getCon().printLine("Error: Valor booleano no válido.");
					} catch (InputMismatchException e) {
						vf.getCon().printLine("Error: Entrada no válida.");
						vf.getCon().burnLine();
					}
					break;

				case 4:
					try {
						vf.getCon().printLine("ELIMINANDO PINTURA");
						vf.getCon().printLine("Ingrese nombre pintura a eliminar");

						String delete = vf.getCon().readLine();
						ExceptionChecker.chequearStringValida(delete);

						if (mf.getPinturaDAO()
								.delete(new PinturaDTO(0, 0, 0, delete, null, null, null, 0, false)) == false) {
							vf.getCon().printLine("NO COINCIDE CON NINGUN DATO DEL INVENTARIO");
						}
					} catch (NotValidStringException e) {
						vf.getCon().printLine("Error: Nombre de pintura contiene caracteres inválidos.");
					} catch (InputMismatchException e) {
						vf.getCon().printLine("Error: Entrada no válida.");
						vf.getCon().burnLine();
					}
					break;

				case 5:
					break paintLoop;

				default:
					vf.getCon().printLine("CABEZA ES LO QUE NO TIENE MANO");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void mostrarMenuMaderas() {
		try {
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
		                try {
		                    vf.getCon().printLine("CREANDO P MADERA");

		                    vf.getCon().printLine("compra");
		                    double precioCompra = vf.getCon().readDouble();
		                    ExceptionChecker.chequearNumeroNegativo((int) precioCompra);

		                    vf.getCon().printLine("venta");
		                    double precioVenta = vf.getCon().readDouble();
		                    ExceptionChecker.chequearNumeroNegativo((int) precioVenta);

		                    vf.getCon().printLine("cantidad");
		                    int cantidad = vf.getCon().readInt();
		                    ExceptionChecker.chequearNumeroNegativo(cantidad);

		                    vf.getCon().burnLine();
		                    vf.getCon().printLine("nombre");
		                    String nombre = vf.getCon().readLine();
		                    ExceptionChecker.chequearStringValida(nombre);

		                    vf.getCon().printLine("tamaño");
		                    String tamanio = vf.getCon().readLine();
		                    ExceptionChecker.chequearStringValida(tamanio);

		                    vf.getCon().printLine("marca");
		                    String marca = vf.getCon().readLine();
		                    ExceptionChecker.chequearStringValida(marca);

		                    vf.getCon().printLine("Es cortado mano");
		                    boolean esCortadoMano = vf.getCon().readBoolean();
		                    ExceptionChecker.chequearBooleanoValido(esCortadoMano);

		                    vf.getCon().printLine("Es cortado laser");
		                    boolean esCortadoLaser = vf.getCon().readBoolean();
		                    ExceptionChecker.chequearBooleanoValido(esCortadoLaser);

		                    vf.getCon().printLine("Es grabado");
		                    boolean esGrabado = vf.getCon().readBoolean();
		                    ExceptionChecker.chequearBooleanoValido(esGrabado);

		                    if (mf.getpMaderaDAO().add(new ProyectoMaderaDTO(precioCompra, precioVenta, cantidad, nombre,
		                            tamanio, marca, esCortadoMano, esCortadoLaser, esGrabado)) == true) {
		                        vf.getCon().printLine("Creado");
		                    } else {
		                        vf.getCon().printLine("Paila");
		                    }
		                } catch (NegativeIntNumberException e) {
		                    vf.getCon().printLine("Error: Número negativo ingresado.");
		                } catch (NotValidStringException e) {
		                    vf.getCon().printLine("Error: String con caracteres inválidos.");
		                } catch (NotValidBooleanException e) {
		                    vf.getCon().printLine("Error: Valor booleano no válido.");
		                } catch (InputMismatchException e) {
		                    vf.getCon().printLine("Error: Entrada no válida para un número.");
		                    vf.getCon().burnLine();
		                }
		                break;

		            case 2:
		                vf.getCon().printLine(mf.getPincelDAO().showAll());
		                break;

		            case 3:
		                try {
		                    vf.getCon().printLine("Ingrese el nombre de la madera a actualizar");
		                    String name = vf.getCon().readLine();
		                    ExceptionChecker.chequearStringValida(name);

		                    if (mf.getpMaderaDAO().find(new ProyectoMaderaDTO(0, 0, 0, name, null, null, false, false, false)) == null) {
		                        vf.getCon().printLine("No se puede actualizar, no coincide con ninguno");
		                        break;
		                    }

		                    vf.getCon().printLine("ACTUALIZANDO MADERA");

		                    vf.getCon().printLine("compra");
		                    double precioCompraA = vf.getCon().readDouble();
		                    ExceptionChecker.chequearNumeroNegativo((int) precioCompraA);

		                    vf.getCon().printLine("venta");
		                    double precioVentaA = vf.getCon().readDouble();
		                    ExceptionChecker.chequearNumeroNegativo((int) precioVentaA);

		                    vf.getCon().printLine("cantidad");
		                    int cantidadA = vf.getCon().readInt();
		                    ExceptionChecker.chequearNumeroNegativo(cantidadA);

		                    vf.getCon().burnLine();
		                    vf.getCon().printLine("nombre");
		                    String nombreA = vf.getCon().readLine();
		                    ExceptionChecker.chequearStringValida(nombreA);

		                    vf.getCon().printLine("tamaño");
		                    String tamanioA = vf.getCon().readLine();
		                    ExceptionChecker.chequearStringValida(tamanioA);

		                    vf.getCon().printLine("marca");
		                    String marcaA = vf.getCon().readLine();
		                    ExceptionChecker.chequearStringValida(marcaA);

		                    vf.getCon().printLine("Es cortado mano");
		                    boolean esCortadoManoA = vf.getCon().readBoolean();
		                    ExceptionChecker.chequearBooleanoValido(esCortadoManoA);

		                    vf.getCon().printLine("Es cortado laser");
		                    boolean esCortadoLaserA = vf.getCon().readBoolean();
		                    ExceptionChecker.chequearBooleanoValido(esCortadoLaserA);

		                    vf.getCon().printLine("Es grabado");
		                    boolean esGrabadoA = vf.getCon().readBoolean();
		                    ExceptionChecker.chequearBooleanoValido(esGrabadoA);

		                    mf.getpMaderaDAO().update(new ProyectoMaderaDTO(0, 0, 0, name, null, null, false, false, false),
		                            new ProyectoMaderaDTO(precioCompraA, precioVentaA, cantidadA, nombreA, tamanioA, marcaA,
		                                    esCortadoManoA, esCortadoLaserA, esGrabadoA));

		                } catch (NegativeIntNumberException e) {
		                    vf.getCon().printLine("Error: Número negativo ingresado.");
		                } catch (NotValidStringException e) {
		                    vf.getCon().printLine("Error: String con caracteres inválidos.");
		                } catch (NotValidBooleanException e) {
		                    vf.getCon().printLine("Error: Valor booleano no válido.");
		                } catch (InputMismatchException e) {
		                    vf.getCon().printLine("Error: Entrada no válida para un número.");
		                    vf.getCon().burnLine();
		                }
		                break;

		            case 4:
		                try {
		                    vf.getCon().printLine("ELIMINANDO MADERA");
		                    vf.getCon().printLine("Ingrese nombre de la madera a eliminar");

		                    String delete = vf.getCon().readLine();
		                    ExceptionChecker.chequearStringValida(delete);

		                    if (mf.getpMaderaDAO()
		                            .delete(new ProyectoMaderaDTO(0, 0, 0, delete, null, null, false, false, false)) == false) {
		                        vf.getCon().printLine("NO COINCIDE CON NINGUN DATO DEL INVENTARIO");
		                    }
		                } catch (NotValidStringException e) {
		                    vf.getCon().printLine("Error: Nombre de la madera contiene caracteres inválidos.");
		                } catch (InputMismatchException e) {
		                    vf.getCon().printLine("Error: Entrada no válida.");
		                    vf.getCon().burnLine();
		                }
		                break;

		            case 5:
		                break woodLoop;

		            default:
		                vf.getCon().printLine("CABEZA ES LO QUE NO TIENE MANO");
		                break;
		        }
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}

	
}
