package afternoon.lang.wrapper;

public class WrapperMethodMain {
    public static void main(String[] args) {
        int intValue = Integer.parseInt("10");
        System.out.println(intValue);

        // 비교
        Integer int1 = 10;
        System.out.println(int1.compareTo(20));

        // 산술 연산
        System.out.println(Integer.sum(10, 20));
        System.out.println(Integer.min(10, 20));
        System.out.println(Integer.max(10, 20));
    }
}
