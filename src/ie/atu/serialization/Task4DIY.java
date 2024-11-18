package ie.atu.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Task4DIY {
    public static void main(String[] args) {
        BankAccount bank1 = new BankAccount("1632fbvjfbl", "John Doe", 20567, "1234");
        
        System.out.println("Original User: " + bank1);
        
        // Serialize
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("resources/bank.ser"))) {
            out.writeObject(bank1);
            System.out.println("Bank Account has been serialized");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Deserialize
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("resources/bank.ser"))) {
            BankAccount deserializedBank = (BankAccount) in.readObject();
            System.out.println("Bank Account has been deserialized");
            System.out.println("Deserialized Bank Account: " + deserializedBank);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
