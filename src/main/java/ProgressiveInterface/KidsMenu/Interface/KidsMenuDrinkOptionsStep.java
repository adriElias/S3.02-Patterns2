package ProgressiveInterface.KidsMenu.Interface;

import ProgressiveInterface.KidsMenu.KidsMenu;

public interface KidsMenuDrinkOptionsStep {
    KidsMenuDrinkOptionsStep setIsVegan();
    KidsMenuDrinkOptionsStep setIsGlutenFree();
    KidsMenuDessertOptionsStep setDessert(String dessertName);
    KidsMenu build();
}
