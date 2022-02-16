// An immutable passive data object (PDO) to represent the rating data
public class Rating implements Comparable<Rating> {
    private final String movieId;
    private final double movieRating;

    public Rating(String movieId, double movieRating) {
        this.movieId = movieId;
        this.movieRating = movieRating;
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
        return Double.compare(movieRating, other.movieRating);
    }
}
