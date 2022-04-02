import java.util.ArrayList;

public class Vendeur extends User {
	
	private String Type;
    private ArrayList<ProduitExterne> produitExterneArrayList = new ArrayList<>();

    public Vendeur(String username, String mdp,Boolean connected, String type) {
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
    public void AjouterProduit() {
        // TODO implement here
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

	@Override
	public void Identification(String username, String mdp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void CreerCompte(String username, String mdp) {
		// TODO Auto-generated method stub
		
	}


}