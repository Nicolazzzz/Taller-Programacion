package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.ProyectoMadera;
import co.edu.unbosque.model.ProyectoMaderaDTO;

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

	@Override
	public ArrayList<ProyectoMaderaDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(ProyectoMaderaDTO newData) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(ProyectoMaderaDTO toDelete) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ProyectoMadera find(ProyectoMadera toFind) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(ProyectoMaderaDTO previous, ProyectoMaderaDTO newData) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void readFile() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeFile() {
		// TODO Auto-generated method stub
		
	}

	

	
}
