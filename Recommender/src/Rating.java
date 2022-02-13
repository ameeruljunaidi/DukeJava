// An immutable passive data object (PDO) to represent the rating data
public class Rating implements Comparable<Rating> {
    private String movieId;
    private double movieRating;

    public Rating(String anItem, double aValue) {
        movieId = anItem;
        movieRating = aValue;
    }

    // Returns item being rated
    public String getMovieId() {
        return movieId;
    }

    // Returns the value of this rating (as a number so it can be used in calculations)
    public double getMovieRating() {
        return movieRating;
    }

    // Returns a string of all the rating information
    public String toString() {
        return "[" + getMovieId() + ", " + getMovieRating() + "]";
    }

    public int compareTo(Rating other) {
        if (movieRating < other.movieRating) return -1;
        if (movieRating > other.movieRating) return 1;

        return 0;
    }
}
