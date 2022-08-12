abstract class AbstractListInteger{
    private int[] initialList;

    public AbstractListInteger(){
        this.initialList = new int[0];
    }

    public AbstractListInteger(int[] arr){
        this.initialList = arr;
    }

    public int[] getOriginalList(){
        return initialList;
    }

    public abstract int get(int position);
    public abstract void add(int element);
    public abstract void add(int[] elements);
    public abstract int pop();
    public abstract void addAt(int position, int element);
    public abstract void addAt(int position, int[] elements);
    public abstract int removeAt(int position);
    public abstract void removeAllAt(int start);
    public abstract void removeAllAt(int start, int end);
    public abstract AbstractListInteger subList(int start);
    public abstract AbstractListInteger subList(int start, int end);
}






public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
