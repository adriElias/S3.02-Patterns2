package Decorator;

import Decorator.Bases.LatteBase;
import Decorator.Bases.MatchaBase;
import Decorator.Bases.TeaBase;
import Decorator.Decorators.FlavorDecorator;
import Decorator.Decorators.IceDecorator;
import Decorator.Decorators.SugarDecorator;
import Decorator.Decorators.TapiocaDecorator;
import Decorator.Interface.BubbleTea;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BubbleTeaDecoratorsTest {

    @Test
    @DisplayName("TapiocaDecorator adds description and 0.50 to cost")
    void shouldAddTapiocaDescriptionAndCost() {
        BubbleTea tea = new TapiocaDecorator(new LatteBase());

        assertAll(
                () -> assertTrue(tea.getDescription().contains("+ TAPIOCA")),
                () -> assertEquals(4.00, tea.getCost())
        );
    }

    @Test
    @DisplayName("SugarDecorator adds description and 0.30 to cost")
    void shouldAddSugarDescriptionAndCost() {
        BubbleTea tea = new SugarDecorator(new LatteBase());

        assertAll(
                () -> assertTrue(tea.getDescription().contains("+ SUGAR")),
                () -> assertEquals(3.80, tea.getCost())
        );
    }

    @Test
    @DisplayName("IceDecorator adds description and 0.25 to cost")
    void shouldAddIceDescriptionAndCost() {
        BubbleTea tea = new IceDecorator(new LatteBase());

        assertAll(
                () -> assertTrue(tea.getDescription().contains("+ ICE")),
                () -> assertEquals(3.75, tea.getCost())
        );
    }

    @Test
    @DisplayName("FlavorDecorator adds flavor name to description and 0.60 to cost")
    void shouldAddFlavorDescriptionAndCost() {
        BubbleTea tea = new FlavorDecorator(new LatteBase(), "Mango");

        assertAll(
                () -> assertTrue(tea.getDescription().contains("+ FLAVOR: Mango")),
                () -> assertEquals(4.10, tea.getCost())
        );
    }

    @Test
    @DisplayName("Two FlavorDecorators stack description and cost correctly")
    void shouldStackTwoFlavors() {
        BubbleTea tea = new FlavorDecorator(
                new FlavorDecorator(new LatteBase(), "Maduixa"),
                "Mango"
        );

        assertAll(
                () -> assertTrue(tea.getDescription().contains("+ FLAVOR: Maduixa")),
                () -> assertTrue(tea.getDescription().contains("+ FLAVOR: Mango")),
                () -> assertEquals(4.70, tea.getCost(), 0.001)
        );
    }

  @Test
    @DisplayName("Combining Tapioca + Sugar + two Flavors stacks description and cost correctly")
    void shouldCombineMultipleDecorators() {
        // LatteBase(3.50) + Tapioca(0.50) + Sugar(0.30) + Flavor(0.60) + Flavor(0.60) = 5.50
        BubbleTea tea = new FlavorDecorator(
                new FlavorDecorator(
                        new SugarDecorator(
                                new TapiocaDecorator(new LatteBase())
                        ), "Maduixa"
                ), "Mango"
        );

        assertAll(
                () -> assertTrue(tea.getDescription().contains("Bubble tea base: latte")),
                () -> assertTrue(tea.getDescription().contains("+ TAPIOCA")),
                () -> assertTrue(tea.getDescription().contains("+ SUGAR")),
                () -> assertTrue(tea.getDescription().contains("+ FLAVOR: Maduixa")),
                () -> assertTrue(tea.getDescription().contains("+ FLAVOR: Mango")),
                () -> assertEquals(5.50, tea.getCost(), 0.001)
        );
    }

    @Test
    @DisplayName("Full combination with MatchaBase stacks cost correctly")
    void shouldCombineDecoratorsOnMatchaBase() {
        // MatchaBase(3.20) + Ice(0.25) + Sugar(0.30) + Flavor(0.60) = 4.35
        BubbleTea tea = new FlavorDecorator(
                new SugarDecorator(
                        new IceDecorator(new MatchaBase())
                ), "Strawberry"
        );

        assertAll(
                () -> assertTrue(tea.getDescription().contains("Bubble tea base: Matcha")),
                () -> assertTrue(tea.getDescription().contains("+ ICE")),
                () -> assertTrue(tea.getDescription().contains("+ SUGAR")),
                () -> assertTrue(tea.getDescription().contains("+ FLAVOR: Strawberry")),
                () -> assertEquals(4.35, tea.getCost())
        );
    }

    @Test
    @DisplayName("Full combination with TeaBase stacks cost correctly")
    void shouldCombineDecoratorsOnTeaBase() {
        // TeaBase(3.00) + Tapioca(0.50) + Ice(0.25) = 3.75
        BubbleTea tea = new IceDecorator(
                new TapiocaDecorator(new TeaBase())
        );

        assertAll(
                () -> assertTrue(tea.getDescription().contains("Bubble tea base: Tea")),
                () -> assertTrue(tea.getDescription().contains("+ TAPIOCA")),
                () -> assertTrue(tea.getDescription().contains("+ ICE")),
                () -> assertEquals(3.75, tea.getCost())
        );
    }
}



