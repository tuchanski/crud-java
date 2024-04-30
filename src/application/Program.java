package application;

import model.entities.Book;
import model.entities.BookFactory;
import model.entities.Library;
import model.exceptions.BookException;
import model.exceptions.BookNotFoundException;
import model.exceptions.DuplicateBookException;

import java.util.InputMismatchException;
import java.util.Scanner;

import static model.entities.Library.getMenu;

public class Program {

    public static void main(String[] args) {

        Library library = new Library();
        Scanner input = new Scanner(System.in);
        int menuSelector = -1;

        System.out.println("Hello World! Welcome to Lapa's Library Management.\n" +
                "You can add, remove and search books easily. (＾-＾)");

        do {
            getMenu();

            try {
                System.out.print("\nChoose an option: ");
                menuSelector = input.nextInt();

                switch (menuSelector) {
                    case 1:
                        try{
                            BookFactory bf = new BookFactory();
                            Book book = bf.createBook();
                            if (book != null) {
                                library.addBook(book);
                            }
                        }
                        catch (BookException | DuplicateBookException e) {
                            System.out.println("\nError: " + e.getMessage());
                        }
                        break;

                    case 2:
                        System.out.println("\n- Remove Book Mode -");
                        System.out.print("- Enter ID: ");
                        int idToRemove = input.nextInt();
                        try {
                            library.removeBook(idToRemove);
                        }
                        catch (BookException | BookNotFoundException e) {
                            System.out.println("\nError: " + e.getMessage());
                        }
                        break;

                    case 3:
                        System.out.println("\n- Update Book Mode -");
                        System.out.print("- Enter ID: ");
                        int idToUpdate = input.nextInt();
                        try {
                            library.updateBook(idToUpdate);
                        }
                        catch (BookException | BookNotFoundException e) {
                            System.out.println("\nError: " + e.getMessage());
                        }
                        break;

                    case 4:
                        System.out.println("\n- Search Book Mode -");
                        System.out.print("- Enter ID: ");
                        int idToSearch = input.nextInt();
                        try {
                            library.getBook(idToSearch);
                        }
                        catch (BookException | BookNotFoundException e) {
                            System.out.println("\nError: " + e.getMessage());
                        }
                        break;

                    case 5:
                        System.out.println("\n- Library Stock -");
                        try{
                            library.getBooks();
                        }
                        catch (BookNotFoundException e) {
                            System.out.println("\nWarning: " + e.getMessage());
                        }
                        break;

                    case 0:
                        //System.out.println("Goodbye!");
                        break;

                    default:
                        System.out.println("\nError: invalid option.");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("\nError: Please enter a valid input.");
                input.next(); // Clean scanner buffer
            }
        }
        while (menuSelector != 0);
        input.close();
        System.out.println("\n- Thanks for using Lapa's Library! ^_^");
    }
}
