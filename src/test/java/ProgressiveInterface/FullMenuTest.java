package ProgressiveInterface;

import ProgressiveInterface.Dish;
import ProgressiveInterface.FullMenu.FullMenu;
import ProgressiveInterface.FullMenu.FullMenuBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FullMenuTest {

    @Test
    @DisplayName("Builds a FullMenu with starter, main course, garnish, and coffee")
    void shouldBuildMenuWithStarterMainCourseGarnishAndCoffee() {
        FullMenu menu = FullMenuBuilder.getInstance()
                .setStarter("Ensalada")
                .setIsVegan()
                .setIsGlutenFree()
                .setMainCourse("Macarrones")
                .setIsVegan()
                .setIsGlutenFree()
                .setGarnish("Patatas")
                .setCoffee("Americano")
                .build();

        assertEquals(4, menu.dishes.size());
        assertDish(menu.dishes.get(0), "Starter", "Ensalada", true, true);
        assertDish(menu.dishes.get(1), "Main Course: ", "Macarrones", true, true);
        assertDish(menu.dishes.get(2), "Garnish", "Patatas", false, false);
        assertDish(menu.dishes.get(3), "Coffee", "Americano", false, false);
    }

    @Test
    @DisplayName("Builds a FullMenu with drink and dessert, applying flags to the current dish")
    void shouldBuildMenuWithDrinkAndDessertAndApplyFlagsToCurrentDish() {
        FullMenu menu = FullMenuBuilder.getInstance()
                .setStarter("Sopa")
                .setMainCourse("Pollo")
                .setDrink("Agua")
                .setIsGlutenFree()
                .setDessert("Tarta")
                .setIsVegan()
                .build();

        assertEquals(4, menu.dishes.size());
        assertDish(menu.dishes.get(0), "Starter", "Sopa", false, false);
        assertDish(menu.dishes.get(1), "Main Course: ", "Pollo", false, false);
        assertDish(menu.dishes.get(2), "Drink", "Agua", false, true);
        assertDish(menu.dishes.get(3), "Dessert", "Tarta", true, false);
    }

    @Test
    @DisplayName("Allows building the menu with only starter and main course")
    void shouldBuildMenuWithoutOptionalCourses() {
        FullMenu menu = FullMenuBuilder.getInstance()
                .setStarter("Crema de verduras")
                .setMainCourse("Merluza")
                .build();

        assertEquals(2, menu.dishes.size());
        assertDish(menu.dishes.get(0), "Starter", "Crema de verduras", false, false);
        assertDish(menu.dishes.get(1), "Main Course: ", "Merluza", false, false);
    }

    @Test
    @DisplayName("Allows selecting coffee directly after the main course")
    void shouldBuildMenuWithCoffeeDirectlyAfterMainCourse() {
        FullMenu menu = FullMenuBuilder.getInstance()
                .setStarter("Gazpacho")
                .setMainCourse("Arroz")
                .setCoffee("Solo")
                .setIsGlutenFree()
                .build();

        assertEquals(3, menu.dishes.size());
        assertDish(menu.dishes.get(0), "Starter", "Gazpacho", false, false);
        assertDish(menu.dishes.get(1), "Main Course: ", "Arroz", false, false);
        assertDish(menu.dishes.get(2), "Coffee", "Solo", false, true);
    }

    @Test
    @DisplayName("Allows selecting dessert directly after the main course")
    void shouldBuildMenuWithDessertDirectlyAfterMainCourse() {
        FullMenu menu = FullMenuBuilder.getInstance()
                .setStarter("Crema")
                .setMainCourse("Pescado")
                .setDessert("Fruta")
                .setIsGlutenFree()
                .build();

        assertEquals(3, menu.dishes.size());
        assertDish(menu.dishes.get(0), "Starter", "Crema", false, false);
        assertDish(menu.dishes.get(1), "Main Course: ", "Pescado", false, false);
        assertDish(menu.dishes.get(2), "Dessert", "Fruta", false, true);
    }

    @Test
    @DisplayName("Allows building the menu after selecting only the drink")
    void shouldBuildMenuWithDrinkOnlyAfterMainCourse() {
        FullMenu menu = FullMenuBuilder.getInstance()
                .setStarter("Tomate")
                .setMainCourse("Ternera")
                .setDrink("Agua")
                .setIsVegan()
                .build();

        assertEquals(3, menu.dishes.size());
        assertDish(menu.dishes.get(0), "Starter", "Tomate", false, false);
        assertDish(menu.dishes.get(1), "Main Course: ", "Ternera", false, false);
        assertDish(menu.dishes.get(2), "Drink", "Agua", true, false);
    }

    @Test
    @DisplayName("Throws an exception if the starter is blank")
    void shouldThrowExceptionWhenStarterNameIsBlank() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> FullMenuBuilder.getInstance().setStarter("   "));

        assertEquals("The dish name cannot be empty.", exception.getMessage());
    }

    @Test
    @DisplayName("Throws an exception if the main course is blank")
    void shouldThrowExceptionWhenMainCourseNameIsBlank() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> FullMenuBuilder.getInstance()
                        .setStarter("Ensalada")
                        .setMainCourse("   "));

        assertEquals("The dish name cannot be empty.", exception.getMessage());
    }

    private void assertDish(Dish dish, String expectedType, String expectedName, boolean expectedVegan, boolean expectedGlutenFree) {
        assertAll(
                () -> assertEquals(expectedType, dish.getType()),
                () -> assertEquals(expectedName, dish.getName()),
                () -> assertEquals(expectedVegan, dish.getIsVegan()),
                () -> assertEquals(expectedGlutenFree, dish.getIsGlutenFree())
        );
    }
}
