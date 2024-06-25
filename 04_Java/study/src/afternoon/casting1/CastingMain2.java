package afternoon.casting1;

public class CastingMain2 {
    public static void main(String[] args) {
        Parent parent1 = new Child();
        Child child1 = (Child) parent1;

        Parent parent2 = new Parent();
        Child child2 = (Child) parent2;
    }
}
