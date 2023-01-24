package tp01;

public class UseBook {
    
    public static void main(String[] args) {
        Book[] biblio = new Book[] {
            new Book("J. K. Rowling", "Harry Potter", 1997),
            new Book("J. K. Rowling", "Harry Potter et la Chambre des Secrets", 1998),
            new Book("J. K. Rowling", "Harry Potter et le Prisonnier d'Azkaban", 1999),
            new Book("J. K. Rowling", "Harry Potter et la Coupe de Feu", 2000),
            new Book("J. K. Rowling", "Harry Potter et l'Ordre du Phénix", 2003),
            new Book("J. K. Rowling", "Harry Potter et le Prince de Sang-Mêlé", 2005),
            new Book("J. K. Rowling", "Harry Potter et les Reliques de la Mort", 2007),
        };
        
        for(int idx = 0; idx < biblio.length; idx++) {
            System.out.println(biblio[idx].getAuthor() + " a écrit " + biblio[idx].getTitle() + " en " + biblio[idx].year);
        }

    }

}
