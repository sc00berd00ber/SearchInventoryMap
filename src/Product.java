public class Product {
    private int id;
    private String name;
    private double price;

    //Constructor
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    //Getters
    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public double getPrice() {
        return this.price;
    }

    public String toString() {
        return String.format("%d | %s | %.2f", id, name, price);
    }
}
