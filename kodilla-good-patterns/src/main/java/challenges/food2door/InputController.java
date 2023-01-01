package challenges.food2door;

public class InputController {

    public Order retrieveOrder() {
        return new Order(new Product("Melon", 23), new ExtraFoodShop(), 10);
    }
}