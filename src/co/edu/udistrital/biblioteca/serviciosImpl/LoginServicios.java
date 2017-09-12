package co.edu.udistrital.biblioteca.serviciosImpl;

import co.edu.udistrital.biblioteca.dao.PersonaDAO;
import co.edu.udistrital.biblioteca.modelo.Persona;
import co.edu.udistrital.biblioteca.servicios.ILoginServicios;

public class LoginServicios implements ILoginServicios {

	public Persona validarUsuario(String nombreUsuario, String contrasena) {
		PersonaDAO personaDAO = new PersonaDAO();
		Persona persona = personaDAO.getPersonaXNombreConstrasena(nombreUsuario, contrasena);
		if (persona != null)
			return persona;
		return null;
	}

}
