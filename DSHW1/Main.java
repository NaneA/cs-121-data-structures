
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello person who's grading this :)) !");
    }
}

abstract class Widget{
    private String name;
    abstract public double calculatePrice();
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String toString(){
        return "** Ridge Fluffy Dev **" +  "\n" + this.getName() + ": " + this.calculatePrice();
    }
}


abstract class Dootoros extends Widget{
    private int minAge;
    private int defaultAge = 2;
    private int defaultVactor = 8;
    public int getMinAge(){
        return minAge;
    }
    public void setMinAge(int minAge){
        this.minAge = minAge;
    }
    private int x = this.getName().length();
    public double calculatePrice() {
        return (Math.abs(minAge) * defaultVactor * 3 * x) % 100;
    }
    public Dootoros(String name){
        super();
        this.setName(name);
        this.setMinAge(defaultAge);
    }
    public Dootoros(int minAge){
        super();
        this.setMinAge(minAge);
        this.setName("RDF DooToros");
    }
    public Dootoros(String name, int minAge){
        super();
        this.setMinAge(minAge);
        this.setName(name);
    }
}

abstract class Critter extends Widget{
    private double manuCost, salePrice;
    private String name;
    private double markUpVal = 25.99;

    public Critter(String name, double manuCost){
        super();
        this.setName(name);
        this.manuCost = manuCost;
    }
    public double calculatePrice(){
        return manuCost + markUpVal;
    }

    public double getManuCost() {
        return manuCost;
    }

    public double getMarkUpVal() {
        return markUpVal;
    }

    public double calculateSalesPrice(){
        return salePrice * 9/50; //aysinqn salesprice * (1 + 20/100) (1 - 10/100)
    }
}

class Sonic extends Critter implements Talker{
    public String sayHi(){
        return "Good day fellow traveler";
    }
    public String sayBye(){
        return "Have a nice day";
    }
    public Sonic(String name, double manuCost){
        super(name, manuCost);
    }
    public Sonic(){
        super("Sonic Toy", 99.99);
    }
    public double calculatePrice(double markUpVal){
        return calculatePrice() + markUpVal;
    }
    public double calculatePrice(){
        double cutoff = 25.99;
        double markup = 5.55;
        if(getManuCost() < cutoff){
            return calculatePrice(markup);
        } else {
            return calculatePrice() + getMarkUpVal();
        }
    }
}

/*by taking a markup value (a double) as an argument. This value is simply added to the standard
calculatePrice value for a Critter.*/

interface Locomote{
    int howFar();
    String style();
}

interface Talker{
    public String sayHi();
    public String sayBye();
}
class CatBus extends Dootoros implements Locomote, Talker{
    private int movingThingie;
    public int minVal = 5;
    public int howFar(){
        return movingThingie;
    }
    public String style(){
        return "Saunter";
    }
    public String sayHi(){
        return "Hi";
    }
    public String sayBye(){
        return "Bye Bye";
    }
    public CatBus(String name, int distance){
        super(name);
        movingThingie = distance;
        if(distance > minVal){
            this.setMinAge(-1);
        }
    }
    public CatBus(String name, int distance, int minAge){
        super(name, minAge);
        movingThingie = distance;
    }
    public String toString() {
        if(this.getMinAge() == -1){
            return super.toString() + "Age: unrestricted";
        }
        else{
            return super.toString() + "Age: " + getMinAge() + " above.";
        }
    }
}

class SootBall extends CatBus {
    public SootBall(String name, int minAge){
        super(name, minAge);
    }
    public String style(){
        return "Jump";
    }
    public double calculatePrice(){
        double fixedCost = 4.15;
        double defaultPrice = 9.99;
        double price = super.calculatePrice() + fixedCost;
        if(price > 100){
            price = defaultPrice;
        }
        return price;
    }
}


class FloofyLop extends Dootoros{
    public int calculatePrice(int arg){
        return arg * howFar();
    }
    //my baby constructors
    public FloofyLop(String name){
        super(name);
    }
    public FloofyLop(int minAge){
        super(minAge);
    }
    public FloofyLop(String name, int minAge){
        super(name, minAge);
    }
    public int howFar(){
        return 5;
    }
    public String style(){
        return "Roll";
    }

    public String toString() {
        return super.toString() + "\nFor All Ages";
    }
}