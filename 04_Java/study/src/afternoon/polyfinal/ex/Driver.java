package afternoon.polyfinal.ex;

import java.util.Scanner;

public class Driver {
    private Car car;
    Scanner scanner = new Scanner(System.in);

    public void setCar(Car car) {
        this.car = car;
    }

    public void selectCar() {
        System.out.print("운전하고 싶은 차를 선택하세요. (1. K5 / 2. 그랜져 / 3. G70) : ");
        int option = scanner.nextInt();

        if (option == 1) {
            setCar(new K5Car());
        } else if (option == 2) {
            setCar(new Grand());
        } else if (option == 3) {
            setCar(new G70());
        }

        drive();
    }

    public void drive() {
        if (this.car instanceof K5Car) {
            K5Oil();
        }

        car.drive();
    }

    public void K5Oil() {
        System.out.print("K5에 주유할 기름의 양을 입력하세요 : ");
        K5Car.oil = scanner.nextInt();
    }
}
