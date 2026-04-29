package Observer;

import java.math.BigDecimal;

public interface StockBrokerageObserver {
    void notify(String shareName, String event, BigDecimal currentValue);
}
