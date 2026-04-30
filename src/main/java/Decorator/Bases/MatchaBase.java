package Decorator.Bases;

import Decorator.Interface.BubbleTea;

public class MatchaBase implements BubbleTea {
    @Override
    public String getDescription() {
        return "Bubble tea base: Matcha";
    }

    @Override
    public double getCost() {
        return 3.20;
    }
}
