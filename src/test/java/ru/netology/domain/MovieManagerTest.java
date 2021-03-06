package ru.netology.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {
    MovieManager testManager = new MovieManager();
    Movie movie1 = new Movie(1, "Movie One", "Url1", "horror", "desc1");
    Movie movie2 = new Movie(2, "Movie Two", "Url2", "comedy", "desc2");
    Movie movie3 = new Movie(3, "Movie Three", "Url3", "trash", "desc3");

    @BeforeEach
    void setUpManager() {
        testManager.add(movie1);
        testManager.add(movie2);
        testManager.add(movie3);
    }

//    @Test
//    public void shouldAddMovies() {
//
//    }

    @Test
    public void showAddedMovies() {
        Movie[] actual = testManager.showLastMovies(2);
        Movie[] expected = new Movie[]{movie3, movie2};
        assertArrayEquals(expected, actual);

        actual = testManager.showLastMovies();
        expected = new Movie[]{movie3, movie2, movie1};
        assertArrayEquals(expected, actual);

        actual = testManager.showLastMovies(1);
        expected = new Movie[]{movie3};
        assertArrayEquals(expected, actual);

        actual = testManager.showLastMovies(155);
        expected = new Movie[]{movie3, movie2, movie1};
        assertArrayEquals(expected, actual);
    }


}