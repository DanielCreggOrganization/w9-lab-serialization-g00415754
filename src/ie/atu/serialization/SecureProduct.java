package ie.atu.serialization;


import java.io.*;
import java.util.logging.Logger;

public class SecureProduct implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(SecureProduct.class.getName());
    
    private String name;
    private double price;
    private transient String secretKey;
    
    // Constructor with validation
    public SecureProduct(String name, double price) {
        validateInput(name, price);
        this.name = name;
        this.price = price;
        this.secretKey = generateKey();
    }
    
    private void validateInput(String name, double price) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
    }
    
    private String generateKey() {
        return java.util.UUID.randomUUID().toString();
    }
    
    // Custom serialization handling
    private void writeObject(ObjectOutputStream out) throws IOException {
        logger.info("Serializing product: " + name);
        out.defaultWriteObject();
    }
    
    private void readObject(ObjectInputStream in) 
            throws IOException, ClassNotFoundException {
        logger.info("Deserializing product");
        in.defaultReadObject();
        this.secretKey = generateKey(); // Regenerate transient data
        validateInput(name, price); // Revalidate after deserialization
    }
    
    @Override
    public String toString() {
        return "SecureProduct{name='" + name + "', price=" + price + 
               ", secretKey='" + secretKey + "'}";
    }
}