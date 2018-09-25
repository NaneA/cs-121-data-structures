/*
Class name: CatBus
Purpose of the class: This class is for creating special Critters. which are special type of Widget. It provides the following public methods:
    int howFar()
    String style()
    String sayHi()
    String sayBye()

    int getMinAge()
    void setMinAge(int minAge)
    double calculatePrice() @Overriden
    String getName()
    void setName(String name)
Child classes: SootBall.
*/

package ChildrenWidgets;

import Widgets.Talker;

public class CatBus extends DooToros implements Locomote, Talker {
    private int moveDistance;

    //constructor
    public CatBus(String name, int distance) {
        super(name);
        moveDistance = distance;
        if(distance >= 5) {
            this.setMinAge(-1);
        }
    }
    public CatBus(String name, int distance, int minAge) {
        super(name, minAge);
        moveDistance = distance;
    }

    //ChildrenWidgets.Locomote interface
    public int howFar() {
        return moveDistance;
    }

    public String style() {
        return "Saunter";
    }
    //end ChildrenWidgets.Locomote interface


    //Widgets.Talker interface
    public String sayHi() {
        return "Hi";
    }
    public String sayBye() {
        return "Bye Bye”";
    }
    //end Widgets.Talker interface


    @Override
    public String toString() {
        String newLine = "\nAge: ";
        if(this.getMinAge() == -1) {
            newLine += "unrestricted";
        } else {
            newLine += this.getMinAge() + " and above";
        }
        return super.toString() + newLine;
    }
}
