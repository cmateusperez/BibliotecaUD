package co.edu.udistrital.biblioteca.servicios;

import java.util.List;

import co.edu.udistrital.biblioteca.modelo.Autor;

public interface IAutorServicios {
	
	public List<Autor> buscarAutores();
	
	public boolean crearAutor(Autor autor);
	
	public boolean eliminarAutor(Autor autor);


}
