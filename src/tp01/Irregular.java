package tp01;

import java.util.Random;

public class Irregular {

    int[][] tableau;
 
    Irregular(int[] lineSize) {
        this.tableau = new int[lineSize.length][];
        for(int i=0; i<lineSize.length; i++) {
            this.tableau[i] = new int[lineSize[i]];
        }
    }

    void randomFilling() {
        Random r = new Random();
        for(int i = 0; i < this.tableau.length; i++) {
            for(int j = 0; j < this.tableau[i].length; j++) {
                this.tableau[i][j] = r.nextInt(100);
            }
        }
    }

    String display() {
        String s = "";
        for(int i=0; i< this.tableau.length; i++) {
            for(int j=0; j< this.tableau[i].length; j++) {
                s += this.tableau[i][j] + "|";
            }
            s += "\n";
        }
        return s;
    }

    boolean isCommun(int element) {
        /*
         * Recherche si l'élément appartient à toutes les lignes
         * :return true si l'élément appartient à toutes les lignes:
         */

        for(int i=0; i< this.tableau.length; i++) {
            if(!this.inLine(element, i)) {
                return false;
            }
        }
        return true;
    }

    boolean inLine(int element, int line) {
        /*
         * Recherche si l'élément appartient à la ligne
         * :return true si l'élément appartient à la ligne:
         */
        for(int i=0; i< this.tableau[line].length; i++) {
            if(this.tableau[line][i] == element) {
                return true;
            }
        }
        return false;
    }

    boolean existCommon() {
        /*
         * Recherche si un élement est en commun dans toutes lignes
         * :return true si un élément est en commun dans toutes les lignes:
        */

        int[] tab = new int[this.tableau[0].length];
        for(int i=0; i< this.tableau[0].length; i++) {
            tab[i] = this.tableau[0][i];
        }
        
        int rang = 0;
        while(rang < tab.length && !isCommun(tab[rang])) rang++;
        return rang != tab.length;
    }
}
