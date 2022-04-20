package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args){
        int choix = -1; //choix du menu


        try{

            while(choix != 0){
                Vendeur user1;
                Acheteur user2;
                MarketplaceAdmin user3;
                Livreur user4;
                ArrayList<Produit> produitsP = new ArrayList<>(); //catalogue
                //user1 = new Vendeur(" "," ",false, " ");
                user2 = new Acheteur(" "," ",false, false);
                user1 = new Vendeur("","",false,"","");
                user3 = new MarketplaceAdmin("","",false);
                user4 = new Livreur("","","");
                boolean validationpanier;
                afficherMenu0();
                choix = saisieChoix(0,7);

                switch (choix){
                    case 0 : System.out.println("CIAO !");
                        break;
                    case 1 : Authentication(user2);
                            for (Acheteur l: MarketplaceAdmin.ListeAcheteur) {
                                if (l.getUsername().equals(user2.getUsername()) && l.getMdp().equals(user2.getMdp())){
                                    user2 = l;
                                }
                            }
                            if (!MarketplaceAdmin.ListeAcheteur.contains((Acheteur) user2)){
                                MarketplaceAdmin.ListeAcheteur.add((Acheteur) user2);
                            }
                            if (user2.ListeColis.size() > 0){
                                user2.SuivreColis();
                            }
                            recupProduitBDD(produitsP);
                            afficherMenuAcheteur(produitsP);
                            afficherSouscrireAbonnement(user2);
                            choixAcheteurProduit(user2,produitsP);     //appelle la methode ajouterPanier de Acheteur
                            validationpanier = ValiderCommande(user2);
                            while (!validationpanier) {
                                afficherMenuAcheteur(produitsP);
                                afficherSouscrireAbonnement(user2);
                                choixAcheteurProduit(user2,produitsP);
                                validationpanier = ValiderCommande(user2);


                            }

                            System.out.println("\nVotre adresse" + " " + user2.getAdresseLivraison());


                            System.out.print("\nVotre commande détaillée : \n" + user2.getListeCommandes());


                        break;
                    case 2 :  CreationCompte(user2);
                    break;

                    case 3 : Authentication(user1);
                            SetIDVendeur(user1);
                            afficherProduitsVendeur(user1);
                            for (Vendeur v: MarketplaceAdmin.ListeVendeur) {
                                if (v.getIdVendeur().equals(user1.getIdVendeur())){
                                    user1 = v;
                                }
                            }
                            if (!MarketplaceAdmin.ListeVendeur.contains((Vendeur)user1)){
                                MarketplaceAdmin.ListeVendeur.add((Vendeur) user1);
                            }
                            if (user1.getSousContrat()) {
                                choixVendeur(user1);
                            }
                            user1.SignerContrat();

                        break;

                    case 4 : CreationCompte(user1);
                    break;

                    case 5 :
                            Authentication(user3);
                            choixMarketplaceAdmin(user3);
                            if (user3.getListeCommande().size() > 0 && user3.ListeLivreur.size()>0){
                                user3.ExpedierCommande();
                            }
                            else{
                                System.out.printf("\nVous n'avez pas de commandes à livrer ou pas de livreur pour les livrer...\n");
                            }

                            //user3.ChiffreAffaire();

                            if (user3.getListeVendeurContrat().size() > 0) {
                                user3.AjouterVendeur();}
                            break;


                    case 6: CreationCompte(user3);
                    break;

                    case 7: Authentication(user4);
                            setIDLivreur(user4);
                            System.out.println(user4.getIdLivreur());
                        for (Livreur l: MarketplaceAdmin.ListeLivreur) {
                            if (l.getIdLivreur().equals(user4.getIdLivreur())){
                                user4 = l;
                            }
                        }
                        if (!MarketplaceAdmin.ListeLivreur.contains((Livreur) user4)){
                            MarketplaceAdmin.ListeLivreur.add((Livreur) user4);
                        }
                        if (user4.listeColis.size() > 0){
                            infoColisLivreur(user4);
                            user4.NotifierClient();
                        }
                        if (user4.listeColis.size() == 0){
                            SetInfoLivreur(user4);
                        }
                    break;

                    case 8: CreationCompte(user4);
                    break;

                }

             }
//            user2.SouscrireAbonnement();
//            System.out.println(user2.toString());
//            System.out.println(user2.getPanier());

        }
        catch (IOError | ParseException e){
            System.out.println("Erreur grave d'entrée/sortie ; fin de l'application");
        }

    }

    public static void choixMarketplaceAdmin(MarketplaceAdmin m) {
        int choix = -1;

        System.out.println("\n Choisissez ce que vous voulez réaliser : ");
        System.out.println("(0) : Consulter le chiffre d'affaires");
        System.out.println("(1) : Ajouter un produit");
        System.out.println("(2) : Ne rien faire");
        while(choix != 2) {
            choix = saisieChoix(0,2);
            switch (choix){
                case 0: m.ChiffreAffaire();
                    break;

                case 1 :
                    m.AjouterProduit();
                    break;
                case 2:
                    System.out.println("\n Bye monsieur l'administrateur !");
                    break;

            }
        }
    }

    private static void choixVendeur(Vendeur v){
        int choix = -1;

        System.out.println("\n Choisissez ce que vous voulez réaliser : ");
        System.out.println("(0) : Suivre mes ventes");
        System.out.println("(1) : Ajouter un produit");
        System.out.println("(2) : Supprimer un produit");
        System.out.println("(3) : Modifier un produit");
        System.out.println("(4) : Ne rien faire");

        while(choix != 4) {
            choix = saisieChoix(0,4);
            switch (choix){
                case 0: v.SuivreVentes();
                break;

                case 1 :
                v.AjouterProduit();
                break;


                case 2:
                v.Supprimer();
                break;

                case 3:
                v.Modifier();
                break;

                case 4:
                System.out.println("\nBye monsieur le vendeur !");
                break;
            }
        }
    }
    
    private static void setIDLivreur(Livreur l){
        String saisie;
        saisie = lireInfo("Rentrez votre ID livreur");
        l.setIdLivreur(saisie);
    }
    
    private static void infoColisLivreur(Livreur l){
        System.out.println("\nVoici la liste des colis que vous avez à livrer : ");
        System.out.println(l.getListeColis());
    }

    private static void SetInfoLivreur(Livreur l) throws ParseException {
        String choixDispo;
        String permis;
        System.out.println("\nBonjour monsieur le livreur");

        Date today;
        Date date;
        do {
            choixDispo = lireInfo("\nEntrez votre disponibilité (format dd/MM/yyyy)");
            date = new SimpleDateFormat("dd/MM/yyyy").parse(choixDispo);
            String todayS = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
            today = new SimpleDateFormat("dd/MM/yyyy").parse(todayS);
        } while (today.after(date));


        l.setDisponibilite(date);


        boolean matchFound;
        do {
            permis = lireInfo("\nRenseignez le type de votre permis");
            Pattern pattern = Pattern.compile("[abcde]", Pattern.CASE_INSENSITIVE);  //tous les types de permis
            Matcher matcher = pattern.matcher(permis);
            matchFound = matcher.find();

        } while (!matchFound);

        l.setType_permis(permis);

        System.out.println("\nNous avons bien enregistré cela, merci !");


    }

    private static void afficherSouscrireAbonnement(Acheteur a) {
        Boolean choix;
        choix = lireInfoBool("\n Voulez-vous vous abonner à notre marketplace ? \n Oui (true) ou non (false)");
        if(choix){
            a.SouscrireAbonnement();
        }
    }

    public static Boolean ValiderCommande(Acheteur a){
        Boolean choix;
        choix = lireInfoBool("\n Voulez-vous valider votre panier : (true) or (false) ?");

        if(choix){
            a.ValiderPanier();
            System.out.println("Panier validé !");
            return true;
        }
        else{
            return false;
        }

    }


    public static void afficherMenu0(){
        System.out.println("\n Page de connexion/inscription");
        System.out.println("\n------------------En tant qu'acheteur-----------------------");
        System.out.println("(1) : Veuillez vous connecter");
        System.out.println("\nSi vous n'avez pas de compte");
        System.out.println("(2) Créer un compte");
        System.out.println("\n------------------En tant que vendeur------------------------");
        System.out.println("(3) : Veuillez vous connecter");
        System.out.println("\nSi vous n'avez pas de compte");
        System.out.println("(4) Créer un compte");
        System.out.println("\n------------------En tant qu'administrateur de la marketplace------------------------");
        System.out.println("(5) : Veuillez vous connecter");
        System.out.println("\nSi vous n'avez pas de compte");
        System.out.println("(6) Créer un compte");
        System.out.println("\n------------------En tant que livreur------------------------");
        System.out.println("(7) : Veuillez vous connecter");
        System.out.println("\nSi vous n'avez pas de compte");
        System.out.println("(8) Créer un compte");

        System.out.println("\n------------------Pressez (0) pour quitter------------------------");
    }

    public static void choixAcheteurProduit(Acheteur a, ArrayList<Produit> catalogue){
        int choix;
        int arret = 0;
        ArrayList<Produit> p = new ArrayList<>();

        while(arret != -1) {
            choix = lireInfoInt("Choisissez vos produits");
            a.setProduitList(catalogue.get(choix));   // set la liste de produit de l'acheteur avec le choix de l'acheteur dans le catalogue
            a.AjouterPanier();                        // Ajoute la liste de produit de l'acheteur à son panier

            arret = lireInfoInt("Pour arreter le choix des produits appuyez sur (-1) sinon appuyez sur (0)");

        }

    }

    /*public static void MenuVendeur(){
        System.out.println("\n Que voulez-vous faire en tant que vendeur ?");

        System.out.println("\n------------------En tant que vendeur------------------------");
        System.out.println("(1) : Ajouter un produit que vous voulez vendre");
        System.out.println("\n(2) : Supprimer un produit que vous vendez");
        System.out.println("\n(3) : Modifier un produit que vous vendez");

        System.out.println("\n------------------Pressez (0) pour quitter------------------------");
    }

    public static void afficherChoixVendeur(Vendeur v){
        Integer choix = -1;
        while(choix != 0) {
            afficherMenu0();
            choix = saisieChoix(0, 6);
        }
        switch (choix) {
            case 1 : v.AjouterProduit();
            break;

        }
        }
*/



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
        v.recupProduitVendeurBDD(v.getProduitsVendeur());   //on recupere à chaque fois les produits contenant l'id du vendeur
        System.out.println("\nNombre de produits que vous vendez : "+ v.getProduitsVendeur().size() );
        System.out.println("\n" +  v.getProduitsVendeur());
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
                produitsP.add(new Produit(splitted[0], splitted[1], Float.valueOf(splitted[2]), Float.valueOf(splitted[3]), splitted[4]));
                //produitsP.add(splitted[k]);


            }



            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
    }

    public static String lireInfo(String messageInfo) {
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

    public static int saisieChoix(int borneMin, int borneMax) {
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

    private static void SetIDVendeur(Vendeur v){
        String saisie;
        saisie = lireInfo("Rentrez votre ID vendeur");
        v.setIdVendeur(saisie);
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
        //a.setID();
        if (a instanceof Acheteur) {
            a.CreerCompte(username,mdp, "acheteur");
        }
        if (a instanceof Vendeur){
            a.CreerCompte(username,mdp, "vendeur");
        }
        if (a instanceof MarketplaceAdmin){
            a.CreerCompte(username,mdp,"marketplace");
        }
        if (a instanceof Livreur){
            a.CreerCompte(username,mdp,"livreur");
        }
          //creer le compte sur le fichier connexion.csv avec le bon type

    }

    private static void Authentication(User u){
        String username;
        String mdp;

        boolean connect = false;

        username = lireInfo("Entrez votre nom d'utilisateur");
        mdp = lireInfo("Entrez votre mot de passe");
        //abonne = lireInfoBool("Voulez-vous abonner à la marketplace");
        u.setMdp(mdp);
        u.setUsername(username);
        u.setID();
        if (u instanceof Acheteur) {
            do {
                connect = u.Identification(username,mdp,"acheteur");
            }while (!connect);

        }
        if (u instanceof Vendeur){
            u.Identification(username,mdp,"vendeur");


        }
        if (u instanceof MarketplaceAdmin){
            u.Identification(username,mdp,"marketplace");
        }
        if (u instanceof Livreur){
            u.Identification(username,mdp,"livreur");

        }

    }

}
