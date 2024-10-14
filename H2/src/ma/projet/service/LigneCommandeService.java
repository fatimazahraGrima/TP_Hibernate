
package ma.projet.service;

import ma.projet.dao.IDao;
import ma.projet.classes.LigneCommandeProduit;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ma.projet.util.HibernateUtil;

import java.util.List;

public class LigneCommandeService implements IDao<LigneCommandeProduit> {

    @Override
    public boolean create(LigneCommandeProduit ligneCommandeProduit) {
         Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(ligneCommandeProduit);
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
    public LigneCommandeProduit getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return (LigneCommandeProduit) session.get(LigneCommandeProduit.class, id);  // session.get ne pose pas de problème avec le type Produit
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<LigneCommandeProduit> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from LigneCommandeProduit";
            return session.createQuery(hql).list();  // Pas besoin de spécifier le type de retour
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
