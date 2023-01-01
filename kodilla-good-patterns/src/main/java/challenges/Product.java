package challenges;

public class Product {

    private final String name;
    private final double price;
    private final int quantityAvailable;

    public Product(final String name, final double price, int quantityAvailable) {
        this.name = name;
        this.price = price;
        this.quantityAvailable = quantityAvailable;
    }

    public String getName() {
        return name;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

}