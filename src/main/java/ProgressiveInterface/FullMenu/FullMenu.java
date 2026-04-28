package ProgressiveInterface.FullMenu;

import ProgressiveInterface.Dish;

import java.util.ArrayList;
import java.util.List;

public class FullMenu {
    public List<Dish> dishes = new ArrayList<Dish>();

    public FullMenu(List<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public String toString() {
        return "FullMenu{" +
                "dishes=" + dishes +
                '}';
    }
}
