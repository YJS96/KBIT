package afternoon.casting1;

public class CastingMain1 {
    public static void main(String[] args) {
        Child child = new Child();
        Parent parent1 = child;
        Parent parent2 = (Parent) child;

//        parent1.childMethod();
        parent2.parentMethod();
    }
}
