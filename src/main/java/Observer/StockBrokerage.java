package Observer;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class StockBrokerage implements StockBrokerageObserver{

    private final String name;
    private final DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
    private String message;

    public StockBrokerage(String name){
        this.name = name;
    }

    @Override
    public void notify(String shareName, String event, BigDecimal currentValue) {
        this.message = name + " received notification: " + shareName + " went " + " to "+
                decimalFormat.format(currentValue);
        System.out.println(message);
    }

    public String getName(){
        return name;
    }

    public String getMessage() {
        return message;
    }
}
