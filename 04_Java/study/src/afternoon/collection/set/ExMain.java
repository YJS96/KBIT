package afternoon.collection.set;

import java.util.HashSet;
import java.util.Random;

public class ExMain {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] lst = new int[10];
        HashSet<Integer> setList = new HashSet<>();

        for (int i = 0; i < lst.length; i++) {
            lst[i] = rand.nextInt(10) + 1;
        }

        for (int i = 0; i < lst.length; i++) {
            setList.add(lst[i]);
        }

        if (lst.length == setList.size()) {
            System.out.println("중복이 아니다!");
        } else {
            System.out.println("중복이다!");
        }
    }
}
