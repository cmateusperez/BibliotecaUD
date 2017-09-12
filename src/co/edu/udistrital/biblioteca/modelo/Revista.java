package co.edu.udistrital.biblioteca.modelo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("REVISTA")
public class Revista extends MaterialBibliografico {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getResena() {
		return "La edici�n de la revista es la: " + getEdicion();
	}

}
