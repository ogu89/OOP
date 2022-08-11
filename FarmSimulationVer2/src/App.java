import java.util.Date;
import java.util.Random;
import java.util.ArrayList;
import java.text.SimpleDateFormat;


class BMI {
    private double heightM;
    private double weightKg;

    public BMI(double heightM, double weightKg) {
        this.heightM = heightM;
        this.weightKg = weightKg;
    }

    public double getWeightKg() {
        return this.weightKg;
    }

    public double getValue() {
        return this.weightKg / (this.heightM * this.heightM);
    }

    public String toString() {
        return this.heightM + " meters, " + this.weightKg + "kg, BMI:" + this.getValue();
    }
}


class Animal {
    protected String species;
    protected BMI bmi;
    protected double lifeSpanDays;
    protected String biologicalSex;
    protected Date spawnTime;
    protected Date deathTime;
    protected int hungerPercent = 100;
    protected int sleepPercent = 100;

    public Animal(String species, double heightM, double weightKg, double lifeSpanDays, String biologicalSex) {
        this.species = species;
        this.bmi = new BMI(heightM, weightKg);
        this.lifeSpanDays = lifeSpanDays;
        this.biologicalSex = biologicalSex;
        this.spawnTime = new java.util.Date();
    }

    public void eat() {
        if (!this.isAlive())
            return;
        this.hungerPercent = 0;
    }

    public void setAsHungry() {
        if (!this.isAlive())
            return;
        this.hungerPercent = 100;
    }

    public boolean isHungry() {
        return this.hungerPercent >= 70;
    }

    public void sleep() {
        if (!this.isAlive())
            return;
        this.sleepPercent = 0;
    }

    public void setAsSleepy() {
        if (!this.isAlive())
            return;
        this.sleepPercent = 100;
    }

    public boolean isSleepy() {
        return this.sleepPercent >= 70;
    }

    public void die() {
        this.sleepPercent = 0;
        this.hungerPercent = 0;
        this.deathTime = new java.util.Date();
    }

    public boolean isAlive() {
        return this.deathTime == null;
    }

    public void move() {
        if (!this.isAlive())
            return;
        System.out.println("This animal just moved...");
    }

    public String toString() {
        return this.species + ": " + this.bmi + " lives " + this.lifeSpanDays + " days/" + "gender:" + this.biologicalSex + "."
                + this.status();
    }

    public String status() {
        return this.species + " status:" + " Hunger - " + this.hungerPercent + "%, " + "sleepiness:" + this.sleepPercent
                + "%" + ", Alive - " + this.isAlive() + ". First created at " + this.dateCreated();
    }

    public String dateCreated() {
        return new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(this.spawnTime);
    }
}


class Mammal extends Animal {
    protected double furLengthCm;
    protected String furType;
    protected int toothCounter;
    protected double bodyTemperatureC;
    protected double avgBodyTemperatureC;
    protected boolean mammaryGland = false;

    protected boolean sweatGland = true;
    protected boolean isPregnant = false;

    public Mammal(String species, double heightM, double weightKg, double lifeSpanDays, String biologicalSex,
            double furLengthCm, String furType, double avgBodyTemperatureC) {

        super(species, heightM, weightKg, lifeSpanDays, biologicalSex);

        this.furLengthCm = furLengthCm;
        this.furType = furType;

        this.mammaryGland = (biologicalSex == "female");

        this.avgBodyTemperatureC = avgBodyTemperatureC;
        this.bodyTemperatureC = this.avgBodyTemperatureC;
    }

    public void sweat() {
        if (!this.isAlive())
            return;

        if (this.sweatGland)
            System.out.print("Sweating....");
        this.bodyTemperatureC -= 0.3;
        System.out.print("Body temperature is now " + this.bodyTemperatureC + "C");
        System.out.println();
    }

    public void mate(Mammal mammal) {
        if (!this.isAlive())
            return;

        this.isPregnant = true;
    }

    public void fertalize() {
        if (!this.isAlive())
            return;

        this.isPregnant = true;
    }

    public boolean isPregnant() {
        if (!this.isAlive())
            return false;

        return this.isPregnant;
    }

    public void bite() {
        if (!this.isAlive())
            return;

        System.out.println(this.species + " bites with their single lower jaws which has"
                + (this.toothCounter == 0 ? " not" : "") + " replaced its teeth: " + (this.toothCounter > 0));
        System.out.println();
    }

    public void replaceTeeth() {
        if (!this.isAlive())
            return;

        if (this.toothCounter == 0)
            this.toothCounter++;
    }

    public void increaseBodyHeat(double celcius) {
        this.bodyTemperatureC += celcius;
    }

    public void decreaseBodyHead(double celcius) {
        this.bodyTemperatureC -= celcius;
    }

    public void adjustBodyHeat() {
        this.bodyTemperatureC = this.avgBodyTemperatureC;
    }

