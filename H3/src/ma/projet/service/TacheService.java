/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import ma.projet.classes.Tache;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;

public class TacheService implements IDao<Tache> {

    @Override
    public boolean create(Tache tache) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(tache);
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
    public Tache getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return (Tache) session.get(Tache.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Tache> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
              return session.createQuery("from Tache").list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public List<Tache> getTachesAbovePrice(double prix) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from Tache where prix > :prix";
            return session.createQuery(hql)
                          .setParameter("prix", prix)
                          .list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public List<Tache> getTachesBetweenDates(Date startDate, Date endDate) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from Tache where dateDebutReelle between :startDate and :endDate";
            return session.createQuery(hql)
                          .setParameter("startDate", startDate)
                          .setParameter("endDate", endDate)
                          .list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
