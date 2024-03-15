import java.util.ArrayList;

public class Library {
    private ArrayList<User> users;
    private ArrayList<Book> books;

    public Library() {
        users = new ArrayList<>();
        books = new ArrayList<>();
    }

    public void registerUser(User user) {
        users.add(user);
    }

    public void registerBook(Book book) {
        books.add(book);
    }

    public void rentBook(String userName, String bookTitle) {
        User user = getUserByName(userName);
        Book book = getBookByTitle(bookTitle);
        if (user != null && book != null && book.getRenter() == null) {
            user.rentBook(book);
        } else {
            System.out.println("User or book not found, or book already rented.");
        }
    }

    public ArrayList<User> getAllUsers() {
        return users;
    }

    public ArrayList<Book> getAllBooks() {
        return books;
    }

    public ArrayList<User> getUsersWithRentedBooks() {
        ArrayList<User> usersWithRentedBooks = new ArrayList<>();
        for (User user : users) {
            if (!user.getRentedBooks().isEmpty()) {
                usersWithRentedBooks.add(user);
            }
        }
        return usersWithRentedBooks;
    }

    public ArrayList<Book> getUnrentedBooks() {
        ArrayList<Book> unrentedBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getRenter() == null) {
                unrentedBooks.add(book);
            }
        }
        return unrentedBooks;
    }

    public ArrayList<Book> getRentedBooks() {
        ArrayList<Book> rentedBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getRenter() != null) {
                rentedBooks.add(book);
            }
        }
        return rentedBooks;
    }

    private User getUserByName(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    private Book getBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }
}
