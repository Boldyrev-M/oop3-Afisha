package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AfishaRepositoryTest {
    @Test

    public void shouldAddNewMovie() {
        AfishaRepository repo = new AfishaRepository();
        Movie movie1 = new Movie(1, "Movie One", "Url1", "horror", "desc1");
        Movie movie2 = new Movie(2, "Movie Two", "Url2", "comedy", "desc2");
        Movie movie3 = new Movie(3, "Movie Three", "Url3", "trash", "desc3");

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
        AfishaRepository repo = new AfishaRepository();
        Movie movie1 = new Movie(1, "Movie One", "Url1", "horror", "desc1");
        Movie movie2 = new Movie(2, "Movie Two", "Url2", "comedy", "desc2");
        Movie movie3 = new Movie(3, "Movie Three", "Url3", "trash", "desc3");
        repo.save(movie1);
        repo.save(movie2);
        repo.save(movie3);
        repo.removeById(2);
        Movie[] actual = repo.findAll();
        Movie[] expected = new Movie[]{movie1, movie3};
        assertArrayEquals(expected, actual);
    }


}