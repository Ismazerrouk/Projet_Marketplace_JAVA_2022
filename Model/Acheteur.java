


public class Acheteur extends User {
	private Boolean abonne;
	
	



	public Boolean getAbonne() {
		return abonne;
	}


	public void setAbonne(Boolean abonne) {
		this.abonne = abonne;
	}


	public Acheteur(String username, String mdp, Boolean abonne) {
    	super(username, mdp);
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
	public void CreerCompte() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void Identification() {
		// TODO Auto-generated method stub
		
	}

}