
/**
 * Write a description of class Rater here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Rater {
    private String myID;
    private ArrayList<Rating> myRatings;

    public Rater(String id) {
        myID = id;
        myRatings = new ArrayList<Rating>();
    }

    public boolean equals(Rater other) {
        return this.myID.equals(other.getID());
    }

    public void addRating(String item, double rating) {
        myRatings.add(new Rating(item,rating));
    }

    public boolean hasRating(String movieId) {
        for(int k=0; k < myRatings.size(); k++){
            if (myRatings.get(k).getMovieId().equals(movieId)){
                return true;
            }
        }
        
        return false;
    }

    public String getID() {
        return myID;
    }

    public double getRating(String movieId) {
        for(int k=0; k < myRatings.size(); k++){
            if (myRatings.get(k).getMovieId().equals(movieId)){
                return myRatings.get(k).getMovieRating();
            }
        }
        
        return -1;
    }

    public int numRatings() {
        return myRatings.size();
    }

    public ArrayList<String> getMoviesRated() {
        ArrayList<String> list = new ArrayList<>();
        for(int k=0; k < myRatings.size(); k++){
            list.add(myRatings.get(k).getMovieId());
        }
        
        return list;
    }

    public String toString() {
        StringBuilder toString = new StringBuilder();
        toString.append("Rater ID: ").append(this.myID).append(", Ratings: ");
        for (Rating rating : this.myRatings) toString.append(" ").append(rating).append(" ");
        return toString.toString();
    }
}
