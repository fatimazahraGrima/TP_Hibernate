/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.H1.services;

import java.util.Date;
import ma.H1.dao.IDao;
import ma.H1.beans.Produit;
import ma.H1.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


/**
 *
 * @author user
 */
public class ProduitService implements IDao<Produit> {

    @Override
    public boolean create(Produit produit) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(produit);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(Produit produit) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(produit);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean delete(Produit produit) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(produit);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public Produit findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return (Produit) session.get(Produit.class, id);  // session.get ne pose pas de problème avec le type Produit
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Produit> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from Produit";
            return session.createQuery(hql).list();  // Pas besoin de spécifier le type de retour
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    // Méthode supplémentaire pour trouver les produits dont le prix est supérieur à une certaine valeur
   
}


