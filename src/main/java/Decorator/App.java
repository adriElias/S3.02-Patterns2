package Decorator;

import Decorator.Bases.LatteBase;
import Decorator.Decorators.FlavorDecorator;
import Decorator.Decorators.SugarDecorator;
import Decorator.Decorators.TapiocaDecorator;
import Decorator.Interface.BubbleTea;

public class App
{
    public static void main( String[] args ) {
        BubbleTea bubbleTea = new LatteBase();
        bubbleTea = new TapiocaDecorator(bubbleTea);
        bubbleTea = new SugarDecorator(bubbleTea);
        bubbleTea = new FlavorDecorator(bubbleTea, "Maduixa");
        bubbleTea = new FlavorDecorator(bubbleTea, "Mango");

        System.out.println(bubbleTea.getDescription());

        System.out.printf("%.2f%n", bubbleTea.getCost());
    }
}
