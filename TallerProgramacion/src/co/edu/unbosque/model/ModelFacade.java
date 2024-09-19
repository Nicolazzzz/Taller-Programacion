package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.PincelDAO;
import co.edu.unbosque.model.persistence.PinturaDAO;
import co.edu.unbosque.model.persistence.ProyectoMaderaDAO;

/**
 * La clase ModelFacade actúa como una fachada para interactuar con los DAOs
 * (Data Access Objects) relacionados con los objetos de pincel, pintura y
 * proyectos de madera. Proporciona métodos para obtener y establecer las
 * instancias de los DAOs correspondientes, facilitando la comunicación entre el
 * modelo y la persistencia de datos.
 * 
 * @author MARIO RODRIGUEZ
 * @version 1.0
 * @since 2024-04-27
 */
public class ModelFacade {

	private PincelDAO pincelDAO;
	private PinturaDAO pinturaDAO;
	private ProyectoMaderaDAO pMaderaDAO;

	/**
	 * Constructor de la clase ModelFacade. Inicializa las instancias de los DAOs:
	 * PincelDAO, PinturaDAO y ProyectoMaderaDAO.
	 */
	public ModelFacade() {
		pincelDAO = new PincelDAO();
		pinturaDAO = new PinturaDAO();
		pMaderaDAO = new ProyectoMaderaDAO();
	}

	/**
	 * Obtiene la instancia de PincelDAO.
	 * 
	 * @return instancia de PincelDAO.
	 */
	public PincelDAO getPincelDAO() {
		return pincelDAO;
	}

	/**
	 * Establece la instancia de PincelDAO.
	 * 
	 * @param pincelDAO instancia de PincelDAO a asignar.
	 */
	public void setPincelDAO(PincelDAO pincelDAO) {
		this.pincelDAO = pincelDAO;
	}

	/**
	 * Obtiene la instancia de PinturaDAO.
	 * 
	 * @return instancia de PinturaDAO.
	 */
	public PinturaDAO getPinturaDAO() {
		return pinturaDAO;
	}

	/**
	 * Establece la instancia de PinturaDAO.
	 * 
	 * @param pinturaDAO instancia de PinturaDAO a asignar.
	 */
	public void setPinturaDAO(PinturaDAO pinturaDAO) {
		this.pinturaDAO = pinturaDAO;
	}

	/**
	 * Obtiene la instancia de ProyectoMaderaDAO.
	 * 
	 * @return instancia de ProyectoMaderaDAO.
	 */
	public ProyectoMaderaDAO getpMaderaDAO() {
		return pMaderaDAO;
	}

	/**
	 * Establece la instancia de ProyectoMaderaDAO.
	 * 
	 * @param pMaderaDAO instancia de ProyectoMaderaDAO a asignar.
	 */
	public void setpMaderaDAO(ProyectoMaderaDAO pMaderaDAO) {
		this.pMaderaDAO = pMaderaDAO;
	}

}
