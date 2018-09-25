/*
Class name: Talker
Purpose of the class: Interface for all the widgets which can talk. This interface have the following methods:
    String sayHi()
    String sayBye()
Child classes: CatBus, Sonic
*/

package Widgets;

public interface Talker {
    String sayHi();
    String sayBye();
}
