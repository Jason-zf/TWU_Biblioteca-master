package com.twu.biblioteca.control;

import java.util.ArrayList;

public abstract class Repository<T> {

    public abstract void print();

    public abstract boolean isValid(String name);

    public abstract T getOne(String name);

    public abstract ArrayList<T> getAll();
}
