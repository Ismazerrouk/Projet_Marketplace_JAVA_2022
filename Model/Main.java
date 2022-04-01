import java.io.IOError;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        int choix = -1; //choix du menu
        User user1;
        Acheteur user2;

        user1 = new Vendeur(" "," ",false, " ");
        user2 = new Acheteur(" "," ",false, false);
        try{

            while(choix != 0){
                afficherMenu0();
                choix = saisieChoix(0,6);

                switch (choix){
                    case 0 : System.out.println("CIAO !");
                        break;
                    case 1 : CreationCompte(user2);

                }

            }
        }
        catch (IOError e){
            System.out.println("Erreur grave d'entrée/sortie ; fin de l'application");
        }

    }


    public static void afficherMenu0(){
        System.out.println("Page de connexion/inscription");
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

    private static String lireInfo(String messageInfo) {
        String infoLue;
        System.out.print(messageInfo + " : ");
        // lecture clavier et nettoyage des espaces en tête ou en queue de
        // chaîne
        Scanner s = new Scanner(System.in);
        infoLue = s.nextLine();
        return infoLue;
    }

    private static Boolean lireInfoBool(String messageInfo) {
        Boolean infoLue;
        System.out.print(messageInfo + " : ");
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

    private static void CreationCompte(Acheteur a){
        String username;
        String mdp;
        Boolean abonne;

        username = lireInfo("Définissez votre nom d'utilisateur");
        mdp = lireInfo("Définissez votre mot de passe");
        abonne = lireInfoBool("Voulez-vous abonner à la marketplace");
        a.CreerCompte(username,mdp,abonne);

    }
}
