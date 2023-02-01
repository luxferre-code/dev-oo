public class DicePlayer {
    
    String name;
    int totalValue, nbDiceRolls;

    DicePlayer(String name) {
        this.name = name;
        this.totalValue = 0;
        this.nbDiceRolls = 0;
    }

    void play(Dice d) {
        d.roll();
        this.totalValue += d.getValue();
        this.nbDiceRolls++;
    }

    public String toString() {
        return this.name + ": " + this.totalValue + " points en " + this.nbDiceRolls + " coups";
    }

    public int getTotalValue() {
        return totalValue;
    }
    
}
