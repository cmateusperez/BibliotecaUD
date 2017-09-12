package co.edu.udistrital.biblioteca.servicios;

import co.edu.udistrital.biblioteca.modelo.Biblioteca;
import co.edu.udistrital.biblioteca.modelo.MaterialBibliografico;

public interface IBibliotecaServicios {
	
	public boolean agregarMaterialBibliografico(String idBiblioteca, MaterialBibliografico materialBibliografico);
			
	public Biblioteca consultar(int id);
	
	public boolean eleminarBiblioteca(Biblioteca biblioteca);

}
