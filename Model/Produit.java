import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Produit {
	
	private String nom;
	private int prix;
	private String description;
	private Boolean disponibilite;
	private String  date_livraison;
	
	
    public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getPrix() {
		return prix;
	}


	public void setPrix(int prix) {
		this.prix = prix;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Boolean getDisponibilite() {
		return disponibilite;
	}


	public void setDisponibilite(Boolean disponibilite) {
		this.disponibilite = disponibilite;
	}


	public String getDate_livraison() {
		return date_livraison;
	}


	public void setDate_livraison(String date_livraison) {
		this.date_livraison = date_livraison;
	}



	public Produit(String nom, int prix, String description, Boolean disponibilite, String date_livraison) {
		this.nom = nom;
		this.prix = prix;
		this.description = description;
		this.disponibilite = disponibilite;
		this.date_livraison = date_livraison;
	}










}