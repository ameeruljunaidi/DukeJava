public class Main {
    public static void main(String[] args) {
        MovieRunnerAverage mra = new MovieRunnerAverage();
        mra.getAverageRatingOneMovie("data/ratedmoviesfull.csv", "data/ratings.csv");
    }
}
