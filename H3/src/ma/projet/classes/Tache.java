/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author user
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
@Table(name = "Tache")
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private Date dateDebutPrevue;
    private Date dateFinPrevue;
    private double prix;

 @ManyToOne
    @JoinColumn(name = "projet_id")
    private Projet projet; // Many tasks belong to one project

    @ManyToMany
    @JoinTable(
        name = "EmployeTache",
        joinColumns = @JoinColumn(name = "tache_id"),
        inverseJoinColumns = @JoinColumn(name = "employe_id")
    )
    private List<Employe> employes; // Many employees can work on many tasks
    // Getters, setters, and constructors

    public Tache() {
    }

    public Tache(String nom, Date dateDebutPrevue, Date dateFinPrevue, double prix, Projet projet) {
        this.nom = nom;
        this.dateDebutPrevue = dateDebutPrevue;
        this.dateFinPrevue = dateFinPrevue;
        this.prix = prix;
        this.projet = projet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateDebutPrevue() {
        return dateDebutPrevue;
    }

    public void setDateDebutPrevue(Date dateDebutPrevue) {
        this.dateDebutPrevue = dateDebutPrevue;
    }

    public Date getDateFinPrevue() {
        return dateFinPrevue;
    }

    public void setDateFinPrevue(Date dateFinPrevue) {
        this.dateFinPrevue = dateFinPrevue;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }
}
