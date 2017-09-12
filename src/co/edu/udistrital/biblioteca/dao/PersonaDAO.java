package co.edu.udistrital.biblioteca.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.edu.udistrital.biblioteca.modelo.Persona;
import co.edu.udistrital.biblioteca.utilidades.HibernateUtil;

public class PersonaDAO {

	public Persona getPersonaXNombreConstrasena(String nombreUsuario, String contrasena) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		Persona persona = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from Persona where constrasena='" + contrasena + "'"
					+ "and nombre_usuario='" + nombreUsuario + "'");
			persona = (Persona) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return persona;
	}

	public Persona updatePersona(int idPersona) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		Persona persona = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.createQuery(
					"UPDATE Persona SET biblioteca_id_biblioteca=" + null + " WHERE id_persona='" + idPersona + "'")
					.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return persona;
	}

}
