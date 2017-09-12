package co.edu.udistrital.biblioteca.servicios;

import java.util.List;

import co.edu.udistrital.biblioteca.modelo.MaterialBibliografico;

public interface IMaterialBibliograficoServicios {

	public boolean crearMaterialBibliografico(MaterialBibliografico materialBibliografico);

	public List<MaterialBibliografico> buscarMaterialBibliograficoXIdBiblioteca(int id);

	public MaterialBibliografico buscarMaterialBibliograficoXId(int id);

	public boolean actualizarMaterialBibliografico(MaterialBibliografico materialBibliografico);

}
