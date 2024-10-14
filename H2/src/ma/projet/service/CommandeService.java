package ma.projet.service;

import java.util.ArrayList;
import java.util.Date;
import ma.projet.dao.IDao;
import ma.projet.classes.Commande;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ma.projet.util.HibernateUtil;

import java.util.List;
import ma.projet.classes.LigneCommandeProduit;
import ma.projet.classes.Produit;

public class CommandeService implements IDao<Commande> {

    @Override
    public boolean create(Commande commande) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(commande);
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
public void creerCommande(List<Produit> produits, List<Integer> quantites) {
        // Vérifier si la taille des listes est cohérente
        if (produits.size() != quantites.size()) {
            throw new IllegalArgumentException("La liste des produits et des quantités doivent avoir la même taille.");
        }

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Créer une nouvelle commande
            Commande commande = new Commande(new Date());

            List<LigneCommandeProduit> ligneCommandeProduits = new ArrayList<>();
            for (int i = 0; i < produits.size(); i++) {
                Produit produit = produits.get(i);
                int quantite = quantites.get(i);

                LigneCommandeProduit ligneCommandeProduit = new LigneCommandeProduit(produit, commande, quantite);
                ligneCommandeProduits.add(ligneCommandeProduit);
            }

            // Lier la liste des ligneCommandeProduits à la commande
            commande.setLigneCommandes(ligneCommandeProduits);

            // Sauvegarder la commande et ses lignes
            session.save(commande);

            // Commit la transaction
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    @Override
    public Commande getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return (Commande) session.get(Commande.class, id);  // session.get ne pose pas de problème avec le type Produit
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Commande> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from Commande";
            return session.createQuery(hql).list();  // Pas besoin de spécifier le type de retour
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public List<LigneCommandeProduit> getProduitsByCommande(int commandeId) {
   
     Session session = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("from LigneCommandeProduit where commande.id = :commandeId")
                      .setParameter("commandeId", commandeId)
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
}
