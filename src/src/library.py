class Library:
    def __init__(self):
        self.users = []
        self.books = []

    def register_user(self, user):
        self.users.append(user)

    def register_book(self, book):
        self.books.append(book)

    def rent_book(self, user_name, book_title):
        user = self.get_user_by_name(user_name)
        book = self.get_book_by_title(book_title)
        if user and book and not book.get_renter():
            user.rent_book(book)
        else:
            print("User or book not found, or book already rented.")

    def get_all_users(self):
        return self.users

    def get_all_books(self):
        return self.books

    def get_users_with_rented_books(self):
        return [user for user in self.users if user.get_rented_books()]

    def get_unrented_books(self):
        return [book for book in self.books if not book.get_renter()]

    def get_rented_books(self):
        return [book for book in self.books if book.get_renter()]

    def get_user_by_name(self, name):
        for user in self.users:
            if user.get_name() == name:
                return user
        return None

    def get_book_by_title(self, title):
        for book in self.books:
            if book.get_title() == title:
                return book
        return None
