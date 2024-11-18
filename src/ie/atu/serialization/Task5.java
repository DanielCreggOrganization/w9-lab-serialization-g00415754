package ie.atu.serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task5 {
    public static void main(String[] args) {
        // Version 1: Create and serialize products
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 999.99));
        products.add(new Product("Mouse", 29.99));
        
        System.out.println("Original Products (Version 1):");
        products.forEach(System.out::println);
        
        // Serialize version 1
        serializeProducts(products, "resources/products_v1.ser");
        
        // Simulate code update by using Product class version 2
        System.out.println("\nAttempting to deserialize with Version 2 class...");
        deserializeProducts("resources/products_v1.ser");
    }
    
    private static void serializeProducts(List<Product> products, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(filename))) {
            out.writeObject(products);
            System.out.println("\nProducts have been serialized");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void deserializeProducts(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(filename))) {
            List<Product> loadedProducts = (List<Product>) in.readObject();
            System.out.println("Products have been deserialized");
            loadedProducts.forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
