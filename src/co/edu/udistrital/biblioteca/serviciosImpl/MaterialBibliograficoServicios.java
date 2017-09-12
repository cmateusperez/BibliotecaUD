package co.edu.udistrital.biblioteca.serviciosImpl;

import java.util.List;

import co.edu.udistrital.biblioteca.dao.MaterialBibliograficoDAO;
import co.edu.udistrital.biblioteca.modelo.MaterialBibliografico;
import co.edu.udistrital.biblioteca.servicios.IMaterialBibliograficoServicios;

public class MaterialBibliograficoServicios implements IMaterialBibliograficoServicios{

	@Override
	public boolean crearMaterialBibliografico(MaterialBibliografico materialBibliografico) {
		MaterialBibliograficoDAO materialBibligraficoDAO = new MaterialBibliograficoDAO();
		return materialBibligraficoDAO.crearMaterialBibliografico(materialBibliografico);
	}

	@Override
	public List<MaterialBibliografico> buscarMaterialBibliograficoXIdBiblioteca(int id) {
		MaterialBibliograficoDAO materialBibligraficoDAO = new MaterialBibliograficoDAO();
		return materialBibligraficoDAO.buscarMaterialBibiograficoXIdBiblioteca(id);
	}

	@Override
	public MaterialBibliografico buscarMaterialBibliograficoXId(int id) {
		MaterialBibliograficoDAO materialBibligraficoDAO = new MaterialBibliograficoDAO();
		return materialBibligraficoDAO.buscarMaterialBibiograficoXId(id);
	}
	
	@Override
	public boolean actualizarMaterialBibliografico(MaterialBibliografico materialBibliografico) {
		MaterialBibliograficoDAO materialBibligraficoDAO = new MaterialBibliograficoDAO();
		return materialBibligraficoDAO.actualizarMaterialBibliografico(materialBibliografico);
	}

}
