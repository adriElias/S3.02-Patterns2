package Observer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class StockbrokerObservable {
    private final List<StockBrokerageObserver> observers = new ArrayList<>();
    private BigDecimal currentValue;
    private final String shareName;

    public StockbrokerObservable(String shareName) {
        this.shareName = shareName;
    }

    public void addObserver(StockBrokerageObserver observer){
        observers.add(observer);
    }

    public void removeObserver(StockBrokerageObserver observer){
        observers.remove(observer);
    }

    private void notifyObservers(String event){
        observers.forEach(o -> o.notify(shareName, event, currentValue));
    }

    public void stockMarketUp(BigDecimal value){
        this.currentValue = value;
        notifyObservers("UP");
    }

    public void stockMarketDown(BigDecimal value){
        this.currentValue = value;
        notifyObservers("DOWN");
    }

    public BigDecimal getCurrentValue() {
        return currentValue;
    }

}
