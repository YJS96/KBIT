package afternoon.poly3;

public class PolyMain1 {
    public static void main(String[] args) {
        Child child = new Child();

        child.childMethod();
        child.parentMethod();

        Parent parent = new Child();

        Child poly = (Child) parent;
        poly.childMethod();

    }
}
