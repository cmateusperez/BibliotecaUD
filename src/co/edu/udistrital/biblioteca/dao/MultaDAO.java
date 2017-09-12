package co.edu.udistrital.biblioteca.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.edu.udistrital.biblioteca.modelo.Multa;
import co.edu.udistrital.biblioteca.utilidades.HibernateUtil;

public class MultaDAO {

	@SuppressWarnings("unchecked")
	public List<Multa> buscarMulta(int idPersona) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		List<Multa> multaLista = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from Multa where persona_idUsuario='" + idPersona + "'");
			multaLista = (List<Multa>) query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return multaLista;
	}
	
	public Multa buscarMultaXId(int idMulta) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		Multa multa = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from Multa where id_multa='" + idMulta + "'");
			multa = (Multa) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return multa;
	}
	
	
	public boolean eliminarMulta(Multa multa) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.delete(multa);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			return false;
		 } finally {
			session.close();
		}
		return true;
	}

}
