package Model;

import java.time.LocalDate;
import java.util.*;

/**
 * 
 */
public class Colis {
    public Status statusColis;
    private int numero;
    private float taille;
    private float poids;
    private String adresse_livraison;
    private LocalDate date_livraison;
    private String mode_livraison;
    private Livreur livreur;

    /**
     * Default constructor
     */
    public Colis(int numero, float taille, float poids, String adresse_livraison, LocalDate date_livraison, String mode_livraison) {
        this.numero = numero;
        this.taille = taille;
        this.poids = poids;
        this.adresse_livraison = adresse_livraison;
        this.date_livraison = date_livraison;
        this.mode_livraison = mode_livraison;
    }



    public Colis(int numero, String adresse_livraison, LocalDate date_livraison, Livreur livreur) {
        this.numero = numero;
        this.adresse_livraison = adresse_livraison;
        this.date_livraison = date_livraison;
        this.livreur = livreur;
    }

    public Status getStatusColis() {
        return statusColis;
    }

    public void setStatusColis(Status statusColis) {
        this.statusColis = statusColis;
    }

    public Livreur getLivreur() {
        return livreur;
    }

    public void setLivreur(Livreur livreur) {
        this.livreur = livreur;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getTaille() {
        return taille;
    }

    public void setTaille(float taille) {
        this.taille = taille;
    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public String getAdresse_livraison() {
        return adresse_livraison;
    }

    public void setAdresse_livraison(String adresse_livraison) {
        this.adresse_livraison = adresse_livraison;
    }

    public LocalDate getDate_livraison() {
        return date_livraison;
    }

    public void setDate_livraison(LocalDate date_livraison) {
        this.date_livraison = date_livraison;
    }

    public String getMode_livraison() {
        return mode_livraison;
    }

    public void setMode_livraison(String mode_livraison) {
        this.mode_livraison = mode_livraison;
    }

    @Override
    public String toString() {
        return "Colis{" +
                "numero=" + numero +
                ", taille=" + taille +
                ", poids=" + poids +
                ", adresse_livraison='" + adresse_livraison + '\'' +
                ", date_livraison=" + date_livraison +
                ", mode_livraison='" + mode_livraison + '\'' +
                ", livreur=" + livreur +
                '}';
    }
}