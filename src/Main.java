import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter product info");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Price: ");
        float price = scanner.nextFloat();
        System.out.print("Stock: ");
        int stock = scanner.nextInt();

        Product product = new Product(name, price, stock);

        System.out.println("\nProduct Details:");
        System.out.println("Name: " + product.getName());
        System.out.println("Price: " + product.getPrice());
        System.out.println("Stock: " + product.getStock());

        System.out.print("\nEnter the quantity to increase the stock: ");
        int increaseQuantity = scanner.nextInt();
        product.increaseStock(increaseQuantity);
        System.out.println("Stock after increase: " + product.getStock());

        System.out.print("\nEnter the quantity to reduce the stock: ");
        int reduceQuantity = scanner.nextInt();
        product.reduceStock(reduceQuantity);
        System.out.println("Stock after decrease: " + product.getStock());

        scanner.close();
    }
}
