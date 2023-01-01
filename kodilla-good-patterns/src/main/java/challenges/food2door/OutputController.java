package challenges.food2door;

public class OutputController {

    public void confirmOrder(boolean isAvailable) {
        if (isAvailable) {
            System.out.println("Order has been processed.");
        } else {
            System.out.println("Sorry! This order can't be processed.");
        }
    }
}