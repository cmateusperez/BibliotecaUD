package co.edu.udistrital.biblioteca.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.edu.udistrital.biblioteca.modelo.MaterialBibliografico;
import co.edu.udistrital.biblioteca.utilidades.HibernateUtil;

public class MaterialBibliograficoDAO {

	public boolean crearMaterialBibliografico(MaterialBibliografico materialBibliografico) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.saveOrUpdate(materialBibliografico.getBiblioteca());
			session.saveOrUpdate(materialBibliografico);
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

	@SuppressWarnings("unchecked")
	public List<MaterialBibliografico> buscarMaterialBibiograficoXIdBiblioteca(int id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		List<MaterialBibliografico> materialBibliograficoLista = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from MaterialBibliografico where biblioteca_idbiblioteca='" + id + "'");
			materialBibliograficoLista = (List<MaterialBibliografico>) query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return materialBibliograficoLista;
	}

	public MaterialBibliografico buscarMaterialBibiograficoXId(int id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		MaterialBibliografico materialBibliografico = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from MaterialBibliografico where id_material_bibliografico='" + id + "'");
			materialBibliografico = (MaterialBibliografico) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return materialBibliografico;
	}

	public boolean actualizarMaterialBibliografico(MaterialBibliografico materialBibliografico) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.createQuery("UPDATE MaterialBibliografico SET estado='" + materialBibliografico.getEstado()
					+ "' WHERE biblioteca_idbiblioteca=1 AND id_material_bibliografico='"
					+ materialBibliografico.getIdMaterialBibliografico() + "'").executeUpdate();
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
