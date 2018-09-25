/*
Class name: Widget
Purpose of the class: The main class of framework. It provides the following public methods:
    abstract double calculatePrice()
    String getName()
    void setName(String name)
Child classes: DooToros, Critter.
*/


package Widgets;

public abstract class Widget {
    //members
    protected String name;
    //end members

    //abstract methods
    public abstract double calculatePrice();
    //end abstract methods

    //non-abstract public methods
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "** Ridge Fluffy Dev **" +  "\n" + this.getName() + ":" + this.calculatePrice() ;
    }
    //end non-abstract public methods

}