package com.twu.biblioteca.core;

import java.util.ArrayList;

public class Menu {
    private ArrayList<String> menuList = new ArrayList<String>();

    public Menu() {
        menuList.add("List Books");
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
}
