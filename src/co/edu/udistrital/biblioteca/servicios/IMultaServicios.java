package co.edu.udistrital.biblioteca.servicios;

import java.util.List;

import co.edu.udistrital.biblioteca.modelo.Multa;

public interface IMultaServicios {

	public List<Multa> buscarMulta(int idPersona);
	
	public Multa buscarMultaXId(int idMulta);
	
	public boolean eliminarMulta(Multa multa); 

}
