class BankAccount:
    def __init__(self, account_number, account_type):
        self.account_number = account_number
        self.account_type = account_type
        self.balance = self._initialize_balance()

    def _initialize_balance(self):
        if self.account_type == 'A':
            return 1000
        elif self.account_type == 'B':
            return 5000
        elif self.account_type == 'C':
            return 10000

    def deposit_money(self, amount):
        if self.account_type == 'A':
            self._deposit_money_account_type_a(amount)
        elif self.account_type == 'B':
            self._deposit_money_account_type_b(amount)
        else:
            self.balance += amount

    def _deposit_money_account_type_a(self, amount):
        if self.balance + amount <= 50000:
            self.balance += amount
        else:
            print("Cannot have more than $50,000 in account type A")

    def _deposit_money_account_type_b(self, amount):
        if self.balance + amount <= 100000:
            self.balance += amount
        else:
            print("Cannot have more than $100,000 in account type B")

    def is_there_sufficient_balance_to_withdraw(self, amount):
        if self.account_type == 'A':
            return self.balance - amount >= 1000
        elif self.account_type == 'B':
            return self.balance - amount >= 5000
        return self.balance - amount >= 10000

    def withdraw_money(self, amount):
        if self.is_there_sufficient_balance_to_withdraw(amount):
            self.balance -= amount
        else:
            withdraw_error_message = f"Insufficient balance to withdraw from account type {self.account_type}"
            print(withdraw_error_message)