    public void move() {
        if (!this.isAlive())
            return;
        System.out.println("This mammal is moving........");
        System.out.println();
    }

    public String toString(){
        return super.toString() + " & " + this.mammalInformation();
    }

    public String mammalInformation(){
        return "This is a mammal with the following - "+"fur:"+this.furType+"/teethReplaced:"+(this.toothCounter>0)+"/Pregnant:"+this.isPregnant()+"/Body Temperature:"+this.bodyTemperatureC;
    }
    public void eat(){
        super.eat();
        this.bite();
        System.out.println("this" + this.species + " is eating with its single lower jaw");
    }
}

// Person class
class Person extends Mammal{
    private double moneyAUD;
    private Barn barn;
    private double milkContainerL = 0.0;
    private int eggContainer = 0;


    public Person(double heightM, double weightKg, double lifeSpanDays, String biologicalSex, double furLengthCm, double moneyAUD){
        super("Human", heightM, weightKg, lifeSpanDays, biologicalSex, furLengthCm, "Human fur", 36.3);
        this.moneyAUD = moneyAUD;
        this.barn = new Barn();
    }

    public void getMoneyAUD(){
        System.out.println(moneyAUD);
    }

    public void getCowMilk(){
        milkContainerL += this.barn.produceCowMilk();
    }

    public void getChickenEgg(){
        eggContainer += this.barn.produceChickenEgg();
    }

    public void sellMilk(){
        if (this.milkContainerL == 0) System.out.println("There is no milk to sell");
        double money = this.milkContainerL * 1.5;
        this.milkContainerL = 0;
        System.out.println("You got $" + String.valueOf(money));
        this.moneyAUD += money;
    }

    public void sellEgg(){
        if(this.eggContainer == 0)System.out.println("There is not egg to sell");
        double money = this.eggContainer * 0.7;
        this.eggContainer = 0;
        System.out.print("You got " + String.valueOf(money));
        this.moneyAUD += money;
    }

    public void sellAllAnimal(){
        double cowMeatRatio = 5.5;
        double chickenMeatRatio = 3.3;
        double horseMeatRatio = 4.7;

        double sellingPrice = 0;

        for(int i = 0; i < this.barn.getAnimalArray().size(); i++){

            if(this.barn.getAnimalArray().get(i) instanceof Horse) sellingPrice += ((Horse) this.barn.getAnimalArray().get(i)).getPace();
            else sellingPrice += this.barn.getAnimalArray().get(i).bmi.getWeightKg();

            this.moneyAUD += sellingPrice;
        }
        this.barn.sayGoodByeToAnimal();
    }

    public void showMoney(){
        System.out.println(this.moneyAUD);
    }

    public void showBarn(){
        System.out.println(this.barn);
    }

    public void startKeepingAnimal(Animal animal){
        this.barn.addAnimal(animal);
    }
}

class Barn{
    private ArrayList<Animal> animalArray = new ArrayList<Animal>();

    public Barn(){}

    public ArrayList<Animal> getAnimalArray(){
        return animalArray;
    }

    public void addAnimal(Animal animal){
        animalArray.add(animal);
    }

    public String toString(){
        return animalArray.toString();
    }

    public double produceCowMilk(){
        double keepMilk = 0;
        for(int i = 0; i < animalArray.size(); i++){
            // System.out.println(animalArray.get(i).getClass());
            if(animalArray.get(i) instanceof Cow){
                // System.out.println(animalArray.get(i).getClass());
                keepMilk += ((Cow) animalArray.get(i)).produceMilk();
            } 
        }
        return keepMilk;
    }

    public int produceChickenEgg(){
        int keepEgg = 0;
        for(int i = 0; i < animalArray.size(); i++){
            if(animalArray.get(i) instanceof Chicken){
                keepEgg += ((Chicken) animalArray.get(i)).produceEgg();
            }
        }
        return keepEgg;
    }

    public void sayGoodByeToAnimal(){
        animalArray.clear();
    }
}



// Horse class 
class Horse extends Mammal{
    private double pace;

    public Horse(double heightM, double weightKg, double lifeSpanDays, String biologicalSex, double furLengthCm, double pace){

        super("Horse", heightM, weightKg, lifeSpanDays, biologicalSex, furLengthCm, "Horse fur", 37.9);

        this.pace = pace;
    }

    public void runAway(){
        System.out.println(super.species + " is running away..........\nOh coming back");
    }
    
    public void horsePace(){
        System.out.println("This horse pace is" + String.valueOf(this.pace) + "(KM)");
    }

    public double getPace(){
        return this.pace;
    }

    public String toString(){
        return "This is horse";
    }
    

}

// Cow class
class Cow extends Mammal{

    public Cow(double heightM, double weightKg, double lifeSpanDays, String biologicalSex, double furLengthCm){
        super("Cow", heightM, weightKg, lifeSpanDays, biologicalSex, furLengthCm, "Cow fur", 38.4);

    }

