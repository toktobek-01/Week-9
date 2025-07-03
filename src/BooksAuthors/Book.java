package BooksAuthors;

public class Book {
    private String title;
    private String author;
    private int yearPublished;

    public Book() {} // required for Jackson

    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYearPublished() { return yearPublished; }

    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setYearPublished(int yearPublished) { this.yearPublished = yearPublished; }
}
