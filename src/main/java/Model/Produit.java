package Model;

public class Produit {

	private String ref;
	private float prix;
	private String designation;
	private Boolean disponibilite;
	private String  delai;
	private float CoutLivraison;
	private String IdVendeur;

	public Produit(String ref, String designation, Float prix, Float coutLivraison, String idVendeur) {
		this.ref = ref;
		this.prix = prix;
		this.designation = designation;
		CoutLivraison = coutLivraison;
		this.IdVendeur = idVendeur;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getIdVendeur() {
		return IdVendeur;
	}

	public void setIdVendeur(String idVendeur) {
		IdVendeur = getIdVendeur();
	}

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


	public Produit(String ref, String designation, float prix, float coutLivraison) {
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
				", ID du Vendeur=" + IdVendeur +
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