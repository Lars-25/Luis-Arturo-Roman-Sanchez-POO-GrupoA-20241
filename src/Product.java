public class Product {

    private String name;
    private float price;
    private int stock;

    public Product(String name, float price, int stock) {
        setName(name);
        setPrice(price);
        setStock(stock);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        } else {
            System.out.println("Name cannot be null.");
        }
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Price cannot be negative.");
        }
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        } else {
            System.out.println("Stock cannot be negative.");
        }
    }

    public void increaseStock(int quantity) {
        if (quantity > 0) {
            stock += quantity;
        } else {
            System.out.println("Quantity should be positive.");
        }
    }

    public void reduceStock(int quantity) {
        if (quantity > 0 && quantity <= stock) {
            stock -= quantity;
        } else {
            System.out.println("Quantity should be positive and less than or equal to current stock.");
        }
    }
}
