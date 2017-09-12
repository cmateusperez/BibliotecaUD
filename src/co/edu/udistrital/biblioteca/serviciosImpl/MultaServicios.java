package co.edu.udistrital.biblioteca.serviciosImpl;

import java.util.List;

import co.edu.udistrital.biblioteca.dao.MultaDAO;
import co.edu.udistrital.biblioteca.modelo.Multa;
import co.edu.udistrital.biblioteca.servicios.IMultaServicios;

public class MultaServicios implements IMultaServicios {



	@Override
	public List<Multa> buscarMulta(int idPersona) {
		MultaDAO multaDAO = new MultaDAO();
		List<Multa> multaLista = multaDAO.buscarMulta(idPersona);
		return multaLista;
	}

	@Override
	public Multa buscarMultaXId(int idMulta) {
		MultaDAO multaDAO = new MultaDAO();		
		return multaDAO.buscarMultaXId(idMulta);
	}

	@Override
	public boolean eliminarMulta(Multa multa) {
		MultaDAO multaDAO = new MultaDAO();		
		return multaDAO.eliminarMulta(multa);
	}


}
