package co.edu.udistrital.biblioteca.dao;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.edu.udistrital.biblioteca.modelo.Biblioteca;
import co.edu.udistrital.biblioteca.utilidades.HibernateUtil;

public class BibliotecaDAO {
	
	public Biblioteca buscarBibliotecaXId(int id) {
		Session session = HibernateUtil.openSession();
		 Transaction tx = null;
	        Biblioteca biblioteca = null;
	        try {
	            tx = session.getTransaction();
	            tx.begin();
	            Query query = session.createQuery("from Biblioteca where idBiblioteca='"+id+"'");
	            biblioteca = (Biblioteca)query.uniqueResult();
				Hibernate.initialize(biblioteca.getMaterialbibliograficos());
				Hibernate.initialize(biblioteca.getPersonas());
	            tx.commit();
	        } catch (Exception e) {
	            if (tx != null) {
	                tx.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	        return biblioteca;
	}
	
	public boolean eliminarBiblioteca(Biblioteca biblioteca) {
		Session session = HibernateUtil.openSession();
		 Transaction tx = null;
	        try {
	            tx = session.getTransaction();
	            tx.begin();
	            session.delete(biblioteca);
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
