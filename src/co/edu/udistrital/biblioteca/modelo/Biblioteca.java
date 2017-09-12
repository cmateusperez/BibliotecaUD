package co.edu.udistrital.biblioteca.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * The persistent class for the biblioteca database table.
 * 
 */
@Entity
@Table(name="biblioteca")
@NamedQuery(name="Biblioteca.findAll", query="SELECT b FROM Biblioteca b")
public class Biblioteca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_biblioteca", unique=true, nullable=false)
	private int idBiblioteca;

	@Column(length=45)
	private String direccion;
	
	@Column(length=45)
	private String nombreBiblioteca;

	//bi-directional many-to-one association to Materialbibliografico
	@OneToMany(mappedBy="biblioteca",cascade=CascadeType.ALL)
	private List<MaterialBibliografico> materialbibliograficos = new ArrayList<MaterialBibliografico>();

	//bi-directional many-to-one association to Persona
	@OneToMany(mappedBy = "biblioteca")
	private List<Persona> personas = new ArrayList<>();

	//bi-directional one-to-one association to Sede
	@OneToOne(mappedBy="biblioteca",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Sede sede;

	public Biblioteca() {
	}

	public int getIdBiblioteca() {
		return this.idBiblioteca;
	}

	public void setIdBiblioteca(int idBiblioteca) {
		this.idBiblioteca = idBiblioteca;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getNombreBiblioteca() {
		return nombreBiblioteca;
	}

	public void setNombreBiblioteca(String nombreBiblioteca) {
		this.nombreBiblioteca = nombreBiblioteca;
	}

	public List<MaterialBibliografico> getMaterialbibliograficos() {
		return this.materialbibliograficos;
	}

	public void setMaterialbibliograficos(List<MaterialBibliografico> materialbibliograficos) {
		this.materialbibliograficos = materialbibliograficos;
	}

	public MaterialBibliografico addMaterialbibliografico(MaterialBibliografico materialbibliografico) {
		getMaterialbibliograficos().add(materialbibliografico);
		materialbibliografico.setBiblioteca(this);
		return materialbibliografico;
	}

	public MaterialBibliografico removeMaterialbibliografico(MaterialBibliografico materialbibliografico) {
		getMaterialbibliograficos().remove(materialbibliografico);
		materialbibliografico.setBiblioteca(null);
		return materialbibliografico;
	}

	public List<Persona> getPersonas() {
		return this.personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public Persona addPersona(Persona persona) {
		getPersonas().add(persona);
		persona.setBiblioteca(this);
		return persona;
	}

	public Persona removePersona(Persona persona) {
		getPersonas().remove(persona);
		persona.setBiblioteca(null);

		return persona;
	}

	public Sede getSede() {
		return this.sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

}