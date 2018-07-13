package com.twu.biblioteca;

import com.twu.biblioteca.core.Movie;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MovieTest {
    private Movie movie;

    @Before
    public void setUp() throws Exception {
        movie = new Movie("movie1", 2000, "zhangsan", "1");
    }

    @Test
    public void should_return_name_when_get_name() {
        String expectedStr = "movie1";

        assertFalse(movie.getName().isEmpty());
        assertEquals(expectedStr, movie.getName());
    }

    @Test
    public void should_return_year_when_get_year() {
        Integer expectedYear = 2000;

        assertFalse(movie.getName().isEmpty());
        assertEquals(expectedYear, movie.getYear());
    }

    @Test
    public void should_return_director_when_get_director() {
        String expectedStr = "zhangsan";

        assertFalse(movie.getName().isEmpty());
        assertEquals(expectedStr, movie.getDirector());
    }

    @Test
    public void should_return_rating_when_get_rating() {
        String expectedStr = "1";

        assertFalse(movie.getName().isEmpty());
        assertEquals(expectedStr, movie.getRating());
    }

    @Test
    public void should_return_movie_checkedOut_or_not_when_get_checkedOut() {
        Boolean movieCheckedOut = false;

        assertEquals(movieCheckedOut, movie.isCheckedOut());
    }

    @Test
    public void could_change_checkedOut_state_based_on_your_need() {
        assertFalse(movie.isCheckedOut());

        movie.setCheckedOut(true);

        assertTrue(movie.isCheckedOut());
    }
}
