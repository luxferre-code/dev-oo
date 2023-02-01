public class Competitor {

    String numberSign;
    int time;
    int score;

    Competitor(int numberSign, int score, int min, int sec) {
        this.numberSign = "No" + numberSign; 
        this.score = score;
        this.time = min * 60 + sec;
    }

    String display() {
        return "[" + this.numberSign + ", " + this.score + " points, " + this.time + " s]";
    }

    public static void main(String[] args) {
        
        int[][] concurrent = new int[100][];
        concurrent[0] = new int[]{
            1,45,15,20
        };
        concurrent[1] = new int[]{
            2,32,12,45
        };
        concurrent[2] = new int[]{
            5,12,13,59
        };
        concurrent[3] = new int[]{
            12,12,15,70
        };
        concurrent[4] = new int[]{
            32,75,15,20
        };

        for (int i = 0; i < concurrent.length; i++) {
            if (concurrent[i] != null) {
                Competitor c = new Competitor(concurrent[i][0], concurrent[i][1], concurrent[i][2], concurrent[i][3]);
                System.out.println(c.display());
            }
        }

    }

}