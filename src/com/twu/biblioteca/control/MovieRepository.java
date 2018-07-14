package com.twu.biblioteca.control;

import com.twu.biblioteca.core.Movie;

import java.util.ArrayList;

public class MovieRepository extends Repository<Movie> {
    private ArrayList<Movie> movies = new ArrayList<>();

    public MovieRepository() {
        movies.add(new Movie("movie1", 2000, "zhangsan", "1"));
        movies.add(new Movie("movie2", 2005, "lisi", "5"));
        movies.add(new Movie("movie3", 2010, "wangwu", "unrated"));
        movies.add(new Movie("movie4", 2010, "wangwu", "9"));
        movies.get(2).setCheckedOut(true);
    }

    @Override
    public Movie getOne(String name) {
        for (int i = 0; i < movies.size(); ++i) {
            if (movies.get(i).getName().equals(name)) {
                return movies.get(i);
            }
        }
        return null;
    }

    @Override
    public ArrayList<Movie> getAll() {
        return movies;
    }

    @Override
    public boolean isValid(String name) {
        for (int i = 0; i < movies.size(); ++i) {
            if (movies.get(i).getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void print() {
        String res = "";
        String splitLine = "";
        for (int i = 0; i < 76; i++) {
            splitLine += "-";
        }
        res += splitLine + "\n" + String.format("%-15s %-15s %-15s %-15s %-15s", "|Number", "|Name", "|Year", "|Director", "|Rating") + "|\n" + splitLine + "\n";
        for (int i = 0; i < movies.size(); ++i) {
            Movie movie = movies.get(i);
            if (!movie.isCheckedOut()) {
                res += String.format("%-15s %-15s %-15s %-15s %-15s", "|" + String.valueOf(i + 1), "|" + movie.getName(), "|" + movie.getYear(), "|" + movie.getDirector(), "|" + movie.getRating()) + "|\n";
            }
        }
        res += splitLine + "\n";
        System.out.print(res);
    }
}
