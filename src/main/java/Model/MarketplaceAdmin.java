package Model;

import com.sun.deploy.net.MessageHeader;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import static Model.Main.saisieChoix;

public class MarketplaceAdmin extends User {


    private static ArrayList<Commande> listeCommande = new ArrayList<>();
    private ArrayList<Produit> catalogueMarketPlace = new ArrayList<Produit>();
    public static ArrayList<Vendeur> ListeVendeur = new ArrayList<>();
    private static ArrayList<Vendeur> ListeVendeurContrat = new ArrayList<>();
    public static ArrayList<Livreur> ListeLivreur = new ArrayList<>();
    public static ArrayList<Acheteur> ListeAcheteur =new ArrayList<>();
	
    public MarketplaceAdmin(String username, String mdp, Boolean connected) {
    	super(username,mdp,connected);
    }


    public ArrayList<Vendeur> getListeVendeur() {
        return ListeVendeur;
    }

    public void setListeVendeur(ArrayList<Vendeur> listeVendeur) {
        ListeVendeur = listeVendeur;
    }

    public static ArrayList<Livreur> getListeLivreur() {
        return ListeLivreur;
    }

    public static void setListeLivreur(Livreur l) {
        ListeLivreur.add(l);
    }

    public static ArrayList<Vendeur> getListeVendeurContrat() {
        return ListeVendeurContrat;
    }

    public static void setListeVendeurContrat(Vendeur vendeur) {
        ListeVendeurContrat.add(vendeur);
    }

    public ArrayList<Commande> getListeCommande() {
        return listeCommande;
    }

    static void setListeCommande(Commande c) {
        listeCommande.add(c);
    }

    public ArrayList<Produit> getCatalogueMarketPlace() {
        return catalogueMarketPlace;
    }

    public void setCatalogueMarketPlace(ArrayList<Produit> catalogueMarketPlace) {
        this.catalogueMarketPlace = catalogueMarketPlace;
    }

    /**
     * 
     */

    public void ChiffreAffaire() {
        float chiffreAffaire = 0;

        for (int i=0; i<getListeCommande().size();i++){
            Commande commande = getListeCommande().get(i);
            chiffreAffaire += commande.getPrixCommande();
        }
        System.out.println("Votre chiffre d'affaires est de " + chiffreAffaire);

    }

    public void recupProduitMarketplaceBDD(ArrayList produitsP){ //Recupère les produits du csv contenant l'id "marketplace"
        String csvFile = "Base produits.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                if (line.contains("marketplace")) {
                    String[] splitted = line.split(cvsSplitBy);
                    catalogueMarketPlace.add(new Produit(splitted[0], splitted[1], Float.valueOf(splitted[2]), Float.valueOf(splitted[3]), splitted[4]));
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void AjouterProduit() { // méthode pour ajouter un nouveau produit à la marketplace et à la liste de produits du vendeur
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
        recupProduitMarketplaceBDD(catalogueMarketPlace);
        catalogueMarketPlace.add(produitAdded);
        System.out.println(catalogueMarketPlace);
        AjouterProduitBDD(produitAdded);

    }
    public void AjouterProduitBDD(Produit p) {  //ajoute le nouveau produit du Vendeur dans le fichier .csv
        String pathFile = "Base produits.csv";
        File file = new File(pathFile);
        try{
            System.out.println("File found");
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write(p.getRef()+ "," + p.getDescription() + "," + p.getPrix() + "," + p.getCoutLivraison() + ", marketplace,");
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
    public void AjouterVendeur() {

        System.out.println("\nVoici la liste des Vendeurs voulant signer un contrat : " + getListeVendeurContrat());

        System.out.println("\nEntrez le vendeur que vous voulez signer (entrez l'entier correspondant) : ");
        int choixVendeur  = saisieChoix(0, getListeVendeurContrat().size());

        getListeVendeurContrat().get(choixVendeur).setSousContrat(true);


    }


    public void ExpedierCommande() {
        if (!(null == ListeLivreur)) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate localDate = LocalDate.now();
            System.out.println("\nVoici les commandes à expédier : " + getListeCommande());

            System.out.println("\nEntrez la commande que vous voulez expédier (entrez l'entier correspondant) : ");
            int choixCommande = saisieChoix(0, getListeCommande().size());

            System.out.println("\nVoici la liste des livreurs inscrits : " + getListeLivreur());

            System.out.println("\nEntrez le livreur que vous voulez pour expédier le colis de cette commande (entrez l'entier correspondant) : ");
            int choixLivreur = saisieChoix(0, getListeLivreur().size());
            Colis colis = new Colis(getListeCommande().get(choixCommande).getNuméro(), getListeCommande().get(choixCommande).getAcheteur().getAdresseLivraison(), localDate, getListeLivreur().get(choixLivreur));
            getListeLivreur().get(choixLivreur).setListeColis(colis);           // on ajoute le colis au livreur choisi par l'admin
            System.out.println(getListeLivreur().get(choixLivreur).getListeColis());

            System.out.println("\nLa colis de cette commande va être pris en charge par votre livreur, il est notifié.");
            colis.setStatusColis(Status.En_attente);
            getListeCommande().get(choixCommande).getAcheteur().setListeColis(colis); //ajoute le colis à la liste de colis de l'acheteur

        }
        else {
            System.out.println("\nVous n'avez pas de livreur encore inscrit !");
        }
        }
     /*   Colis colis;
        colis = new colis(getID(), Acheteur.getAdresseLivraison(), );*/
    }














