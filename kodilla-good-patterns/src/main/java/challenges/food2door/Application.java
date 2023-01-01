package challenges.food2door;

public class Application {

    public static void main(String[] args) {

        InputController inputController = new InputController();
        Order order = inputController.retrieveOrder();

        OrderProcessor orderProcessor = new OrderProcessor();
        orderProcessor.processOrder(order);

    }
}