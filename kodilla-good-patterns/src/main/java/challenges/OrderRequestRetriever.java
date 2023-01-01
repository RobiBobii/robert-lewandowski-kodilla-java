package challenges;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {

        User user = new User("JS23", "John", "Smith", "Street 23 6789 City");
        Product product = new Product("Toothbrush", 1, 20);

        return new OrderRequest(user, product, 5);
    }
}