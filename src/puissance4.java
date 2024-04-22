/*
 * le jeu puissance 4
 * Grégory Colard
 * mars 2024
 * introprog 2024a
 */

public class puissance4 {
    public static void main(String[] args) {

        char grille[][] = new char[6][7];
        String joueur1;
        String joueur2;
        String joueur;
        char carAffiche = '-';
        char rejouer = 'O';
        boolean finPartie = true;
        int jetons = 0;
        
        monUtil.bienvenue();
        joueur1 = monUtil.initialiserJoueur(1);
        joueur2 = monUtil.initialiserJoueur(2);

        while (rejouer == 'O') {

            monUtil.initialiserGrille(grille);
            monUtil.afficherGrille(grille);
            jetons = 0;
            finPartie = false;

            while (jetons < 42 && !finPartie) {

                finPartie = false;
                jetons++;
                if (jetons % 2 == 1) {
                    joueur = joueur1;
                    carAffiche = 'O';
                } else {
                    joueur = joueur2;
                    carAffiche = 'X';
                }
                monUtil.jouer(joueur, carAffiche, grille);
                monUtil.initScreen();
                monUtil.afficherGrille(grille);
                System.out.println();

                // gagné est true alors finPartie = true
                if (monUtil.verifierGagné(carAffiche, grille)) {
                    System.out.println(joueur + " vous avez gagné !");
                    finPartie = true;
                }
            }
            // 42 jetons pour le match nul
            if (jetons == 42) {
                System.out.println("Match nul !");
            }

            System.out.println("Voulez vous rejouer ?");
            rejouer = monUtil.saisirLettre();
            System.out.println();
        }
    }
}
