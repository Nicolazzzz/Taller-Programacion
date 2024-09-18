package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Pintura;
import co.edu.unbosque.model.PinturaDTO;

public class DataMapper {

	public static Pintura pinturaDTOToPintura(PinturaDTO pinturaDTO) {

		Pintura entity = new Pintura(pinturaDTO.getPrecio(), pinturaDTO.getCantidad(), pinturaDTO.getNombreProducto(),
				pinturaDTO.getMarca(), pinturaDTO.isEsOleo(), pinturaDTO.isEsVinilo(), pinturaDTO.getContenidoML(),
				pinturaDTO.getColor());

		return entity;
	}

	public static ArrayList<PinturaDTO> listaPinturasToListaPinturasDTO(ArrayList<Pintura> entityList) {

		ArrayList<PinturaDTO> dtoList = new ArrayList<>();
		for (Pintura p : entityList) {
			dtoList.add(new PinturaDTO(p.getPrecio(), p.getCantidad(), p.getNombreProducto(), p.getMarca(),
					p.isEsOleo(), p.isEsVinilo(), p.getContenidoML(), p.getColor()));

		}
		return dtoList;

	}

}
