/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 *
 * @author user
 */
@Entity
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private Date dateDebut;
    private Date dateFin;
 @OneToOne
    @JoinColumn(name = "employe_id")
    private Employe chefDeProjet; // Link to Employe as 'Chef de projet'

    @OneToMany(mappedBy = "projet")
    private List<Tache> taches; // One project has many tasks

    public List<Tache> getTaches() {
        return taches;
    }

    public void setTaches(List<Tache> taches) {
        this.taches = taches;
    }

    public Projet(String nom, Date dateDebut, Date dateFin, Employe employe) {
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.chefDeProjet = employe;
    }

    public Employe getEmploye() {
        return chefDeProjet;
    }

    public void setEmploye(Employe employe) {
        this.chefDeProjet = employe;
    }

    public Projet() {
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

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
}

