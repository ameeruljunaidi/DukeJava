import java.util.Collections;
import java.util.List;

public class MovieRunnerAverage {
    public void printAverageRatings(String moviefile, String ratingfile) {
        SecondRatings sr = new SecondRatings(moviefile, ratingfile);

        // Print the number of movies and number of raters from the files
        System.out.println("Number of movies " + sr.getMovieSize());
        System.out.println("Number of raters " + sr.getRaterSize());

        // Print list of movies and their average ratings, sorted by averages
        // Per line: ratings (lowest to highest), title
        int threshold = 50;
        List<Rating> ratings = sr.getAverageRatings(threshold);
        System.out.println(ratings.size() + " movies has " + threshold + " or more ratings.");
        Collections.sort(ratings);
        for (Rating rating : ratings) {
            System.out.println(rating.getMovieRating() + " " + sr.getTitle(rating.getMovieId()));
        }
    }

    public void getAverageRatingOneMovie(String moviefile, String ratingfile) {
        SecondRatings sr = new SecondRatings(moviefile, ratingfile);

        // Print out the average ratings for a specific movie title
        String movieTitle = "Moneyball";
        List<Rating> ratings = sr.getAverageRatings(0);
        for (Rating rating : ratings) {
            if (rating.getMovieId().equals(sr.getID(movieTitle))) {
                System.out.println("Average rating for " + movieTitle + " is " + rating.getMovieRating());
            }
        }
    }

}
