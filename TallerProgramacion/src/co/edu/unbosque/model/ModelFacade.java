package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.PincelDAO;
import co.edu.unbosque.model.persistence.PinturaDAO;
import co.edu.unbosque.model.persistence.ProyectoMaderaDAO;

public class ModelFacade {

	private PincelDAO pincelDAO;
	private PinturaDAO pinturaDAO;
	private ProyectoMaderaDAO pMaderaDAO;

	public ModelFacade() {
		pincelDAO = new PincelDAO();
		pinturaDAO = new PinturaDAO();
		pMaderaDAO = new ProyectoMaderaDAO();
	}

	public PincelDAO getPincelDAO() {
		return pincelDAO;
	}

	public void setPincelDAO(PincelDAO pincelDAO) {
		this.pincelDAO = pincelDAO;
	}

	public PinturaDAO getPinturaDAO() {
		return pinturaDAO;
	}

	public void setPinturaDAO(PinturaDAO pinturaDAO) {
		this.pinturaDAO = pinturaDAO;
	}

	public ProyectoMaderaDAO getpMaderaDAO() {
		return pMaderaDAO;
	}

	public void setpMaderaDAO(ProyectoMaderaDAO pMaderaDAO) {
		this.pMaderaDAO = pMaderaDAO;
	}

}
