
import java.math.*;


abstract class Numeric{
    

    public byte getByte(){
        return (byte) this.getInteger();
    }

    public short getShort(){
        return (short) this.getInteger();
    }

    public long getLong(){
        return (long) this.getInteger();
    }

    public char getChar(){
        return (char) this.getInteger();
    }

    
    public abstract int getInteger();

    public abstract double getDouble();

    public String toString(){

        return this.getClass().getSimpleName() + " of int value: " + this.getInteger();
    }
}

class IntegerNumeric extends Numeric{
    private int value;

    public IntegerNumeric(int value){
        this.value = value;
    }

    public int getInteger(){
        return this.value;
    }

    public double getDouble(){
        return this.value + 0.0;
    }
}

class CharNumeric extends Numeric{
    private char c;

    public CharNumeric(char c){
        this.c = c;
    }

    public CharNumeric(int c){
        this.c = (char) c;
    }

    public int getInteger(){
        return this.c;
    }

    public double getDouble(){
        return this.getInteger() + 0.0;
    }
}

class Hexadecimal extends Numeric{
    private String value;

    public Hexadecimal(String value){
        this.value = value;
    }

    public int getInteger(){
        int decimal=Integer.parseInt(this.value,16);  
        return decimal;
    }

    public double getDouble(){
        return Integer.parseInt(this.value,16)+ 0.0;
    }

}

class Octaldecimal extends Numeric{
    private String value;

    public Octaldecimal(String value){
        this.value = value;
    }

    public int getInteger(){
        int decimal = Integer.parseInt(this.value, 8);
        return decimal;
    }

    public double getDouble(){
        return Integer.parseInt(this.value, 8) + 0.0;
    }
}

class BigDecimalNumeric extends Numeric{
    private BigDecimal value1;
    private BigDecimal value2;
    
    public BigDecimalNumeric(String value1, String value2){
        this.value1 = new BigDecimal(value1);
        this.value2 = new BigDecimal(value2);
    }

    public int getInteger(){
        return (value1.add(value2)).intValue();
    }

    public double getDouble(){
        return (value1.add(value2)).doubleValue();
    }
}

public class App {

    public static void numericPrinter(Numeric num){
        System.out.println(num);
        System.out.println("Byte: " + num.getByte());
        System.out.println("Short: " + num.getShort());
        System.out.println("Long: " + num.getLong());
        System.out.println("Char: " + num.getChar());
        System.out.println("Double: " + num.getDouble());
        System.out.println();
    }
    public static void main(String[] args) throws Exception {
        Numeric num1 = new IntegerNumeric(73);
        Numeric num2 = new IntegerNumeric(23555461);
        Numeric num3 = new CharNumeric(61);
        Numeric num4 = new Hexadecimal("20C");
        Numeric num5 = new Octaldecimal("1134");
        Numeric num6 = new BigDecimalNumeric("124567890.0987654321", "987654321.123456789");

        numericPrinter(num1);
        numericPrinter(num2);
        numericPrinter(num3);
        numericPrinter(num4);
        numericPrinter(num5);
        numericPrinter(num6);
        
    }
}

