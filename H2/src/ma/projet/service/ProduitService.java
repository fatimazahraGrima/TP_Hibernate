package ma.projet.service;

import java.util.ArrayList;
import java.util.Date;
import ma.projet.dao.IDao;
import ma.projet.classes.Produit;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ma.projet.util.HibernateUtil;

import java.util.List;
import org.hibernate.Query;

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
    public Produit getById(int id) {
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
    public List<Produit> getAll() {
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
public List<Produit> getProduitsByCategorie(int categorieId) {
    Session session = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("from Produit where categorie.id = :categorieId")
                      .setParameter("categorieId", categorieId)
                      .list();
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    } finally {
        if (session != null) {
            session.close();
        }
    }
}
public List<Produit> getProduitsParCommande(int commandeId) {
    Session session = null;
    Transaction transaction = null;
    List<Produit> produits = new ArrayList<>();

    try {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        
        // Requête pour obtenir les produits liés à une commande donnée
        String hql = "SELECT p FROM Commande c JOIN c.produits p WHERE c.id = :commandeId";
        Query query = session.createQuery(hql);  // Pas besoin de spécifier la classe ici
        query.setParameter("commandeId", commandeId);
        
        produits = query.list();  // Utiliser list() pour obtenir les résultats
        
        transaction.commit(); // Valider la transaction
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback(); // Annuler en cas d'erreur
        }
        e.printStackTrace();
    } finally {
        if (session != null) {
            session.close(); // Fermer la session manuellement
        }
    }
    
    return produits; // Retourner la liste des produits
}
 public List<Produit> getByPriceGreaterThan(double price) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from Produit where prix > :price";
            return session.createQuery(hql)
                          .setParameter("price", price)
                          .list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    // Méthode pour trouver les produits commandés entre deux dates
    public List<Produit> findBetweenDates(Date startDate, Date endDate) {
           Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;
    List<Produit> produits = null;

    try {
        transaction = session.beginTransaction();

        // Requête HQL pour récupérer les produits commandés entre deux dates
        String hql = "SELECT p FROM Produit p "
                   + "JOIN LigneCommandeProduit lcp ON p.id = lcp.produit.id "
                   + "JOIN Commande c ON lcp.commande.id = c.id "
                   + "WHERE c.date BETWEEN :startDate AND :endDate";

        Query query = session.createQuery(hql);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);

        // Cast manuel vers List<Produit>
        produits = query.list();  // Récupération de la liste des produits
        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    } finally {
        session.close();
    }
    return produits;
}


}
