/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;
import java.util.Date;
import javax.persistence.*;


/**
 *
 * @author user
 */
@Entity
@DiscriminatorValue("EmployeTache")
public class EmployeTache extends Tache{
    
private Date dateDebutReelle;
    private Date dateFinReelle;
    
    @ManyToOne
    @JoinColumn(name = "employe_id")
    private Employe employe;

//    @ManyToOne
//    @JoinColumn(name = "tache_id")
//    private Tache tache;


    public EmployeTache() {
    }

    public Date getDateDebutReelle() {
        return dateDebutReelle;
    }

    public void setDateDebutReelle(Date dateDebutReelle) {
        this.dateDebutReelle = dateDebutReelle;
    }

    public Date getDateFinReelle() {
        return dateFinReelle;
    }

    public void setDateFinReelle(Date dateFinReelle) {
        this.dateFinReelle = dateFinReelle;
    }

    

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

}
