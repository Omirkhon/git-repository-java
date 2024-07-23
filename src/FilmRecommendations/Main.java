package FilmRecommendations;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Main {
    public static TreeMap<Integer, Movie> movieTreeMap = new TreeMap<>();
    public static TreeMap<Integer, User> userTreeMap = new TreeMap<>();

    public static void main(String[] args) {
        movieTreeMap.put(1, new Movie(1, "The Shawshank Redemption", "Drama",
                "Tim Robbins", "Morgan Freeman", "Frank Darabont"));
        movieTreeMap.put(2, new Movie(2, "The Dark Knight", "Action",
                "Christian Bale", "Heath Ledger", "Christopher Nolan"));
        movieTreeMap.put(3, new Movie(3, "Inception", "Sci-Fi",
                "Leonardo DiCaprio", "Joseph Gordon-Levitt", "Christopher Nolan"));
        movieTreeMap.put(4, new Movie(4, "The Godfather", "Drama",
                "Marlon Brando", "Al Pacino", "Francis Ford Coppola"));

        userTreeMap.put(1, new User(1, "John Doe", movieTreeMap.get(1), movieTreeMap.get(2)));
        recommendMovies(1, 3);
    }

    public static void recommendMovies(int userId, int maxRecommendations) {
        for (Integer movie : movieTreeMap.keySet()) {
            for (Movie watchedMovie : userTreeMap.get(userId).watchedMovies) {
                if (watchedMovie.title.equals(movieTreeMap.get(movie).title)) {
                    continue;
                }
                Movie currentMovie = movieTreeMap.get(movie);
                if (watchedMovie.genre.equals(currentMovie.genre)
                        || watchedMovie.actors.containsAll(currentMovie.actors)
                        || watchedMovie.director.equals(currentMovie.director)) {
                    System.out.println("id: " + movie + ", title: " + currentMovie.title);
                }
            }
        }
    }
}

class Movie {
    int id;
    String title;
    String genre;
    List<String> actors = new ArrayList<>();
    String director;

    public Movie(int id, String title, String genre, String actor1, String actor2, String director) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        actors.add(actor1);
        actors.add(actor2);
        this.director = director;
    }
}

class User {
    int id;
    String name;
    List<Movie> watchedMovies = new ArrayList<>();

    public User(int id, String name, Movie movie, Movie movie2) {
        this.id = id;
        this.name = name;
        watchedMovies.add(movie);
        watchedMovies.add(movie2);
    }
}
