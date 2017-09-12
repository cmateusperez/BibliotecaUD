package co.edu.udistrital.biblioteca.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@Table(name="persona")
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_persona", unique=true, nullable=false)
	private int idPersona;

	@Column(length=45)
	private String constrasena;

	@Column(length=45)
	private String direccion;

	@Column(name="nombre_usuario", length=45)
	private String nombreUsuario;

	@Column(length=45)
	private String nombreCompleto;

	@Column(length=45)
	private String observaciones;

	@Column(length=45)
	private String telefono;

	//bi-directional many-to-one association to Multa
	@OneToMany(mappedBy="persona")
	private List<Multa> multas;

	//bi-directional many-to-one association to Biblioteca
	@ManyToOne(targetEntity = Biblioteca.class)
//	@JoinColumn(name="Biblioteca_id_biblioteca", nullable=false)
	private Biblioteca biblioteca;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="Rol_id_rol", nullable=false)
	private Rol rol;

	//bi-directional many-to-many association to Rol
	@ManyToMany
	@JoinTable(
		name="usuario_rol"
		, joinColumns={
			@JoinColumn(name="IdUsuario", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="IdRol", nullable=false)
			}
		)
	private List<Rol> rols;

	public Persona() {
	}

	public int getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getConstrasena() {
		return this.constrasena;
	}

	public void setConstrasena(String constrasena) {
		this.constrasena = constrasena;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombreCompleto() {
		return this.nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Multa> getMultas() {
		return this.multas;
	}

	public void setMultas(List<Multa> multas) {
		this.multas = multas;
	}

	public Multa addMulta(Multa multa) {
		getMultas().add(multa);
		multa.setPersona(this);

		return multa;
	}

	public Multa removeMulta(Multa multa) {
		getMultas().remove(multa);
		multa.setPersona(null);

		return multa;
	}

	public Biblioteca getBiblioteca() {
		return this.biblioteca;
	}

	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public List<Rol> getRols() {
		return this.rols;
	}

	public void setRols(List<Rol> rols) {
		this.rols = rols;
	}

}