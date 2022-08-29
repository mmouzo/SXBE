package model.entity;

public class Author {

    private String name;
    public String book_isbn;

    public Author(String name, String book_isbn) {
        this.name = name;
        this.book_isbn = book_isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBook_isbn() {
        return book_isbn;
    }

    public void setBook_isbn(String book_isbn) {
        this.book_isbn = book_isbn;
    }

    @Override
    public String toString() {
        return "" + name + "\t" + book_isbn;
    }

}
