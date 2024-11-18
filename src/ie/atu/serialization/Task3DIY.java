// File: Main.java
package ie.atu.serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task3DIY {
    public static void main(String[] args) {
        List<Movie> Movies = new ArrayList<>();
        Movies.add(new Movie("The Hobbit", "J.R.R. Tolkien", 4.7, 2009));
        Movies.add(new Movie("1984", "George Orwell", 8.9, 2019));
        Movies.add(new Movie("Pride and Prejudice", "Jane Austen", 9.0, 2021));
        
        System.out.println("Original catalog:");
        Movies.forEach(System.out::println);
        
        // Serialize list
        serializeMovies(Movies, "resources/libraryMovies.ser");
        
        // Deserialize list
        List<Movie> loadedMovies = deserializeMovies("resources/libraryMovies.ser");
        
        System.out.println("\nDeserialized catalog:");
        loadedMovies.forEach(System.out::println);
    }
    
    private static void serializeMovies(List<Movie> Movies, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(filename))) {
            out.writeObject(Movies);
            System.out.println("\nCatalog has been serialized");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static List<Movie> deserializeMovies(String filename) {
        List<Movie> Movies = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(filename))) {
            Movies = (List<Movie>) in.readObject();
            System.out.println("Catalog has been deserialized");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Movies;
    }
}

