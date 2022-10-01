package theme_09_IteratorsAndComaparators.Exercises.Demos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_ComparableAndComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Movie movie1 = new Movie("Harry Potter", 8, 15);
        Movie movie2 = new Movie("Lord of the Rings", 9, 16);
        Movie movie3 = new Movie("Astronaut", 7, 5);

        List<Movie> movies = new ArrayList<>();
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);

        MovieRatingComparator byRating = new MovieRatingComparator();
        MovieCostComparator byCost = new MovieCostComparator();

        Collections.sort(movies);
        System.out.println("sorted:");
        for (Movie movie : movies) {
            System.out.println(movie);
        }

        Collections.sort(movies, byRating.reversed());
        System.out.println("sorted by rating:");
        for (Movie movie : movies) {
            System.out.println(movie);
        }

        Collections.sort(movies, byCost);
        System.out.println("sorted by cost:");
        for (Movie movie : movies) {
            System.out.println(movie);
        }

        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("11");
        strings.add("511");
        strings.add("512");
        strings.add("514");

        Collections.sort(strings, new StringLengthComparator());
        System.out.println("Sorted strings with StringLengthComparator:");
        strings.forEach(System.out::println);

    }
}
