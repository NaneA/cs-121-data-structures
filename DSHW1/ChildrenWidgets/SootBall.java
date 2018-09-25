
/*
Class name: SootBall
Purpose of the class: It provides the following public methods:
    String style()
    double calculatePrice()

    int howFar()
    String sayHi()
    String sayBye()

    int getMinAge()
    void setMinAge(int minAge)
    double calculatePrice() @Overriden
    String getName()
    void setName(String name)
Child classes: none.
*/

package ChildrenWidgets;

public class SootBall extends CatBus {

    public SootBall(String name, int minAge) {
        super(name, minAge);
    }

    @Override
    public String style() {
        return "Jump";
    }

    @Override
    public double calculatePrice() {
        double fixedCost = 4.15;
        double defaultPrize = 9.99;
        double prize = super.calculatePrice() + fixedCost;
        if (prize > 100) {
            prize = defaultPrize;
        }
        return prize;
    }
}
