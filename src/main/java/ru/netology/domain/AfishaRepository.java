package ru.netology.domain;

public class AfishaRepository {
    private Movie[] movies = new Movie[0];

    public Movie[] findAll() {
        return movies;
    }

    public void save(Movie newMovie) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        //               ^source           ^destination   ^how many

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = newMovie;
        movies = tmp;

    }

    public Movie findById(int id) {
        for (Movie item : movies) {
            if (item.getId() == id) {
                return item;
            }
        }
         return null;
    }

    public void removeById(int id) {
        Movie[] tmp = new Movie[movies.length - 1];
        int index = 0;
        for (Movie item : movies) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        movies = tmp;
    }

    public void removeAll() {
        Movie[] emptyOne = new Movie[0];
        movies = emptyOne;

    }
}

