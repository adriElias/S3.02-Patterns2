package ProgressiveInterface.FullMenu.Interface;

import ProgressiveInterface.FullMenu.FullMenu;

public interface FullDessertOptionsStep {
    FullDessertOptionsStep setIsVegan();
    FullDessertOptionsStep setIsGlutenFree();
    FullMenu build();
}
