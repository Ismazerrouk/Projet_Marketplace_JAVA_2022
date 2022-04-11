package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Produit {

	private String ref;
	private float prix;
	private String designation;
	private Boolean disponibilite;
	private String  delai;
	private float CoutLivraison;



	public float getPrix() {
		return prix;
	}


	public void setPrix(float prix) {
		this.prix = prix;
	}


	public String getDescription() {
		return designation;
	}


	public void setDescription(String description) {
		this.designation = description;
	}


	public Boolean getDisponibilite() {
		return disponibilite;
	}


	public void setDisponibilite(Boolean disponibilite) {
		this.disponibilite = disponibilite;
	}


	public String getDelai() {
		return delai;
	}


	public void setDelai(String date_livraison) {
		this.delai = date_livraison;
	}


	public Produit(String ref,String designation ,float prix, float coutLivraison) {
		this.ref = ref;
		this.prix = prix;
		this.designation = designation;
		CoutLivraison = coutLivraison;
	}

	@Override
	public String toString() {
		return "Produit{" +
				"ref='" + ref + '\'' +
				", prix=" + prix +
				", designation='" + designation + '\'' +
				", disponibilite=" + disponibilite +
				", delai='" + delai + '\'' +
				", CoutLivraison=" + CoutLivraison +
				'}';
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public float getCoutLivraison() {
		return CoutLivraison;
	}

	public void setCoutLivraison(float coutLivraison) {
		CoutLivraison = coutLivraison;
	}
}