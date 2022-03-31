
import java.util.*;

/**
 * 
 */
public class Employé extends User {

    private String Nom;
    private String Prenom;
    private String adresse;

    /**
     * Default constructor
     */
    public Employé(String username, String mdp, String nom, String prenom, String adresse) {
        super(username, mdp);
        Nom = nom;
        Prenom = prenom;
        this.adresse = adresse;
    }

    @Override
    public void Identification() {

    }

    @Override
    public void CreerCompte() {

    }
}