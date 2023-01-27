package tp01;

class UseBook{

    public static void main(String[] args) {
        
        Book[] biblio = new Book[]{
            new Book("The Hobbit", "J.R.R. Tolkien", 1937),
            new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954),
            new Book("The Silmarillion", "J.R.R. Tolkien", 1977),
        };

        for(int i = 0; i < biblio.length; i++) {
            biblio[i].affiche();
        }

    }

}