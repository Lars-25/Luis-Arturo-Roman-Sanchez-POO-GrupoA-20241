from library import Library
from book import Book
from user import User

def main():
    library = Library()

    while True:
        print("************************************")
        print("Welcome to the Library Management System")
        print("1. Register new user")
        print("2. Register new book")
        print("3. Rent a book")
        print("4. List all registered users")
        print("5. List all registered books")
        print("6. List users who have rented at least one book")
        print("7. List books that have not been rented")
        print("8. List rented books")
        print("9. Exit")
        print("************************************")
        print("Enter your choice: ")
        
        choice = input()

        if choice == '1':
            register_user(library)
        elif choice == '2':
            register_book(library)
        elif choice == '3':
            rent_book(library)
        elif choice == '4':
            list_all_users(library)
        elif choice == '5':
            list_all_books(library)
        elif choice == '6':
            list_users_with_rented_books(library)
        elif choice == '7':
            list_unrented_books(library)
        elif choice == '8':
            list_rented_books(library)
        elif choice == '9':
            print("Exiting program...")
            break
        else:
            print("Invalid choice! Please try again.")


def register_user(library):
    name = input("Enter user's name: ")
    user = User(name)
    library.register_user(user)
    print("User registered successfully!")


def register_book(library):
    title = input("Enter book's title: ")
    book = Book(title)
    library.register_book(book)
    print("Book registered successfully!")


def rent_book(library):
    user_name = input("Enter user's name: ")
    book_title = input("Enter book's title: ")
    library.rent_book(user_name, book_title)


def list_all_users(library):
    users = library.get_all_users()
    for user in users:
        print(user.get_name())


def list_all_books(library):
    books = library.get_all_books()
    for book in books:
        print(book.get_title())


def list_users_with_rented_books(library):
    users = library.get_users_with_rented_books()
    for user in users:
        print(user.get_name())


def list_unrented_books(library):
    books = library.get_unrented_books()
    for book in books:
        print(book.get_title())


def list_rented_books(library):
    books = library.get_rented_books()
    for book in books:
        print(book.get_title())


if __name__ == "__main__":
    main()
