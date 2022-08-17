import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public abstract void add(int element);// リストの最後に追加します。
    public abstract void add(int[] elements);// リストの最後の要素に追加します。
    public abstract int pop();// リストの最後から削除します。削除した要素を返します。
    public abstract void addAt(int position, int element);// 指定された位置に要素を追加します。
    public abstract void addAt(int position, int[] elements);// 指定された位置に複数の要素を追加します。
    public abstract int removeAt(int position);// 指定した位置にある要素を削除します。削除した要素を返します。
    public abstract void removeAllAt(int start);// 指定された位置から始まるすべての要素を削除します。
    public abstract void removeAllAt(int start, int end);// startからendまでの全ての要素を削除します。
    public abstract AbstractListInteger subList(int start);// AbstractListIntegerの部分リストを、指定された位置から最後まで返します。
    public abstract AbstractListInteger subList(int start, int end);// startからendまでのAbstractListIntegerの部分リストを返します。
}


//write code from here


class IntegerArrayList extends AbstractListInteger{
    // private ArrayList<Integer> arrayList = new ArrayList<>();
    private ArrayList<Integer> arrayList;


    public IntegerArrayList(ArrayList<Integer> arrayList){
        this.arrayList = arrayList;
    }

    public int get(int position){
        return this.arrayList.get(position);
    }

    public void add(int element){
        this.arrayList.add(element);
    }

    public void add(int[] elements){
        ArrayList tempArrayList = new ArrayList<>(Arrays.asList(elements)) ;
        this.arrayList.addAll(tempArrayList);
    }

    public int pop(){
        return this.arrayList.remove(this.arrayList.size());
    }

    public void addAt(int position, int element){
        this.arrayList.add(position, element);
    }

    public void addAt(int position, int[] elements){
        ArrayList tempArrayList = new ArrayList<>(Arrays.asList(elements)) ;
        this.arrayList.addAll(position, tempArrayList);
    }

    public int removeAt(int position){
        return this.arrayList.remove(position);
    }

    public void removeAllAt(int start){
        this.arrayList.subList(start, this.arrayList.size()).clear();;
    }

    public void removeAllAt(int start, int end){
        this.arrayList.subList(start, end).clear();;
    }
    
    public ArrayList<Integer> subList(int start){
        ArrayList<Integer> list= new ArrayList<Integer>(this.arrayList.subList(start, this.arrayList.size()));
        return list;
    }

    public ArrayList<Integer> subList(int start, int end){
        ArrayList<Integer> list= new ArrayList<Integer>(this.arrayList.subList(start, end));
        return list;
    }


}





public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
