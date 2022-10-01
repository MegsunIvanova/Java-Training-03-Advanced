package theme_09_IteratorsAndComaparators.Exercises.Demos;

import java.util.Comparator;

public class MovieCostComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie firstMovie, Movie secondMovie) {
        return firstMovie.getCost() - secondMovie.getCost();
    }
}
