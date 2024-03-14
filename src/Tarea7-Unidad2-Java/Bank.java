import java.util.ArrayList;

public class Bank {
    private ArrayList<Employee> employees;

    public Bank() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public ArrayList<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployeeByName(String name, String lastName) {
        for (Employee employee : employees) {
            if (employee.getName().equalsIgnoreCase(name) && employee.getLastName().equalsIgnoreCase(lastName)) {
                return employee;
            }
        }
        return null;
    }

    public boolean depositMoney(String name, String lastName, long accountNumber, double amount) {
        Employee employee = getEmployeeByName(name, lastName);
        if (employee != null) {
            ArrayList<BankAccount> accounts = employee.getAccounts();
            for (BankAccount account : accounts) {
                if (account.getAccountNumber() == accountNumber) {
                    account.depositMoney(amount);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean withdrawMoney(String name, String lastName, long accountNumber, double amount) {
        Employee employee = getEmployeeByName(name, lastName);
        if (employee != null) {
            ArrayList<BankAccount> accounts = employee.getAccounts();
            for (BankAccount account : accounts) {
                if (account.getAccountNumber() == accountNumber) {
                    account.withdrawMoney(amount);
                    return true;
                }
            }
        }
        return false;
    }

    public double getBalance(String name, String lastName, long accountNumber) {
        Employee employee = getEmployeeByName(name, lastName);
        if (employee != null) {
            ArrayList<BankAccount> accounts = employee.getAccounts();
            for (BankAccount account : accounts) {
                if (account.getAccountNumber() == accountNumber) {
                    return account.getBalance();
                }
            }
        }
        return -1;
    }
}