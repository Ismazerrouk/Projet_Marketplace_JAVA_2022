package Model;

import java.time.LocalDate;
import java.util.*;

/**
 * 
 */
public class Contrat {
    private LocalDate dateDebut;
    private Date dateFin;
    private float commission;
    private Vendeur vendeur;


    public Vendeur getV() {
        return vendeur;
    }

    public void setV(Vendeur v) {
        this.vendeur = v;
    }

    public Contrat() {
    }

    @Override
    public String toString() {
        return "Contrat{" +
                "dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", commission=" + commission +
                '}';
    }

    public float getCommission() {
        return commission;
    }

    public void setCommission(float commission) {
        this.commission = commission;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Vendeur getVendeur() {
        return vendeur;
    }

    public void setVendeur(Vendeur vendeur) {
        this.vendeur = vendeur;
    }

    public Contrat(LocalDate dateDebut, Date dateFin, float commission, Vendeur vendeur) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.commission = commission;
        this.vendeur = vendeur;
    }
}