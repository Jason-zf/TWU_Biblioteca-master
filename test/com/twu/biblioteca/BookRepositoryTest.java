package com.twu.biblioteca;

import com.twu.biblioteca.control.BookRepository;
import com.twu.biblioteca.core.Book;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BookRepositoryTest {
    private BookRepository bookRepository;

    @Before
    public void setUp() throws Exception {
        bookRepository = new BookRepository();
    }

    @Test
    public void should_return_all_books_when_get_books() {
        ArrayList<Book> expectedBooks = new ArrayList<Book>() {{
            add(new Book("book1", "zhangsan", 2000));
            add(new Book("book2", "lisi", 2005));
            add(new Book("book3", "wangwu", 2010));
        }};

        assertEquals(expectedBooks, bookRepository.getBooks());
    }

    @Test
    public void should_print_all_books_infor_when_print() {
        String expectedStr = "-----------------------------------------------------------------\n" +
                "|Number         |Name           |Author         |Year Published|\n" +
                "-----------------------------------------------------------------\n" +
                "|1              |book1          |zhangsan       |2000          |\n" +
                "|2              |book2          |lisi           |2005          |\n" +
                "|3              |book3          |wangwu         |2010          |\n" +
                "-----------------------------------------------------------------\n";
        ByteArrayOutputStream systemOutContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(systemOutContent));
        bookRepository.print();

        assertEquals(expectedStr, systemOutContent.toString());
    }

    @Test
    public void should_return_true_when_book_is_valid() {
        boolean flag = bookRepository.isValidBook("book1");

        assertTrue(flag);
    }

    @Test
    public void should_return_false_when_book_is_invalid() {
        boolean flag = bookRepository.isValidBook("book4");

        assertFalse(flag);
    }

    @Test
    public void should_return_book_when_get_valid_book() {
        Book book = new Book("book1", "zhangsan", 2000);

        assertEquals(book, bookRepository.getBook("book1"));
    }

    @Test
    public void should_return_null_when_get_invalid_book() {
        Book book = null;

        assertEquals(book, bookRepository.getBook("book4"));
    }
}