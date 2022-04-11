package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Vendeur extends User {

	
	private String Type;
    private ArrayList<Produit> produitsVendeur = new ArrayList<>();

    public ArrayList<Produit> getProduitsVendeur() {
        return produitsVendeur;
    }

    public void setProduitsVendeur(ArrayList<Produit> produitsVendeur) {
        this.produitsVendeur = produitsVendeur;
    }

    public Vendeur(String username, String mdp, Boolean connected, String type) {
    	super(username,mdp, connected);
    	this.setType(type);
    }

   
	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}





    /**
     * 
     */
    public void AjouterProduit() { // méthode pour ajouter un nouveau produit à la marketplace
        String ref;
        String designation;
        Float prix;
        Float coutLivraison;

        System.out.println("\nEntrez la ref du produit : ");
        Scanner s = new Scanner(System.in);
        ref = s.nextLine();
        System.out.println("\nEntrez la désignation de votre nouveau produit : ");
        designation = s.nextLine();
        System.out.println("\nEntrez le prix de votre nouveau produit : ");
        prix = s.nextFloat();
        System.out.println("\nEntrez le prix de livraison de votre nouveau produit : ");
        coutLivraison = s.nextFloat();
        Produit produitAdded = new Produit(ref, designation,prix,coutLivraison);
        produitsVendeur.add(produitAdded);
        System.out.println(produitsVendeur);
        AjouterProduitBDD(produitAdded);

    }
    public void AjouterProduitBDD(Produit p) {  //ajoute le nouveau produit du Vendeur dans le fichier .csv
        String pathFile = "Base produits.csv";
        File file = new File(pathFile);
        try{
            System.out.println("File found");
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write(p.getRef()+ "," + p.getDescription() + "," + p.getPrix() + "," + p.getCoutLivraison());
            bw.newLine();
            bw.close();
            writer.close();
            System.out.println("Successfully wrote to the file.");

        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     */
    public void Modifier() {
        // TODO implement here

    }

    /**
     * 
     */
    public void Supprimer() {
        // TODO implement here
    }

    /**
     * 
     */
    public void SuivreVentes() {
        // TODO implement here
    }

    /**
     * 
     */
    public void SignerContrat() {
        // TODO implement here
    }

    /**
     * 
     */
    public void RenouvelerContrat() {
        // TODO implement here
    }

    /**
     * 
     */
    public void RésilierContrat() {
        // TODO implement here
    }






}