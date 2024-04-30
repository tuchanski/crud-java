package model.entities;

import model.entities.enums.Genre;

import java.io.Serializable;
import java.util.Objects;

public class Book implements Serializable {

    private Integer id;
    private String title;
    private String author;
    private int year;
    private int numberOfPages;
    private Genre genre;

    public Book() {}

    public Book(Integer id, String title, String author, int year, int numberOfPages, Genre genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.numberOfPages = numberOfPages;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", numberOfPages=" + numberOfPages +
                ", genre=" + genre +
                '}';
    }
}
