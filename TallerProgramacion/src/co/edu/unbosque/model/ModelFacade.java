package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.PincelDAO;

public class ModelFacade {

	private PincelDAO pincelDAO;

	public ModelFacade() {
		pincelDAO = new PincelDAO();
	}

	public PincelDAO getPincelDAO() {
		return pincelDAO;
	}

	public void setPincelDAO(PincelDAO pincelDAO) {
		this.pincelDAO = pincelDAO;
	}

}
