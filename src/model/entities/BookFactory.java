package model.entities;

import model.entities.enums.Genre;
import model.exceptions.BookException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BookFactory extends Book {

    Scanner input = new Scanner(System.in);

    public BookFactory() {
        super();
    }

    public Book createBook() {
        try{
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
        catch (InputMismatchException e){
            System.out.println("\nError: Please enter a valid input.");
        }
        return null;
    }

}
