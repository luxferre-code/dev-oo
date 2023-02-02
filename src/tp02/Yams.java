import util.Keyboard;

public class Yams {
    
    private Dice[] tabDice;
    private String name;
    private int[] compte;

    public Yams(String name) {
        this.name = name;
        this.tabDice = new Dice[5];
        for(int i = 0; i < this.tabDice.length; i++) this.tabDice[i] = new Dice(6);
    }

    private void setCompte(int[] c) {
        this.compte = c;
    }

    private int[] returnTabCount() {
        int[] tab = new int[]{0,0,0,0,0};
        for(int i = 0; i < this.tabDice.length; i++) tab[this.tabDice[i].getValue() - 1]++;
        return tab;
    }

    private boolean isBrelant() {
        for(int i = 0; i < this.compte.length; i++) if(this.compte[i] == 3) return true;
        return false;
    }

    private boolean isCarre() {
        for(int i = 0; i < this.compte.length; i++) if(this.compte[i] == 4) return true;
        return false;
    }

    private boolean isFull() {
        boolean brelant = false;
        boolean pair = false;
        for(int i = 0; i < this.compte.length; i++) {
            if(this.compte[i] == 3) brelant = true;
            if(this.compte[i] == 2) pair = true;
        }
        return brelant && pair;
    }

    private boolean isPetiteSuite() {
        int count = 0;
        for(int i = 0; i < this.compte.length; i++) {
            if(this.compte[i] == 1) count++;
            else count = 0;
            if(count == 4) return true;
        }
        return false;
    }

    private boolean isGrandeSuite() {
        int count = 0;
        for(int i = 0; i < this.compte.length; i++) {
            if(this.compte[i] == 1) count++;
            else count = 0;
        }
        return count == 5;
    }

    private boolean isYams() {
        for(int i = 0; i < this.compte.length; i++) if(this.compte[i] == 5) return true;
        return false;
    }

    public void lancer() {
        for(Dice d : this.tabDice) d.roll();
    }

    public void lancer(Dice[] aLancer) {
        for(Dice d : aLancer) {
            if(d != null) d.roll();
        }
    }

    public String toString() {
        String s = this.name + " :\n";
        for(int i = 0; i < this.tabDice.length; i++) s += "Dé n°" + (i + 1) + ": " + this.tabDice[i].getValue() + "\n";
        return s;
    }

    private boolean rejouer() {
        String rep;
        do {
            rep = Keyboard.readString("Voulez-vous rejouer ? (o/n)");
        } while(rep.equals("o") && rep.equals("n"));
        return rep.equals("o");
    }

    private Dice[] deARelancer() {
        Dice[] tab = new Dice[5];
        int count = 0;
        for(int i = 0; i < this.tabDice.length; i++) {
            String rep;
            do {
                rep = Keyboard.readString("Voulez-vous relancer le dé n°" + (i + 1) + " ? (o/n)");
            } while(rep.equals("o") && rep.equals("n"));
            if(rep.equals("o")) tab[count++] = this.tabDice[i];
        }
        return tab;
    }

    private String resultat(){
        if(this.isYams()) return "Yams";
        if(this.isGrandeSuite()) return "Grande suite";
        if(this.isPetiteSuite()) return "Petite suite";
        if(this.isFull()) return "Full";
        if(this.isCarre()) return "Carré";
        if(this.isBrelant()) return "Brelant";
        return "Rien";
    }

    private int sommeDes() {
        int somme = 0;
        for(int i = 0; i < this.tabDice.length; i++) somme += this.tabDice[i].getValue();
        return somme;
    }

    public static void main(String[] args) {
        
        if(args.length != 1) {
            System.out.println("Usage: java Yams <name>");
            System.exit(1);
        }

        Yams player = new Yams(args[0]);
        player.lancer();
        System.out.println(player);

        int count = 0;
        while(count < 2 && player.rejouer() ) {
            Dice[] relance = player.deARelancer();
            player.lancer(relance);
            count++;
            System.out.println(player);
        }

        player.setCompte(player.returnTabCount());

        String resultat = player.resultat();
        System.out.println("Résultat: " + resultat);

        switch (resultat) {
            case "Yams":
                System.out.println("Somme des dés: 50");
                break;
            case "Grande suite":
                System.out.println("Somme des dés: 40");
                break;
            case "Petite suite":
                System.out.println("Somme des dés: 30");
                break;
            case "Full":
                System.out.println("Somme des dés: 25");
                break;
            default:
                System.out.println("Somme des dés: " + player.sommeDes());
                break;
        }

    }

}
