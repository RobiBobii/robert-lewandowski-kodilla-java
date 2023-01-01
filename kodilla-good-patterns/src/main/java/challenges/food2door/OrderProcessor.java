package challenges.food2door;

public class OrderProcessor {

    private OutputController outputController = new OutputController();

    public void processOrder(Order order) {
        boolean isAvailable = order.getProduct().getAvailableQuantity() >= order.getQuantity();
        if (isAvailable) {
            order.getSupplier().process(order.getProduct(), order.getQuantity());
        }
        outputController.confirmOrder(isAvailable);
    }
}