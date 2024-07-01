package afternoon.lang.math;

import java.util.Random;

public class RandomMain {
    public static void main(String[] args) {
        Random rand = new Random();

        System.out.println(rand.nextInt()); // int 범위의 +- 정수
        System.out.println(rand.nextDouble()); // 0 ~ 1.0 소수
        System.out.println(rand.nextDouble()); // T, F
        System.out.println(rand.nextInt(100)); // 0 ~ 99
    }
}
