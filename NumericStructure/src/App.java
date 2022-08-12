import java.util.ArrayList;
import java.util.Arrays;



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


        // - Numeric を拡張した Octaldecimal 型を実装してください。8 進数（0 - 7 桁）を表す文字列から構成されます。
        // - Numeric から拡張された BigDecimalNumeric 型を実装してください。"394.4555643321" のような、10 進数を表す文字列によって構築されます。2 つの BigDecimalNumeric の加算を実装してください。







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

        numericPrinter(num1);
        numericPrinter(num2);
        numericPrinter(num3);
        numericPrinter(num4);
        numericPrinter(num5);
        
    }
}

