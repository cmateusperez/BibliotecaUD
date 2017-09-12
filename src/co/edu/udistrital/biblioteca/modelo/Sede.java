package co.edu.udistrital.biblioteca.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sede database table.
 * 
 */
@Entity
@Table(name="sede")
@NamedQuery(name="Sede.findAll", query="SELECT s FROM Sede s")
public class Sede implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int biblioteca_idBiblioteca;

	@Column(name="id_sede")
	private int idSede;

	@Column(name="nombre_sede", length=45)
	private String nombreSede;

	@Column(name="ubicacion_sede", length=45)
	private String ubicacionSede;

	//bi-directional one-to-one association to Biblioteca
	@OneToOne
	@JoinColumn(name="Biblioteca_idBiblioteca", nullable=false, insertable=false, updatable=false)
	private Biblioteca biblioteca;

	public Sede() {
	}

	public int getBiblioteca_idBiblioteca() {
		return this.biblioteca_idBiblioteca;
	}

	public void setBiblioteca_idBiblioteca(int biblioteca_idBiblioteca) {
		this.biblioteca_idBiblioteca = biblioteca_idBiblioteca;
	}

	public int getIdSede() {
		return this.idSede;
	}

	public void setIdSede(int idSede) {
		this.idSede = idSede;
	}

	public String getNombreSede() {
		return this.nombreSede;
	}

	public void setNombreSede(String nombreSede) {
		this.nombreSede = nombreSede;
	}

	public String getUbicacionSede() {
		return this.ubicacionSede;
	}

	public void setUbicacionSede(String ubicacionSede) {
		this.ubicacionSede = ubicacionSede;
	}

	public Biblioteca getBiblioteca() {
		return this.biblioteca;
	}

	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}

}