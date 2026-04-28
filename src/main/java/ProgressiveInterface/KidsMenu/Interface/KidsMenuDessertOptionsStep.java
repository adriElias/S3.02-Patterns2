package ProgressiveInterface.KidsMenu.Interface;

import ProgressiveInterface.KidsMenu.KidsMenu;

public interface KidsMenuDessertOptionsStep {
    KidsMenuDessertOptionsStep setIsVegan();
    KidsMenuDessertOptionsStep setIsGlutenFree();
    KidsMenu build();
}
