package ProgressiveInterface;

import ProgressiveInterface.Dish;
import ProgressiveInterface.HalfMenu.HalfMenu;
import ProgressiveInterface.HalfMenu.HalfMenuBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HalfMenuTest {

    @Test
    @DisplayName("Builds a HalfMenu with main course, garnish, and drink")
    void shouldBuildMenuWithMainCourseGarnishAndDrink() {
        HalfMenu menu = HalfMenuBuilder.getInstance()
                .setMainCourse("Sopa")
                .setIsVegan()
                .setIsGlutenFree()
                .setGarnish("Pan")
                .setDrink("Cerveza")
                .setIsGlutenFree()
                .build();

        assertEquals(3, menu.dishes.size());
        assertDish(menu.dishes.get(0), "Main course", "Sopa", true, true);
        assertDish(menu.dishes.get(1), "Garnish", "Pan", false, false);
        assertDish(menu.dishes.get(2), "Drink", "Cerveza", false, true);
    }

    @Test
    @DisplayName("Builds a HalfMenu with drink and applies flags to the current dish")
    void shouldBuildMenuWithDrinkAndApplyFlagsToCurrentDish() {
        HalfMenu menu = HalfMenuBuilder.getInstance()
                .setMainCourse("Pasta")
                .setDrink("Agua")
                .setIsVegan()
                .build();

        assertEquals(2, menu.dishes.size());
        assertDish(menu.dishes.get(0), "Main course", "Pasta", false, false);
        assertDish(menu.dishes.get(1), "Drink", "Agua", true, false);
    }

    @Test
    @DisplayName("Allows building the menu with only the main course")
    void shouldBuildMenuWithoutOptionalCourses() {
        HalfMenu menu = HalfMenuBuilder.getInstance()
                .setMainCourse("Arroz")
                .build();

        assertEquals(1, menu.dishes.size());
        assertDish(menu.dishes.get(0), "Main course", "Arroz", false, false);
    }

    @Test
    @DisplayName("Allows building the menu with garnish only after the main course")
    void shouldBuildMenuWithGarnishOnlyAfterMainCourse() {
        HalfMenu menu = HalfMenuBuilder.getInstance()
                .setMainCourse("Pollo")
                .setGarnish("Patatas")
                .setIsVegan()
                .build();

        assertEquals(2, menu.dishes.size());
        assertDish(menu.dishes.get(0), "Main course", "Pollo", false, false);
        assertDish(menu.dishes.get(1), "Garnish", "Patatas", true, false);
    }

    @Test
    @DisplayName("Throws an exception if the main course is blank")
    void shouldThrowExceptionWhenMainCourseNameIsBlank() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> HalfMenuBuilder.getInstance().setMainCourse("   "));

        assertEquals("The dish name cannot be empty.", exception.getMessage());
    }

    @Test
    @DisplayName("Throws an exception if the garnish is blank")
    void shouldThrowExceptionWhenGarnishNameIsBlank() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> HalfMenuBuilder.getInstance()
                        .setMainCourse("Sopa")
                        .setGarnish("   "));

        assertEquals("The dish name cannot be empty.", exception.getMessage());
    }

    @Test
    @DisplayName("Throws an exception if the drink is blank")
    void shouldThrowExceptionWhenDrinkNameIsBlank() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> HalfMenuBuilder.getInstance()
                        .setMainCourse("Sopa")
                        .setDrink("   "));

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

