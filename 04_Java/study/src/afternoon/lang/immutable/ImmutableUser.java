package afternoon.lang.immutable;

public class ImmutableUser {
    private final String name;

    public ImmutableUser(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public ImmutableUser setName(String name) {
        return new ImmutableUser(name);
    }

    @Override
    public String toString() {
        return "ImmutableUser{" +
                "name='" + name + '\'' +
                '}';
    }


}
