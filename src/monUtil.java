import java.util.Scanner;

public class monUtil {

    public static void bienvenue() {
        System.out.println("\nBienvenue dans le jeu Puissance 4\n");
        System.out.println("+++ Règles du jeu +++");
        System.out.println("Choisir une colonne de 1 à 7 pour placer son pion");
        System.out.println("Pour gagner :");
        System.out.println("Aligner 4 pions horizontalement");
        System.out.println("Aligner 4 pions verticalement");
        System.out.println("Aligner 4 pions en diagonales\n");
    }

    @SuppressWarnings("resource")
    public static String initialiserJoueur(int num) {
        // demande au joueur d'introduire son nom
        String joueur;
        System.out.println("Joueur " + num + " votre nom : ");
        joueur = new Scanner(System.in).nextLine().toUpperCase();
        System.out.println();
        return joueur;
    }

    public static void initialiserGrille(char grille[][]) {
        // initialisation grille avec '-'
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[0].length; j++) {
                grille[i][j] = '-';
            }
        }
    }

    public static void afficherGrille(char grille[][]) {
        // affichage grille
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
                System.out.print((grille[i][j]) + " ");
            }
            System.out.println();
        }
        // affichage n° colonne sous la grille
        for (int i = 0; i < grille.length + 1; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
    }

    @SuppressWarnings("resource")
    public static int saisirChoix() {
        // demande à l'utilisateur de rentrer un choix de colonne entre 1 et 7
        boolean correct = true;
        int nbre = 0;
        do {
            try {
                correct = true;
                System.out.print("votre choix : ");
                nbre = new Scanner(System.in).nextInt();
                if (nbre < 1 || nbre > 7) {
                    System.out.println("entre 1 et 7");
                    correct = false;
                } else
                    correct = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("un nombre entre 1 et 7 !");
                correct = false;
            }
        } while (!correct);
        return nbre;
    }

    public static void jouer(String joueur, char carAffiche, char grille[][]) {
        boolean colonnePleine = false;
        int choixColonne = 0;
        do {
            System.out.println("\nA vous de jouer " + joueur + " ");
            choixColonne = monUtil.saisirChoix();
            System.out.println();
            colonnePleine = false;
            // placement du pion en i si place dispo'-' dans la colonne choisie
            for (int ligne = grille.length - 1; ligne >= 0 && !colonnePleine; ligne--) {
                            // ! ajout en condition bool colonnePleine
                if (grille[ligne][choixColonne - 1] == '-') {
                    grille[ligne][choixColonne - 1] = carAffiche;
                    colonnePleine = true; // initialisation boolean à vrai pour continuer la boucle
                }
            }
            if (!colonnePleine) {
                System.out.println("colonne pleine fi");
            }
        } while (!colonnePleine);
    }

    public static boolean verifierGagné(char joueur, char grille[][]) {
        boolean gagné = false;
        // boucle pour vérifier horizontalement
        for (int ligne = 0; ligne < grille.length; ligne++) {
            for (int colonne = 0; colonne <= grille[ligne].length - 4; colonne++) {
                if (grille[ligne][colonne] == joueur && grille[ligne][colonne+1] == joueur && grille[ligne][colonne+2] == joueur && grille[ligne][colonne+3] == joueur) {
                    gagné = true;
                    return gagné;
                }
            }
        }
    
        // boucle pour vérifier verticalement
        for (int colonne = 0; colonne < grille[0].length; colonne++) {
            for (int ligne = 0; ligne <= grille.length - 4; ligne++) {
                if (grille[ligne][colonne] == joueur && grille[ligne+1][colonne] == joueur && grille[ligne+2][colonne] == joueur && grille[ligne+3][colonne] == joueur) {
                    gagné = true;
                    return gagné;
                }
            }
        }
    
        // boucle pour vérifier la diagonale principale
        for (int ligne = 0; ligne <= grille.length - 4; ligne++) {
            for (int colonne = 0; colonne <= grille[ligne].length - 4; colonne++) {
                if (grille[ligne][colonne] == joueur && grille[ligne+1][colonne+1] == joueur && grille[ligne+2][colonne+2] == joueur && grille[ligne+3][colonne+3] == joueur) {
                    gagné = true;
                    return gagné;
                }
            }
        }
    
        // boucle pour vérifier la diagonale secondaire
        for (int ligne = 0; ligne <= grille.length - 4; ligne++) {
            for (int colonne = 3; colonne < grille[ligne].length; colonne++) {
                if (grille[ligne][colonne] == joueur && grille[ligne+1][colonne-1] == joueur && grille[ligne+2][colonne-2] == joueur && grille[ligne+3][colonne-3] == joueur) {
                    gagné = true;
                    return gagné;
                }
            }
        }
    
        // si pas gagné renvoi = false
        gagné = false;
        return gagné;
    }

    @SuppressWarnings("resource")
    public static char saisirLettre() {
        // fonction retour caractère saisi par utilisateur avec vérification
        char lettre = ' ';
        boolean ok;
        do {
            ok = true;
            try {
                System.out.print("Entrez une lettre : ");
                lettre = new Scanner(System.in).nextLine().toUpperCase().charAt(0);
                ok = true;
                // nextLine() saisit une String
                // toUpperCase() met la string en majuscule
                // charAt(0) extrait le caractère à la position 0 de la String

            } catch (java.lang.StringIndexOutOfBoundsException e) {
                System.out.println("Une lettre svp");
                ok = false;
            }
            if (lettre < 65 || lettre > 90) {
                // 65 - 90 valeur ascii des lettres en majuscule
                // 97 -122 valeur ascii des lettres en minuscule
                System.out.println("Une lettre de a à z svp");
                ok = false;
            }
        } while (!ok);

        return lettre;
    }
    

    public static void initScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

}
