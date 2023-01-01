package challenges.food2door;

public class Order {

    private final Product product;
    private final Supplier supplier;
    private final int quantity;

    public Order(Product product, Supplier supplier, int quantity) {
        this.product = product;
        this.supplier = supplier;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public int getQuantity() {
        return quantity;
    }
}