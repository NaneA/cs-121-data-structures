/*
Class name: Critter
Purpose of the class: This class is for creating special Critters. which are special type of Widget. It provides the following public methods:
    double getManufacturingCost()
    double calculatePrice() @Overridden
    double calculateSalePrice()
    String getName()
    void setName(String name)
Child classes: Sonic.
*/

package AdultWidgets;
import Widgets.Widget;

public class Critter extends Widget {
    //members
    private double manufacturingCost;
    private double markUpValue = 25.99;
    //end members

    //constructor

    public Critter(String name, double manufacturingCost) {
        super();
        this.setName(name);
        this.manufacturingCost = manufacturingCost;
    }

    public double getManufacturingCost() {
        return manufacturingCost;
    }
    //end constructor

    //methods
    @Override
    public double calculatePrice() {
        return manufacturingCost + markUpValue;
    }

    public double calculateSalePrice() {
        return (calculatePrice() + calculatePrice()/5) - (calculatePrice() + calculatePrice()/5)/10; //Critter +20% − 10%.
    }
    //end methods
}