/*
Class name: Sonic
Purpose of the class: This class is for creating special Sonics. which are special talking type of Critter. It provides the following public methods:
    calculatePrice(double markUpValue)
    String sayHi()
    String sayBye()

    double getManufacturingCost()
    double calculatePrice() @Overridden
    double calculateSalePrice()
    String getName()
    void setName(String name)
Child classes: none.
*/

package AdultWidgets;
import Widgets.Talker;

public class Sonic extends Critter implements Talker {
    //members
    private double cutoffForPrize = 25.99;
    private double defaultMarkUpValue = 5.55;
    //end members

    //constructor
    public Sonic() {
        super("Sonic Toy", 99.99);
    }

    public Sonic(String name, double manufacturingCost) {
        super(name, manufacturingCost);
    }
    //end constructor

    //methods
    @Override
    public String sayHi() {
        return "Good day fellow traveler";
    }
    @Override
    public String sayBye() {
        return "Have a nice day";
    }

    public double calculatePrice(double markUpValue) {
        return calculatePrice() + markUpValue;
    }

    @Override
    public double calculatePrice() {
        if(getManufacturingCost() < cutoffForPrize) {
            return calculatePrice(defaultMarkUpValue);
        }
        return this.getManufacturingCost();
    }

    @Override
    public String toString() {
        return super.toString() + this.sayHi();
    }
    //end methods
}