package ProgressiveInterface.KidsMenu.Interface;

import ProgressiveInterface.KidsMenu.KidsMenu;

public interface KidsMenuMainCourseOptionsStep {
    KidsMenuMainCourseOptionsStep setIsVegan();
    KidsMenuMainCourseOptionsStep setIsGlutenFree();
    KidsMenuMainCourseOptionsStep setGarnish(String garnishName);
    KidsMenuDrinkOptionsStep setDrink(String drinkName);
    KidsMenuDessertOptionsStep setDessert(String dessertName);
    KidsMenu build();
}
