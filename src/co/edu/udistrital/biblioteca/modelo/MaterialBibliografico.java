package co.edu.udistrital.biblioteca.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the materialbibliografico database table.
 * 
 */
@Entity
@Table(name = "materialbibliografico")
@NamedQuery(name = "MaterialBibliografico.findAll", query = "SELECT m FROM MaterialBibliografico m")
//@IdClass(MaterialBibliograficoPK.class)
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo",  discriminatorType = DiscriminatorType.STRING)
public abstract class MaterialBibliografico implements Serializable, IResenable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_material_bibliografico")
	private int idMaterialBibliografico;

	@Column(length = 45, insertable= false, updatable=false)
	private String tipo;

	@Column(length = 45)
	private String edicion;

	@Column(length = 45)
	private String estado;

	@Column(name = "nombre_material", length = 45)
	private String nombreMaterial;

	@Column(length = 45)
	private String observaciones;

	// bi-directional many-to-one association to Autor
	@ManyToOne()
	@JoinColumn(name = "Autor_idAutor")
	private Autor autor;

	// bi-directional many-to-one association to Biblioteca
	@ManyToOne()
//	@Id
	@JoinColumn(name = "Biblioteca_idBiblioteca")
	private Biblioteca biblioteca;

	public MaterialBibliografico() {
	}

	public int getIdMaterialBibliografico() {
		return idMaterialBibliografico;
	}

	public void setIdMaterialBibliografico(int idMaterialBibliografico) {
		this.idMaterialBibliografico = idMaterialBibliografico;
	}

	public String getEdicion() {
		return this.edicion;
	}

	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombreMaterial() {
		return this.nombreMaterial;
	}

	public void setNombreMaterial(String nombreMaterial) {
		this.nombreMaterial = nombreMaterial;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Autor getAutor() {
		return this.autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Biblioteca getBiblioteca() {
		return this.biblioteca;
	}

	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public  abstract String getResena();
}