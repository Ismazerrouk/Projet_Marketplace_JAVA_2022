package Model;


import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.util.*;

import static Model.Main.saisieChoix;


/**
 * 
 */
public class Livreur extends User {


    private String type_permis;
    //private String planig;
    private Date disponibilite;
    public ArrayList<Colis> listeColis = new ArrayList<>();
    private String idLivreur;
    /**
     * Default constructor
     */


    public Livreur(String username, String mdp) {
        super(username, mdp);
    }

    public Livreur(String username, String mdp, String idLivreur) {
        super(username, mdp);
        this.idLivreur = idLivreur;
    }



    public String getIdLivreur() {
        return idLivreur;
    }

    public void setIdLivreur(String idLivreur) {
        this.idLivreur = idLivreur;
    }

    public String getType_permis() {
        return type_permis;
    }

    public void setType_permis(String type_permis) {
        this.type_permis = type_permis;
    }

    public Date getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(Date disponibilite) {
        this.disponibilite = disponibilite;
    }

    public ArrayList<Colis> getListeColis() {
        return listeColis;
    }

    public void setListeColis(Colis c) {
        listeColis.add(c);
    }

    @Override
    public String toString() {
        return "Livreur{" +
                "type_permis='" + type_permis + '\'' +
                ", disponibilite=" + disponibilite +
                '}';
    }


    public void NotifierClient(){
        String saisie;
        int choix;
        System.out.println("Entrez 0 pour marquer un colis livré ou 1 pour un colis en cours de livraison");
        choix = saisieChoix(0,1);
        for (Colis c: listeColis ) {
            System.out.println("\n" + c);
        }
        if (choix == 1){
            saisie = Main.lireInfo("\nRentrez le colis que vous etes en train de livrer (entrez l'entier correspondant)");
            listeColis.get(Integer.parseInt(saisie)).setStatusColis(Status.En_livraison);}
        else{
            saisie = Main.lireInfo("\nRentrez le colis que vous venez de livrer (entrez l'entier correspondant)");
            listeColis.get(Integer.parseInt(saisie)).setStatusColis(Status.Livré);}
        }
    }


