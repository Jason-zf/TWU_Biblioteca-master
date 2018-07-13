package com.twu.biblioteca;

import com.twu.biblioteca.core.Menu;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MenuTest {
    private Menu menu;

    @Before
    public void setUp() {
        menu = new Menu();
    }

    @Test
    public void should_only_return_List_Books_when_get_initial_main_menu() {
        ArrayList<String> names = menu.getMenuList();

        assertEquals(1, names.size());
        assertEquals("List Books", names.get(0));
    }

    @Test
    public void could_set_menu_list_based_on_your_need() {
        ArrayList<String> mNames = new ArrayList<String>();
        mNames.add("list 1");
        mNames.add("list 2");
        mNames.add("list 3");

        menu.setMenuList(mNames);
        assertEquals(mNames, menu.getMenuList());
    }

    @Test
    public void could_add_menu_based_on_your_need() {
        menu.addMenu("Quit");
        ArrayList<String> names = new ArrayList<String>();
        names.add("List Books");
        names.add("Quit");

        assertEquals(names, menu.getMenuList());
    }

    @Test
    public void should_print_menu_list_when_print() {
        String expectedStr = "1.List Books\r\n" +
                "\r\n" +
                "Choose one option with number or quit:";
        ByteArrayOutputStream systemOutContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(systemOutContent));
        menu.print();

        assertEquals(expectedStr, systemOutContent.toString());
    }
}
