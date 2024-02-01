package Internship;

import java.util.Scanner;


class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}


public class Task_3
{
    private BankAccount userAccount;

    public Task_3(BankAccount userAccount) {
        this.userAccount = userAccount;
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (userAccount.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful. Remaining balance: " + userAccount.getBalance());
                    } else {
                        System.out.println("Insufficient balance. Withdrawal failed.");
                    }
                    break;

                case 2:

                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    userAccount.deposit(depositAmount);
                    System.out.println("Deposit successful. Updated balance: " + userAccount.getBalance());
                    break;

                case 3:

                    System.out.println("Your current balance: " + userAccount.getBalance());
                    break;

                case 4:

                    System.out.println("Thank you for using the ATM. Have A Nice Day!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }

        } while (choice != 4);

        scanner.close();
    }

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000);
        Task_3 atm = new Task_3(userAccount);
        atm.run();
    }
}
