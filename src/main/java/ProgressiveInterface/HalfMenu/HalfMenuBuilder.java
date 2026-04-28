package ProgressiveInterface.HalfMenu;

import ProgressiveInterface.Dish;
import ProgressiveInterface.FullMenu.Interface.FullMainCourseOptionsStep;
import ProgressiveInterface.HalfMenu.Interface.HalfMenuDrinkOptionsStep;

import ProgressiveInterface.HalfMenu.Interface.HalfMenuMainCourseOptionsStep;
import ProgressiveInterface.HalfMenu.Interface.HalfMenuMainCourseStep;

import java.util.ArrayList;
import java.util.List;

public class HalfMenuBuilder implements HalfMenuMainCourseStep, HalfMenuMainCourseOptionsStep, HalfMenuDrinkOptionsStep {
    public List<Dish> dishes = new ArrayList<>();
    public Dish currentDish;

    private HalfMenuBuilder(){}

    public static HalfMenuMainCourseStep getInstance() {
        return new HalfMenuBuilder();
    }

    @Override
    public HalfMenuMainCourseOptionsStep setMainCourse(String mainCourseName) {
        Dish mainCourse = new Dish("Main course", mainCourseName);
        this.currentDish = mainCourse;

        return this;
    }

    @Override
    public HalfMenuBuilder setIsVegan() {
        this.currentDish.setIsVegan(true);
        return this;
    }

    @Override
    public HalfMenuBuilder setIsGlutenFree() {
        this.currentDish.setIsGlutenFree(true);
        return this;
    }

    @Override
    public HalfMenuMainCourseOptionsStep setGarnish(String garnishName) {
        this.dishes.add(this.currentDish);
        Dish garnish = new Dish("Garnish", garnishName);
        this.currentDish = garnish;

        return this;
    }

    @Override
    public HalfMenuDrinkOptionsStep setDrink(String drinkName) {
        this.dishes.add(this.currentDish);
        Dish drink = new Dish("Drink", drinkName);
        this.currentDish = drink;

        return this;
    }

    @Override
    public HalfMenu build() {
        this.dishes.add(currentDish);
        return new HalfMenu(this.dishes);
    }
}
