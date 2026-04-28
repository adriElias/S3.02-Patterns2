package ProgressiveInterface.HalfMenu.Interface;

import ProgressiveInterface.HalfMenu.HalfMenu;

public interface HalfMenuMainCourseOptionsStep {
    HalfMenuMainCourseOptionsStep setIsVegan();
    HalfMenuMainCourseOptionsStep setIsGlutenFree();
    HalfMenuMainCourseOptionsStep setGarnish(String garnishName);
    HalfMenuDrinkOptionsStep setDrink(String drinkName);
    HalfMenu build();
}
