package co.edu.udistrital.biblioteca.serviciosImpl;

import java.util.List;

import co.edu.udistrital.biblioteca.modelo.Biblioteca;
import co.edu.udistrital.biblioteca.modelo.MaterialBibliografico;

public interface IBibliotecaServicios {
	
	public boolean agregarMaterialBibliografico(String idBiblioteca, MaterialBibliografico materialBibliografico);
		
	public List<MaterialBibliografico>  prestarMaterialBibliografico(String idBiblioteca, Integer codigo);
	
	public Biblioteca consultar(String id);

}
