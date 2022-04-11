package Model;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;
import sun.awt.geom.AreaOp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.security.cert.Certificate;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedMap;

public class Main {

    public static void main(String[] args){
        int choix = -1; //choix du menu


        try{

            while(choix != 0){
                Vendeur user1;
                Acheteur user2;
                ArrayList<Produit> produitsP = new ArrayList<>();
                //user1 = new Vendeur(" "," ",false, " ");
                user2 = new Acheteur(" "," ",false, false);
                user1 = new Vendeur("","",false,"");

                afficherMenu0();
                choix = saisieChoix(0,6);

                switch (choix){
                    case 0 : System.out.println("CIAO !");
                        break;
                    case 1 : Authentication(user2);
                            recupProduitBDD(produitsP);
                            afficherMenuAcheteur(produitsP);
                            afficherSouscrireAbonnement(user2);
                            choixAcheteurProduit(user2,produitsP);
                            System.out.println(user2.getListe_P());


                        break;
                    case 2 :  CreationCompte(user2);
                    break;

                    case 3 : Authentication(user1);
                            afficherProduitsVendeur(user1);
                            // todo : une fonction scénario avec plusieurs choix pour le vendeur (ajouterProduit, modifier, supprimer, ect)
                            user1.AjouterProduit();
                            afficherProduitsVendeur(user1);
                    break;

                    case 4 : CreationCompte(user1);
                    break;


                }

             }
//            user2.SouscrireAbonnement();
//            System.out.println(user2.toString());
//            System.out.println(user2.getPanier());

        }
        catch (IOError e){
            System.out.println("Erreur grave d'entrée/sortie ; fin de l'application");
        }

    }

    private static void afficherSouscrireAbonnement(Acheteur a) {
        Boolean choix;
        choix = lireInfoBool("\n Voulez-vous vous abonner à notre marketplace ? \n Oui (1) ou non(2)");
        if(choix == true){
            a.SouscrireAbonnement();
        }


    }


    public static void afficherMenu0(){
        System.out.println("\n Page de connexion/inscription");
        System.out.println("\n------------------En tant qu'acheteur-----------------------");
        System.out.println("(1) : Veuillez vous connecter");
        System.out.println("Si vous n'avez pas de compte");
        System.out.println("(2) Créer un compte");
        System.out.println("\n------------------En tant que vendeur------------------------");
        System.out.println("(3) : Veuillez vous connecter");
        System.out.println("Si vous n'avez pas de compte");
        System.out.println("(4) Créer un compte");
        System.out.println("\n------------------En tant qu'employé------------------------");
        System.out.println("(5) : Veuillez vous connecter");
        System.out.println("Si vous n'avez pas de compte");
        System.out.println("(6) Créer un compte");
        System.out.println("\n------------------Pressez (0) pour quitter------------------------");
    }

    public static void choixAcheteurProduit(Acheteur a, ArrayList<Produit> catalogue){
        int choix;
        int arret = 0;
        ArrayList<Produit> p = new ArrayList<>();

        while(arret != -1) {
            choix = lireInfoInt("Choisissez vos produits");
            a.setProduitList(catalogue.get(choix));
            a.AjouterPanier();
            arret = lireInfoInt("Pour arreter le choix des produts appuyez sur (-1) sinon appuyez sur (0)");

        }

    }


    public static void afficherMenuAcheteur(ArrayList produitsP){
        System.out.println("\n Vous êtes sur la page acheteur");
        afficherProduitsAcheteur(produitsP);
    }

    public  static void afficherProduitsAcheteur(ArrayList produitsP){
            System.out.println("\n Produit :" + produitsP.size());
        for (int i =0;i<produitsP.size();i++){
            System.out.println("\n Le produit n°" + i + ": " + produitsP.get(i));
        }
    }
    public static void afficherProduitsVendeur(Vendeur v){
        System.out.println("\nNombre de produits que vous vendez : "+ v.getProduitsVendeur().size() );
        for (int i =0;i<v.getProduitsVendeur().size();i++){
            System.out.println("\n" +  v.getProduitsVendeur());
        }
    }

    public static void recupProduitBDD(ArrayList produitsP){
        try {
            String pathFile = "Base produits.csv";
            File file = new File(pathFile);
            //File myObj = new File("filename.txt");
            Scanner myReader = new Scanner(file);
            String ligne0 = myReader.nextLine();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] splitted = data.split(",");
                produitsP.add(new Produit(splitted[0], splitted[1], Float.valueOf(splitted[2]), Float.valueOf(splitted[3])));

                //produitsP.add(splitted[k]);


            }


            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
    }

    private static String lireInfo(String messageInfo) {
        String infoLue;
        System.out.print(messageInfo + " : ");
        // lecture clavier et nettoyage des espaces en tête ou en queue de
        // chaîne
        Scanner s = new Scanner(System.in);
        infoLue = s.nextLine();
        return infoLue;
    }

    private static int lireInfoInt(String messageInfo) {
        String infoLue;
        System.out.print(messageInfo + " : ");
        // lecture clavier et nettoyage des espaces en tête ou en queue de
        // chaîne
        Scanner s = new Scanner(System.in);
        infoLue = s.nextLine();
        return Integer.parseInt(infoLue);
    }

    private static Boolean lireInfoBool(String messageInfo) {
        Boolean infoLue;
        System.out.print(messageInfo  + " : ");
        // lecture clavier et nettoyage des espaces en tête ou en queue de
        // chaîne
        Scanner s = new Scanner(System.in);
        infoLue = Boolean.parseBoolean(s.nextLine());
        return infoLue;
    }

    private static int saisieChoix(int borneMin, int borneMax) {
        int choix = -1;
        boolean erreur;
        String lecture; // buffer de lecture clavier

        // lecture du choix jusqu'à ce qu'elle soit correcte
        do {
            try {
                erreur = false;
                lecture = lireInfo("Votre choix");
                choix = Integer.parseInt(lecture);
            } catch (NumberFormatException e) {
                // ce n'est pas un entier qui a été lu au clavier
                erreur = true;
            }
        } while (erreur || choix<0 || choix>10);
        return choix;
    }

    private static void CreationCompte(User a){
        String username;
        String mdp;
        Boolean abonne;

        username = lireInfo("Définissez votre nom d'utilisateur");
        mdp = lireInfo("Définissez votre mot de passe");
        //abonne = lireInfoBool("Voulez-vous abonner à la marketplace");
        a.setUsername(username);
        a.setMdp(mdp);
        a.CreerCompte(username,mdp);  //creer le compte sur le fichier connexion.csv

    }
    private static void Authentication(User u){
        String username;
        String mdp;


        username = lireInfo("Entrez votre nom d'utilisateur");
        mdp = lireInfo("Entrez votre mot de passe");
        //abonne = lireInfoBool("Voulez-vous abonner à la marketplace");
        u.setMdp(mdp);
        u.setUsername(username);
        u.Identification(username,mdp);

    }

}
