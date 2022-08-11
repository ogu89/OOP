class Main{
    public static boolean isLeapYear(int year){
        if (year % 400 == 0) return true;
        else if (year % 100 == 0) return false;
        else if (year % 4 == 0) return true;
        else return false;
    }

    public static void main(String[] args){
        System.out.println(isLeapYear(2000)); // true
        System.out.println(isLeapYear(2011)); // false
        System.out.println(isLeapYear(2012)); // true
        System.out.println(isLeapYear(2024)); // true
        System.out.println(isLeapYear(1900)); // false
        System.out.println(isLeapYear(2100)); // false
    }
}
