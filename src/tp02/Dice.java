import java.util.Random;

public class Dice {
    
    private int numberSides;
    private Random r = new Random();
    private int value;

    Dice(int numberSides) {
        if(numberSides >= 1) {
            this.numberSides = numberSides;
        } else {
            this.numberSides = 1;
        }
    }

    public void roll() {
        this.value = r.nextInt(this.numberSides) + 1;
    }

    public String toString() {
        return "Dice with " + this.numberSides + " sides, value: " + this.value;
    }

    public int getValue() {
        return value;
    }



}
