package Decorator.Bases;

import Decorator.Interface.BubbleTea;

public class TeaBase implements BubbleTea {
    @Override
    public String getDescription() {
        return "Bubble tea base: Tea";
    }

    @Override
    public double getCost() {
        return 3.00;
    }
}
