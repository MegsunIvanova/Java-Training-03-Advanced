package theme_09_IteratorsAndComaparators.Exercises.Demos;

public class Movie implements Comparable<Movie> {
    private String name;
    private int rating;
    private int cost;

    public Movie(String name, int rating, int cost) {
        this.name = name;
        this.rating = rating;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public int compareTo(Movie anotherMovie) {
        return this.getName().compareTo(anotherMovie.getName());
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                ", cost=" + cost +
                '}';
    }
}
