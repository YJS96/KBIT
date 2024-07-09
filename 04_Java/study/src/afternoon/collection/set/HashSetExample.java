package afternoon.collection.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();

        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);
        set.add(50);

        // 중복 데이터 추가 시도
        boolean isAdded = set.add(30);
        System.out.println("isAdded = " + isAdded);
        System.out.println("set = " + set);

        // 데이터 검색
        boolean contains20 = set.contains(20);
        boolean contains60 = set.contains(60);
        System.out.println("contains20 = " + contains20);
        System.out.println("contains60 = " + contains60);

        // 데이터 삭제
        boolean isRemoved = set.remove(20);
        System.out.println("isRemoved = " + isRemoved);
        System.out.println("set = " + set);

        // Set의 크기 확인
        int size = set.size();
        System.out.println("size = " + size);
    }
}
