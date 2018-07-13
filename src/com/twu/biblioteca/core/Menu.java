package com.twu.biblioteca.core;

import java.util.ArrayList;

public class Menu {
    private ArrayList<String> menuList = new ArrayList<String>();

    public Menu() {
        menuList.add("List Books");
        menuList.add("List Movies");
    }

    public Menu(ArrayList<String> menuList) {
        this.menuList = menuList;
    }

    public ArrayList<String> getMenuList() {
        return menuList;
    }

    public void setMenuList(ArrayList<String> menuList) {
        this.menuList = menuList;
    }

    public void addMenu(String menuName) {
        menuList.add(menuName);
    }

    public void print() {
        for (int i = 0; i < menuList.size(); ++i) {
            System.out.print(String.valueOf(i + 1) + ".");
            System.out.println(menuList.get(i));
        }
        System.out.println();

        System.out.print("Choose one option with number or quit:");
    }
}
