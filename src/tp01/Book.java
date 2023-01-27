package tp01;

class Book {
    // class attributes
    String author;
    String title;
    int year;

    
    // constructor
    Book(String author, String title, int year) {
        this.author = author;
        this.title = title;
        this.year = year;
    }


    // methods
    String getAuthor() {
        return this.author;
    }


    String getTitle() {
        return this.title;
    }

    void affiche() {
        System.out.println(this.author + " a écrit " + this.title + " en " + this.year);
    }

    public String toString() {
        return this.author + " a écrit " + this.title + " en " + this.year;
    }

}