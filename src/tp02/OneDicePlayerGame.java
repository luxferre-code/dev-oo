public class OneDicePlayerGame {
    
    public static void main(String[] args) {
        if(args.length != 2) {
            System.out.println("Usage: java OneDicePlayerGame <player name> <dice number of sides>");
            System.exit(1);
        }

        String playerName = args[0];
        int diceNumberOfSides = Integer.parseInt(args[1]);
        DicePlayer player = new DicePlayer(playerName);
        Dice dice = new Dice(diceNumberOfSides);

        while(player.getTotalValue() < 20) {
            player.play(dice);
            System.out.println(player);
        }

    }

}
