class Bank:
    def __init__(self):
        self.employees = []

    def add_employee(self, employee):
        self.employees.append(employee)

    def get_all_employees(self):
        return self.employees

    def get_employee_by_name(self, name, last_name):
        for employee in self.employees:
            if employee.name.lower() == name.lower() and employee.last_name.lower() == last_name.lower():
                return employee
        return None

    def deposit_money(self, name, last_name, account_number, amount):
        employee = self.get_employee_by_name(name, last_name)
        if employee:
            for account in employee.accounts:
                if account.account_number == account_number:
                    account.deposit_money(amount)
                    return True
        return False

    def withdraw_money(self, name, last_name, account_number, amount):
        employee = self.get_employee_by_name(name, last_name)
        if employee:
            for account in employee.accounts:
                if account.account_number == account_number:
                    account.withdraw_money(amount)
                    return True
        return False

    def get_balance(self, name, last_name, account_number):
        employee = self.get_employee_by_name(name, last_name)
        if employee:
            for account in employee.accounts:
                if account.account_number == account_number:
                    return account.balance
        return -1
