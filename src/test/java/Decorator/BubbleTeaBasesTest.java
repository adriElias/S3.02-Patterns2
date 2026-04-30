package Decorator;

import Decorator.Bases.LatteBase;
import Decorator.Bases.MatchaBase;
import Decorator.Bases.TeaBase;
import Decorator.Interface.BubbleTea;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BubbleTeaBasesTest {

    @Test
    @DisplayName("LatteBase returns correct description and cost")
    void shouldReturnLatteBaseDescriptionAndCost() {
        BubbleTea latte = new LatteBase();

        assertAll(
                () -> assertEquals("Bubble tea base: latte", latte.getDescription()),
                () -> assertEquals(3.50, latte.getCost())
        );
    }

    @Test
    @DisplayName("MatchaBase returns correct description and cost")
    void shouldReturnMatchaBaseDescriptionAndCost() {
        BubbleTea matcha = new MatchaBase();

        assertAll(
                () -> assertEquals("Bubble tea base: Matcha", matcha.getDescription()),
                () -> assertEquals(3.20, matcha.getCost())
        );
    }

    @Test
    @DisplayName("TeaBase returns correct description and cost")
    void shouldReturnTeaBaseDescriptionAndCost() {
        BubbleTea tea = new TeaBase();

        assertAll(
                () -> assertEquals("Bubble tea base: Tea", tea.getDescription()),
                () -> assertEquals(3.00, tea.getCost())
        );
    }
}

