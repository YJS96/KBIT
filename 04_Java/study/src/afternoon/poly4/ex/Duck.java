package afternoon.poly4.ex;

public class Duck implements Animal, Fly {
    @Override
    public void sound() {
        System.out.println("오리는 꽥꽥");
    }

    @Override
    public void eat() {
        System.out.println("오리는 도토리를 먹어요");
    }

    @Override
    public void fly() {
        System.out.println("오리 날다");
    }
}
