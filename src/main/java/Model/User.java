package Model;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

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




	public static void Identification(String username, String mdp)  {
		// TODO Auto-generated method stub
		String pathFile = "connexion.csv";
		File file = new File(pathFile);
		try{
			BufferedReader br = new BufferedReader(new FileReader(pathFile));
			System.out.println("File found");
			String line = br.readLine();

			while(line != null){
				line = br.readLine();
				if(line.equals(username+","+mdp) ) {
					System.out.println("Authentication suceed");
					break;
				}

			}
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

    public static void CreerCompte(String username, String mdp) {
		// TODO Auto-generated method stub
		String pathFile = "connexion.csv";
		File file = new File(pathFile);
		try{
			System.out.println("File found");
			FileWriter writer = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(writer);
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

	}

}