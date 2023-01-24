package tp01;

public class Book {
    
    String author;
    String title;
    int year;

    Book(String author, String title, int year) {
        this.author = author;
        this.title = title;
        this.year = year;
    }

    String getAuthor() {
        return author;
    }

    String getTitle() {
        return title;
    }

    public static void main(String[] args) {
        Book book = new Book("J. K. Rowling", "Harry Potter", 1997);
        System.out.println(book.author + " a écrit " + book.title + " en " + book.year);
    }

}
