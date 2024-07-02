package afternoon.nested.local.ex3;

public class AnonymousMain {
    public static void main(String[] args) {
        Hello hello = new Hello() {
            @Override
            public void hello() {
                System.out.println("hello 메서드 실행");
            }
        };

        hello.hello();
    }
}
