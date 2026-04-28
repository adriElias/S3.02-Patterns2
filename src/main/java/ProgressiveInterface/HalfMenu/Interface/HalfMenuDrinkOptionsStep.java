package ProgressiveInterface.HalfMenu.Interface;

import ProgressiveInterface.HalfMenu.HalfMenu;

public interface HalfMenuDrinkOptionsStep {
    HalfMenuDrinkOptionsStep setIsVegan();
    HalfMenuDrinkOptionsStep setIsGlutenFree();
    HalfMenu build();
}
