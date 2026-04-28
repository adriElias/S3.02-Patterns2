package ProgressiveInterface.FullMenu;

import ProgressiveInterface.Dish;
import ProgressiveInterface.FullMenu.Interface.*;

import java.util.ArrayList;
import java.util.List;

public class FullMenuBuilder implements FullStarterStep, FullStarterOptionsStep, FullMainCourseOptionsStep, FullDrinkOptionsStep, FullDessertOptionsStep, FullCoffeeOptionsStep {

    public List<Dish> dishes = new ArrayList<Dish>();
    public Dish currentDish;


    private FullMenuBuilder() {}

    public static FullStarterStep getInstance() {
        return new FullMenuBuilder();
    }

    @Override
    public FullStarterOptionsStep setStarter(String starterName) {
        Dish starter = new Dish("Starter", starterName);
        this.currentDish = starter;

        return this;
    }

    @Override
    public FullMenuBuilder setIsVegan() {
        this.currentDish.setIsVegan(true);
        return this;
    }

    @Override
    public FullMenuBuilder setIsGlutenFree() {
        this.currentDish.setIsGlutenFree(true);
        return this;
    }

    @Override
    public FullMainCourseOptionsStep setMainCourse(String mainCourseName) {
        this.dishes.add(this.currentDish); // Push starter to dishes
        Dish mainCourseDish = new Dish("Main Course: ", mainCourseName);
        this.currentDish = mainCourseDish; // Set Main Course dish as current dish

        return this;
    }

    @Override
    public FullMainCourseOptionsStep setGarnish(String garnishName) {
        this.dishes.add(this.currentDish);
        Dish garnish = new Dish("Garnish", garnishName);
        this.currentDish = garnish;
        return this;
    }

    @Override
    public FullDrinkOptionsStep setDrink(String drinkName) {
        this.dishes.add(this.currentDish); // Push Main course to dishes
        Dish drink = new Dish("Drink", drinkName);
        this.currentDish = drink; // Set drink as current dish
        return this;
    }

    @Override
    public FullDessertOptionsStep setDessert(String dessertName) {
        this.dishes.add(this.currentDish);
        Dish dessert = new Dish("Dessert", dessertName);
        this.currentDish = dessert;
        return this;
    }

    @Override
    public FullCoffeeOptionsStep setCoffee(String coffeeName) {
        this.dishes.add(this.currentDish);
        Dish coffee = new Dish("Coffee", coffeeName);
        this.currentDish = coffee;

        return this;
    }

    @Override
    public FullMenu build() {
        this.dishes.add(this.currentDish);
        return new FullMenu(this.dishes);
    }

}
