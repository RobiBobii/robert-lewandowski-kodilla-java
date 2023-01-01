package challenges;

public class ProductOrderService implements OrderService {

    @Override
    public boolean sell(final User user, final Product product, final int quantity ) {
        if(product.getQuantityAvailable() >= quantity) {
            System.out.println("Selling " + quantity + " pieces of " + product.getName() + " to " + user.getUsername());
            return true;
        } else {
            return false;
        }
    }
}