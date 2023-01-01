package challenges.food2door;

public class HealthyShop implements Supplier {
    @Override
    public void process(Product product, int quantity) {
        System.out.println("Sending " + quantity + " " + product.getName() + "s to you.");
    }
}