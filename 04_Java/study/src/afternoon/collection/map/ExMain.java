package afternoon.collection.map;

import java.util.HashMap;
import java.util.Random;

public class ExMain {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] lst = new int[10];
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < lst.length; i++) {
            lst[i] = rand.nextInt(10) + 1;
            hashMap.put(i + 1, 0);
        }

        for (int i : lst) {
            hashMap.put(i, hashMap.get(i) + 1);
        }

        System.out.println("hashMap = " + hashMap);
    }
}
