package Course.arrays;

import java.util.ArrayList;

public class List {
    public static void main(String[] args) {
        int [] arr = new int[10];
        java.util.List<Integer> lst = new ArrayList<>();
        lst.add(1);
        lst.add(0,5); // 5 1
        lst.add(2,0); // 5 1 0
        lst.set(2, 10); // 1 5 10
        lst.remove(1); // 1 10
        System.out.println(lst);
    }
}
