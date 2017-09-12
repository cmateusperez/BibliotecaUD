package co.edu.udistrital.biblioteca.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the multa database table.
 * 
 */
@Embeddable
public class MultaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_multa", unique=true, nullable=false)
	private int idMulta;

	@Column(insertable=false, updatable=false, unique=true, nullable=false)
	private int persona_idUsuario;

	public MultaPK() {
	}
	public int getIdMulta() {
		return this.idMulta;
	}
	public void setIdMulta(int idMulta) {
		this.idMulta = idMulta;
	}
	public int getPersona_idUsuario() {
		return this.persona_idUsuario;
	}
	public void setPersona_idUsuario(int persona_idUsuario) {
		this.persona_idUsuario = persona_idUsuario;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MultaPK)) {
			return false;
		}
		MultaPK castOther = (MultaPK)other;
		return 
			(this.idMulta == castOther.idMulta)
			&& (this.persona_idUsuario == castOther.persona_idUsuario);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idMulta;
		hash = hash * prime + this.persona_idUsuario;
		
		return hash;
	}
}