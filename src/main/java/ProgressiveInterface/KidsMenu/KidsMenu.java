package ProgressiveInterface.KidsMenu;

import ProgressiveInterface.Dish;

import java.util.ArrayList;
import java.util.List;

public class KidsMenu {
    public List<Dish> dishes = new ArrayList<>();

    public KidsMenu(List<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public String toString() {
        return "KidsMenu{" +
                "dishes=" + dishes +
                '}';
    }
}
