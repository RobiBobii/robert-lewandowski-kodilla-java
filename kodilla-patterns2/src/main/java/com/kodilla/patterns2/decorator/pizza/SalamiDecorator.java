package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class SalamiDecorator extends AbstractPizzaOrderDecorator {

    protected SalamiDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal(3));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with salami";
    }
}