package afternoon.collection.map;

import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        hashMap.put("사과", 10000);
        hashMap.put("바나나", 2000);
        hashMap.put("토마토", 500);
        hashMap.put("수박", 20000);

        System.out.println("hashMap = " + hashMap);

        int appleCount = hashMap.get("사과");
        System.out.println("appleCount = " + appleCount);

        boolean hasBanana = hashMap.containsKey("바나나");
        System.out.println("hasBanana = " + hasBanana);

        boolean hasValue20000 = hashMap.containsValue(20000);
        System.out.println("hasValue20000 = " + hasValue20000);

        int removedValue = hashMap.remove("수박");
        System.out.println("removedValue = " + removedValue);
        System.out.println("hashMap = " + hashMap);

    }
}
