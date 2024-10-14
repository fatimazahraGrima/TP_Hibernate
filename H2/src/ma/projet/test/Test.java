/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import ma.projet.classes.*;
import ma.projet.service.*;
/**
 *
 * @author user
 */
public class Test {
    public static void main(String[] args) {
        ProduitService produitService = new ProduitService();
        CategorieService categorieService = new CategorieService();
        CommandeService commandeService = new CommandeService();

        
        Categorie cat1 = new Categorie("CODE_1", "Categorie_1");
        Categorie cat2 = new Categorie("CODE_2", "Categorie_2");
         categorieService.create(cat1);  // Ajouter une méthode pour sauvegarder les catégories
        categorieService.create(cat2);
        // Créer et récupérer des produits
        Produit produit1 = new Produit("ES12", 120.0, cat1);
Produit produit2 = new Produit("ZR85", 100.0, cat2);
Produit produit3 = new Produit("EE85", 200.0, cat1);
   produitService.create(produit1);
        produitService.create(produit2);
        produitService.create(produit3);
 List<Produit> produits = Arrays.asList(produit1, produit2);
        List<Integer> quantites = Arrays.asList(2, 3); // Quantités correspondantes pour chaque produit

        commandeService.creerCommande(produits, quantites);

        // Afficher les produits par catégorie
        List<Produit> produitsCategorie = produitService.getProduitsByCategorie(1);
        for (Produit p : produitsCategorie) {
            System.out.println(p.getReference());
        }

        // Afficher les produits avec prix > 100 DH
        List<Produit> produitsExpensifs = produitService.getByPriceGreaterThan(100);
        for (Produit p : produitsExpensifs) {
            System.out.println(p.getReference() + " " + p.getPrix());
        }
        
        try {
            // Définir les deux dates
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = sdf.parse("2024-01-01");
            Date endDate = sdf.parse("2024-12-31");

            // Récupérer et afficher les produits commandés entre ces deux dates
            List<Produit> produitsCommandes = produitService.findBetweenDates(startDate, endDate);
            for (Produit produit : produitsCommandes) {
                System.out.println(produit.getReference() + " - " + produit.getPrix());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
