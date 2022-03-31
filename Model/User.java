

public abstract class User {

	private String username;
	private String mdp;
    
    public User(String username, String mdp) {
		super();
		this.username = username;
		this.mdp = mdp;
	}
    
 


    public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getMdp() {
		return mdp;
	}




	public void setMdp(String mdp) {
		this.mdp = mdp;
	}




	public abstract void Identification();
    
    public abstract void CreerCompte();
    	
    

}