/*package ie.atu.serialization;

// Usage demonstration
public class Task6 {
    public static void main(String[] args) {
        try {
            // Create product with validation
            SecureProduct product = new SecureProduct("Laptop", 999.99);
            System.out.println("Original product: " + product);
            
            // Serialize with proper resource management
            File file = new File("resources/secure_product.ser");
            file.getParentFile().mkdirs(); // Ensure directory exists
            
            try (ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(file))) {
                out.writeObject(product);
                System.out.println("Product serialized securely");
            }
            
            // Deserialize with validation
            try (ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(file))) {
                SecureProduct loadedProduct = (SecureProduct) in.readObject();
                System.out.println("Deserialized product: " + loadedProduct);
            }
            
            // Demonstrate validation
            try {
                new SecureProduct(null, 100); // Should throw exception
            } catch (IllegalArgumentException e) {
                System.out.println("Validation caught invalid input: " + 
                                 e.getMessage());
            }
            
        } catch (Exception e) {
            System.err.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

*/
