public class BankAccount {
    private long accountNumber;
    private double balance;
    private char accountType;

    public BankAccount(long accountNumber, char accountType) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;

        switch (accountType) {
            case ('A'):
                balance = 1000;
                break;
            case ('B'):
                balance = 5000;
                break;
            case ('C'):
                balance = 10000;
                break;
        }
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public char getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void depositMoney(double amount) {
        if (accountType == 'A') depositMoneyAccountTypeA(amount);
        else if (accountType == 'B') depositMoneyAccountTypeB(amount);
        else balance += amount;
    }

    private void depositMoneyAccountTypeA(double amount) {
        if (balance + amount <= 50000) {
            balance += amount;
        } else {
            System.out.println("Cannot have more than $50,000 in account type A");
        }
    }

    private void depositMoneyAccountTypeB(double amount) {
        if (balance + amount <= 100000) {
            balance += amount;
        } else {
            System.out.println("Cannot have more than $100,000 in account type B");
        }
    }

    public boolean isThereSufficientBalanceToWithdraw(double amount) {
        if (accountType == 'A') {
            return balance - amount >= 1000;
        } else if (accountType == 'B') {
            return balance - amount >= 5000;
        }
        return balance - amount >= 10000;
    }

    public void withdrawMoney(double amount) {
        if (isThereSufficientBalanceToWithdraw(amount)) {
            balance -= amount;
        } else {
            String withdrawErrorMessage = String.format("Insufficient balance to withdraw from account type %c", accountType);
            System.out.println(withdrawErrorMessage);
        }
    }

    
}