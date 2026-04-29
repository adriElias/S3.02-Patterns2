package Observer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StockBrokerageTest {

    @Test
    @DisplayName("Notifies all agencies when the market goes up and down")
    void testStockAgentNotifications() {
        StockbrokerObservable agent = new StockbrokerObservable("Stock market");

        StockBrokerage alphaBrokers = new StockBrokerage("Alpha Brokers");
        StockBrokerage zenithInvestments = new StockBrokerage("Zenith Investments");

        agent.addObserver(alphaBrokers);
        agent.addObserver(zenithInvestments);

        agent.stockMarketUp(new BigDecimal("150.75"));
        // Expected console output:
        // Alpha Brokers received notification: Stock market went UP to 150.75
        // Zenith Investments received notification: Stock market went UP to 150.75

        assertAll(
                () -> assertTrue(alphaBrokers.getMessage().contains("Alpha Brokers received notification")),
                () -> assertTrue(alphaBrokers.getMessage().contains("Stock market")),
                () -> assertContainsAmount(alphaBrokers.getMessage(), "150.75"),
                () -> assertTrue(zenithInvestments.getMessage().contains("Zenith Investments received notification")),
                () -> assertTrue(zenithInvestments.getMessage().contains("Stock market")),
                () -> assertContainsAmount(zenithInvestments.getMessage(), "150.75")
        );

        agent.stockMarketDown(new BigDecimal("145.50"));
        // Expected console output:
        // Alpha Brokers received notification: Stock market went DOWN to 145.50
        // Zenith Investments received notification: Stock market went DOWN to 145.50

        assertAll(
                () -> assertContainsAmount(alphaBrokers.getMessage(), "145.50"),
                () -> assertContainsAmount(zenithInvestments.getMessage(), "145.50")
        );
    }

    @Test
    @DisplayName("Allows unsubscribing an agency and stops notifying it")
    void shouldNotNotifyRemovedObserver() {
        StockbrokerObservable agent = new StockbrokerObservable("Stock market");

        StockBrokerage alphaBrokers = new StockBrokerage("Alpha Brokers");
        StockBrokerage zenithInvestments = new StockBrokerage("Zenith Investments");

        agent.addObserver(alphaBrokers);
        agent.addObserver(zenithInvestments);
        agent.removeObserver(zenithInvestments);

        agent.stockMarketUp(new BigDecimal("150.75"));

        assertAll(
                () -> assertContainsAmount(alphaBrokers.getMessage(), "150.75"),
                () -> assertEquals(null, zenithInvestments.getMessage())
        );
    }

    private void assertContainsAmount(String message, String expectedAmount) {
        assertTrue(message.replace(',', '.').contains(expectedAmount));
    }
}
