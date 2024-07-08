package afternoon.generic.ex3;

public class Pair<Type1, Type2> {
    private Type1 key;
    private Type2 value;

    public Pair(Type1 key, Type2 value) {
        this.key = key;
        this.value = value;
    }

    public Type1 getKey() {
        return key;
    }

    public Type2 getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
