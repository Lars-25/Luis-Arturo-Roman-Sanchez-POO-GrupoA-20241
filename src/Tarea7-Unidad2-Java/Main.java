import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank();

    public static void main(String[] args) {
        boolean exit = false;
        
        while (!exit) {
            System.out.println("************************************");
            System.out.println("Welcome to the Bank Management System");
            System.out.println("1. Add new employee");
            System.out.println("2. Show all employees");
            System.out.println("3. Show employee details");
            System.out.println("4. Deposit money");
            System.out.println("5. Withdraw money");
            System.out.println("6. Exit");
            System.out.println("************************************");


            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    showAllEmployees();
                    break;
                case 3:
                    showEmployeeDetails();
                    break;
                case 4:
                    depositMoney();
                    break;
                case 5:
                    withdrawMoney();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        
        scanner.close();
    }

    private static void addEmployee() {
        System.out.println("Enter employee's name:");
        String name = scanner.nextLine();

        System.out.println("Enter employee's last name:");
        String lastName = scanner.nextLine();

        System.out.println("Enter number of bank accounts for this employee:");
        int numAccounts = scanner.nextInt();
        scanner.nextLine();

        ArrayList<BankAccount> accounts = new ArrayList<>();
        for (int i = 0; i < numAccounts; i++) {
            System.out.println("Enter account number for account " + (i + 1) + ":");
            long accountNumber = scanner.nextLong();
            scanner.nextLine();

            System.out.println("Enter account type (A, B, or C) for account " + (i + 1) + ":");
            char accountType = scanner.nextLine().charAt(0);

            BankAccount account = new BankAccount(accountNumber, accountType);
            accounts.add(account);
        }

        Employee employee = new Employee(name, lastName, accounts);
        bank.addEmployee(employee);
        System.out.println("Employee added successfully!");
    }

    private static void showAllEmployees() {
        ArrayList<Employee> employees = bank.getAllEmployees();
        for (Employee employee : employees) {
            employee.viewEmployee();
            System.out.println();
        }
    }

    private static void showEmployeeDetails() {
        System.out.println("Enter employee's name:");
        String name = scanner.nextLine();

        System.out.println("Enter employee's last name:");
        String lastName = scanner.nextLine();

        Employee employee = bank.getEmployeeByName(name, lastName);
        if (employee != null) {
            employee.viewEmployeeDetails();
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static void depositMoney() {
        System.out.println("Enter employee's name:");
        String name = scanner.nextLine();

        System.out.println("Enter employee's last name:");
        String lastName = scanner.nextLine();

        System.out.println("Enter account number:");
        long accountNumber = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Enter amount to deposit:");
        double depositAmount = scanner.nextDouble();
        scanner.nextLine();

        if (bank.depositMoney(name, lastName, accountNumber, depositAmount)) {
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Deposit failed");
        }
    }

    private static void withdrawMoney() {
        System.out.println("Enter employee's name:");
        String name = scanner.nextLine();

        System.out.println("Enter employee's last name:");
        String lastName = scanner.nextLine();

        System.out.println("Enter account number:");
        long accountNumber = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Enter amount to withdraw:");
        double withdrawAmount = scanner.nextDouble();
        scanner.nextLine();

        if (bank.withdrawMoney(name, lastName, accountNumber, withdrawAmount)) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Withdrawal failed");
        }
    }

}