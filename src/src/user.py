class User:
    def __init__(self, name):
        self.name = name
        self.rented_books = []

    def get_name(self):
        return self.name

    def get_rented_books(self):
        return self.rented_books

    def rent_book(self, book):
        self.rented_books.append(book)
        book.set_renter(self)
