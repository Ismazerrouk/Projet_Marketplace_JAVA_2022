package Model;

import java.util.*;

public class Panier {
    private float Prix_Total;
    private String Mode_de_livraison;
    private Acheteur acheteur;
    private List<Produit> produitList = new ArrayList<>();


    public Panier(float prix_Total, String mode_de_livraison, Acheteur acheteur, List<Produit> produitList) {
        Prix_Total = prix_Total;
        Mode_de_livraison = mode_de_livraison;
        this.acheteur = acheteur;
        this.produitList = produitList;
    }

    @Override
    public String toString() {
        return "Panier{" +
                "Prix_Total=" + Prix_Total +
                ", Mode_de_livraison='" + Mode_de_livraison + '\'' +
                ", acheteur=" + acheteur +
                ", produitList=" + produitList +
                '}';
    }

    public List<Produit> getProduitList() {
        return produitList;
    }

    public void setProduitList(List<Produit> produitList) {
        this.produitList = produitList;
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