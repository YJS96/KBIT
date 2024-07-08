package afternoon.generic.method;

public class GenericMethod {
    public static <T extends Number> T genericMethod(T t) {
        System.out.println("t = " + t);
        return t;
    }
}
