package ma.projet.service;

import ma.projet.dao.IDao;
import ma.projet.classes.Categorie;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ma.projet.util.HibernateUtil;

import java.util.List;

public class CategorieService implements IDao<Categorie> {

    @Override
    public boolean create(Categorie categorie) {
        Transaction transaction = null;
        Session session;
        session = HibernateUtil.getSessionFactory().openSession();
        try  {
            transaction = session.beginTransaction();
            session.save(categorie);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Categorie getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try  {
            return (Categorie) session.get(Categorie.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Categorie> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from Categorie";
            return session.createQuery(hql).list();  // Pas besoin de spécifier le type de retour
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

}
