public class Main {
    public static void main(String[] args) {
        MovieRunWithFilters mrf = new MovieRunWithFilters();
        mrf.printAverageRatingsByDirectorsAndMinutes("ratedmoviesfull.csv", "data/ratings.csv", 3,
                "Clint Eastwood,Joel Coen,Tim Burton,Ron Howard,Nora Ephron,Sydney Pollack", 90, 180);
    }
}
