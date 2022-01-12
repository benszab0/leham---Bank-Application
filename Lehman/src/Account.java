import java.util.Scanner;

public class Account {
    //Class Variables (instance fields)
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    //Constructor
    Account(String name, String id){
        customerName = name;
        customerID = id;
    }

    //Method to deposit
    void deposit(int amount) {
        if (amount != 0){
            balance += amount;
            previousTransaction = amount;
        }
    }

    //Method to withdraw
    void withdraw(int amount) {
        if (balance != 0) {
            balance -= amount;
            previousTransaction = -amount;
        }
    }

    //Method showing previous transaction
    void getPreviousTransaction() {
        if (previousTransaction > 0){
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occured");
        }
    }

    //Method calculating interest on funds after a time period
    void calculateInterest(int years) {
        double interestRate = 0.02;
        double newBalance =  (balance * interestRate * years) + balance;
        System.out.println("The current interest rate is: " + (100 * interestRate) + "%");
        System.out.println("After " + years + " years, you balance will be: " + newBalance);
    }

    //Method showing the main menu
    void showMenu(){
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your ID is: " + customerID + "\n");
        System.out.println("What would you like to do?" + "\n");
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawl");
        System.out.println("D. Check previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit");

        do {
            System.out.println();
            System.out.println("Enter an option: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch(option) {
                //Case 'A' allows users to check their account balance
                case 'A':
                    System.out.println("==========================================");
                    System.out.println("Balance = $" + balance);
                    System.out.println("==========================================" + "\n");
                    break;
                //Case 'B' allows the user to deposit money into their account
                case 'B':
                    System.out.println("Enter an amount to deposit: ");
                    int amount1 = scanner.nextInt();
                    deposit(amount1);
                    System.out.println();
                    break;
                //Case 'C' allows the user to withdraw money from their account
                case 'C':
                    System.out.println("Enter an amount to withdraw");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;
                //Case 'D' allow the user to view their most recent transation
                case 'D':
                    System.out.println("==========================================");
                    getPreviousTransaction();
                    System.out.println("==========================================" + "\n");
                    break;
                //Case 'E' calculates the accrued interest on the account after a number of years
                case 'E':
                    System.out.println("Enter the years of accrued interest: ");
                    int years = scanner.nextInt();
                    calculateInterest(years);
                    break;
                //Case 'F' exits the user from their account
                case 'F':
                    System.out.println("==========================================");
                    break;
                //The default case let's the users know that they entered an invalid character
                default:
                    System.out.println("Error: invalid option. Please enter A, B, C, D, F");
                    break;
            }
        } while(option != 'F');
        System.out.println("Thank you for banking with us!");
    }
}


