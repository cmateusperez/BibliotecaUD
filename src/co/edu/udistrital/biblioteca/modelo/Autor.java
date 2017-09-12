package co.edu.udistrital.biblioteca.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the autor database table.
 * 
 */
@Entity
@Table(name="autor")
@NamedQuery(name="Autor.findAll", query="SELECT a FROM Autor a")
public class Autor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_autor", unique=true, nullable=false)
	private int idAutor;

	@Column(name="nombre_autor", length=45)
	private String nombreAutor;

	//bi-directional many-to-one association to Materialbibliografico
	@OneToMany(mappedBy="autor")
	private List<MaterialBibliografico> materialbibliograficos;

	public Autor() {
	}

	public int getIdAutor() {
		return this.idAutor;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}

	public String getNombreAutor() {
		return this.nombreAutor;
	}

	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}

	public List<MaterialBibliografico> getMaterialbibliograficos() {
		return this.materialbibliograficos;
	}

	public void setMaterialbibliograficos(List<MaterialBibliografico> materialbibliograficos) {
		this.materialbibliograficos = materialbibliograficos;
	}

	public MaterialBibliografico addMaterialbibliografico(MaterialBibliografico materialbibliografico) {
		getMaterialbibliograficos().add(materialbibliografico);
		materialbibliografico.setAutor(this);

		return materialbibliografico;
	}

	public MaterialBibliografico removeMaterialbibliografico(MaterialBibliografico materialbibliografico) {
		getMaterialbibliograficos().remove(materialbibliografico);
		materialbibliografico.setAutor(null);

		return materialbibliografico;
	}

}