package tp01;

class Parameter {
    public static void main(String[] args) {
        if(args.length==0) {
            System.out.println("No parameter");
        }
        for(int i=0; i<args.length; i++) {
            System.out.println("(" + (i+1) + ") " + args[i]);
        }
    }
}