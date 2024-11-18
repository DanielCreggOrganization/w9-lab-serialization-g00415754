package ie.atu.serialization;

import java.io.Serializable;

public class BankAccount implements Serializable{
     private String accountNumber;
     private String accountHolder;
     private double balance;
     private transient String pin;
     //private transient Date lastAccessTime;

     public BankAccount(String accountNumber, String accountHolder, double balance, String pin){
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.pin = pin;
     }

     public double depositMoney(int depositAmount){
        balance += depositAmount;
        return balance;
     }

     public double withdrawMoney(int pin, int withdrawAmount){
        //if(pin == 1234){
            balance -= withdrawAmount;
            return balance;
        //}
     }

     public double checkBalance(){
        return balance;
     }

     /*public int updatePin(int pin){

     }

@Override
public String toString() {
    return String.format("Account{accountNumber='%s', accountHolder='%s', " +
                       "balance=%d, pin='%s'}", 
                       accountNumber, accountHolder, balance, pin);
}
                       */
}
