package model;

import javax.persistence.*;
import javax.persistence.GenerationType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrateur on 04/03/2015.
 */

@Entity
public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titre;
    @Temporal(TemporalType.DATE)
    private Date dateLivraison;
    @ManyToMany(mappedBy="projets",cascade = CascadeType.ALL)
    private List<Employee> equip;

    public Projet(String titre, Date dateLivraison) {
        this.titre = titre;
        this.dateLivraison = dateLivraison;
        equip = new ArrayList<Employee>();
    }

    public Projet() {
        equip = new ArrayList<Employee>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public List<Employee> getEquip() {
        return equip;
    }

    public void setEquip(List<Employee> equip) {
        this.equip = equip;
    }

    @Override
    public String toString() {
        return "Projet{" +
                "titre='" + titre + '\'' +
                ", dateLivraison=" + dateLivraison +
                '}';
    }
}
