import java.util.Scanner;

class ATM {
    private double balance;
    private int pin;

    // Constructor
    public ATM(double initialBalance, int pin) {
        this.balance = initialBalance;
        this.pin = pin;
    }

    // Check PIN
    public boolean validatePin(int enteredPin) {
        return this.pin == enteredPin;
    }

    // Check Balance
    public void checkBalance() {
        System.out.println("Your current balance: ₹" + balance);
    }

    // Deposit Money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited ₹" + amount);
            checkBalance();
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Withdraw Money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn ₹" + amount);
            checkBalance();
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }
}

public class ATM_Machine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create an ATM object with initial balance ₹10,000 and PIN 1234
        ATM atm = new ATM(10000, 1234);

        System.out.print("Enter your PIN: ");
        int enteredPin = sc.nextInt();

        if (atm.validatePin(enteredPin)) {
            int choice;
            do {
                System.out.println("\n===== ATM Menu =====");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        atm.checkBalance();
                        break;
                    case 2:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = sc.nextDouble();
                        atm.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter withdraw amount: ");
                        double withdrawAmount = sc.nextDouble();
                        atm.withdraw(withdrawAmount);
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } while (choice != 4);
        } else {
            System.out.println("❌ Incorrect PIN. Access Denied!");
        }

        sc.close();
    }
}
