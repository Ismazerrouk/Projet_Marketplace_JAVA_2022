import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Acheteur extends User {

	private Boolean abonne;

    private final ArrayList<Produit> liste_P = new ArrayList<>();


    public ArrayList<Produit> getListe_P() {
        return liste_P;
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

	
    public void SuivreColis() {
        // TODO implement here
    }

    /**
     * 
     */
    public void RetournerColis() {
        // TODO implement here
    }

    /**
     * 
     */
    public void AjouterPanier() {
        // TODO implement here
    }

    /**
     * 
     */
    public void ValiderPanier() {
        // TODO implement here
    }

    /**
     * 
     */
    public void SouscrireAbonnement() {
        // TODO implement here
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

    /**
     * 
     */
    public void Operation1() {
        // TODO implement here
    }

    /**
     * 
     */
    public void RetournerCommande() {
        // TODO implement here
    }


	@Override
	public void CreerCompte(String username, String mdp, Boolean abonne) {
            // TODO Auto-generated method stub
        String pathFile = "connexion.csv";
        try{
            BufferedReader br = new BufferedReader(new FileReader(pathFile));
            System.out.println("File found");

        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }

	}


	@Override
	public static void Identification() {
        // TODO Auto-generated method stub


    }

}