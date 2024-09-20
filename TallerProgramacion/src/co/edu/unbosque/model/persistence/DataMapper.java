package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Pincel;
import co.edu.unbosque.model.PincelDTO;
import co.edu.unbosque.model.Pintura;
import co.edu.unbosque.model.PinturaDTO;
import co.edu.unbosque.model.ProyectoMadera;
import co.edu.unbosque.model.ProyectoMaderaDTO;

/**
 * The {@code DataMapper} class provides utility methods to convert between Data
 * Transfer Objects (DTOs) and their corresponding entity classes for various
 * product types such as {@link Pincel}, {@link Pintura}, and
 * {@link ProyectoMadera}. This facilitates the transformation of data between
 * different layers of the application, ensuring separation of concerns and ease
 * of data manipulation.
 * <p>
 * This class contains static methods and is not meant to be instantiated.
 * </p>
 * 
 * @author MARIO RODRIGUEZ
 * @version 1.0
 * @since 2024-04-27
 */
public class DataMapper {

	// ===== PINCELES =====

	/**
	 * Converts a {@link PincelDTO} object to a {@link Pincel} entity.
	 *
	 * @param dto the {@code PincelDTO} to be converted
	 * @return a new {@code Pincel} entity with properties copied from the DTO
	 */
	public static Pincel pincelDTOToPincel(PincelDTO dto) {
		Pincel entity = new Pincel(dto.getPrecioCompra(), dto.getPrecioVenta(), dto.getCantidad(), dto.getNombre(),
				dto.getTamanio(), dto.getMarca(), dto.getGrosorCerda(), dto.getMaterial(), dto.getTipoPincel());
		return entity;
	}

	/**
	 * Converts a {@link Pincel} entity to a {@link PincelDTO} object.
	 *
	 * @param entity the {@code Pincel} entity to be converted
	 * @return a new {@code PincelDTO} with properties copied from the entity
	 */
	public static PincelDTO pincelToPincelDTO(Pincel entity) {
		PincelDTO dto = new PincelDTO(entity.getPrecioCompra(), entity.getPrecioVenta(), entity.getCantidad(),
				entity.getNombre(), entity.getTamanio(), entity.getMarca(), entity.getGrosorCerda(),
				entity.getMaterial(), entity.getTipoPincel());
		return dto;
	}

	/**
	 * Converts a list of {@link PincelDTO} objects to a list of {@link Pincel}
	 * entities.
	 *
	 * @param dtoList the {@code ArrayList} of {@code PincelDTO} objects to be
	 *                converted
	 * @return a new {@code ArrayList} of {@code Pincel} entities with properties
	 *         copied from the DTOs
	 */
	public static ArrayList<Pincel> listaPincelesDTOToListaPinceles(ArrayList<PincelDTO> dtoList) {
		ArrayList<Pincel> entityList = new ArrayList<>();

		for (PincelDTO dto : dtoList) {
			entityList.add(new Pincel(dto.getPrecioCompra(), dto.getPrecioVenta(), dto.getCantidad(), dto.getNombre(),
					dto.getTamanio(), dto.getMarca(), dto.getGrosorCerda(), dto.getMaterial(), dto.getTipoPincel()));
		}

		return entityList;
	}

	/**
	 * Converts a list of {@link Pincel} entities to a list of {@link PincelDTO}
	 * objects.
	 *
	 * @param entityList the {@code ArrayList} of {@code Pincel} entities to be
	 *                   converted
	 * @return a new {@code ArrayList} of {@code PincelDTO} objects with properties
	 *         copied from the entities
	 */
	public static ArrayList<PincelDTO> listaPincelesToListaPincelesDTO(ArrayList<Pincel> entityList) {
		ArrayList<PincelDTO> dtoList = new ArrayList<>();

		for (Pincel entity : entityList) {
			dtoList.add(new PincelDTO(entity.getPrecioCompra(), entity.getPrecioVenta(), entity.getCantidad(),
					entity.getNombre(), entity.getTamanio(), entity.getMarca(), entity.getGrosorCerda(),
					entity.getMaterial(), entity.getTipoPincel()));
		}

		return dtoList;
	}

	// ===== PINTURAS =====

	/**
	 * Converts a {@link PinturaDTO} object to a {@link Pintura} entity.
	 *
	 * @param dto the {@code PinturaDTO} to be converted
	 * @return a new {@code Pintura} entity with properties copied from the DTO
	 */
	public static Pintura pinturaDTOToPintura(PinturaDTO dto) {
		Pintura entity = new Pintura(dto.getPrecioCompra(), dto.getPrecioVenta(), dto.getCantidad(), dto.getNombre(),
				dto.getTamanio(), dto.getMarca(), dto.getColor(), dto.getContenidoMl(), dto.isEsVinilo());
		return entity;
	}

	/**
	 * Converts a {@link Pintura} entity to a {@link PinturaDTO} object.
	 *
	 * @param entity the {@code Pintura} entity to be converted
	 * @return a new {@code PinturaDTO} with properties copied from the entity
	 */
	public static PinturaDTO pinturaToPinturaDTO(Pintura entity) {
		PinturaDTO dto = new PinturaDTO(entity.getPrecioCompra(), entity.getPrecioVenta(), entity.getCantidad(),
				entity.getNombre(), entity.getTamanio(), entity.getMarca(), entity.getColor(), entity.getContenidoMl(),
				entity.isEsVinilo());
		return dto;
	}

