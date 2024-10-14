/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.H1.test;
import ma.H1.beans.Produit;
import ma.H1.services.ProduitService;

import java.util.Date;
import java.util.List;
/**
 *
 * @author user
 */
public class Test {
    
    public static void main(String[] args) {
        ProduitService produitService = new ProduitService();

        // Créer 5 produits
        Produit p1 = new Produit("Marque1", "Ref1", new Date(), 120.0, "Produit1");
        Produit p2 = new Produit("Marque2", "Ref2", new Date(), 150.0, "Produit2");
        Produit p3 = new Produit("Marque3", "Ref3", new Date(), 80.0, "Produit3");
        Produit p4 = new Produit("Marque4", "Ref4", new Date(), 200.0, "Produit4");
        Produit p5 = new Produit("Marque5", "Ref5", new Date(), 300.0, "Produit5");

        produitService.create(p1);
        produitService.create(p2);
        produitService.create(p3);
        produitService.create(p4);
        produitService.create(p5);

        // Afficher tous les produits
        List<Produit> produits = produitService.findAll();
        produits.forEach(System.out::println);

        // Afficher le produit avec id=2
        Produit produit = produitService.findById(2);
        System.out.println("Produit avec id=2 : " + produit);

        // Supprimer le produit avec id=3
        produitService.delete(produitService.findById(18));

        // Modifier les informations du produit avec id=1
        Produit produit1 = produitService.findById(20);
        produit1.setPrix(1000.0);
        produitService.update(produit1);

        // Afficher les produits dont le prix est supérieur à 100 DH
        produits = produitService.findAll();
        produits.stream()
                .filter(p -> p.getPrix() > 100)
                .forEach(System.out::println);

        // Afficher les produits commandés entre deux dates
        // Vous pouvez utiliser un Scanner pour saisir les dates
    }
}

