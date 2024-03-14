import java.util.ArrayList;

public class Employee {
    private String name;
    private String lastName;
    private ArrayList<BankAccount> accounts;

    public Employee(String name, String lastName, ArrayList<BankAccount> accounts) {
        this.name = name;
        this.lastName = lastName;
        this.accounts = accounts;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public ArrayList<BankAccount> getAccounts() {
        return accounts;
    }

    public void viewEmployee() {
        System.out.println("Employee: " + name + " " + lastName);
        for (BankAccount account : accounts) {
            System.out.println("Account Type: " + account.getAccountType());
        }
    }

    public void viewEmployeeDetails() {
        System.out.println("Employee: " + name + " " + lastName);
        for (BankAccount account : accounts) {
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Balance: $" + account.getBalance());
            System.out.println("Account Type: " + account.getAccountType());
        }
    }

}