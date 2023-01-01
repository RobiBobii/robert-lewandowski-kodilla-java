package challenges.food2door;

public class ExtraFoodShop implements Supplier {

    @Override
    public void process(Product product, int quantity) {
        System.out.println("Product " + product.getName() + " (" + quantity + ") will be delivered to your door! Thank you for shopping with ExtraFoodShop.");
    }
}