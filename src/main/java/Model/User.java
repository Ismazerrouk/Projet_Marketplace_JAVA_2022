package Model;



import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public abstract class User {

	private String username;
	private String mdp;
	private Boolean connected;
	private int ID;

    
    public User(String username, String mdp, Boolean connected) {
		this.username = username;
		this.mdp = mdp;
		this.connected = connected;
	}

	public User(String username, String mdp) {
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

	public int getID() {
		return ID;
	}

	public void setID() {
		String csvFile = "connexion.csv";
		String line = "";
		String cvsSplitBy = ",";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((line = br.readLine()) != null) {
				ID = ID + 1;

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

		public static Boolean Identification(String username, String mdp, String type)  {
		// TODO Auto-generated method stub
		String pathFile = "connexion.csv";
		File file = new File(pathFile);
		try{
			BufferedReader br = new BufferedReader(new FileReader(pathFile));
			System.out.println("File found");
			String line = br.readLine();

			while(line != null){
				line = br.readLine();
				if(line.equals(username+","+mdp+','+type)) {
					System.out.println("Authentication suceed");
					return true;
				}

			}
			return false;
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}



    }

    public static void CreerCompte(String username, String mdp, String type) {
		// TODO Auto-generated method stub
		String pathFile = "connexion.csv";
		File file = new File(pathFile);
		try{
			System.out.println("File found");
			FileWriter writer = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(writer);
			bw.write(username + ',' + mdp + ',' + type);
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