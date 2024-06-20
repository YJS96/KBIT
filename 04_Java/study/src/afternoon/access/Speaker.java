package afternoon.access;

public class Speaker {
    private int volume;

    public Speaker() {
        this.volume = 20;
    }

    public void volumeUp() {
        if (isVolumeValid(this.volume + 1)) {
            this.volume += 1;
        } else {
            printInvalid();
        }
    }

    public void volumeDown() {
        if (isVolumeValid(this.volume - 1)) {
            this.volume -= 1;
        } else {
            printInvalid();
        }
    }

    public void volumeMute() {
        this.volume = 0;
        System.out.println("스피커가 Mute 되었습니다");
    }

    private boolean isVolumeValid(int amount) {
        return amount >= 0 && amount <= 100;
    }

    private void printInvalid() {
        System.out.println("더 이상 볼륨 조절이 불가능합니다");
    }
}