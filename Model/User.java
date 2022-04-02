

public abstract class User {

	private String username;
	private String mdp;
	private Boolean connected;
    
    public User(String username, String mdp, Boolean connected) {
		this.username = username;
		this.mdp = mdp;
		this.connected = connected;
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




	public abstract void Identification(String username, String mdp);
    
    public abstract void CreerCompte(String username, String mdp);
    	
    

}