	/**
	 * Converts a list of {@link PinturaDTO} objects to a list of {@link Pintura}
	 * entities.
	 *
	 * @param dtoList the {@code ArrayList} of {@code PinturaDTO} objects to be
	 *                converted
	 * @return a new {@code ArrayList} of {@code Pintura} entities with properties
	 *         copied from the DTOs
	 */
	public static ArrayList<Pintura> listaPinturasDTOToListaPinturas(ArrayList<PinturaDTO> dtoList) {
		ArrayList<Pintura> entityList = new ArrayList<>();

		for (PinturaDTO dto : dtoList) {
			entityList.add(new Pintura(dto.getPrecioCompra(), dto.getPrecioVenta(), dto.getCantidad(), dto.getNombre(),
					dto.getTamanio(), dto.getMarca(), dto.getColor(), dto.getContenidoMl(), dto.isEsVinilo()));
		}

		return entityList;
	}

	/**
	 * Converts a list of {@link Pintura} entities to a list of {@link PinturaDTO}
	 * objects.
	 *
	 * @param entityList the {@code ArrayList} of {@code Pintura} entities to be
	 *                   converted
	 * @return a new {@code ArrayList} of {@code PinturaDTO} objects with properties
	 *         copied from the entities
	 */
	public static ArrayList<PinturaDTO> listaPinturasToListaPinturasDTO(ArrayList<Pintura> entityList) {
		ArrayList<PinturaDTO> dtoList = new ArrayList<>();

		for (Pintura entity : entityList) {
			dtoList.add(new PinturaDTO(entity.getPrecioCompra(), entity.getPrecioVenta(), entity.getCantidad(),
					entity.getNombre(), entity.getTamanio(), entity.getMarca(), entity.getColor(),
					entity.getContenidoMl(), entity.isEsVinilo()));
		}

		return dtoList;
	}

	// ===== PROYECTOS DE MADERA =====

	/**
	 * Converts a {@link ProyectoMaderaDTO} object to a {@link ProyectoMadera}
	 * entity.
	 *
	 * @param dto the {@code ProyectoMaderaDTO} to be converted
	 * @return a new {@code ProyectoMadera} entity with properties copied from the
	 *         DTO
	 */
	public static ProyectoMadera proyectoMaderaDTOToProyectoMadera(ProyectoMaderaDTO dto) {
		ProyectoMadera entity = new ProyectoMadera(dto.getPrecioCompra(), dto.getPrecioVenta(), dto.getCantidad(),
				dto.getNombre(), dto.getTamanio(), dto.getMarca(), dto.isEsCortadoMano(), dto.isEsCortadoLaser(),
				dto.isEsGrabado());
		return entity;
	}

	/**
	 * Converts a {@link ProyectoMadera} entity to a {@link ProyectoMaderaDTO}
	 * object.
	 *
	 * @param entity the {@code ProyectoMadera} entity to be converted
	 * @return a new {@code ProyectoMaderaDTO} with properties copied from the
	 *         entity
	 */
	public static ProyectoMaderaDTO proyectoMaderaToProyectoMaderaDTO(ProyectoMadera entity) {
		ProyectoMaderaDTO dto = new ProyectoMaderaDTO(entity.getPrecioCompra(), entity.getPrecioVenta(),
				entity.getCantidad(), entity.getNombre(), entity.getTamanio(), entity.getMarca(),
				entity.isEsCortadoMano(), entity.isEsCortadoLaser(), entity.isEsGrabado());
		return dto;
	}

	/**
	 * Converts a list of {@link ProyectoMaderaDTO} objects to a list of
	 * {@link ProyectoMadera} entities.
	 *
	 * @param dtoList the {@code ArrayList} of {@code ProyectoMaderaDTO} objects to
	 *                be converted
	 * @return a new {@code ArrayList} of {@code ProyectoMadera} entities with
	 *         properties copied from the DTOs
	 */
	public static ArrayList<ProyectoMadera> listaProyectosMaderaDTOToListaProyectosMadera(
			ArrayList<ProyectoMaderaDTO> dtoList) {
		ArrayList<ProyectoMadera> entityList = new ArrayList<>();

		for (ProyectoMaderaDTO dto : dtoList) {
			entityList.add(new ProyectoMadera(dto.getPrecioCompra(), dto.getPrecioVenta(), dto.getCantidad(),
					dto.getNombre(), dto.getTamanio(), dto.getMarca(), dto.isEsCortadoMano(), dto.isEsCortadoLaser(),
					dto.isEsGrabado()));
		}

		return entityList;
	}

	/**
	 * Converts a list of {@link ProyectoMadera} entities to a list of
	 * {@link ProyectoMaderaDTO} objects.
	 *
	 * @param entityList the {@code ArrayList} of {@code ProyectoMadera} entities to
	 *                   be converted
	 * @return a new {@code ArrayList} of {@code ProyectoMaderaDTO} objects with
	 *         properties copied from the entities
	 */
	public static ArrayList<ProyectoMaderaDTO> listaProyectosMaderaToListaProyectosMaderaDTO(
			ArrayList<ProyectoMadera> entityList) {
		ArrayList<ProyectoMaderaDTO> dtoList = new ArrayList<>();

		for (ProyectoMadera entity : entityList) {
			dtoList.add(new ProyectoMaderaDTO(entity.getPrecioCompra(), entity.getPrecioVenta(), entity.getCantidad(),
					entity.getNombre(), entity.getTamanio(), entity.getMarca(), entity.isEsCortadoMano(),
					entity.isEsCortadoLaser(), entity.isEsGrabado()));
		}

		return dtoList;
	}
}
