package ProgressiveInterface.FullMenu.Interface;

import ProgressiveInterface.FullMenu.FullMenu;

public interface FullDrinkOptionsStep {
    FullDrinkOptionsStep setIsVegan();
    FullDrinkOptionsStep setIsGlutenFree();
    FullDessertOptionsStep setDessert(String dessertName);
    FullCoffeeOptionsStep setCoffee(String coffeeName);
    FullMenu build();
}
