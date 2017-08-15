package co.edu.udistrital.biblioteca.modelo;

import java.util.Date;

public class Prestamo {
	
	private Integer id;
	
	private Date fechaInicioPrestamo;
	
	private Date fechaFinPrestamos;
	
	private Usuario usuario;
	
	private MaterialBibliografico materialBibliografico;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaInicioPrestamo() {
		return fechaInicioPrestamo;
	}

	public void setFechaInicioPrestamo(Date fechaInicioPrestamo) {
		this.fechaInicioPrestamo = fechaInicioPrestamo;
	}

	public Date getFechaFinPrestamos() {
		return fechaFinPrestamos;
	}

	public void setFechaFinPrestamos(Date fechaFinPrestamos) {
		this.fechaFinPrestamos = fechaFinPrestamos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public MaterialBibliografico getMaterialBibliografico() {
		return materialBibliografico;
	}

	public void setMaterialBibliografico(MaterialBibliografico materialBibliografico) {
		this.materialBibliografico = materialBibliografico;
	}

}
