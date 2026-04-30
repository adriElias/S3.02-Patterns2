package Decorator.Decorators;

import Decorator.BubbleTeaDecorator;
import Decorator.Interface.BubbleTea;

public class FlavorDecorator extends BubbleTeaDecorator {
    private static final double PRICE = 0.60;
    private final String flavorName;

    public FlavorDecorator(BubbleTea bubbleTea, String flavorName) {
        super(bubbleTea);
        this.flavorName = flavorName;
    }

    @Override
    public String getDescription(){
        return bubbleTea.getDescription() + " + FLAVOR: " + flavorName;
    }

    @Override
    public double getCost(){
        return bubbleTea.getCost() + PRICE;
    }
}
