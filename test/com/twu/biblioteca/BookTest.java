package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

        assertTrue(!actualAuthor.isEmpty());
        assertEquals(expectedAuthor, actualAuthor);
    }

    @Test
    public void should_return_name_when_get_book_name() {
        String actualName = book.getName();
        String expectedName = "book1";

        assertTrue(!actualName.isEmpty());
        assertEquals(expectedName, actualName);
    }

    @Test
    public void should_return_year_published_when_get_book_year_published() {
        Integer actualYearPublished = book.getYearPublished();
        Integer expectedYearPublished = 2018;

        assertTrue(actualYearPublished != 0);
        assertEquals(expectedYearPublished, actualYearPublished);
    }

    @Test
    public void should_return_checkedOut_or_not_when_get_book_checkedOut_state() {
        boolean bookCheckedOut = book.isCheckedOut();

        assertFalse(bookCheckedOut);
    }

}
