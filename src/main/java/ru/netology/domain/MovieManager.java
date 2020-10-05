package ru.netology.domain;

public class MovieManager {
    private Movie[] movies = new Movie[0];

    public void add(Movie newMovie) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];

        //        for (int i = 0; i < movies.length; i++) {
        //            tmp[i] = movies[i];
        //        }
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        //               ^source           ^destination   ^how many

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = newMovie;
        movies = tmp;
    }

    public Movie[]  showLastMovies() {
        return showLastMovies(10);
    }

    public Movie[] showLastMovies(int number) {

//        if (number < movies.length)
        number = Math.min(number, movies.length);
        Movie[] resultMovies = new Movie[number];

        for (int i = 0; i < number; i++) {
            int index = movies.length - i - 1;
            resultMovies[i] = movies[index];
        } // переворачиваем массив
        return resultMovies;
    }
}
