package co.edu.udistrital.biblioteca.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the rol database table.
 * 
 */
@Entity
@Table(name="rol")
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_rol", unique=true, nullable=false)
	private int idRol;

	@Column(name="nombre_rol", length=45)
	private String nombreRol;

	//bi-directional many-to-one association to Persona
	@OneToMany(mappedBy="rol")
	private List<Persona> personas1;

	//bi-directional many-to-many association to Persona
	@ManyToMany(mappedBy="rols")
	private List<Persona> personas2;

	public Rol() {
	}

	public int getIdRol() {
		return this.idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getNombreRol() {
		return this.nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public List<Persona> getPersonas1() {
		return this.personas1;
	}

	public void setPersonas1(List<Persona> personas1) {
		this.personas1 = personas1;
	}

	public Persona addPersonas1(Persona personas1) {
		getPersonas1().add(personas1);
		personas1.setRol(this);

		return personas1;
	}

	public Persona removePersonas1(Persona personas1) {
		getPersonas1().remove(personas1);
		personas1.setRol(null);

		return personas1;
	}

	public List<Persona> getPersonas2() {
		return this.personas2;
	}

	public void setPersonas2(List<Persona> personas2) {
		this.personas2 = personas2;
	}

}