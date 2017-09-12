package co.edu.udistrital.biblioteca.serviciosImpl;

import java.util.List;

import co.edu.udistrital.biblioteca.dao.AutorDAO;
import co.edu.udistrital.biblioteca.modelo.Autor;
import co.edu.udistrital.biblioteca.servicios.IAutorServicios;

public class AutorServicios implements IAutorServicios {

	@Override
	public List<Autor> buscarAutores() {
		AutorDAO autorDAO = new AutorDAO();
		List<Autor> autorLista = autorDAO.buscarAutores();
		return autorLista;
	}

	@Override
	public boolean crearAutor(Autor autor) {
		AutorDAO autorDAO = new AutorDAO();
		return autorDAO.crearAutor(autor);

	}

	@Override
	public boolean eliminarAutor(Autor autor) {
		AutorDAO autorDAO = new AutorDAO();
		return autorDAO.eliminarAutor(autor);
	}

}
