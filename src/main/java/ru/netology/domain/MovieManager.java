package ru.netology.domain;

public class MovieManager {
    private Movie[] movies = new Movie[0];
    private int lastMovies;

    public MovieManager() {
        lastMovies = 10;
    }

    public MovieManager(int lastMovies) {
        this.lastMovies = lastMovies;
    }

    public void add(Movie newMovie) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];

        System.arraycopy(movies, 0, tmp, 0, movies.length);

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = newMovie;
        movies = tmp;
    }

    public Movie[] showLastMovies() {
        int number = Math.min(lastMovies, movies.length);
        Movie[] resultMovies = new Movie[number];

        for (int i = 0; i < number; i++) {
            int index = movies.length - i - 1;
            resultMovies[i] = movies[index];
        } // переворачиваем массив
        return resultMovies;
    }
}
