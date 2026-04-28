package ProgressiveInterface.KidsMenu;

import ProgressiveInterface.Dish;

import ProgressiveInterface.KidsMenu.Interface.KidsMenuDessertOptionsStep;
import ProgressiveInterface.KidsMenu.Interface.KidsMenuDrinkOptionsStep;

import ProgressiveInterface.KidsMenu.Interface.KidsMenuMainCourseOptionsStep;
import ProgressiveInterface.KidsMenu.Interface.KidsMenuMainCourseStep;

import java.util.ArrayList;
import java.util.List;

public class KidsMenuBuilder implements KidsMenuMainCourseStep, KidsMenuMainCourseOptionsStep, KidsMenuDrinkOptionsStep, KidsMenuDessertOptionsStep{
    public List<Dish> dishes = new ArrayList<>();
    public Dish currentDish;

    private KidsMenuBuilder(){}

    public static KidsMenuMainCourseStep getInstance() {
        return new KidsMenuBuilder();
    }

    @Override
    public KidsMenuMainCourseOptionsStep setMainCourse(String mainCourseName) {
        Dish mainCourse = new Dish("Main course", mainCourseName);
        this.currentDish = mainCourse;

        return this;
    }

    @Override
    public KidsMenuBuilder setIsVegan() {
        this.currentDish.setIsVegan(true);
        return this;
    }

    @Override
    public KidsMenuBuilder setIsGlutenFree() {
        this.currentDish.setIsGlutenFree(true);
        return this;
    }

    @Override
    public KidsMenuMainCourseOptionsStep setGarnish(String garnishName) {
        this.dishes.add(this.currentDish);
        Dish garnish = new Dish("Garnish", garnishName);
        this.currentDish = garnish;

        return this;
    }

    @Override
    public KidsMenuDrinkOptionsStep setDrink(String drinkName) {
        this.dishes.add(this.currentDish); // Push Main course to dishes
        Dish drink = new Dish("Drink", drinkName);
        this.currentDish = drink; // Set drink as current dish

        return this;
    }

    @Override
    public KidsMenuDessertOptionsStep setDessert(String dessertName) {
        this.dishes.add(this.currentDish);
        Dish dessert = new Dish("Dessert", dessertName);
        this.currentDish = dessert;

        return this;
    }

    @Override
    public KidsMenu build() {
        this.dishes.add(this.currentDish);
        return new KidsMenu(this.dishes);
    }
}
