package Model;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Acheteur extends User {


	private Boolean abonne;
    private Panier panier;
    private int NumeroCommande;
    private static String adresseLivraison;

    private ArrayList<Commande> listeCommandes = new ArrayList<>();
    private final ArrayList<Produit> liste_P = new ArrayList<>();


    static String getAdresseLivraison() {
        return adresseLivraison;
    }

    public void setAdresseLivraison(String adresseLivraison) {
        this.adresseLivraison = adresseLivraison;
    }

    public ArrayList<Commande> getListeCommandes() {
        return listeCommandes;
    }

    public void setListeCommandes(ArrayList<Commande> listeCommandes) {
        this.listeCommandes = listeCommandes;
    }

    public int getNumeroCommande() {
        return NumeroCommande;
    }

    public void setNumeroCommande(int numeroCommande) {
        NumeroCommande = numeroCommande;
    }

    public ArrayList<Produit> getListe_P() {
        return liste_P;
    }
    public void setProduitList(Produit p) {
        liste_P.add(p);
    }

    public Boolean getAbonne() {
		return abonne;
	}


	public void setAbonne(Boolean abonne) {
		this.abonne = abonne;
	}


	public Acheteur(String username, String mdp,Boolean connected, Boolean abonne) {
    	super(username, mdp, connected);
    	this.abonne = abonne;
    }

    @Override
    public String toString() {
        String s = "Acheteur{" +
                "abonne=" + abonne +
                ", liste_P=" + liste_P +
                //", panier = " + panier.toString() +
                '}';
        return s;
    }

    public void SuivreColis() {
        // TODO implement here
    }


    public void AjouterPanier() {
        // TODO implement here
        Produit produit;
        float coutTot = 0;

        if (this.abonne == false) {
            for (int i = 0; i < liste_P.size(); i++) {
                produit = liste_P.get(i);
                coutTot = coutTot + produit.getPrix() + produit.getCoutLivraison();
            }
            this.setPanier( new Panier(coutTot, "", this, getListe_P()));
            }
         else {
            for (int i = 0; i < liste_P.size(); i++) {
                produit = liste_P.get(i);
                coutTot = coutTot + produit.getPrix() ;
            }
            this.setPanier(new Panier(coutTot, "", this, getListe_P()));
        }
    }

    /**
     * 
     */
    public void ValiderPanier() {
        // TODO implement here

        System.out.println("Nous allons valider votre panier et creer une commande...");
        /*ThreadLocalRandom tlr = ThreadLocalRandom.current();
        setNumeroCommande(tlr.nextInt(1,1000));*/
        setNumeroCommande(getID() + listeCommandes.size());
        Commande c = new Commande(panier.getPrix_Total(), liste_P, NumeroCommande);
        boolean matchFound;
        String adresse;
        do {
            Scanner s = new Scanner(System.in);
            System.out.println("Saissisez votre adresse de livraison : ");
            adresse = s.nextLine();
            Pattern pattern = Pattern.compile("[0-9]{1,3}(?:(?:[,. ]){1}[-a-zA-Zàâäéèêëïîôöùûüç]+)*", Pattern.CASE_INSENSITIVE); //regex pour une adresse3
            Matcher matcher = pattern.matcher(adresse);
            matchFound = matcher.find();

        } while (!matchFound);

        setAdresseLivraison(adresse);
        listeCommandes.add(c);
        MarketplaceAdmin.setListeCommande(c);    //on ajoute la commande à la liste des commandes à expedier par la marketplace
    }


    /**
     * 
     */
    public void SouscrireAbonnement() {
        // TODO implement here
        setAbonne(true);
    }

    /**
     * 
     */
    public void ChoisirLivraison() {
        // TODO implement here
    }

    /**
     * 
     */
    public void definirCritere() {
        // TODO implement here
    }

    /**
     * 
     */
    public void ComparerPrix() {
        // TODO implement here
    }




    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }


    /*public void CreerCompte(String username, String mdp) {
            // TODO Auto-generated method stub
        String pathFile = "connexion.csv";
        File file = new File(pathFile);
        try{
            System.out.println("File found");
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.newLine();
            bw.write(username + ',' + mdp);
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

    }*/



}