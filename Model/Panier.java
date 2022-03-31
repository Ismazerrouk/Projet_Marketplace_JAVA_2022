
import java.util.*;

public class Panier {
    private float Prix_Total;
    private String Mode_de_livraison;
    private Acheteur acheteur;


    public Panier(float prix_Total, String mode_de_livraison, Acheteur acheteur) {
        Prix_Total = prix_Total;
        Mode_de_livraison = mode_de_livraison;
        this.acheteur = acheteur;
    }

    /**
     * Default constructor
     */


    public float getPrix_Total() {
        return Prix_Total;
    }

    public void setPrix_Total(float prix_Total) {
        Prix_Total = prix_Total;
    }

    public String getMode_de_livraison() {
        return Mode_de_livraison;
    }

    public void setMode_de_livraison(String mode_de_livraison) {
        Mode_de_livraison = mode_de_livraison;
    }
}