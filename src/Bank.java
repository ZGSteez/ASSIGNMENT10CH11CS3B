/*
 * Bank
 * Assignment 10 - P11.09
 * Chapter 11
 *
 * @author Zhuo Guan
 * Implementing Bank class
 */
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bank {
    private static boolean status = true;
    private ArrayList<BankAccount> accounts = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private File fileName;
    private boolean classStatus = status;

    /**
     * Reads the file
     * @throws FileNotFoundException
     */
    public void readFile() throws FileNotFoundException {

        while (!fileName.exists()) {
            try {
                if (!fileName.exists()) {
                    throw new FileNotFoundException("Error: file not found");
                }
            } catch (FileNotFoundException e) {
                System.out.print("Error: file not found. Enter alternative filename: ");
                String newFilename = scanner.nextLine();
                fileName = new File(newFilename);
            }
        }
        Scanner input = new Scanner(fileName);

        double highestBalance = 0;
        int accountNumber = 0;
        double balance = 0;
        int account = 0;

        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] values = line.split(" ");

            while (values.length != 2) {
                try {
                    throw new FileNotFoundException("Error: incorrect format");
                } catch (FileNotFoundException e) {

                    if (status) {
                        System.out.print("Error: incorrect format. Enter alternative filename: ");
                        String newFilename = scanner.nextLine();
                        fileName = new File(newFilename);
                    }
                    status = false;
                    readFile();
                    System.exit(0);
                }
            }

            accounts.add(new BankAccount(account,balance));

            if (highestBalance < (Double.parseDouble(values[1]))) {
                accountNumber = Integer.parseInt(values[0]);
                highestBalance = Double.parseDouble(values[1]);
            }
        }
        input.close();

        if (classStatus)
            System.out.print("ID # with largest bank account balance: ");
        System.out.println(accountNumber + " , " + "$" + highestBalance);
    }

    /**
     * Allows user to pick if they want to read from default file or one of their choosing
     */
    public void choice(){
        Scanner newScanner = new Scanner(System.in);
        System.out.print("Do you want to test file for improper format? ");
        char pick = newScanner.next().charAt(0);
        if (pick == 'Y' || pick == 'y'){
            fileName = new File("src/bankAccountError");
        }

        else{
            fileName = new File("src/bankAccounts");
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Bank bank = new Bank();
        bank.choice();
        bank.readFile();
    }
}


//    Design a class Bank that contains a number of bank accounts. Each account has an
//        account number and a current balance. Add an accountNumber field to the BankAccount
//class. Store the bank accounts in an array list. Write a readFile method of the Bank
//class for reading a file with the format
//        accountNumber1 balance1
//        accountNumber2 balance2
//        ...
//        Implement read methods for the Bank and BankAccount classes. Write a sample program
//        to read in a file with bank accounts, then print the account with the highest balance.
//        If the file is not properly formatted, give the user a chance to select another file.


/*
Sample Run # 1
Do you want to test file for improper format? y
Error: incorrect format. Enter alternative filename: src/banks
Error: file not found. Enter alternative filename: src/bankAccounts
ID # with largest bank account balance: 529503 , $99289.55

Process finished with exit code 0
 */


/*
Sample Run # 2
Do you want to test file for improper format? n
ID # with largest bank account balance: 529503 , $99289.55

Process finished with exit code 0
 */

/*
Sample Run # 3
Do you want to test file for improper format? y
Error: incorrect format. Enter alternative filename: src/bankAccounts2
ID # with largest bank account balance: 3902802 , $498439.0

Process finished with exit code 0
 */