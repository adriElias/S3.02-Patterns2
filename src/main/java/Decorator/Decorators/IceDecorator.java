package Decorator.Decorators;

import Decorator.BubbleTeaDecorator;
import Decorator.Interface.BubbleTea;

public class IceDecorator extends BubbleTeaDecorator {
    private static final double PRICE = 0.25;

    public IceDecorator(BubbleTea bubbleTea) {
        super(bubbleTea);
    }

    @Override
    public String getDescription(){
        return bubbleTea.getDescription() + " + ICE";
    }

    @Override
    public double getCost(){
        return bubbleTea.getCost() + PRICE;
    }
}
