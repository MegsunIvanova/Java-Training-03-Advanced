package theme_09_IteratorsAndComaparators.Exercises.Demos;

import java.util.Comparator;

public class MovieRatingComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie firstMovie, Movie secondMovie) {
        return firstMovie.getRating() - secondMovie.getRating();
      //  return Integer.compare(firstMovie.getRating(), secondMovie.getRating());

    }
}
