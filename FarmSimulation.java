import java.util.Date;
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
        return this.species + this.bmi + " lives " + this.lifeSpanDays + " days/" + "gender:" + this.biologicalSex + "."
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
    private double furLengthCm;
    private String furType;
    private int toothCounter;
    private double bodyTemperatureC;
    private double avgBodyTemperatureC;
    private boolean mammaryGland = false;

    private boolean sweatGland = true;
    private boolean isPregnant = false;

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

    public void produceMilk() {
        if (!this.isAlive())
            return;

        if (!this.isAlive() && this.mammaryGland)
            System.out.println("Producing milk....");
        else
            System.out.println("Cannot produce milk");

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
        return super.toString() + this.mammalInformation();
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