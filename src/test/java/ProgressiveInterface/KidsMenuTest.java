package ProgressiveInterface;

import ProgressiveInterface.Dish;
import ProgressiveInterface.KidsMenu.KidsMenu;
import ProgressiveInterface.KidsMenu.KidsMenuBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class KidsMenuTest {

    @Test
    @DisplayName("Builds a KidsMenu with main course, drink, and dessert")
    void shouldBuildMenuWithMainCourseDrinkAndDessert() {
        KidsMenu menu = KidsMenuBuilder.getInstance()
                .setMainCourse("Sopa")
                .setIsVegan()
                .setIsGlutenFree()
                .setDrink("Zumo naranja")
                .setDessert("Helado")
                .setIsVegan()
                .setIsGlutenFree()
                .build();

        assertEquals(3, menu.dishes.size());
        assertDish(menu.dishes.get(0), "Main course", "Sopa", true, true);
        assertDish(menu.dishes.get(1), "Drink", "Zumo naranja", false, false);
        assertDish(menu.dishes.get(2), "Dessert", "Helado", true, true);
    }

    @Test
    @DisplayName("Builds a KidsMenu with garnish, drink, and dessert")
    void shouldBuildMenuWithGarnishDrinkAndDessert() {
        KidsMenu menu = KidsMenuBuilder.getInstance()
                .setMainCourse("Pasta")
                .setGarnish("Patatas")
                .setIsVegan()
                .setDrink("Agua")
                .setDessert("Yogur")
                .build();

        assertEquals(4, menu.dishes.size());
        assertDish(menu.dishes.get(0), "Main course", "Pasta", false, false);
        assertDish(menu.dishes.get(1), "Garnish", "Patatas", true, false);
        assertDish(menu.dishes.get(2), "Drink", "Agua", false, false);
        assertDish(menu.dishes.get(3), "Dessert", "Yogur", false, false);
    }

    @Test
    @DisplayName("Builds a KidsMenu with drink and applies flags to the current dish")
    void shouldBuildMenuWithDrinkAndApplyFlagsToCurrentDish() {
        KidsMenu menu = KidsMenuBuilder.getInstance()
                .setMainCourse("Arroz")
                .setDrink("Leche")
                .setIsGlutenFree()
                .build();

        assertEquals(2, menu.dishes.size());
        assertDish(menu.dishes.get(0), "Main course", "Arroz", false, false);
        assertDish(menu.dishes.get(1), "Drink", "Leche", false, true);
    }

    @Test
    @DisplayName("Allows building the menu with only the main course")
    void shouldBuildMenuWithoutOptionalCourses() {
        KidsMenu menu = KidsMenuBuilder.getInstance()
                .setMainCourse("Croquetas")
                .build();

        assertEquals(1, menu.dishes.size());
        assertDish(menu.dishes.get(0), "Main course", "Croquetas", false, false);
    }

    @Test
    @DisplayName("Allows selecting dessert directly after the main course")
    void shouldBuildMenuWithDessertDirectlyAfterMainCourse() {
        KidsMenu menu = KidsMenuBuilder.getInstance()
                .setMainCourse("Hamburguesa")
                .setDessert("Fruta")
                .setIsVegan()
                .build();

        assertEquals(2, menu.dishes.size());
        assertDish(menu.dishes.get(0), "Main course", "Hamburguesa", false, false);
        assertDish(menu.dishes.get(1), "Dessert", "Fruta", true, false);
    }

    @Test
    @DisplayName("Allows building the menu with garnish only after the main course")
    void shouldBuildMenuWithGarnishOnlyAfterMainCourse() {
        KidsMenu menu = KidsMenuBuilder.getInstance()
                .setMainCourse("Pizza")
                .setGarnish("Tomate")
                .setIsGlutenFree()
                .build();

        assertEquals(2, menu.dishes.size());
        assertDish(menu.dishes.get(0), "Main course", "Pizza", false, false);
        assertDish(menu.dishes.get(1), "Garnish", "Tomate", false, true);
    }

    @Test
    @DisplayName("Throws an exception if the main course is blank")
    void shouldThrowExceptionWhenMainCourseNameIsBlank() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> KidsMenuBuilder.getInstance().setMainCourse("   "));

        assertEquals("The dish name cannot be empty.", exception.getMessage());
    }

    @Test
    @DisplayName("Throws an exception if the garnish is blank")
    void shouldThrowExceptionWhenGarnishNameIsBlank() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> KidsMenuBuilder.getInstance()
                        .setMainCourse("Sopa")
                        .setGarnish("   "));

        assertEquals("The dish name cannot be empty.", exception.getMessage());
    }

    @Test
    @DisplayName("Throws an exception if the drink is blank")
    void shouldThrowExceptionWhenDrinkNameIsBlank() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> KidsMenuBuilder.getInstance()
                        .setMainCourse("Sopa")
                        .setDrink("   "));

        assertEquals("The dish name cannot be empty.", exception.getMessage());
    }

    @Test
    @DisplayName("Throws an exception if the dessert is blank")
    void shouldThrowExceptionWhenDessertNameIsBlank() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> KidsMenuBuilder.getInstance()
                        .setMainCourse("Sopa")
                        .setDessert("   "));

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
