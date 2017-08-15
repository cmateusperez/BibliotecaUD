package co.edu.udistrital.biblioteca.modelo;

public class MaterialBibliografico  implements IResenable  {

	private Integer codigo;
	private String nombre;
	private String estado;

	public MaterialBibliografico(Integer codigo, String nombre, String estado) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.estado = estado;
	}

	public MaterialBibliografico(Integer codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String getResena() {
		return "";
	}


}