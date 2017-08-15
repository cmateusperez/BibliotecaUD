package co.edu.udistrital.biblioteca.servicios;

import java.util.ArrayList;
import java.util.List;

import co.edu.udistrital.biblioteca.modelo.Usuario;
import co.edu.udistrital.biblioteca.serviciosImpl.ILoginServicios;

public class LoginServicios implements ILoginServicios {

	public String validarUsuario(String nombreUsuario, String contrasena) {

		List<Usuario> usuarioList = new ArrayList<Usuario>();

		// Datos Dummy
		Usuario usuarioPrueba = new Usuario();
		usuarioPrueba.setContrasena("12345");
		usuarioPrueba.setNombreUsuario("administrador");
		usuarioList.add(usuarioPrueba);

		if (nombreUsuario == null || contrasena == null || nombreUsuario.length() == 0 || contrasena.length() == 0) {
			return "Se requieren los campos usuario y contraseña!";
		} else if (!usuarioPrueba.getNombreUsuario().equalsIgnoreCase(nombreUsuario)
				|| !usuarioPrueba.getContrasena().equalsIgnoreCase(contrasena)) {
			return "Los datos son invalidos!";

		}
		return null;

	}

}
