package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.ProyectoMadera;

public class ProyectoMaderaDAO implements CRUDOperation<ProyectoMaderaDTO, ProyectoMadera>{
	
	private ArrayList<ProyectoMadera> listaMadera;
	private final String FILE_NAME = "madera.csv";
	
	public ProyectoMaderaDAO() {
		listaMadera = new ArrayList<>();
		FileHandler.checkFolder();
	}

	@Override
	public String showAll() {
		String rta = "";
		if (listaMadera.isEmpty()) {
			return "No hay mascotas en la lista";
		} else {
			for (ProyectoMadera pm : listaMadera) {
				rta += pm;
			}
			return rta;
		}
	}

	

	
}
