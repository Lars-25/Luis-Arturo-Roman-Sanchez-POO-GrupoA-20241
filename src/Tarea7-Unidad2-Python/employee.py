class Employee:
    def __init__(self, name, last_name, accounts):
        self.name = name
        self.last_name = last_name
        self.accounts = accounts

    def view_employee(self):
        print(f"Employee: {self.name} {self.last_name}")
        for account in self.accounts:
            print(f"Account Type: {account.account_type}")

    def view_employee_details(self):
        print(f"Employee: {self.name} {self.last_name}")
        for account in self.accounts:
            print(f"Account Number: {account.account_number}")
            print(f"Balance: ${account.balance}")
            print(f"Account Type: {account.account_type}")
