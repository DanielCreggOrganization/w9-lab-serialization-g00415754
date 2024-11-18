package ie.atu.serialization;

import java.io.Serializable;

public class Movie implements Serializable{
    private String title;
    private String director;
    private double rating;
    private int year;

    //constructor
    public Movie(String title, String director, double rating, int year){
        this.title = title;
        this.director = director;
        this.rating = rating;
        this.year = year;
    }

    @Override
    public String toString(){
        return "Movie{title='" + title + "', director='" + 
        director + "', year=" + year + "', rating=" + rating + "}";
    }
}
