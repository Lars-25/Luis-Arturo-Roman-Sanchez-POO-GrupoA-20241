from employee import Employee
from bank_account import BankAccount
from bank import Bank

def main():
    bank = Bank()

    while True:
        print("************************************")
        print("Welcome to the Bank Management System")
        print("1. Add new employee")
        print("2. Show all employees")
        print("3. Show employee details")
        print("4. Deposit money")
        print("5. Withdraw money")
        print("6. Exit")
        print("************************************")

        choice = input("Enter your choice: ")

        if choice == '1':
            add_employee(bank)
        elif choice == '2':
            employees = bank.get_all_employees()
            for employee in employees:
                employee.view_employee()
                print()
        elif choice == '3':
            show_employee_details(bank)
        elif choice == '4':
            deposit_money(bank)
        elif choice == '5':
            withdraw_money(bank)
        elif choice == '6':
            print("Exiting program...")
            break
        else:
            print("Invalid choice! Please try again.")


def add_employee(bank):
    name = input("Enter employee's name: ")
    last_name = input("Enter employee's last name: ")
    num_accounts = int(input("Enter number of bank accounts for this employee: "))
    accounts = []
    for _ in range(num_accounts):
        account_number = int(input(f"Enter account number for account {_ + 1}: "))
        account_type = input(f"Enter account type (A, B, or C) for account {_ + 1}: ")[0]
        account = BankAccount(account_number, account_type)
        accounts.append(account)
    employee = Employee(name, last_name, accounts)
    bank.add_employee(employee)
    print("Employee added successfully!")


def show_employee_details(bank):
    name = input("Enter employee's name: ")
    last_name = input("Enter employee's last name: ")
    employee = bank.get_employee_by_name(name, last_name)
    if employee:
        employee.view_employee_details()
    else:
        print("Employee not found.")


def deposit_money(bank):
    name = input("Enter employee's name: ")
    last_name = input("Enter employee's last name: ")
    account_number = int(input("Enter account number: "))
    deposit_amount = float(input("Enter amount to deposit: "))
    if bank.deposit_money(name, last_name, account_number, deposit_amount):
        print("Deposit successful.")
    else:
        print("Deposit failed.")


def withdraw_money(bank):
    name = input("Enter employee's name: ")
    last_name = input("Enter employee's last name: ")
    account_number = int(input("Enter account number: "))
    withdraw_amount = float(input("Enter amount to withdraw: "))
    if bank.withdraw_money(name, last_name, account_number, withdraw_amount):
        print("Withdrawal successful.")
    else:
        print("Withdrawal failed.")


if __name__ == "__main__":
    main()
