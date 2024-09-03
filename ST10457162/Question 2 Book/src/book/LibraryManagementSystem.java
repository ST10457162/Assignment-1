/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package book;

/**
 *
 * @author Mahum
 */
import java.util.ArrayList;
import java.util.Scanner;

// Book class to represent the books in the library
class Book {
    private String bookID;
    private String title;
    private String author;
    private String genre;
    private int yearPublished;

    public Book(String bookID, String title, String author, String genre, int yearPublished) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.yearPublished = yearPublished;
    }

    public String getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookID + "\nTitle: " + title + "\nAuthor: " + author +
                "\nGenre: " + genre + "\nYear Published: " + yearPublished;
    }
}

public class LibraryManagementSystem {
    public static ArrayList<Book> books = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
        }
    }

    public static void displayMenu() {
        System.out.println("Library Management System");
        System.out.println("1. Add New Book");
        System.out.println("2. Search Book");
        System.out.println("3. View Book Report");
        System.out.println("4. Exit");
        System.out.print("Select an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        //W3Schools (n.d.). Java Switch. [online] www.w3schools.com. Available at: https://www.w3schools.com/java/java_switch.asp.
        switch (choice) {
            case 1:
                addNewBook();
                break;
            case 2:
                searchBook();
                break;
            case 3:
                viewBookReport();
                break;
            case 4:
                System.out.println("Exiting the application...");
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public static void addNewBook() {
        System.out.print("Enter Book ID: ");
        String bookID = scanner.nextLine();

        System.out.print("Enter Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Author: ");
        String author = scanner.nextLine();

        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine();

        System.out.print("Enter Year Published: ");
        int yearPublished = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        books.add(new Book(bookID, title, author, genre, yearPublished));
        System.out.println("Book details successfully saved.");
    }

    public static void searchBook() {
        System.out.print("Enter Book ID to search: ");
        String bookID = scanner.nextLine();
        
        //W3schools (2020). Java For Loop. [online] W3schools.com. Available at: https://www.w3schools.com/java/java_for_loop.asp.
        for (Book book : books) {
            if (book.getBookID().equals(bookID)) {
                System.out.println("Book Found:\n" + book);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public static void viewBookReport() {
        
        //W3Schools (n.d.). Java If ... Else. [online] www.w3schools.com. Available at: https://www.w3schools.com/java/java_conditions.asp.
        if (books.isEmpty()) {
            System.out.println("No books to display.");
        } else {
            System.out.println("Book Report:");
            for (Book book : books) {
                System.out.println(book + "\n");
            }
        }
    }
}
