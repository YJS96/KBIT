package afternoon.poly4.ex;

public class AnimalMain {
    public static void main(String[] args) {
        Animal[] animals = {new Dog(), new Cat(), new Duck()};

        for (int i = 0; i < animals.length; i++) {
            animalDo(animals[i]);

            if (animals[i] instanceof Fly) {
                flyDo((Fly) animals[i]);
            }

        }
    }

    public static void animalDo(Animal animal) {
//        System.out.println("동물 기능 테스트");
        animal.sound();
        animal.eat();
//        System.out.println("동물 기능 테스트 종료");
    }

    public static void flyDo(Fly fly) {
//        System.out.println("조류 기능 테스트");
        fly.fly();
//        System.out.println("조류 기능 테스트 종료");
    }
}
