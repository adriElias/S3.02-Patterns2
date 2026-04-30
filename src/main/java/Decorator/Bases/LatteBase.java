package Decorator.Bases;

import Decorator.Interface.BubbleTea;

public class LatteBase implements BubbleTea {

    @Override
    public String getDescription() {
        return "Bubble tea base: latte" ;
    }

    @Override
    public double getCost() {
        return 3.50;
    }
}
