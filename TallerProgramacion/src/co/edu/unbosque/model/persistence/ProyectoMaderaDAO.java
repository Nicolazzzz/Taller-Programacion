package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.ProyectoMadera;
import co.edu.unbosque.model.ProyectoMaderaDTO;

public class ProyectoMaderaDAO implements CRUDOperation<ProyectoMaderaDTO, ProyectoMadera> {

	private ArrayList<ProyectoMadera> listaMadera;
	private final String FILE_NAME = "madera.csv";
	private final String SERIAL_NAME = "madera.bat";

	public ProyectoMaderaDAO() {
		FileHandler.checkFolder();
		readSerialized();

	}

	@Override
	public String showAll() {
		String rta = "";
		int pos = 1;
		if (listaMadera.isEmpty()) {
			return "No hay proyectos de madera creados en la lista";
		} else {
			for (ProyectoMadera pm : listaMadera) {
				rta += "Producto " + pos;
				pos++;
				rta += pm + "\n" + "\n";
			}
			return rta;
		}
	}

	@Override
	public ArrayList<ProyectoMaderaDTO> getAll() {
		return DataMapper.listaProyectosMaderaToListaProyectosMaderaDTO(listaMadera);
	}

	@Override
	public boolean add(ProyectoMaderaDTO newData) {
		if (find(DataMapper.proyectoMaderaDTOToProyectoMadera(newData)) == null) {
			listaMadera.add(DataMapper.proyectoMaderaDTOToProyectoMadera(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean delete(ProyectoMaderaDTO toDelete) {
		ProyectoMadera found = find(DataMapper.proyectoMaderaDTOToProyectoMadera(toDelete));
		if (found != null) {
			listaMadera.remove(found);
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public ProyectoMadera find(ProyectoMadera toFind) {
		ProyectoMadera found = null;
		if (!listaMadera.isEmpty()) {
			for (ProyectoMadera madera : listaMadera) {
				if (madera.getNombre().toLowerCase().equals(toFind.getNombre().toLowerCase())) {
					found = madera;
					return found;
				} else {
					continue;
				}
			}
		} else {
			return null;
		}
		return null;
	}

	@Override
	public boolean update(ProyectoMaderaDTO previous, ProyectoMaderaDTO newData) {
		ProyectoMadera found = find(DataMapper.proyectoMaderaDTOToProyectoMadera(previous));
		if (found != null) {
			listaMadera.remove(found);
			listaMadera.add(DataMapper.proyectoMaderaDTOToProyectoMadera(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void readFile() {
		String content = FileHandler.readFile(FILE_NAME);
		if (content.equals("") || content == null) {
			listaMadera = new ArrayList<>();
		} else {
			listaMadera = new ArrayList<>();
			String[] rows = content.split("\n");
			for (String row : rows) {
				String[] cols = content.split(";");
				ProyectoMadera pm = new ProyectoMadera();
				pm.setPrecioCompra(Double.parseDouble(cols[0]));
				pm.setPrecioVenta(Double.parseDouble(cols[1]));
				pm.setCantidad(Integer.parseInt(cols[2]));
				pm.setNombre(cols[3]);
				pm.setTamanio(cols[4]);
				pm.setMarca(cols[5]);
				pm.setEsCortadoMano(Boolean.parseBoolean(cols[6]));
				pm.setEsCortadoLaser(Boolean.parseBoolean(cols[7]));
				pm.setEsGrabado(Boolean.parseBoolean(cols[8]));
				listaMadera.add(pm);
			}
		}

	}

	@Override
	public void writeFile() {
		String content = "";
		for (ProyectoMadera pm : listaMadera) {
			content += pm.getPrecioCompra() + ";";
			content += pm.getPrecioVenta() + ";";
			content += pm.getCantidad() + ";";
			content += pm.getNombre() + ";";
			content += pm.getTamanio() + ";";
			content += pm.getMarca() + ";";
			content += pm.isEsCortadoMano() + ";";
			content += pm.isEsCortadoLaser() + ";";
			content += pm.isEsGrabado();
		}
		FileHandler.writeFile(FILE_NAME, content);

	}

	public void writeSerialized() {
		FileHandler.writeSerialized(SERIAL_NAME, listaMadera);
	}

	@SuppressWarnings("unchecked")
	public void readSerialized() {

		Object content = FileHandler.readSerialized(SERIAL_NAME);

		if (content == null) {
			listaMadera = new ArrayList<>();
		} else {
			listaMadera = (ArrayList<ProyectoMadera>) content;
		}

	}

	public double calculateInversion() {
		double inversion = 0;
		for (ProyectoMadera p : listaMadera) {
			inversion += p.getPrecioCompra();
		}
		return inversion;
	}

	public double calculateGanancia() {
		double ganancia = 0;
		for (ProyectoMadera p : listaMadera) {
			ganancia += p.getPrecioVenta();
		}
		return ganancia;
	}

	public int calculateCantidad() {
		int cantidad = 0;
		for (ProyectoMadera p : listaMadera) {
			cantidad += p.getCantidad();
		}
		return cantidad;
	}

}