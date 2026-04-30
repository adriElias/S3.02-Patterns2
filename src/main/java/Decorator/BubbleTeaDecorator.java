package Decorator;

import Decorator.Interface.BubbleTea;

public abstract class BubbleTeaDecorator implements BubbleTea {

    public final BubbleTea bubbleTea;

    public BubbleTeaDecorator(BubbleTea bubbleTea) {
        this.bubbleTea = bubbleTea;
    }

    @Override
    public String getDescription() {
        return bubbleTea.getDescription();
    }

    @Override
    public double getCost() {
        return Math.round(bubbleTea.getCost() * 100.0) / 100.0;
    }
}
