public class UseIrregular {
    
    public static void main(String[] args) {
        Irregular i = new Irregular(new int[]{3, 5, 2, 4, 1});
        i.randomFilling();
        System.out.println(i.display());

        int nbr = i.tableau[0][0];

        System.out.println(i.isCommun(nbr));
        
        for(int j = 0; j < i.tableau.length; j++) {
            i.tableau[j][0] = nbr;
        }

        System.out.println(i.display());
        
        System.out.println(i.existCommon());

    }

}
