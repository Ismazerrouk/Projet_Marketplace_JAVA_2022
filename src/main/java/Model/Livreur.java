package Model;


import java.util.*;

/**
 * 
 */
public class Livreur extends User {
    private String type_permis;
    //private String planig;
    private Date disponibilite;
    private static ArrayList<Colis> listeColis = new ArrayList<>();
    /**
     * Default constructor
     */


    public Livreur(String username, String mdp) {
        super(username, mdp);
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

    public static ArrayList<Colis> getListeColis() {
        return listeColis;
    }

    public static void setListeColis(Colis c) {
        listeColis.add(c);
    }

    @Override
    public String toString() {
        return "Livreur{" +
                "type_permis='" + type_permis + '\'' +
                ", disponibilite=" + disponibilite +
                '}';
    }
}