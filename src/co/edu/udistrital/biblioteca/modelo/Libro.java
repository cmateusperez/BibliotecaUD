package co.edu.udistrital.biblioteca.modelo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "materialbibliografico")
@DiscriminatorValue("LIBRO")
public class Libro extends MaterialBibliografico {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getResena() {
		return "El autor del libro es: " + getAutor().getNombreAutor();
	}

}
