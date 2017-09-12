package co.edu.udistrital.biblioteca.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the multa database table.
 * 
 */
@Entity
@Table(name="multa")
@NamedQuery(name="Multa.findAll", query="SELECT m FROM Multa m")
public class Multa implements Serializable {
	private static final long serialVersionUID = 1L;

//	@EmbeddedId
//	private MultaPK id;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_multa")
	private int idMulta;

	@Column(name="costo_multa", length=45)
	private String costoMulta;

	@Column(length=45)
	private String observaciones;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="Persona_idUsuario")
	private Persona persona;

	public Multa() {
	}

	public String getCostoMulta() {
		return this.costoMulta;
	}

	public void setCostoMulta(String costoMulta) {
		this.costoMulta = costoMulta;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public int getIdMulta() {
		return idMulta;
	}

	public void setIdMulta(int idMulta) {
		this.idMulta = idMulta;
	}

}