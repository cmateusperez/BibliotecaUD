package co.edu.udistrital.biblioteca.servicios;

import co.edu.udistrital.biblioteca.modelo.Persona;

public interface ILoginServicios {
	
	public Persona validarUsuario(String nombreUsuario, String contrasena);

}
