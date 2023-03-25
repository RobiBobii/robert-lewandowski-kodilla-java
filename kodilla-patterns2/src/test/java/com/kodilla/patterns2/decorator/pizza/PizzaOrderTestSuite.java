package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTestSuite {

    private PizzaOrder pizzaOrder = new BasicPizzaOrder();

    @Test
    public void testBasicPizzaOrderGetPrice() {
        //When
        BigDecimal pizzaPrice = pizzaOrder.getPrice();
        //Then
        assertEquals(new BigDecimal(15),pizzaPrice);
    }

    @Test
    public void testBasicPizzaOrderGetDescription() {
        //When
        String pizza = pizzaOrder.getDescription();
        //Then
        assertEquals("Pizza with tomato sauce and cheese", pizza);
    }

    @Test
    public void testPizzaWithExtraCheeseGetPrice() {
        //Given
        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder);
        //When
        BigDecimal pizzaPrice = pizzaOrder.getPrice();
        //Then
        assertEquals(new BigDecimal(20),pizzaPrice);
    }

    @Test
    public void testPizzaWithExtraCheeseGetDescription() {
        //Given
        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder);
        //When
        String pizza = pizzaOrder.getDescription();
        //Then
        assertEquals("Pizza with tomato sauce and cheese with extra cheese", pizza);
    }

    @Test
    public void testDoubleSizePizzaWithSalamiMushroomsAndOlivesGetPrice() {
        //Given
        pizzaOrder = new SalamiDecorator(pizzaOrder);
        pizzaOrder = new MushroomsDecorator(pizzaOrder);
        pizzaOrder = new OlivesDecorator(pizzaOrder);
        pizzaOrder = new DoubleSizeDecorator(pizzaOrder);
        //When
        BigDecimal pizzaPrice = pizzaOrder.getPrice();
        //Then
        assertEquals(new BigDecimal(33),pizzaPrice);
    }

    @Test
    public void testDoubleSizePizzaWithSalamiMushroomsAndOlivesGetDescription() {
        //Given
        pizzaOrder = new SalamiDecorator(pizzaOrder);
        pizzaOrder = new MushroomsDecorator(pizzaOrder);
        pizzaOrder = new OlivesDecorator(pizzaOrder);
        pizzaOrder = new DoubleSizeDecorator(pizzaOrder);
        //When
        String pizza = pizzaOrder.getDescription();
        //Then
        assertEquals("Pizza with tomato sauce and cheese with salami with mushrooms with olives double size", pizza);
    }
}