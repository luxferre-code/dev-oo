public class TwoDicePlayerGame {

    private DicePlayer player1;
    private DicePlayer player2;
    private final int MAX_TOTAL = 20;
    
    public TwoDicePlayerGame(DicePlayer player1, DicePlayer player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    private DicePlayer winner() {
        if(this.player1.getNbDiceRolls() > this.player2.getNbDiceRolls()) {
            return this.player1;
        } else if(this.player1.getNbDiceRolls() < this.player2.getNbDiceRolls()) {
            return this.player2;
        } else {
            if(this.player1.getTotalValue() > this.player2.getTotalValue()) {
                return this.player1;
            } else if(this.player1.getTotalValue() < this.player2.getTotalValue()) {
                return this.player2;
            } else {
                return null;
            }
        }
    }

    public void playGame(Dice de) {
        while(this.player1.getTotalValue() < this.MAX_TOTAL) this.player1.play(de);
        while(this.player2.getTotalValue() < this.MAX_TOTAL) this.player2.play(de);
    }

    public static void main(String[] args) {
        if(args.length != 3) {
            System.out.println("Usage: java TwoDicePlayerGame <namePlayer1> <namePlayer2> <nbFaces>");
            System.exit(1);
        }

        DicePlayer player1 = new DicePlayer(args[0]);
        DicePlayer player2 = new DicePlayer(args[1]);
        Dice de = new Dice(Integer.parseInt(args[2]));

        TwoDicePlayerGame game = new TwoDicePlayerGame(player1, player2);

        game.playGame(de);
        
        System.out.println(game.winner());

    }

}
