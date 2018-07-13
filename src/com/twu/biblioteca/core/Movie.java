package com.twu.biblioteca.core;

public class Movie {
    private String name;
    private Integer year;
    private String director;
    private String rating;
    private Boolean checkedOut = false;

    public Movie(String name, Integer year, String director, String rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public Integer getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public String getRating() {
        return rating;
    }

    public Boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(Boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
}
