/*
 * BankAccount
 * Assignment 10 - P11.09
 * Chapter 11
 *
 * @author Zhuo Guan
 * Implementing BankAccount class
 */
public class BankAccount {
    private int accountNumber = 0;
    private double balance = 0;

    public BankAccount(int accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int returnAccountNumber(){
        return accountNumber;
    }

    public double returnBalance(){
        return balance;
    }


}
