
public class Vendeur extends User {
	
	private String Type;
    /**
     * Default constructor
     */
    public Vendeur(String username, String mdp, String type) {
    	super(username,mdp);
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
	public void Identification() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void CreerCompte() {
		// TODO Auto-generated method stub
		
	}


}