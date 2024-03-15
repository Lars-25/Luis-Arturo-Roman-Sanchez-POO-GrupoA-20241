public class Book {
    private String title;
    private User renter;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public User getRenter() {
        return renter;
    }

    public void setRenter(User renter) {
        this.renter = renter;
    }
}
