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
    public Employé(String username, String mdp,Boolean connected, String nom, String prenom, String adresse) {
        super(username, mdp, connected);
        Nom = nom;
        Prenom = prenom;
        this.adresse = adresse;
    }



}