package application;

import entities.Book;
import entities.Library;
import entities.enums.Genre;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        Library library = new Library();
        System.out.println("Hello World! Welcome to Lapa's Library Management.\n" +
                "You can add, remove and search books easily. (＾-＾)");

        int menu;
        do{
            System.out.println("\nWhat would you like to do?\n" +
                    "1. Insert Book\n" +
                    "2. Remove Book\n" +
                    "3. Update Book\n" +
                    "4. Search Book\n" +
                    "5. All books available\n" +
                    "0. Exit");
            System.out.print("\nEnter your choice: ");

            menu = input.nextInt();
            switch(menu){
                case 1:
                    try {
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
                        library.addBook(book);

                        break;
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }


                case 5:
                    System.out.println("\n- Lapa's Library Stock -");
                    library.getBooks();
                    break;
            }


        }
        while (menu != 0);
        System.out.println("- Thanks for using Lapa's Library! This is an OOP project designed by Tuchanski.");

    }
}
