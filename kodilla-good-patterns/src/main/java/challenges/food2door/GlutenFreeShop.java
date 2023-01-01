package challenges.food2door;

public class GlutenFreeShop implements Supplier {

    @Override
    public void process(Product product, int quantity) {
        System.out.println("Thank you for ordering " + product.getName() + ".\n" + quantity + "pcs are on the way.");
    }
}