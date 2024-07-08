package afternoon.generic.limit;

public class GenericWorld<Type> {
    private Type number;

    public Type getNumber() {
        return number;
    }

    public void setNumber(Type number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "GenericWorld{" +
                "number=" + number +
                '}';
    }
}
