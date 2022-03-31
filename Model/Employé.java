
import java.util.*;

/**
 * 
 */
public class Employé extends User {

    /**
     * Default constructor
     */
    public Employé() {
    }

    /**
     * 
     */
    public String Nom;

    /**
     * 
     */
    public String Prénom;

    /**
     * 
     */
    public String Adresse;

    /**
     * 
     */
    public User possède;

    /**
     * 
     */
    public Set<PrestataireServiceLivraison> embauche;

}