package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BibliotecaTest {
    private Biblioteca biblioteca;
    private ByteArrayOutputStream systemOutContent;
    private ByteArrayOutputStream systemErrorContent;

    private InputStream setSystemInContent(String inContent) {
        InputStream systemInContent = new ByteArrayInputStream(inContent.getBytes());
        System.setIn(systemInContent);
        return System.in;
    }

    @Before
    public void setUp() {
        biblioteca = new Biblioteca();
        systemOutContent = new ByteArrayOutputStream();
        systemErrorContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(systemOutContent));
        System.setErr(new PrintStream(systemErrorContent));
        setSystemInContent("1");
    }


    @Test
    public void should_return_welcome_when_first_start() {
        biblioteca.start();
        String expectedStr = "\r\nWelcome to the Biblioteca library!\r\n";

        assertTrue(systemErrorContent.toString().isEmpty());
        assertFalse(systemOutContent.toString().isEmpty());
        assertTrue(systemOutContent.toString().startsWith(expectedStr));
    }

    @Test
    public void should_return_list_books_after_welcome_message() {
        biblioteca.start();
        String expectedStr = "-----------------------------------------------------------------\n" +
                "|Number         |Name           |Author         |Year Published|\n" +
                "-----------------------------------------------------------------\n" +
                "|1              |book1          |zhangsan       |2000          |\n" +
                "|2              |book2          |lisi           |2005          |\n" +
                "|3              |book3          |wangwu         |2010          |\n" +
                "-----------------------------------------------------------------\n";

        assertTrue(systemErrorContent.toString().isEmpty());
        assertFalse(systemOutContent.toString().isEmpty());
        assertTrue(systemOutContent.toString().contains(expectedStr));
    }

    @Test
    public void should_contain_book_list_menu_instead_of_automatically() {
        biblioteca.start();

        String expectedStr = "List Books";
        assertTrue(systemErrorContent.toString().isEmpty());
        assertFalse(systemOutContent.toString().isEmpty());
        assertTrue(systemOutContent.toString().contains(expectedStr));
    }

    @Test
    public void should_judge_invalid_option() {
        setSystemInContent("2\n1\n");
        biblioteca.start();

        String expectedStr = "Select a valid option!";
        assertTrue(systemErrorContent.toString().isEmpty());
        assertFalse(systemOutContent.toString().isEmpty());
        assertTrue(systemOutContent.toString().contains(expectedStr));
    }
}
