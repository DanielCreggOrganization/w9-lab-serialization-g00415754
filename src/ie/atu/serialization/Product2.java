/*package ie.atu.serialization;

// File: Product.java - Version 2 (with new field)
public class Product implements Serializable {
    private static final long serialVersionUID = 2L; // Changed version
    
    private String name;
    private double price;
    private String category; // New field
    
    public Product(String name, double price) {
        this(name, price, "Uncategorized");
    }
    
    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    
    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + 
               ", category='" + category + "'}";
    }
}
*/