    public double produceMilk() {
        double milkL = 0;
        if (!this.isAlive())
            return 0;

        if (this.isPregnant()&& this.mammaryGland){
            double random = new Random().nextDouble();
            milkL =  0 +Math.round( (random * (20)) )  / 10.0;
            System.out.println("Producing milk....");
        }else
            System.out.println("Cannot produce milk");

        // System.out.println("This cow has "+ String.valueOf(this.milkAmountL) + " of milk(L)" );

        return milkL;
    }

    public void print(){
        System.out.println("weeeeee");
    }
}

// Brid class
class Bird extends Animal{
    protected String featherColor;
    protected double wingSpanM;
    protected String beakType;
    protected double bodyTemperatureC;
    protected double avgBodyTemperatureC;
    
    public Bird(String species, double heightM, double weightKg, double lifeSpanDays, String biologicalSex, double avgBodyTemperatureC,String featherColor, double wingSpanM, String beakType){
        super(species, heightM, weightKg, lifeSpanDays, biologicalSex);

        this.featherColor = featherColor;
        this.wingSpanM = wingSpanM;
        this.beakType = beakType;
        this.avgBodyTemperatureC = avgBodyTemperatureC;
        this.bodyTemperatureC = this.avgBodyTemperatureC;
    }

    public void squawk(){
        System.out.println("Squawwwwwwwwwwwwwwwwwwwwwwwk");
    }

    public void fly(){
        System.out.println("flying somewhere");
    }
}

class Chicken extends Bird{
    private String eggColor;

    public Chicken(double heightM, double weightKg, double lifeSpanDays, String biologicalSex, double avgBodyTemperatureC, String featherColor,double wingSpanM, String beakType, String eggColor){
        super("Chicken", heightM, weightKg, lifeSpanDays, biologicalSex, avgBodyTemperatureC, featherColor, wingSpanM, beakType);
        this.eggColor = eggColor;

    }

    public void showEgg(){
        
        System.out.println(eggColor);
    }
    
    public int produceEgg(){
        int eggs = 0;
        if(!this.isAlive())
            return 0;
        // if (!this.isAlive() && this.mammaryGland)
        Random rand = new Random();
        eggs = rand.nextInt(10);
        System.out.println("Producing eggs...." + String.valueOf(eggs));
        
        return eggs;
    }

    // public void produceEggs() {
    //     if (!this.isAlive())
    //         return;

    //     if (!this.isAlive() && this.mammaryGland){
    //         double random = new Random().nextDouble();
    //         double result = 0 + (random * (2));
    //         this.milkAmountL += result;
    //         System.out.println("Producing milk....");
    //     }else
    //         System.out.println("Cannot produce milk");
    //     System.out.println("This cow has "+ String.valueOf(this.milkAmountL) + " of milk(L)" );
    // }
}

class Parrot extends Bird{
    // private ArrayList<Integer> nums = new ArrayList<Integer>();
    private ArrayList<String> phraseMemory = new ArrayList<String>();

    public Parrot(String species, double heightM, double weightKg, double lifeSpanDays, String biologicalSex, double avgBodyTemperatureC, String featherColor, double wingSpanM, String beakType){
        super(species, heightM, weightKg, lifeSpanDays, biologicalSex, avgBodyTemperatureC, featherColor, wingSpanM, beakType);
    }

    public void memoriseWord(String word){
        this.phraseMemory.add(word);
    }
    public void talk(){
        Random rand = new Random();

        int randomNum = rand.nextInt((this.phraseMemory.size() - 0) + 1) + 0;

        System.out.println(this.phraseMemory.get(randomNum));
    }
}



public class App {
    public static void main(String[] args) throws Exception {


        Person ken = new Person(175.5, 70.3, 700800, "male", 0.2, 100);
        Cow cowcow = new Cow(100.2, 60, 5555, "female", 0.5);
        Horse horrrse = new Horse( 130, 50, 1000, "male", 1, 40);
        Chicken chicken = new Chicken(40, 20, 2000, "female", 2, "Brown", 0.5, "hard ans sharp", "white and brown");
        


        // System.out.println();
        // System.out.println(ken);
        // System.out.println();
        // System.out.println(cowcow);
        // System.out.println();
        // System.out.println(horrrse);
        // System.out.println();
        // System.out.println(chicken);
        // System.out.println();


        ken.startKeepingAnimal(cowcow);
        ken.startKeepingAnimal(horrrse);
        ken.startKeepingAnimal(chicken);
        System.out.println();
        ken.showMoney();
        ken.showBarn();
        System.out.println();
        ken.getCowMilk();
        ken.getChickenEgg();
        ken.sellAllAnimal();
        ken.showBarn();
        ken.getMoneyAUD();
        System.out.println(cowcow);
    }
}
