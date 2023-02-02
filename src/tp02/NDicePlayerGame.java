import util.Keyboard;

public class NDicePlayerGame { /* Note à moi même, pas OUBLIER CE PTN DE :. dans la compilation et dans l'execution !!!!!! */

    private DicePlayer[] tabPlayer;
    private final int MAX_TOTAL_VALUE = 50;
    private final Dice DE = new Dice(6);
    
    NDicePlayerGame(int nbJoeur) {
        this.tabPlayer = new DicePlayer[nbJoeur];
        for(int i = 0; i < this.tabPlayer.length; i++) this.tabPlayer[i] = new DicePlayer("Player" + (i + 1));
    }

    public void playGame() {
        /*
         * Permet de faire jouer tous les joueurs
         */
        for(DicePlayer player : this.tabPlayer) {
            while(player.getTotalValue() < MAX_TOTAL_VALUE) player.play(this.DE);
        }
    }

    private int dernierVeritableElement(DicePlayer[] tab) {
        /*
         * Permet de trouver le dernier élément d'un tableau
         */
        int i = 0;
        while(i < tab.length && tab[i] != null) i++;
        return i;
    }

    private DicePlayer[] addElementInTab(DicePlayer[] tab, DicePlayer player) {
        /* 
         * Permet d'ajouter à un tableau défini à un taille fixe un joueur
        */
        int rang = dernierVeritableElement(tab);
        if(rang < tab.length) tab[rang] = player;
        else {
            DicePlayer[] newTab = new DicePlayer[tab.length * 2];
            for(int i = 0; i < tab.length; i++) newTab[i] = tab[i];
            newTab[tab.length] = player;
            tab = newTab;
        }
        return tab;
    }

    public DicePlayer[] winner() {
        /*
         * Permet de trouver le ou les gagnants
         */
        DicePlayer[] winner = new DicePlayer[]{this.tabPlayer[0]};
        for(int i = 1; i < this.tabPlayer.length; i++) {
            if(this.tabPlayer[i].getTotalValue() > winner[0].getTotalValue()) {
                winner = new DicePlayer[]{this.tabPlayer[i]};
            } else if(this.tabPlayer[i].getTotalValue() == winner[0].getTotalValue()) {
                winner = addElementInTab(winner, this.tabPlayer[i]);
            }
        }
        return winner;        
    }

    public static void main(String[] args) {
        NDicePlayerGame game = new NDicePlayerGame(Keyboard.readInt("Nombre de joueurs: "));
        game.playGame();
        System.out.println("Gagnant(s):");
        for(DicePlayer player : game.winner()) {
            if(player != null) System.out.println(player);
        }

    }

}
