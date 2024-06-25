package afternoon.poly3.instance;

public class InstanceMain {
    public static void main(String[] args) {
        Parent parent = new Parent();
        Child child = new Child();
        GrandChild grandChild = new GrandChild();

        System.out.println(child instanceof Parent);
        System.out.println(grandChild instanceof Parent);
        System.out.println(parent instanceof Child);
        System.out.println(child instanceof GrandChild);
    }
}
