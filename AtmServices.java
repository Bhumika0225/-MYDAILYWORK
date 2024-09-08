//------------------------------------------TASK 3----------------------------------------------

import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfuly Deposited" + amount);
        } else {
            System.out.println("Invalid Deposit amount..Please try again..!");
        }
    }


    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdraw" + amount);
            return true;
        } 
        else if (amount > balance) {
            System.out.println("Insufficient Balance" + amount);
            return false;
        } 
        else {
            System.out.println("Invalid withdraw amount.Please try again...");
            return false;
        }
    }

    public double checkBalance() {
        return balance;

    }
}

    class Atm {
        private BankAccount bankAccount;

        public Atm(BankAccount account) {
            this.bankAccount = account;
        }

        public void showMenu() {
            Scanner scanner = new Scanner(System.in);
            boolean quit = false;
            while (!quit) {
                System.out.println("\n ------ATM menu------");
                System.out.println("1.Check Balance");
                System.out.println("2.Deposite Money");
                System.out.println("3.Withdraw Money");
                System.out.println("4.Exit");
                System.out.println("Chose an option :");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Your current Balance is" + bankAccount.checkBalance());
                        break;
                    case 2:
                        System.out.println("Enter amount to deposit :");
                        double depositAmount = scanner.nextDouble();
                        bankAccount.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.println("Enter amount to withdraw :");
                        double withdrawAmount = scanner.nextDouble();
                        bankAccount.withdraw(withdrawAmount);
                        break;
                    case 4:
                        quit = true;
                        System.out.println("Thanks for chooseing SBI ATM Services");
                        System.out.println("Good Bye...!");
                        break;

                    default:
                        System.out.println("Invalid option try againm");
                        break;
                }
            }
            scanner.close();
        }

    }

public class AtmServices  {
public static void main (String[] args) {
    BankAccount myAccount = new BankAccount(10000);

    Atm atm = new Atm(myAccount);
    atm.showMenu();
}

}

