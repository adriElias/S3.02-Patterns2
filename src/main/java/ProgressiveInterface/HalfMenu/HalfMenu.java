package ProgressiveInterface.HalfMenu;

import ProgressiveInterface.Dish;

import java.util.ArrayList;
import java.util.List;

public class HalfMenu {
    public List<Dish> dishes = new ArrayList<>();

    public HalfMenu(List<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public String toString() {
        return "HalfMenu{" +
                "dishes=" + dishes +
                '}';
    }
}
