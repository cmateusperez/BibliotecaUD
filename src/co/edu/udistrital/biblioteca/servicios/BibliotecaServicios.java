package co.edu.udistrital.biblioteca.servicios;

import java.util.ArrayList;
import java.util.List;

import co.edu.udistrital.biblioteca.modelo.Biblioteca;
import co.edu.udistrital.biblioteca.modelo.Libro;
import co.edu.udistrital.biblioteca.modelo.MaterialBibliografico;
import co.edu.udistrital.biblioteca.modelo.Revista;
import co.edu.udistrital.biblioteca.serviciosImpl.IBibliotecaServicios;

public class BibliotecaServicios implements IBibliotecaServicios {

	@Override
	public boolean agregarMaterialBibliografico(String idBiblioteca, MaterialBibliografico materialBibliografico) {
		return true;
	}

	@Override
	public List<MaterialBibliografico> prestarMaterialBibliografico(String idBiblioteca, Integer codigo) {
		List<MaterialBibliografico> materialBibliograficoList = new ArrayList<MaterialBibliografico>();
		MaterialBibliografico materialBibliografico = new MaterialBibliografico(new Integer(1), "100 años de soledad",
				"No disponible");
		materialBibliograficoList.add(materialBibliografico);
		return materialBibliograficoList;

	}

	@Override
	public Biblioteca consultar(String idBiblioteca) {
		Biblioteca biblioteca = new Biblioteca();
		List<MaterialBibliografico> materialBibliograficoLista = new ArrayList<>();
		Libro libro = new Libro(new Integer(1), "100 años de soledad", "Disponible");
		libro.setEditorial("Suramericana");
		libro.setAutor("Gabriel Garcia Marquez");
		Revista revista = new Revista(new Integer(2), "Contexto Digital", "Disponible");
		revista.setEdicion("10");
		materialBibliograficoLista.add(libro);
		materialBibliograficoLista.add(revista);
		biblioteca.setListaMaterialBibliografico(materialBibliograficoLista);
		return biblioteca;
	}

}
