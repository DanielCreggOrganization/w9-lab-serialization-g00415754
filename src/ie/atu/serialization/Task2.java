package ie.atu.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class Task2 {
    public static void main(String[] args) {
        
        Book book = new Book("Java Fundamentals", "John Doe", 29.99);
        System.out.println("Original Book: " + book);

        //serialize
        try(FileOutputStream fileOut = new FileOutputStream("resources/book.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(book);
            System.out.println("Book has been serialized.");
        }catch(IOException e){
            e.printStackTrace();
        }

        //deserialize
        try (FileInputStream fileIn = new FileInputStream("resources/book.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            Book deserializedBook = (Book) in.readObject();
            System.out.println("Book has been deserialized");
            System.out.println("Deserialized Book: " + deserializedBook);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
