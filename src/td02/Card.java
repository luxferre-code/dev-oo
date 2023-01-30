package td02;

import java.util.Random;

public class Card {

    private int rank;
    private int color;

    Card(int rank, int color) {
        this.rank = rank;
        this.color = color;
    }

    public String toString() {
        return this.color + " " + this.rank;
    }

    public int getRank() {
        return this.rank;
    }

    public int getColor() {
        return this.color;
    }

    public boolean equals(Card c) {
        if(this == c) return true;
        if(c == null) return false;
        return this.color == c.getColor() && this.rank == c.getRank();
    }

    public int compareRank(Card c) {
        if(c == null) return -2;
        if(this.rank == c.getRank()) return 0;
        if(this.rank > c.getRank()) return 1;
        return -1;
    }

    public int compareColor(Card c) {
        if(c == null) return -2;
        if(this.color == c.getColor()) return 0;
        if(this.color > c.getColor()) return 1;
        return -1;
    }

    public boolean isBefore(Card c) {
        if(c == null) return false;
        if(this.compareRank(c) == -1) return true;
        if(this.compareRank(c) == 1) return false;
        return this.compareColor(c) == 1;
    }

    private Card genereRandomCard() {
        Random r = new Random();
        return new Card(r.nextInt(3), r.nextInt(7));
    }

    public Card[] genereRandomCards(int n) {
        Card[] cards = new Card[n];
        for(int i = 0; i < n; i++) {
            cards[i] = this.genereRandomCard();
        }
        return cards;
    }

    public void affiche2RandomCards() {
        Card c1 = this.genereRandomCard();
        Card c2 = this.genereRandomCard();
        if(c1.equals(c2)) {
            this.affiche2RandomCards();
        } else {
            if(c1.isBefore(c2)) {
                System.out.println(c1 + "\n" + c2);
            } else {
                System.out.println(c2 + "\n" + c1);
            }
        }
    }

    private Card bestCard(Card[] cs) {
        if(cs.length == 0) return null;
        Card best = cs[0];
        for(int i = 1; i < cs.length; i++) {
            if(cs[i].isBefore(best)) {
                best = cs[i];
            }
        }
        return best;
    }

    public static void main(String[] args) {
        if(args.length == 0) {
            System.out.println("Usage: java Card <nbCards>");
            System.exit(1);
        }
        Card c = new Card(0, 0);
        Card[] cs = new Card[Integer.parseInt(args[0])];
        for(int i = 0; i < cs.length; i++) {
            cs[i] = c.genereRandomCard();   
            System.out.println(cs[i]);
        }

        Card best = c.bestCard(cs);
        System.out.println("Best card: " + best);
    }
    
}
