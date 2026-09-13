import java.util.Scanner;

public class ATM {

    static Scanner sc = new Scanner(System.in);

    static int pin;
    static double balance = 10000;

    public static void main(String[] args) {

        System.out.println("================================");
        System.out.println("       WELCOME TO ATM");
        System.out.println("================================");

        // Set PIN
        setPin();

        // ATM Menu
        while (true) {

            System.out.println("\n================================");
            System.out.println("           ATM MENU");
            System.out.println("================================");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Mini Statement");
            System.out.println("5. Change PIN");
            System.out.println("6. Exit");
            System.out.println("================================");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    checkBalance();
                    break;

                case 2:
                    deposit();
                    break;

                case 3:
                    withdraw();
                    break;

                case 4:
                    miniStatement();
                    break;

                case 5:
                    changePin();
                    break;

                case 6:
                    System.out.println("\nThank you for using our ATM!");
                    System.out.println("Please collect your card.");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Set PIN
    static void setPin() {

        while (true) {

            System.out.print("Set your 4-digit PIN: ");
            int newPin = sc.nextInt();

            if (newPin < 1000 || newPin > 9999) {
                System.out.println("PIN must contain exactly 4 digits!");
                continue;
            }

            System.out.print("Confirm your PIN: ");
            int confirmPin = sc.nextInt();

            if (newPin == confirmPin) {
                pin = newPin;
                System.out.println("\nPIN set successfully!");
                System.out.println("Your account is ready to use.");
                break;
            } else {
                System.out.println("PIN does not match!");
                System.out.println("Please try again.\n");
            }
        }
    }

    // Check Balance
    static void checkBalance() {

        System.out.println("\n----- BALANCE -----");
        System.out.println("Available Balance: Rs." + balance);
    }

    // Deposit
    static void deposit() {

        System.out.print("\nEnter amount to deposit: Rs.");
        double amount = sc.nextDouble();

        if (amount > 0) {

            balance = balance + amount;

            System.out.println("Amount deposited successfully!");
            System.out.println("Deposited Amount: Rs." + amount);
            System.out.println("New Balance: Rs." + balance);

        } else {
            System.out.println("Invalid amount!");
        }
    }

    // Withdraw
    static void withdraw() {

        System.out.print("\nEnter amount to withdraw: Rs.");
        double amount = sc.nextDouble();

        if (amount <= 0) {

            System.out.println("Invalid amount!");

        } else if (amount > balance) {

            System.out.println("Insufficient balance!");

        } else {

            balance = balance - amount;

            System.out.println("Please collect your cash.");
            System.out.println("Withdrawn Amount: Rs." + amount);
            System.out.println("Remaining Balance: Rs." + balance);
        }
    }

    // Mini Statement
    static void miniStatement() {

        System.out.println("\n================================");
        System.out.println("          MINI STATEMENT");
        System.out.println("================================");
        System.out.println("Account Type     : Savings");
        System.out.println("Current Balance  : Rs." + balance);
        System.out.println("================================");
    }

    // Change PIN
    static void changePin() {

        System.out.print("\nEnter your current PIN: ");
        int oldPin = sc.nextInt();

        if (oldPin == pin) {

            System.out.print("Enter new 4-digit PIN: ");
            int newPin = sc.nextInt();

            if (newPin >= 1000 && newPin <= 9999) {

                System.out.print("Confirm new PIN: ");
                int confirmPin = sc.nextInt();

                if (newPin == confirmPin) {
                    pin = newPin;
                    System.out.println("PIN changed successfully!");
                } else {
                    System.out.println("PIN does not match!");
                }

            } else {
                System.out.println("PIN must contain 4 digits!");
            }

        } else {
            System.out.println("Incorrect current PIN!");
        }
    }
}