package Decorator.Decorators;

import Decorator.BubbleTeaDecorator;
import Decorator.Interface.BubbleTea;

public class TapiocaDecorator extends BubbleTeaDecorator {
    private static final double PRICE = 0.50;

    public TapiocaDecorator(BubbleTea bubbleTea) {
        super(bubbleTea);
    }

    @Override
    public String getDescription(){
        return bubbleTea.getDescription() + " + TAPIOCA";
    }

    @Override
    public double getCost(){
        return bubbleTea.getCost() + PRICE;
    }
}
