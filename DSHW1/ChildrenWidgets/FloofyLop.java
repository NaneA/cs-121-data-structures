/*
Class name: FloofyLop
Purpose of the class: One of the two childs of DooToros. It provides the following public methods:

    int howFar()
    String style()
    double calculatePrice(int priceFactor)

    int getMinAge()
    void setMinAge(int minAge)
    double calculatePrice() @Overriden
    String getName()
    void setName(String name)
Child classes: none
*/

package ChildrenWidgets;

public class FloofyLop extends DooToros implements Locomote {
    //members
    private int moveSize = 5;
    //end members

    //constructors
    public FloofyLop(String name) {
        super(name);
    }
    public FloofyLop(int minAge) {
        super(minAge);
    }

    public FloofyLop(String name, int minAge) {
        super(name, minAge);
    }
    //end constructors

    //non-abstract public methods
    public int howFar() {
        return moveSize;
    }

    public String style() {
        return "Roll";
    }

    public double calculatePrice(int priceFactor) {
        //we are overloading this function, since it is also possible to calculate the price just like any DooToros object
        return priceFactor * howFar();
    }

    public String toString() {
        return super.toString() + "\n" + "For All Ages";
    }
    //end non-abstract public methods
}

