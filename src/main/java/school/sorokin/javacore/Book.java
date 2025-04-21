package school.sorokin.javacore;

import java.util.Objects;

public class Book extends Publication {
    private String ISBN;

    public Book(String title, String author, int year, String ISBN) {
        super(title, author, year);
        this.ISBN = ISBN;
    }

    public void printDetails() {
        System.out.printf(getDetailsString());
    }

    private String getDetailsString() {
        return String.format("Книга: \"%s\" | Автор: %s | Год: %d | ISBN: %s\n",
                getTitle(), getAuthor(), getYear(), ISBN);
    }

    @Override
    public String getType() {
        return "Книга";
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return Objects.equals(ISBN, book.ISBN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ISBN);
    }

    @Override
    public String toString() {
        return getDetailsString();
    }
}
