package afternoon.nested.local.ex1;

import java.util.Random;

public class Ex5Main {
    public static void main(String[] args) {
        Dice diceSum = new Dice() {
            @Override
            public void run() {
                int rand1 = new Random().nextInt(6) + 1;
                int rand2 = new Random().nextInt(6) + 1;
                int sum = rand1 + rand2;
                System.out.println("주사위를 두 번 굴린 값의 합은 : " + sum);
            }
        };

        Dice diceOnce = new Dice() {
            public void run() {
                int rand = new Random().nextInt(6) + 1;
                System.out.println("주사위의 값은 : " + rand);
            }
        };
    }
}
