/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import ma.projet.classes.Employe;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;

public class EmployeService implements IDao<Employe> {

    @Override
    public boolean create(Employe employe) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(employe);
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
    public Employe getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return (Employe) session.get(Employe.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Employe> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.createQuery("from Employe").list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public List<Tache> getTachesByEmploye(int employeId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from Tache where employe.id = :employeId";
            return session.createQuery(hql)
                          .setParameter("employeId", employeId)
                          .list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }


    public List<Projet> getProjetsByEmploye(int employeId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from Projet where employe.id = :employeId";
            return session.createQuery(hql)
                          .setParameter("employeId", employeId)
                          .list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
