/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package book;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class LibraryManagementSystemTest {

    private LibraryManagementSystem lms;
    private Book book1;
    private Book book2;

    @Before
    public void setUp() {
        lms = new LibraryManagementSystem();
        book1 = new Book("B001", "1984", "George Orwell", "Dystopian", 1949);
        book2 = new Book("B002", "To Kill a Mockingbird", "Harper Lee", "Fiction", 1960);
        lms.books.add(book1);
        lms.books.add(book2);
    }

    @Test
    public void testAddNewBook() {
        int initialSize = lms.books.size();
        Book newBook = new Book("B003", "The Great Gatsby", "F. Scott Fitzgerald", "Classic", 1925);
        lms.books.add(newBook);
        assertEquals(initialSize + 1, lms.books.size());
        assertTrue(lms.books.contains(newBook));
    }

    @Test
    public void testSearchBook() {
        Book foundBook = null;
        for (Book book : lms.books) {
            if (book.getBookID().equals("B001")) {
                foundBook = book;
            }
        }
        assertNotNull(foundBook);
        assertEquals("1984", foundBook.getTitle());
    }

    @Test
    public void testViewBookReport() {
        assertEquals(2, lms.books.size());
        assertEquals("1984", lms.books.get(0).getTitle());
        assertEquals("To Kill a Mockingbird", lms.books.get(1).getTitle());
    }
}
