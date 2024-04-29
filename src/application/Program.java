package application;

import model.entities.Book;
import model.entities.Library;
import model.entities.enums.Genre;
import model.exceptions.BookException;
import model.exceptions.BookNotFoundException;
import model.exceptions.DuplicateBookException;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner input = new Scanner(System.in);

        System.out.println("Hello World! Welcome to Lapa's Library Management.\n" +
                "You can add, remove and search books easily. (＾-＾)");
        int menu;
        do {
            System.out.println("""
                    \nWhat would you like to do?
                    1. Insert Book
                    2. Remove Book
                    3. Update Book
                    4. Search Book
                    5. Book Stock List
                    0. Exit""");

            System.out.print("\nEnter your choice: ");
            menu = input.nextInt();

            switch (menu) {

                case 1:
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

                    Book book = new Book(id, title, author, year, pages, genre);

                    try {
                        library.addBook(book);
                    }
                    catch (BookException | DuplicateBookException | BookNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }

                    break;

                case 2:
                    System.out.println("\n- Remove Book Mode -");
                    System.out.print("- Enter ID: ");
                    int removeId = input.nextInt();

                    try {
                        library.removeBookById(removeId);
                    }
                    catch (BookException | BookNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }

                    break;

                case 3:
                    System.out.println("\n- Update Book Mode -");
                    System.out.print("- Enter ID: ");
                    int updateId = input.nextInt();

                    try {
                        library.updateBook(updateId);
                    }
                    catch (BookException | BookNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }

                    break;

                case 4:
                    System.out.println("\n- Search Book Mode -");
                    System.out.print("- Enter ID: ");
                    int searchId = input.nextInt();

                    try {
                        library.getBookById(searchId);
                    }
                    catch (BookException | BookNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("\n- Library Stock -");
                    try{
                        library.getBooks();
                    }
                    catch (BookException | BookNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 0:
                    // System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Error: invalid option.");
            }
        }
        while (menu != 0);
        input.close();
        System.out.println("- Thanks for using Lapa's Library! This is an OOP project designed by Tuchanski.");
    }
}
