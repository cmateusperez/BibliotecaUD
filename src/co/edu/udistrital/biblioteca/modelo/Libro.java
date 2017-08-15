package co.edu.udistrital.biblioteca.modelo;

public class Libro extends MaterialBibliografico{

	public Libro(Integer codigo, String nombre, String estado) {
		super(codigo, nombre, estado);
	}

	private String autor;

	private String editorial;

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	@Override
	public String getResena() {
		return "Autor: " + getAutor() + " Editorial: " + getEditorial();
	}

}
