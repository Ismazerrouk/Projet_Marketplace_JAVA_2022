package Model;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Vendeur extends User {

    private static String idVendeur;
    private static Boolean SousContrat = false;
    private static Contrat contrat;

    @Override
    public String toString() {
        return "Vendeur{" +
                "idVendeur='" + idVendeur + '\'' +
                ", contrat=" + contrat +
                ", produitsVendeur=" + produitsVendeur +
                '}';
    }

    public Boolean getSousContrat() {
        return SousContrat;
    }

    public static void setSousContrat(Boolean sousContrat) {
        SousContrat = sousContrat;
    }

    public static String getIdVendeur() {
        return idVendeur;
    }

    public void setIdVendeur(String idVendeur) {
        this.idVendeur = idVendeur;
    }

    private String Type;
    private ArrayList<Produit> produitsVendeur = new ArrayList<>();

    public ArrayList<Produit> getProduitsVendeur() {
        return produitsVendeur;
    }

  /*  public void setProduitsVendeur(Produit p) {
        String pathFile = "Base produits.csv";
        File file = new File(pathFile);
        try{
            BufferedReader br = new BufferedReader(new FileReader(pathFile));
            System.out.println("File found");
            String line = br.readLine();

            while(line != null){
                if (line.contains(idVendeur) ) {
                    produitsVendeur.add(p);
                    line = br.readLine();
                }  //si la ligne ne contient pas l'id du Vendeur on continue
                else{ // sinon
                      line = br.readLine();   //on l'ajoute à la liste des produits de ce Vendeur
                }

            }
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }

    }*/
    public void recupProduitVendeurBDD(ArrayList produitsP){ //Recupère les produits du csv contenant l'id du vendeur
        String csvFile = "Base produits.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                if (line.contains(idVendeur)) {
                    String[] splitted = line.split(cvsSplitBy);
                    produitsVendeur.add(new Produit(splitted[0], splitted[1], Float.valueOf(splitted[2]), Float.valueOf(splitted[3]), splitted[4]));
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public Vendeur(String username, String mdp, Boolean connected, String type,String idVendeur) {
    	super(username,mdp, connected);
    	this.setType(type);
    	this.idVendeur = idVendeur;
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
    public void AjouterProduit() { // méthode pour ajouter un nouveau produit à la marketplace et à la liste de produits du vendeur
        String ref;
        String designation;
        Float prix;
        Float coutLivraison;
        if (SousContrat == true) {
            System.out.println("\nEntrez la ref du produit : ");
            Scanner s = new Scanner(System.in);
            ref = s.nextLine();
            System.out.println("\nEntrez la désignation de votre nouveau produit : ");
            designation = s.nextLine();
            System.out.println("\nEntrez le prix de votre nouveau produit : ");
            prix = s.nextFloat();
            System.out.println("\nEntrez le prix de livraison de votre nouveau produit : ");
            coutLivraison = s.nextFloat();
            Produit produitAdded = new Produit(ref, designation, prix, coutLivraison, idVendeur);
            recupProduitVendeurBDD(produitsVendeur);
            produitsVendeur.add(produitAdded);
            System.out.println(produitsVendeur);
            AjouterProduitBDD(produitAdded);
        }

        else{
            System.out.println("\nVeuillez signer un contrat avec la marketplace pour pouvoir ajouter des produits !\n");

        }
    }
    public void AjouterProduitBDD(Produit p) {  //ajoute le nouveau produit du Vendeur dans le fichier .csv
        String pathFile = "Base produits.csv";
        File file = new File(pathFile);
        try{
            System.out.println("File found");
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write(p.getRef()+ "," + p.getDescription() + "," + p.getPrix() + "," + p.getCoutLivraison() + "," + p.getIdVendeur());
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
        if (SousContrat == false) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate localDate = LocalDate.now();
            //System.out.println(dtf.format(localDate));
            float commission;
            Scanner s = new Scanner(System.in);
            System.out.println("\nEntrez le montant de votre comission produit : ");
            commission = s.nextFloat();

            // TODO implement here
            contrat = new Contrat();
            contrat.setVendeur(this);
            contrat.setDateDebut(localDate);
            contrat.setCommission(commission);
            MarketplaceAdmin.setListeVendeurContrat(this);
        }
        else{
            System.out.println("\nVous avez deja un contrat avec la marketplace");
        }
          //contrat.setDateDebut();



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