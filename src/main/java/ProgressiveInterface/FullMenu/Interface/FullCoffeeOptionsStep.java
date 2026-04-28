package ProgressiveInterface.FullMenu.Interface;

import ProgressiveInterface.FullMenu.FullMenu;

public interface FullCoffeeOptionsStep {
    FullCoffeeOptionsStep setIsVegan();
    FullCoffeeOptionsStep setIsGlutenFree();
    FullMenu build();
}
