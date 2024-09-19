package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Pincel;
import co.edu.unbosque.model.PincelDTO;
import co.edu.unbosque.model.Pintura;
import co.edu.unbosque.model.PinturaDTO;
import co.edu.unbosque.model.ProyectoMadera;
import co.edu.unbosque.model.ProyectoMaderaDTO;

public class DataMapper {

	// PINCELES

	public static Pincel pincelDTOToPincel(PincelDTO dto) {

		Pincel entity = new Pincel(dto.getPrecioCompra(), dto.getPrecioVenta(), dto.getCantidad(), dto.getNombre(),
				dto.getTamanio(), dto.getMarca(), dto.getGrosorCerda(), dto.getMaterial(), dto.getTipoPincel());
		return entity;

	}

	public static PincelDTO pincelToPincelDTO(Pincel entity) {

		PincelDTO dto = new PincelDTO(entity.getPrecioCompra(), entity.getPrecioVenta(), entity.getCantidad(),
				entity.getNombre(), entity.getTamanio(), entity.getMarca(), entity.getGrosorCerda(),
				entity.getMaterial(), entity.getTipoPincel());
		return dto;
	}

	public static ArrayList<Pincel> listaPincelesDTOToListaPinceles(ArrayList<PincelDTO> dto) {

		ArrayList<Pincel> entityList = new ArrayList<>();

		for (PincelDTO d : dto) {

			entityList.add(new Pincel(d.getPrecioCompra(), d.getPrecioVenta(), d.getCantidad(), d.getNombre(),
					d.getTamanio(), d.getMarca(), d.getGrosorCerda(), d.getMaterial(), d.getTipoPincel()));

		}

		return entityList;

	}

	public static ArrayList<PincelDTO> listaPincelesToListaPincelesDTO(ArrayList<Pincel> entity) {

		ArrayList<PincelDTO> dtoList = new ArrayList<>();

		for (Pincel e : entity) {

			dtoList.add(new PincelDTO(e.getPrecioCompra(), e.getPrecioVenta(), e.getCantidad(), e.getNombre(),
					e.getTamanio(), e.getMarca(), e.getGrosorCerda(), e.getMaterial(), e.getTipoPincel()));

		}

		return dtoList;

	}

	// PINTURAS

	public static Pintura pinturaDTOToPintura(PinturaDTO dto) {

		Pintura entity = new Pintura(dto.getPrecioCompra(), dto.getPrecioVenta(), dto.getCantidad(), dto.getNombre(),
				dto.getTamanio(), dto.getMarca(), dto.getColor(), dto.getContenidoMl(), dto.isEsVinilo(),
				dto.isEsOleo());
		return entity;
	}

	public static PinturaDTO pinturaToPinturaDTO(Pintura entity) {

		PinturaDTO dto = new PinturaDTO(entity.getPrecioCompra(), entity.getPrecioVenta(), entity.getCantidad(),
				entity.getNombre(), entity.getTamanio(), entity.getMarca(), entity.getColor(), entity.getContenidoMl(),
				entity.isEsVinilo(), entity.isEsOleo());
		return dto;
	}

	public static ArrayList<Pintura> listaPinturasDTOToListaPinturas(ArrayList<PinturaDTO> dto) {
		ArrayList<Pintura> entityList = new ArrayList<>();

		for (PinturaDTO d : dto) {
			entityList.add(new Pintura(d.getPrecioCompra(), d.getPrecioVenta(), d.getCantidad(), d.getNombre(),
					d.getTamanio(), d.getMarca(), d.getColor(), d.getContenidoMl(), d.isEsVinilo(), d.isEsOleo()));

		}
		return entityList;

	}

	public static ArrayList<PinturaDTO> listaPinturasToListaPinturasDTO(ArrayList<Pintura> entity) {
		ArrayList<PinturaDTO> dtoList = new ArrayList<>();

		for (Pintura e : entity) {
			dtoList.add(new PinturaDTO(e.getPrecioCompra(), e.getPrecioVenta(), e.getCantidad(), e.getNombre(),
					e.getTamanio(), e.getMarca(), e.getColor(), e.getContenidoMl(), e.isEsVinilo(), e.isEsOleo()));

		}
		return dtoList;

	}

	// MADERAS

	public static ProyectoMadera proyectoMaderaDTOToProyectoMadera(ProyectoMaderaDTO dto) {

		ProyectoMadera entity = new ProyectoMadera(dto.getPrecioCompra(), dto.getPrecioVenta(), dto.getCantidad(),
				dto.getNombre(), dto.getTamanio(), dto.getMarca(), dto.isEsCortadoMano(), dto.isEsCortadoLaser(),
				dto.isEsGrabado());
		return entity;

	}

	public static ProyectoMaderaDTO proyectoMaderaToProyectoMaderaDTO(ProyectoMadera entity) {

		ProyectoMaderaDTO dto = new ProyectoMaderaDTO(entity.getPrecioCompra(), entity.getPrecioVenta(),
				entity.getCantidad(), entity.getNombre(), entity.getTamanio(), entity.getMarca(),
				entity.isEsCortadoMano(), entity.isEsCortadoLaser(), entity.isEsGrabado());
		return dto;

	}

	public static ArrayList<ProyectoMadera> listaProyectosMaderaDTOToListaProyectosMadera(
			ArrayList<ProyectoMaderaDTO> dto) {

		ArrayList<ProyectoMadera> entityList = new ArrayList<>();

		for (ProyectoMaderaDTO d : dto) {

			entityList.add(new ProyectoMadera(d.getPrecioCompra(), d.getPrecioVenta(), d.getCantidad(), d.getNombre(),
					d.getTamanio(), d.getMarca(), d.isEsCortadoMano(), d.isEsCortadoLaser(), d.isEsGrabado()));

		}

		return entityList;

	}

	public static ArrayList<ProyectoMaderaDTO> listaProyectosMaderaToListaProyectosMaderaDTO(
			ArrayList<ProyectoMadera> entity) {

		ArrayList<ProyectoMaderaDTO> dtoList = new ArrayList<>();

		for (ProyectoMadera e : entity) {

			dtoList.add(new ProyectoMaderaDTO(e.getPrecioCompra(), e.getPrecioVenta(), e.getCantidad(), e.getNombre(),
					e.getTamanio(), e.getMarca(), e.isEsCortadoMano(), e.isEsCortadoLaser(), e.isEsGrabado()));

		}

		return dtoList;

	}
}
