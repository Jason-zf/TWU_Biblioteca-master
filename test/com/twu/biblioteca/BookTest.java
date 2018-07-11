package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class BookTest {
    private Book book;

    @Before
    public void setUp() {
        book = new Book("book1", "zhangsan", 2018, false);
    }

    @Test
    public void should_return_author_when_get_book_author() {
        String actualAuthor = book.getAuthor();
        String expectedAuthor = "zhangsan";

        assertEquals(expectedAuthor, actualAuthor);
    }

    @Test
    public void should_return_name_when_get_book_name() {
        String actualName = book.getName();
        String expectedName = "book1";

        assertEquals(expectedName, actualName);
    }

    @Test
    public void should_return_year_published_when_get_book_year_published() {
        Integer actualYearPublished = book.getYearPublished();
        Integer expectedYearPublished = 2018;

        assertEquals(expectedYearPublished, actualYearPublished);
    }

    @Test
    public void should_return_checkout_or_not_when_get_book_checkout_state() {
        boolean bookCheckOut = book.isCheckOut();

        assertFalse(bookCheckOut);
    }

}
