package afternoon.exception.check;

public class Service {
    public static void main(String[] args) {
        Client client = new Client();

        try {
            client.callRandException();
        } catch (MyCheckException2 e) {
            e.printStackTrace();
        }
    }
}
