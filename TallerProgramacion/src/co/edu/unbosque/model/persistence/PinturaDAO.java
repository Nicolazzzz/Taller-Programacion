package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Pintura;
import co.edu.unbosque.model.PinturaDTO;

public class PinturaDAO implements CRUDOperation<PinturaDTO, Pintura> {

	private ArrayList<Pintura> listaPinturas;
	private final String FILE_NAME = "pinturas.csv";

	public PinturaDAO() {
		listaPinturas = new ArrayList<>();

	}

	@Override
	public String showAll() {
		String cont = "";

		if (listaPinturas.isEmpty()) {
			return "NO HAY NADA";

		} else {
			for (Pintura p : listaPinturas)

				cont += p + "\n";
		}
		return cont;
	}

	@Override
	public ArrayList<PinturaDTO> getAll() {
		return DataMapper.listaPinturasToListaPinturasDTO(listaPinturas);
	}

	@Override
	public boolean add(PinturaDTO newData) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(PinturaDTO toDelete) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Pintura find(Pintura toFind) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(PinturaDTO previous, PinturaDTO newData) {
		// TODO Auto-generated method stub
		return false;
	}

}
