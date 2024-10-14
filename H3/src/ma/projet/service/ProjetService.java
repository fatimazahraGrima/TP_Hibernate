/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.text.SimpleDateFormat;
import java.util.List;
import ma.projet.classes.EmployeTache;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.dao.IDao;
import  ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author user
 */
public class ProjetService implements IDao<Projet> {
    @Override
    public boolean create(Projet projet) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(projet);
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
    public Projet getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return (Projet) session.get(Projet.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Projet> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.createQuery("from Projet").list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public List<Tache> getTachesByProjet(int projetId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from Tache where projet.id = :projetId";
            return session.createQuery(hql)
                          .setParameter("projetId", projetId)
                          .list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public void displayCompletedTaches(int projetId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
    try {
        // Récupérer uniquement les instances d'EmployeTache
        String hql = "from EmployeTache where projet.id = :projetId";
        List<EmployeTache> taches = session.createQuery(hql)
                                                  .setParameter("projetId", projetId)
                                                  .list();
        System.out.println("Projet ID: " + projetId);
        for (EmployeTache tache : taches) {
            System.out.println("Nom: " + tache.getNom() + " Début: " + tache.getDateDebutReelle()
                + " Fin: " + tache.getDateFinReelle());
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        session.close();
    }
    }
public void displayTachesByProjet(int projetId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            String hql = "from EmployeTache where projet.id = :projetId";
            List<EmployeTache> tachesReelles = session.createQuery(hql)
                    .setParameter("projetId", projetId)
                    .list();

            // Afficher les informations du projet
            System.out.println("Projet : " + projetId);
            if (!tachesReelles.isEmpty()) {
                EmployeTache firstTask = tachesReelles.get(0);
                System.out.println("Nom : " + firstTask.getProjet().getNom());
                System.out.println("Date début : " + new SimpleDateFormat("dd MMMM yyyy").format(firstTask.getProjet().getDateDebut()));

                // Afficher la liste des tâches
                System.out.println("Liste des tâches:");
                System.out.println("Num\tNom\t\tDate Début Réelle\tDate Fin Réelle");

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                for (EmployeTache tache : tachesReelles) {
                    System.out.println(tache.getId() + "\t" + tache.getNom() + "\t\t" + 
                                       sdf.format(tache.getDateDebutReelle()) + "\t\t" + 
                                       sdf.format(tache.getDateFinReelle()));
                }
            } else {
                System.out.println("Aucune tâche trouvée pour ce projet.");
            }

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
}
