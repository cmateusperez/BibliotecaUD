package co.edu.udistrital.biblioteca.modelo;

public class Revista extends MaterialBibliografico{

	private String edicion;
	
	public Revista(Integer codigo, String nombre, String estado) {
		super(codigo, nombre, estado);
	}

	public String getEdicion() {
		return edicion;
	}

	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}

	@Override
	public String getResena() {
		return "Edición: " + getEdicion();
	}
	
}
