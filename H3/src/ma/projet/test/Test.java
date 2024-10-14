/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import ma.projet.classes.Employe;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.service.EmployeService;
import ma.projet.service.ProjetService;
import ma.projet.service.TacheService;

/**
 *
 * @author user
 */

       public class Test {
    
    public static void main(String[] args) {
        ProjetService projetService = new ProjetService();
        TacheService tacheService = new TacheService();
        EmployeService employeService = new EmployeService();
//        Calendar calendar = Calendar.getInstance();
//
//        Employe employe1= new Employe("fati", "alami", "45678");
//        Employe employe2= new Employe("SIMO", "RAKI", "868679");
//        Employe employe3= new Employe("AMAL", "ALI", "458742");
//        Employe employe4= new Employe("SALMA", "ALAOUI", "868679");
////        employeService.create(employe2);
////        employeService.create(employe1);
////        employeService.create(employe3);
////        employeService.create(employe4);
//
//        // Création du projet 1
//        Projet projet = new Projet();
//        projet.setNom("Gestion de stock");
//        calendar.set(2023, Calendar.JANUARY, 14);
//        Date dateDebutProjet = calendar.getTime();
//        projet.setDateDebut(dateDebutProjet); 
//
//        calendar.set(2023, Calendar.JUNE, 18);
//        Date dateFinProjet = calendar.getTime();
//        projet.setDateFin(dateFinProjet); 
//        projet.setEmploye(employe1);
//        //projetService.create(projet);  // Persister le projet
//
//        // Création du projet 2
//        calendar.set(2023, Calendar.JANUARY, 14);
//        Date dateDebutProjet2 = calendar.getTime();
//
//        calendar.set(2023, Calendar.JUNE, 18);
//        Date dateFinProjet2 = calendar.getTime();
//        Projet projet2 = new Projet("Gestion de commande", dateDebutProjet2, dateFinProjet2, employe2);

        ///projetService.create(projet2);  // Persister projet2 avant de l'utiliser

        // Création des tâches liées au projet 1
//        Tache tache = new Tache();
//        tache.setNom("Conception");
//        calendar.set(2024, Calendar.MAY, 03);
//        Date dateDebutPrevue = calendar.getTime();
//        tache.setDateDebutPrevue(dateDebutPrevue); 
//        calendar.set(2024, Calendar.MAY, 20);
//        Date dateFinPrevue = calendar.getTime();
//        tache.setDateFinPrevue(dateFinPrevue); 
//        tache.setPrix(1200);
//        tache.setProjet(projet);  // Associer la tâche au projet déjà persisté
        //tacheService.create(tache);

        // Création des tâches liées au projet 2
//        Tache tache2 = new Tache("Analyse", dateDebutProjet, dateFinProjet2, 280, projet2);
//        //tacheService.create(tache2);
//
//        Tache tache3 = new Tache("Analyse", dateDebutProjet, dateFinProjet2, 3200, projet);
//        Tache tache4 = new Tache("Developpement", dateDebutProjet2, dateFinProjet2, 500, projet2);
        //tacheService.create(tache3);
        //tacheService.create(tache4);
        
        
        
        // Affichage des tâches
        List<Tache> allTaches = tacheService.getAll();
        allTaches.forEach(t -> System.out.println("Tache: " + t.getNom()));
        
        // Affichage des projets par employes
        
        List<Projet> projetsByEmploye = employeService.getProjetsByEmploye(9);
        System.out.println("Projets de l'employé: ");
        for (Projet p : projetsByEmploye) {
            System.out.println("Projet: " + p.getNom());
        }
        
// Test de récupération des tâches par projet
        List<Tache> tachesByProjet = projetService.getTachesByProjet(5);
        System.out.println("Tâches du projet: ");
        for (Tache tache : tachesByProjet) {
            System.out.println("Tâche: " + tache.getNom());
        }
        // Test affichage des tâches réalisées pour le projet avec ID 4
        projetService.displayTachesByProjet(6);

        // Affichage des tâches au-dessus de 1000 DH
        List<Tache> tachesAbovePrice = tacheService.getTachesAbovePrice(1000);
        tachesAbovePrice.forEach(t -> System.out.println("Expensive Tache: " + t.getNom()));
    }
}

