package pl.coderslab.springDemoZbliski.model;

public class Book {
    private int id;
    private String title;
    private int pages;
    private int year;

    public Book(String title, int pages, int year) {
        this.title = title;
        this.pages = pages;
        this.year = year;
    }

    public Book(int id, String title, int pages, int year) {
        this.id = id;
        this.title = title;
        this.pages = pages;
        this.year = year;
    }

    //konstruktor bezparemetrowy wymagany przez biblioteke Jackson, której kontrolery używają do tłumaczenia obiektów na JSON
    public Book() {

    }

    //gettery wymagane przez bibliotekę Jackson
    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    public int getYear() {
        return year;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", pages=" + pages +
                ", year=" + year +
                '}';
    }
}
