package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BibliotecaTest {
    private Biblioteca biblioteca;
    private ByteArrayOutputStream systemOutContent;
    private ByteArrayOutputStream systemErrorContent;


    @Before
    public void setUp() {
        biblioteca = new Biblioteca();
        systemOutContent = new ByteArrayOutputStream();
        systemErrorContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(systemOutContent));
        System.setErr(new PrintStream(systemErrorContent));
    }

    @Test
    public void should_return_welcome_when_first_start() {
        biblioteca.start();
        String expectedStr = "Welcome to the Biblioteca library!";

        assertTrue(systemErrorContent.toString().isEmpty());
        assertFalse(systemOutContent.toString().isEmpty());
        assertTrue(systemOutContent.toString().startsWith(expectedStr));
    }

    @Test
    public void should_return_list_books_after_welcome_message() {
        biblioteca.start();
        String expectedStr ="------------------------------------------------\n" +
                "|Name           |Author         |Year Published|\n" +
                "------------------------------------------------\n" +
                "|book1          |zhangsan       |2000          |\n" +
                "|book2          |lisi           |2005          |\n" +
                "|book3          |wangwu         |2010          |\n" +
                "------------------------------------------------";

        assertTrue(systemErrorContent.toString().isEmpty());
        assertFalse(systemOutContent.toString().isEmpty());
        assertTrue(systemOutContent.toString().contains(expectedStr));
    }
}
