import java.util.ArrayList;

public class User {
    private String name;
    private ArrayList<Book> rentedBooks;

    public User(String name) {
        this.name = name;
        this.rentedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Book> getRentedBooks() {
        return rentedBooks;
    }

    public void rentBook(Book book) {
        rentedBooks.add(book);
        book.setRenter(this);
    }
}
