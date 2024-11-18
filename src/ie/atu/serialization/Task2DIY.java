package ie.atu.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Task2DIY {
    public static void main(String[] args) {
        Movie movie = new Movie("Java Fundamentals", "John Doe", 3.4, 2013);
    System.out.println("Original Movie: " + movie);

    //serialize
    try(FileOutputStream fileOut = new FileOutputStream("resources/movie.ser");
    ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
        out.writeObject(movie);
        System.out.println("Movie has been serialized.");
    }catch(IOException e){
        e.printStackTrace();
    }
    

    // Deserialize
    try(

    FileInputStream fileIn = new FileInputStream("resources/movie.ser");
    ObjectInputStream in = new ObjectInputStream(fileIn))
    {
        Movie deserializedMovie = (Movie) in.readObject();
        System.out.println("Movie has been deserialized");
        System.out.println("Deserialized Movie: " + deserializedMovie);
    }catch(IOException|
    ClassNotFoundException e)
    {
        e.printStackTrace();
    }
    }
}
