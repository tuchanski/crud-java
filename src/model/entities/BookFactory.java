package model.entities;

import model.entities.enums.Genre;

import java.util.Scanner;

public class BookFactory extends Book {

    Scanner input = new Scanner(System.in);

    public BookFactory() {
        super();
    }

    public Book createBook() {
        System.out.println("\n- Insert Book Mode -");

        System.out.print("- Enter ID: ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("- Enter title: ");
        String title = input.nextLine();

        System.out.print("- Enter author: ");
        String author = input.nextLine();

        System.out.print("- Enter year: ");
        int year = input.nextInt();

        System.out.print("- Enter number of pages: ");
        int pages = input.nextInt();
        input.nextLine();

        System.out.print("- Enter genre: ");
        String genreString = input.nextLine();
        Genre genre = Genre.valueOf(genreString);

        return new Book(id, title, author, year, pages, genre);
    }

}
