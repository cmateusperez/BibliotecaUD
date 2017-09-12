package co.edu.udistrital.biblioteca.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.edu.udistrital.biblioteca.modelo.Autor;
import co.edu.udistrital.biblioteca.utilidades.HibernateUtil;

public class AutorDAO {

	@SuppressWarnings("unchecked")
	public List<Autor> buscarAutores() {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		List<Autor> autorLista = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from Autor");
			autorLista = (List<Autor>) query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return autorLista;
	}
	
	public boolean crearAutor(Autor autor) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.save(autor);
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
	
	
	public boolean eliminarAutor(Autor autor) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.delete(autor);
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
