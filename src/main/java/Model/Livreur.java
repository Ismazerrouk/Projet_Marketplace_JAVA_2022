package Model;

import java.util.*;

/**
 * 
 */
public class Livreur extends Employé {
    private String type_permis;
    //private String planig;
    private Date disponibilite;
    /**
     * Default constructor
     */
    public Livreur(String username, String mdp, Boolean connected, String nom, String prenom, String adresse, String type_permis, Date disponibilite) {
        super(username, mdp, connected, nom, prenom, adresse);
        this.type_permis = type_permis;
        this.disponibilite = disponibilite;
    }
}