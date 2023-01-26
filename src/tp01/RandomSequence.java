import java.util.Random;

public class RandomSequence {

    int nbrEltGenerated;
    int maxVal;
    boolean isInteger;
    Random r;

    RandomSequence(int nbrEltGenerated, int maxVal, boolean isInteger) {
        this.nbrEltGenerated = nbrEltGenerated;
        this.maxVal = maxVal;
        this.isInteger = isInteger;
        this.r = new Random();
    }

    int genereRandomInt() {
        return r.nextInt(maxVal);
    }

    double genereRandomDouble() {
        return r.nextDouble() * maxVal;
    }

    void genereSequence() {
        for(int i=0; i<nbrEltGenerated; i++) {
            if(isInteger) {
                System.out.println(genereRandomInt());
            } else {
                System.out.println(genereRandomDouble());
            }
        }
    }

    
    
    public static void main(String[] args) {
        
        if(args.length < 2 || args.length > 3) {
            System.out.println("Correct usage : <nbElt> <maxVal> [INTEGER|REAL]");
            System.exit(1);
        }
        
        boolean isInteger = true;
        if(args.length == 3 && args[2].equals("REAL")) {
            isInteger = false;
        }

        RandomSequence r = new RandomSequence(Integer.parseInt(args[0]), Integer.parseInt(args[1]), isInteger);


        r.genereSequence();
    }

}
