package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AfishaRepositoryTest {
    AfishaRepository repo = new AfishaRepository();
    Movie movie1 = new Movie(1, "Movie One", "Url1", "horror", "desc1");
    Movie movie2 = new Movie(2, "Movie Two", "Url2", "comedy", "desc2");
    Movie movie3 = new Movie(3, "Movie Three", "Url3", "trash", "desc3");


    @Test
    public void shouldAddNewMovie() {

        repo.save(movie1);
        Movie[] actual = repo.findAll();
        Movie[] expected = new Movie[]{movie1};
        assertArrayEquals(expected, actual);
        repo.save(movie2);
        actual = repo.findAll();
        expected = new Movie[]{movie1, movie2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldRemoveMovie() {
        repo.save(movie1);
        repo.save(movie2);
        repo.save(movie3);
        repo.removeById(2);
        Movie[] actual = repo.findAll();
        Movie[] expected = new Movie[]{movie1, movie3};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAll() {
        repo.removeAll();
        Movie[] actual = repo.findAll();
        Movie[] expected = new Movie[]{};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById(){
        repo.save(movie1);
        repo.save(movie2);
        repo.save(movie3);
        Movie actual = repo.findById(2);
        Movie expected = movie2;
        assertEquals(expected, actual);
    }
    @Test
    public void shouldNotFindById(){
        repo.save(movie1);
        repo.save(movie2);
        repo.save(movie3);
        Movie actual = repo.findById(4);
        Movie expected = null;
        assertEquals(expected, actual);
    }
}


