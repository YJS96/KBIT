package afternoon.extendss.superrr;

public class Child extends Parent {
    public Child(String name) {
        super(); // == Parent();
        System.out.println("Child 생성자");
    }

    public Child(String name, int age) {
        super();
        System.out.println("Child 생성자 2");
    }
}
