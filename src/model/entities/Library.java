package model.entities;

import model.entities.enums.Genre;
import model.exceptions.BookException;
import model.exceptions.BookNotFoundException;
import model.exceptions.DuplicateBookException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

    Scanner input = new Scanner(System.in);

    public Library(){}

    private List<Book> stock = new ArrayList<Book>();

    public void getBooks(){

        if (stock.isEmpty()){
            throw new BookNotFoundException("There's no books in the library.");
        }
        else{
            for (Book book : this.stock){
                System.out.println(book);
            }
        }
    }

    //Added exception
    public void getBookById(Integer id){
        for (Book book : this.stock){
            if (book.getId() == id){
                System.out.println(book);
                return;
            }
        }
        throw new BookNotFoundException("Book with ID #" + id + " not found.");
    }

    //Added Exception
    public void addBook(Book book){
        for (Book existingBook : this.stock){
            if (existingBook.getId() == book.getId()){
                throw new DuplicateBookException("Book with ID #" + book.getId() + " already exists.");
            }
        }
        this.stock.add(book);
    }

    //Added Exception
    public void removeBookById(Integer id){
        boolean removed = this.stock.removeIf(book -> book.getId() == id);
        if (removed){
            System.out.println("Book #" + id + " removed successfully.");
        }
        else{
            throw new BookNotFoundException("Book with ID #" + id + " not found.");
        }
    }

    //Added Exception
    public void updateBook(Integer id){

        boolean updatedAttempt = false;
        for (Book book : this.stock){
            if (book.getId().equals(id)){
                updatedAttempt = true;
                System.out.println("\n- Updating Book -" +
                        "\n[1] - Title" + "\n[2] - Author" + "\n[3] - Year" +
                        "\n[4] - Number of Pages" + "\n[5] - Genre" + "\n[0] - Return to Menu");
                System.out.print("\nEnter your choice: ");

                int mode = input.nextInt();
                switch(mode){
                    case 0:
                        System.out.println("- Exiting from Update Mode -");
                        return;
                    case 1:
                        updateTitle(id);

                    case 2:
                        try{
                            System.out.println("- Changing Author from Book #" + id + " -");
                            System.out.print("\n- Enter new author: ");
                            String author = input.next();

                            if (author != null && !author.equals(book.getAuthor()) && !author.isEmpty()){
                                book.setAuthor(author);
                                System.out.println("- Changed Author to Book #" + id + " -");
                                break;
                            }

                        }
                        catch(BookException e){
                            System.out.println("- Error: " + e.getMessage());
                            break;
                        }

                    case 3:
                        try{
                            System.out.println("- Changing Year from Book #" + id + " -");
                            System.out.print("\n- Enter new year: ");
                            int year = input.nextInt();
                            if (year != book.getYear() && year > 0){
                                book.setYear(year);
                                break;
                            }
                        }
                        catch(BookException e){
                            System.out.println("- Error: " + e.getMessage());
                        }

                    case 4:
                        try{
                            System.out.println("- Changing Number of Pages from Book #" + id + " -");
                            System.out.print("\n- Enter new number of pages: ");
                            int pages = input.nextInt();
                            if (pages != book.getNumberOfPages() && pages > 0){
                                book.setNumberOfPages(pages);
                                break;
                            }
                        }
                        catch(BookException e){
                            System.out.println("- Error: " + e.getMessage());
                        }

                    case 5:
                        try{
                            System.out.println("- Changing Genre from Book #" + id + " -");
                            System.out.print("\n- Enter new genre: ");
                            String GenreStr = input.next();

                            Genre genre = Genre.valueOf(GenreStr.toUpperCase());
                            book.setGenre(genre);
                            break;
                        }
                        catch(BookException e){
                            System.out.println("- Error: " + e.getMessage());
                            break;
                        }

                    default:
                        System.out.println("- Error: Please, select a valid option. -");
                }
            }
        }
        if (!updatedAttempt){
            throw new BookNotFoundException("Book with ID #" + id + " not found.");
        }

    }

    public void updateTitle(Integer id){
        for (Book book : this.stock){
            if (book.getId() == id){
                System.out.println("- Changing Title from Book #" + id + " -");
                System.out.print("\n- Enter new title: ");
                String title = input.next();
                if (title != null && !title.equals(book.getTitle()) && !title.isEmpty()){
                    book.setTitle(title);
                    System.out.println("- Changed Title to Book #" + id + " -");
                    break;
                }
                else{
                    throw new BookException("Invalid title entered.");
                }
            }
            else{
                throw new BookNotFoundException("Book with ID #" + id + " not found.");
            }

        }
    }

}
