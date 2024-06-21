package afternoon.extendss;

public class CarMain {
    public static void main(String[] args) {
        GasCar gasCar = new GasCar();
        ElectricCar electricCar = new ElectricCar();

        gasCar.fillUp();
        gasCar.move();
        gasCar.openDoor();

        electricCar.charge();
        electricCar.move();
        electricCar.openDoor();
    }
}
