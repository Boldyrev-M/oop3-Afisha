package ru.netology.domain;


public class AfishaManager {

    private AfishaRepository repository;
    private int showLast = 10;

    public AfishaManager(){

    }
    public AfishaManager(AfishaRepository repo) {
        this.repository = repo;
    }
    public AfishaManager(AfishaRepository repo, int number) {
        this.repository = repo;
        showLast = number;
    }

    public void add(Movie newMovie) {
        repository.save(newMovie);
    }

    public Movie[] showLastMovies() {
        Movie[] allMovies = repository.findAll();

        int number = Math.min(showLast, allMovies.length);
        Movie[] resultMovies = new Movie[number];

        for (int i = 0; i < number; i++) {
            int index = allMovies.length - i - 1;
            resultMovies[i] = allMovies[index];
        } // переворачиваем массив
        return resultMovies;
    }
}
