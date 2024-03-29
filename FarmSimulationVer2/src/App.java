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

class Person{
    private String name;
    private double money;

    public Person(String name, double money){
        this.name = name;
        this.money = money;
    }

    public String toString(){
        return "This person name is: " + this.name + ", having $" + this.money + " of money";
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }
}

class Barn{
    private ArrayList<Cow> cowArray = new ArrayList<Cow>();
    private ArrayList<Chicken> chickenArray = new ArrayList<Chicken>();
    private ArrayList<Horse> horseArray = new ArrayList<Horse>();
    private Person manager;
    private Person employy;
    private double milkContainerL = 0;
    private int eggContainer = 0;
    private double assetAUD = 0.0;
    

    public Barn(Person mangeer, Person employee){
        this.manager = mangeer;
        this.employy = employee;
    }


    public void addCow(Cow cow){
        cowArray.add(cow);
    }

    public void addChicken(Chicken chicken){
        chickenArray.add(chicken);
    }

    public void addHorse(Horse horse){
        horseArray.add(horse);
    }

    public String toString(){
        return "Manager is " + this.manager.getName() + "and employee is " + this.employy.getName() + ", having those animals: " + cowArray.toString() + chickenArray.toString() + horseArray.toString() +"\nThis barn asset it " + this.assetAUD;
    }

    public void getCowMilk(){
        double keepMilk = 0;
        for(int i = 0; i < cowArray.size(); i++){
            keepMilk += (cowArray.get(i)).produceMilk();
        }

        this.milkContainerL += keepMilk;
        System.out.println("current milk amount is :" + this.milkContainerL + ("(L)"));
    }

    public void getChickenEgg(){
        int keepEgg = 0;
        for(int i = 0; i < chickenArray.size(); i++){
            keepEgg += (chickenArray.get(i)).produceEgg();
        }
        this.eggContainer += keepEgg;
        System.out.println("current egg amount is :" + this.eggContainer + ("(count)"));
        
    }

    public void sellMilk(){
        if (this.milkContainerL == 0) System.out.println("There is no milk to sell");
        else{
            double money = this.milkContainerL * 1.5;
            this.milkContainerL = 0;
            System.out.println("You got $" + String.valueOf(money));
            this.assetAUD += money;
        }
        System.out.println("current asset is :" + this.assetAUD);
    }

    public void sellEgg(){
        if(this.eggContainer == 0)
        System.out.println("There is not egg to sell");
        else{
            double money = this.eggContainer * 0.7;
            this.eggContainer = 0;
            System.out.println("You got " + String.valueOf(money));
            this.assetAUD += money;
        }
        System.out.println("current asset is :" + this.assetAUD);
    }


    

    public void sellAllCow(){
        double cowMeatRatio = 5.5;
        double sellingPrice = 0;

        for(int i = 0; i < this.cowArray.size(); i++){
            sellingPrice += cowArray.get(i).bmi.getWeightKg() * cowMeatRatio;
        }

        cowArray.clear();
        this.assetAUD += sellingPrice;
        System.out.println("current asset is: " + this.assetAUD);
    }

    public void sellAllChicken(){
        double chickenMeatRatio = 3.3;
        double sellingPrice = 0;
        
        for(int i = 0; i < this.chickenArray.size(); i++){
            sellingPrice += chickenArray.get(i).bmi.getWeightKg() * chickenMeatRatio;
        }

        chickenArray.clear();;
        this.assetAUD += sellingPrice;
        System.out.println("Current asset is: " + this.assetAUD);
    }

    public void sellAllHorse(){
        double horseMeatRatio = 4.7;
        double sellingPrice = 0;
        for(int i = 0; i < this.horseArray.size(); i++){
            sellingPrice += horseArray.get(i).bmi.getWeightKg() * horseMeatRatio;
        }
        horseArray.clear();
        this.assetAUD += sellingPrice;
        System.out.println("Currsent assest is: " + this.assetAUD);

    }


    // public void sayGoodByeToAnimal(){
    //     animalArray.clear();
    // }
}






public class App {
    public static void main(String[] args) throws Exception {


        Cow cowcow = new Cow(100.2, 60, 5555, "female", 0.5);
        Horse horrrse = new Horse( 130, 50, 1000, "male", 1, 40);
        Chicken chicken = new Chicken(40, 20, 2000, "female", 2, "Brown", 0.5, "hard ans sharp", "white and brown");
        Person john = new Person("John", 1000);
        Person mike = new Person("Mike",100);
        Barn barn1 = new Barn(john, mike);
        barn1.addCow(cowcow);
        barn1.addHorse(horrrse);
        barn1.addChicken(chicken);
        // barn1.addChicken(new Chicken(asdfad));

        System.out.println(barn1);
        barn1.getCowMilk();
        barn1.getChickenEgg();
        barn1.sellEgg();
        barn1.sellMilk();
        barn1.sellAllCow();
        barn1.sellAllChicken();
        System.out.println(barn1);

    }
}
