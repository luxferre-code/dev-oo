package tp01;

import java.util.Random;

public class RandomSequence {
    
    public static void main(String[] args) {

        if(args.length != 3) {
            System.out.println("Usage: java RandomSequence <nbElt> <maxVal> <INTEGER|DOUBLE>");
            System.exit(1);
        }

        int nbElt = Integer.parseInt(args[0]);
        int maxVal = Integer.parseInt(args[1]);
        boolean transfoToInt = false;

        if(args[2].equals("INTEGER")) transfoToInt = true;
        else if(args[2].equals("DOUBLE")) transfoToInt = false;
        else {
            System.out.println("Usage: java RandomSequence <nbElt> <maxVal> <INTEGER|DOUBLE>");
            System.exit(1);
        }

        Random r = new Random();

        for(int i = 0; i < nbElt; i++) {
            if(transfoToInt) System.out.println(r.nextInt(maxVal));
            else System.out.println(r.nextDouble() * maxVal);
        }

    }

}
