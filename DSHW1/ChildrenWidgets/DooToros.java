/*
Class name: DooToros
Purpose of the class: This is the main template for widgets for children. It provides the following public methods:
    int getMinAge()
    void setMinAge(int minAge)
    double calculatePrice() @Overriden
    String getName()
    void setName(String name)
Child classes: CatBus, FloofyLop
*/

package ChildrenWidgets;
import Widgets.Widget;

abstract class DooToros extends Widget {
    //members
    private int minAge;         // minimum age of childern that can use this
    private int defaultAge = 2; //default age, to create the object with only name
    private int ageFactor = 8;  //age factor to calculate the prize
    //end members

    //constructors
    public DooToros(String name) {
        this.setName(name);
        this.setMinAge(defaultAge);
    }

    public DooToros(int minAge) {
        this.setName("RDF ChildrenWidgets.DooToros");
        this.setMinAge(minAge);
    }

    public DooToros(String name, int minAge) {
        this.setName(name);
        this.setMinAge(minAge);
    }
    //end constructors

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    @Override
    public double calculatePrice() {
        int x = this.getName().length();
        return (Math.abs(getMinAge()) * ageFactor * 3 * x) % 100;
    }

}