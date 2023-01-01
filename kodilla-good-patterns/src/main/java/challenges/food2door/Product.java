package challenges.food2door;

public class Product {

    private final String name;
    private final int availableQuantity;

    public Product(final String name, final int availableQuantity) {
        this.name = name;
        this.availableQuantity = availableQuantity;
    }

    public String getName() {
        return name;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }
}