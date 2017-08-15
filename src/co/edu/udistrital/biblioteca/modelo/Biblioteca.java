package co.edu.udistrital.biblioteca.modelo;

import java.util.List;

public class Biblioteca {
	
	private String idBliblioteca;
	
	private List<MaterialBibliografico> listaMaterialBibliografico;
	
	private List<Usuario> listaUsuario;

	public String getIdBliblioteca() {
		return idBliblioteca;
	}

	public void setIdBliblioteca(String idBliblioteca) {
		this.idBliblioteca = idBliblioteca;
	}

	public List<MaterialBibliografico> getListaMaterialBibliografico() {
		return listaMaterialBibliografico;
	}

	public void setListaMaterialBibliografico(List<MaterialBibliografico> listaMaterialBibliografico) {
		this.listaMaterialBibliografico = listaMaterialBibliografico;
	}

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}
	
}
