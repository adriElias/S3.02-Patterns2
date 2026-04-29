package Observer;

import java.math.BigDecimal;

public class App
{
    public static void main( String[] args ) {
        StockbrokerObservable agent = new StockbrokerObservable("APPLE");

        agent.addObserver(new StockBrokerage("Alpha Brokers"));
        agent.addObserver(new StockBrokerage("Zenith Investments"));

        agent.stockMarketUp(new BigDecimal("150.75"));

        agent.stockMarketDown(new BigDecimal("145.50"));
    }
}
