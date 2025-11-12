package Saiket_Internship.Task6;

import java.util.ArrayList; //  A dynamic array to store multiple transaction history and accounts
import java.util.Scanner;   //  Used to take user input from the keyboard.

public class BasicBankingSystem
{
    // Scanner → reads user input (keyboard).
    static Scanner sc = new Scanner(System.in);

    // ANSI color codes for colorful console output
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";

    // ArrayList to store multiple transactions (works like a dynamic list)
    static ArrayList<String> transactions = new ArrayList<>();

    // variable to store the account holder name (acts as account creation check)
    static String accountHolderName = null;

    public static void main(String[] args)
    {
        double balance = 0; // variable to store the current balance
        boolean isRunning = true; // variable to store the program running  state
        int choice;  //  stores user choice to perform different menu operations

        System.out.println(CYAN + "***************************************" + RESET);
        System.out.println(YELLOW + "        Welcome to My Bank!           " + RESET);
        System.out.println(CYAN + "***************************************" + RESET);

        // keeps running the loop until isRunning = false
        while (isRunning)
        {
            // Display menu
            System.out.println(BLUE + "\n************** Banking Menu **************" + RESET);
            System.out.println("1. Create Account");
            System.out.println("2. Show Balance");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Show Transaction History");
            System.out.println("6. Exit");
            System.out.println(BLUE + "*****************************************" + RESET);

            System.out.print("Enter your choice (1-6): ");
            choice = sc.nextInt(); // ask user to enter their input and stores in choice variable

            // select one case from menu according to the choice
            switch (choice)
            {
                case 1 -> createAccount(); // calls createAccount method
                case 2 -> {
                    if (isAccountCreated()) // check if account exists before balance check
                        showBalance(balance); // calls showBalance method
                }
                case 3 -> {
                    if (isAccountCreated()) // check before deposit
                        balance += deposit(); // calls deposit method
                }
                case 4 -> {
                    if (isAccountCreated()) // check before withdraw
                        balance -= withdraw(balance); // calls withdraw method
                }
                case 5 -> {
                    if (isAccountCreated()) // check before showing transactions
                        showTransactionHistory(); // shows all previous transaction history
                }
                case 6 -> {
                    // ends the loop and print thank you message
                    isRunning = false;
                    System.out.println(GREEN + "Thank you for using My Bank!" + RESET);
                }
                // prints error message (invalid choice) => if user input any other value except(1-6)
                default -> System.out.println(RED + "Invalid choice. Please try again!" + RESET);
            }
        }
        sc.close(); // close scanner sc object to release the resources
    }

    // Method to create an account
    static void createAccount()
    {
        sc.nextLine(); // clear input buffer
        System.out.print(YELLOW + "Enter account holder name: " + RESET);
        String name = sc.nextLine(); // takes account holder name

        if (accountHolderName != null) // checks if an account is already created
        {
            System.out.println(RED + "⚠️ Account already exists for " + accountHolderName + "!" + RESET);
        }
        else
        {
            accountHolderName = name; // store name as account holder
            System.out.println(GREEN + "✅ Account successfully created for " + name + "!" + RESET);
        }
    }

    // Method to check if an account exists before any operation
    static boolean isAccountCreated()
    {
        // checks if accountHolderName is still null → means no account created
        if (accountHolderName == null)
        {
            System.out.println(RED + "❌ No account found! Please create an account first." + RESET);
            return false; // return false => no account created yet
        }
        else
        {
            return true; // return true => account exists
        }
    }

    // Method to show current balance
    static void showBalance(double balance)
    {
        System.out.println(CYAN + "--------------------------------" + RESET);
        // %.2f => prints the two values after the decimal points
        System.out.printf(YELLOW + "Account Holder: " + accountHolderName + "\nYour current balance: ₹%.2f\n" + RESET, balance);
        System.out.println(CYAN + "--------------------------------" + RESET);
    }

    // Method to deposit money
    static double deposit()
    {
        System.out.print("Enter amount to be deposited: ");
        double amount = sc.nextDouble(); // takes amount input from user

        // <= -> invalid condition
        if (amount <= 0)
        {
            System.out.println(RED + "Amount must be positive (can't be negative!)" + RESET);
            return 0; // sends result back to caller
        }
        else
        {
            System.out.println(GREEN + "₹" + amount + " deposited successfully!" + RESET);
            transactions.add("Deposited: ₹" + amount); // add transaction to the list
            return amount; // returns the amount to caller
        }
    }

    // Method to withdraw money
    static double withdraw(double balance)
    {
        System.out.print("Enter amount to be withdrawn: ");
        double amount = sc.nextDouble(); // takes withdrawal amount

        if (amount <= 0)
        {
            System.out.println(RED + "Amount must be positive (can't be negative)!" + RESET);
            return 0;
        }
        else if (amount > balance)
        {
            System.out.println(RED + "Insufficient balance!" + RESET);
            return 0;
        }
        else
        {
            System.out.println(GREEN + "₹" + amount + " withdrawn successfully!" + RESET);
            transactions.add("Withdrawn: ₹" + amount); // add withdrawal record
            return amount; // return withdrawn amount
        }
    }

    // Method to show all transactions
    static void showTransactionHistory()
    {
        System.out.println(CYAN + "\n******** Transaction History ********" + RESET);

        // checks if the list is empty
        if (transactions.isEmpty())
        {
            System.out.println(YELLOW + "No transactions yet!" + RESET);
        }
        else
        {
            // prints each transaction present in the  transactions list
            for (String t : transactions)
            {
                // shows each transaction
                System.out.println(GREEN + "- " + t + RESET);
            }
        }

        System.out.println(CYAN + "*************************************\n" + RESET);
    }
}



