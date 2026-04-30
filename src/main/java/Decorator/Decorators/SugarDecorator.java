package Decorator.Decorators;

import Decorator.BubbleTeaDecorator;
import Decorator.Interface.BubbleTea;

public class SugarDecorator extends BubbleTeaDecorator {
    private static final double PRICE = 0.30;

    public SugarDecorator(BubbleTea bubbleTea) {
        super(bubbleTea);
    }

    @Override
    public String getDescription(){
        return bubbleTea.getDescription() + " + SUGAR";
    }

    @Override
    public double getCost(){
        return bubbleTea.getCost() + PRICE;
    }
}
