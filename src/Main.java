import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Library library = new Library();

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("************************************");
            System.out.println("Welcome to the Library Management System");
            System.out.println("1. Register new user");
            System.out.println("2. Register new book");
            System.out.println("3. Rent a book");
            System.out.println("4. List all registered users");
            System.out.println("5. List all registered books");
            System.out.println("6. List users who have rented at least one book");
            System.out.println("7. List books that have not been rented");
            System.out.println("8. List rented books");
            System.out.println("9. Exit");
            System.out.println("************************************");
            System.out.print("Enter your choice: ");
            

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    registerBook();
                    break;
                case 3:
                    rentBook();
                    break;
                case 4:
                    listAllUsers();
                    break;
                case 5:
                    listAllBooks();
                    break;
                case 6:
                    listUsersWithRentedBooks();
                    break;
                case 7:
                    listUnrentedBooks();
                    break;
                case 8:
                    listRentedBooks();
                    break;
                case 9:
                    exit = true;
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        scanner.close();
    }

    private static void registerUser() {
        System.out.println("Enter user's name:");
        String name = scanner.nextLine();
        User user = new User(name);
        library.registerUser(user);
        System.out.println("User registered successfully!");
    }

    private static void registerBook() {
        System.out.println("Enter book's title:");
        String title = scanner.nextLine();
        Book book = new Book(title);
        library.registerBook(book);
        System.out.println("Book registered successfully!");
    }

    private static void rentBook() {
        System.out.println("Enter user's name:");
        String userName = scanner.nextLine();
        System.out.println("Enter book's title:");
        String bookTitle = scanner.nextLine();
        library.rentBook(userName, bookTitle);
    }

    private static void listAllUsers() {
        ArrayList<User> users = library.getAllUsers();
        for (User user : users) {
            System.out.println(user.getName());
        }
    }

    private static void listAllBooks() {
        ArrayList<Book> books = library.getAllBooks();
        for (Book book : books) {
            System.out.println(book.getTitle());
        }
    }

    private static void listUsersWithRentedBooks() {
        ArrayList<User> users = library.getUsersWithRentedBooks();
        for (User user : users) {
            System.out.println(user.getName());
        }
    }

    private static void listUnrentedBooks() {
        ArrayList<Book> books = library.getUnrentedBooks();
        for (Book book : books) {
            System.out.println(book.getTitle());
        }
    }

    private static void listRentedBooks() {
        ArrayList<Book> books = library.getRentedBooks();
        for (Book book : books) {
            System.out.println(book.getTitle());
        }
    }
}
