package co.edu.udistrital.biblioteca.modelo;

import java.io.Serializable;

/**
 * The primary key class for the materialbibliografico database table.
 * 
 */
public class MaterialBibliograficoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int idMaterialBibliografico;

	private int biblioteca;

	public MaterialBibliograficoPK() {
	}
	public int getIdMaterialBibliografico() {
		return this.idMaterialBibliografico;
	}
	public void setIdMaterialBibliografico(int idMaterialBibliografico) {
		this.idMaterialBibliografico = idMaterialBibliografico;
	}

	public int getBiblioteca() {
		return biblioteca;
	}
	public void setBiblioteca(int biblioteca) {
		this.biblioteca = biblioteca;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + biblioteca;
		result = prime * result + idMaterialBibliografico;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MaterialBibliograficoPK other = (MaterialBibliograficoPK) obj;
		if (biblioteca != other.biblioteca)
			return false;
		if (idMaterialBibliografico != other.idMaterialBibliografico)
			return false;
		return true;
	}

}