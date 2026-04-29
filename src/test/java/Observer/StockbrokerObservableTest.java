package Observer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class StockbrokerObservableTest {

    private static class TestObserver implements StockBrokerageObserver {
        private String lastShareName;
        private String lastEvent;
        private BigDecimal lastValue;
        private int notificationCount;

        @Override
        public void notify(String shareName, String event, BigDecimal currentValue) {
            this.lastShareName = shareName;
            this.lastEvent = event;
            this.lastValue = currentValue;
            this.notificationCount++;
        }
    }

    @Test
    @DisplayName("Notifies all registered observers with UP event")
    void shouldNotifyAllObserversWhenMarketGoesUp() {
        StockbrokerObservable observable = new StockbrokerObservable("APPLE");
        TestObserver first = new TestObserver();
        TestObserver second = new TestObserver();

        observable.addObserver(first);
        observable.addObserver(second);

        BigDecimal value = new BigDecimal("150.75");
        observable.stockMarketUp(value);

        assertAll(
                () -> assertObserverState(first, "APPLE", "UP", value, 1),
                () -> assertObserverState(second, "APPLE", "UP", value, 1)
        );
    }

    @Test
    @DisplayName("Notifies all registered observers with DOWN event")
    void shouldNotifyAllObserversWhenMarketGoesDown() {
        StockbrokerObservable observable = new StockbrokerObservable("APPLE");
        TestObserver observer = new TestObserver();
        observable.addObserver(observer);

        BigDecimal value = new BigDecimal("145.50");
        observable.stockMarketDown(value);

        assertObserverState(observer, "APPLE", "DOWN", value, 1);
    }

    @Test
    @DisplayName("Does not notify an observer after it is removed")
    void shouldNotNotifyRemovedObserver() {
        StockbrokerObservable observable = new StockbrokerObservable("APPLE");
        TestObserver active = new TestObserver();
        TestObserver removed = new TestObserver();

        observable.addObserver(active);
        observable.addObserver(removed);
        observable.removeObserver(removed);

        observable.stockMarketUp(new BigDecimal("150.75"));

        assertAll(
                () -> assertEquals(1, active.notificationCount),
                () -> assertEquals(0, removed.notificationCount),
                () -> assertNull(removed.lastShareName),
                () -> assertNull(removed.lastEvent),
                () -> assertNull(removed.lastValue)
        );
    }

    @Test
    @DisplayName("Updates current value when market changes")
    void shouldUpdateCurrentValue() {
        StockbrokerObservable observable = new StockbrokerObservable("APPLE");

        BigDecimal upValue = new BigDecimal("150.75");
        BigDecimal downValue = new BigDecimal("145.50");

        observable.stockMarketUp(upValue);
        assertEquals(upValue, observable.getCurrentValue());

        observable.stockMarketDown(downValue);
        assertEquals(downValue, observable.getCurrentValue());
    }

    private void assertObserverState(TestObserver observer, String expectedShareName, String expectedEvent,
                                     BigDecimal expectedValue, int expectedNotifications) {
        assertAll(
                () -> assertEquals(expectedShareName, observer.lastShareName),
                () -> assertEquals(expectedEvent, observer.lastEvent),
                () -> assertEquals(expectedValue, observer.lastValue),
                () -> assertEquals(expectedNotifications, observer.notificationCount)
        );
    }

}

