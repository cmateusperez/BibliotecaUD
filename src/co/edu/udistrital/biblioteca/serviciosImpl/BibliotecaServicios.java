package co.edu.udistrital.biblioteca.serviciosImpl;

import co.edu.udistrital.biblioteca.dao.BibliotecaDAO;
import co.edu.udistrital.biblioteca.dao.PersonaDAO;
import co.edu.udistrital.biblioteca.modelo.Biblioteca;
import co.edu.udistrital.biblioteca.modelo.MaterialBibliografico;
import co.edu.udistrital.biblioteca.modelo.Persona;
import co.edu.udistrital.biblioteca.servicios.IBibliotecaServicios;

public class BibliotecaServicios implements IBibliotecaServicios {

	@Override
	public boolean agregarMaterialBibliografico(String idBiblioteca, MaterialBibliografico materialBibliografico) {
		return true;
	}

	@Override
	public Biblioteca consultar(int id) {
		BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
		Biblioteca biblioteca = bibliotecaDAO.buscarBibliotecaXId(id);
		return biblioteca;
	}

	@Override
	public boolean eleminarBiblioteca(Biblioteca biblioteca) {
		BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
		PersonaDAO personaDAO = new PersonaDAO();
		for (Persona persona : biblioteca.getPersonas()) {
			personaDAO.updatePersona(persona.getIdPersona());
		}
		return bibliotecaDAO.eliminarBiblioteca(biblioteca);
	}

}
