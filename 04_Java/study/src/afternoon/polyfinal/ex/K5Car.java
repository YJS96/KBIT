package afternoon.polyfinal.ex;

public class K5Car implements Car {
    static int oil;
    final int EFFICIENCY = 2;
//    private int cnt = 0;

    @Override
    public void openDoor() {
        System.out.println("K5, 차 문을 엽니다");
    }

    @Override
    public void drive() {
        System.out.println("K5 주행 시작");
        this.getDistance();
        System.out.println("K5 주행 종료");
    }

    public void getDistance() {
        int cnt = 0;
        while (oil >= EFFICIENCY) {
            oil -= EFFICIENCY;
            cnt += 1;
            System.out.printf("K5가 %dkm를 주행했습니다.\n", cnt);
        }
        System.out.printf("K5가 최종 주행한 거리는 %dkm 입니다\n", cnt);
    }
}
