interface Fly{
    public abstract void fly();
    public abstract double flightHeight();
    public abstract double flySpeed();

}

class Bird implements Fly{
    private String name;


    public Bird(String name){
        this.name = name;
    }

    public void fly(){
        System.out.println(this.name + " is flying");
    }

    public double flightHeight(){
        return 40.4;
    }

    public double flySpeed(){
        return 4.4;
    }
}

class Airplane implements Fly{
    private String name;

    public Airplane(String name){
        this.name = name;
    }

    public void fly(){
        System.out.println(this.name + " is flying");
    }

    public double flightHeight(){
        return 1000;
    }

    public double flySpeed(){
        return 555.4;
    }
}

class Helicopter implements Fly{
    private String name;

    public Helicopter(String name){
        this.name = name;
    }

    public void fly(){
        System.out.println(this.name + " is flying");
    }

    public double flightHeight(){
        return 2000;
    }

    public double flySpeed(){
        return 400;
    }
}

class Drone implements Fly{
    private String name;

    public void fly(){
        System.out.println(this.name + " is flying");
    }

    public double flightHeight(){
        return 3000;
    }

    public double flySpeed(){
        return 5555.5;
    }
}

class PaperAirplane implements Fly{
    private String name;

    public void fly(){
        System.out.println(this.name + " is flying");
    }

    public double flightHeight(){
        return 2;
    }

    public double flySpeed(){
        return 13;
    }
}






public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
