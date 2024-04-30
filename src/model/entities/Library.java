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

    private final List<Book> stock = new ArrayList<>();

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

    public void getBookById(Integer id){
        for (Book book : this.stock){
            if (book.getId().equals(id)){
                System.out.println(book);
                return;
            }
        }
        throw new BookNotFoundException("Book with ID #" + id + " not found.");
    }

    public void addBook(Book book){
        for (Book existingBook : this.stock){
            if (existingBook.getId().equals(book.getId())){
                throw new DuplicateBookException("Book with ID #" + book.getId() + " already exists.");
            }
        }
        this.stock.add(book);
    }

    public void removeBookById(Integer id){
        boolean removed = this.stock.removeIf(book -> book.getId().equals(id));
        if (removed){
            System.out.println("Book #" + id + " removed successfully.");
        }
        else{
            throw new BookNotFoundException("Book with ID #" + id + " not found.");
        }
    }

    // Update methods

    public void updateBook(Integer id){
        boolean idChecker = false;
        int updateMenu;
        for (Book book : this.stock){
            if (book.getId().equals(id)){
                idChecker = true;
                System.out.println("- Updating Book #" + id + " -");
                System.out.println("""
                        [1] - Update Title
                        [2] - Update Author
                        [3] - Update Year\

                        [4] - Update Pages
                        [5] - Update Genre
                        [0] - Quit Update Menu""");
                System.out.print("\nEnter your choice: ");
                updateMenu = input.nextInt();

                switch (updateMenu){
                    case 1:
                        updateTitle(id, book);
                        break;
                    case 2:
                        updateAuthor(id, book);
                        break;
                    case 3:
                        updateYear(id, book);
                        break;
                    case 4:
                        updatePages(id, book);
                        break;
                    case 5:
                        updateGenre(id, book);
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Error: invalid option.");
                }
            }
        }
        if (!idChecker){
            throw new BookNotFoundException("Book with ID #" + id + " not found.");
        }
    }

    private void updateTitle(Integer id, Book book){
        System.out.println("\n- Changing Title from Book #" + id + " -");
        System.out.print("\n- Enter new title: ");
        String title = input.nextLine();
        if (title != null && !title.equals(book.getTitle()) && !title.isEmpty()){
            book.setTitle(title);
            System.out.println("- Changed Title to Book #" + id + " -");
        }
        else{
            throw new BookException("Invalid title entered.");
        }
    }

    private void updateAuthor(Integer id, Book book){
        System.out.println("\n- Changing Author from Book #" + id + " -");
        System.out.print("\n- Enter new author: ");
        String author = input.nextLine();
        if (author != null && !author.equals(book.getAuthor()) && !author.isEmpty()){
            book.setAuthor(author);
            System.out.println("- Changed Author to Book #" + id + " -");
        }
        else{
            throw new BookException("Invalid name entered.");
        }

    }

    private void updateYear(Integer id, Book book){
        System.out.println("\n- Changing Year from Book #" + id + " -");
        System.out.print("\n- Enter new year: ");
        int year = input.nextInt();
        if (year != book.getYear() && year > 0){
            book.setYear(year);
        }
        else{
            throw new BookException("Invalid year entered.");
        }
    }

    private void updatePages(Integer id, Book book){
        System.out.println("\n- Changing Number of Pages from Book #" + id + " -");
        System.out.print("\n- Enter new number of pages: ");
        int pages = input.nextInt();
        if (pages != book.getNumberOfPages() && pages > 0){
            book.setNumberOfPages(pages);
        }
        else{
            throw new BookException("Invalid number of pages entered.");
        }
    }

    private void updateGenre(Integer id, Book book){
        System.out.println("\n- Changing Genre from Book #" + id + " -");
        System.out.print("\n- Enter new genre: ");
        String GenreStr = input.next();
        try{
            Genre genre = Genre.valueOf(GenreStr.toUpperCase());
            book.setGenre(genre);
        }
        catch (BookException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    }


