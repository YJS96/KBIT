package afternoon.exception.basic;

public class ExceptionFinally {
    public static void main(String[] args) {
        try {
            Object obj = null;
            obj.equals(null);

            System.out.println("실행하고 싶은 코드");

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("나오나요?");
    }
}
