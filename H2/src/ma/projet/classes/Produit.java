package ma.projet.classes;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "produit")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "reference", nullable = false)
    private String reference;

    @Column(name = "prix", nullable = false)
    private double prix;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;
    
    @ManyToOne
    @JoinColumn(name = "commande_id")
    private Commande commande;

    public Produit() {
    }

    public Produit(String reference, double prix, Categorie categorie) {
        this.reference = reference;
        this.prix = prix;
        this.categorie = categorie;
    }

    public Produit(String reference, float prix) {
        this.reference = reference;
        this.prix = prix;
    }

    // Getters and Setters
    // toString method for debugging

    public int getId() {
        return id;
    }

   

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
