import java.util.ArrayList;
import java.util.List;

public class SecondRatings {
    private final List<Movie> myMovies;
    private final List<PlainRater> myPlainRaters;

    public SecondRatings(String moviefile, String ratingsfile) {
        FirstRatings fr = new FirstRatings();
        this.myMovies = fr.loadMovies(moviefile);
        this.myPlainRaters = fr.loadRaters(ratingsfile);
    }

    public SecondRatings() {
        // default constructor
        this("ratedmoviesfull.csv", "ratings.csv");
    }

    public int getMovieSize() {
        return this.myMovies.size();
    }

    public int getRaterSize() {
        return this.myPlainRaters.size();
    }

    public String getTitle(String movieId) {
        for (Movie movie : this.myMovies) if (movie.getID().equals(movieId)) return movie.getTitle();
        return "Movie not found.";
    }

    public String getID(String title) {
        for (Movie movie : this.myMovies) if (movie.getTitle().equals(title)) return movie.getID();
        return "NO SUCH TITLE.";
    }

    /**
     * @param movieId the id of the movie
     * @param minimalRaters the minimum number of raters to consider this rating
     * @return the average if minimalRaters is met
     */
    private double getAverageByID(String movieId, int minimalRaters) {
        int ratingCount = 0;
        double average = 0;

        for (PlainRater plainRater : this.myPlainRaters) {
            if (plainRater.hasRating(movieId)) {
                ratingCount++;
                average += plainRater.getRating(movieId);
            }
        }

        if (ratingCount >= minimalRaters) return average / ratingCount;
        else return 0.0;
    }

    /**
     * find the average rating for every movie that has been rated by at least minimalRaters raters
     * Store each rating in a Rating object in which the movie ID and the average rating are used in creating the object
     *
     * @param minimalRaters the minimum threshold amount of raters
     * @return list of Ratings
     */
    public List<Rating> getAverageRatings(int minimalRaters) {
        List<Rating> averageRatings = new ArrayList<>();

        for (Movie movie : this.myMovies) {
            Rating addRating = new Rating(movie.getID(), getAverageByID(movie.getID(), minimalRaters));
            if (addRating.getMovieRating() != 0.0) averageRatings.add(addRating);
        }

        return averageRatings;
    }
}
