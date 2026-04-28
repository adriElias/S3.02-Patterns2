package ProgressiveInterface.FullMenu.Interface;

import ProgressiveInterface.FullMenu.FullMenu;

public interface FullMainCourseOptionsStep {
    FullMainCourseOptionsStep setIsVegan();
    FullMainCourseOptionsStep setIsGlutenFree();
    FullMainCourseOptionsStep setGarnish(String garnishName);
    FullDrinkOptionsStep setDrink(String drinkName);
    FullDessertOptionsStep setDessert(String dessertName);
    FullCoffeeOptionsStep setCoffee(String coffeeName);
    FullMenu build();
}
