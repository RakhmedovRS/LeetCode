package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-09-20
 */
@LeetCode(
        id = 1912,
        name = "Design Movie Rental System",
        url = "https://leetcode.com/problems/design-movie-rental-system/description/",
        difficulty = Difficulty.HARD
)
public class DesignMovieRentalSystem {
    class Movie implements Comparable<Movie> {
        int shop;
        int id;
        int price;
        boolean available;

        public Movie(int shop, int id, int price) {
            this.shop = shop;
            this.id = id;
            this.price = price;
        }

        @Override
        public int compareTo(Movie movie) {
            if (price == movie.price) {
                if (shop == movie.shop) {
                    return id - movie.id;
                } else {
                    return shop - movie.shop;
                }
            }
            return price - movie.price;
        }
    }

    class MovieRentingSystem {

        Map<Integer, Map<Integer, Movie>> freeMovie;
        Map<Integer, Map<Integer, Movie>> rentedMovie;
        TreeSet<Movie> availableMovies;
        TreeSet<Movie> rentedMovies;
        TreeSet<Movie> dummy;
        Map<Integer, TreeSet<Movie>> sortedMovies;

        public MovieRentingSystem(int n, int[][] entries) {
            freeMovie = new HashMap<>();
            rentedMovie = new HashMap<>();
            availableMovies = new TreeSet<>();
            rentedMovies = new TreeSet<>();
            dummy = new TreeSet<>();
            sortedMovies = new HashMap<>();
            for (int[] entry : entries) {
                Movie movie = new Movie(entry[0], entry[1], entry[2]);
                freeMovie.computeIfAbsent(movie.shop, M -> new HashMap<>()).put(movie.id, movie);
                availableMovies.add(movie);

                sortedMovies.computeIfAbsent(movie.id, M -> new TreeSet<>()).add(movie);
            }
        }

        public List<Integer> search(int movie) {
            List<Integer> result = new ArrayList<>();
            for (Movie MOVIE : sortedMovies.getOrDefault(movie, dummy)) {
                if (result.size() == 5) {
                    break;
                }
                result.add(MOVIE.shop);
            }
            return result;
        }

        public void rent(int shop, int movie) {
            Movie rented = freeMovie.get(shop).remove(movie);
            rented.available = false;
            availableMovies.remove(rented);
            rentedMovies.add(rented);
            sortedMovies.get(rented.id).remove(rented);

            rentedMovie.computeIfAbsent(rented.shop, M -> new HashMap<>()).put(rented.id, rented);
        }

        public void drop(int shop, int movie) {
            Movie returned = rentedMovie.get(shop).remove(movie);
            returned.available = true;
            availableMovies.add(returned);
            rentedMovies.remove(returned);
            sortedMovies.get(returned.id).add(returned);

            freeMovie.get(shop).put(movie, returned);
        }

        public List<List<Integer>> report() {
            List<List<Integer>> result = new ArrayList<>();
            for (Movie movie : rentedMovies) {
                if (result.size() == 5) {
                    break;
                }
                result.add(Arrays.asList(movie.shop, movie.id));
            }
            return result;
        }
    }
}