package Model;

import java.util.ArrayList;

public class Commande {
    private float PrixCommande;
    private ArrayList<Produit> listeProduits = new ArrayList<>();
    private int numéro;
    private Acheteur acheteur;

    public Commande(float prixCommande, ArrayList<Produit> listeProduits, int numéro) {
        PrixCommande = prixCommande;
        this.listeProduits = listeProduits;
        this.numéro = numéro;
    }

    public Commande(float prixCommande, ArrayList<Produit> listeProduits, int numéro, Acheteur acheteur) {
        PrixCommande = prixCommande;
        this.listeProduits = listeProduits;
        this.numéro = numéro;
        this.acheteur = acheteur;
    }

    public Acheteur getAcheteur() {
        return acheteur;
    }

    public void setAcheteur(Acheteur acheteur) {
        this.acheteur = acheteur;
    }

    public float getPrixCommande() {
        return PrixCommande;
    }

    public void setPrixCommande(float prixCommande) {
        PrixCommande = prixCommande;
    }

    public ArrayList<Produit> getListeProduits() {
        return listeProduits;
    }

    public void setListeProduits(ArrayList<Produit> listeProduits) {
        this.listeProduits = listeProduits;
    }

    public int getNuméro() {
        return numéro;
    }

    public void setNuméro(int numéro) {
        this.numéro = numéro;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "listeProduits=" + listeProduits +
                ", numéro='" + numéro + '\'' +
                ", prix de la commande=" + PrixCommande +
                "acheteur=" + acheteur +
                '}';
    }
}
