package afternoon.lang.math.lotto;

import java.util.Arrays;
import java.util.Random;

public class LottoGenerator {
    private final int LOTTO_SIZE = 6;
    private final int MAX_NUMBER = 45;
    private int[] lottoNumbers;

    public LottoGenerator() {
        lottoNumbers = new int[LOTTO_SIZE];
    }

    public void generate() {
        Random rand = new Random();
        int cnt = 0;
        while (cnt < LOTTO_SIZE) {
            int num = rand.nextInt(MAX_NUMBER) + 1;
            if (!isDup(num)) {
                lottoNumbers[cnt] = num;
                cnt++;
            }
        }
        Arrays.sort(lottoNumbers);
    }

    private boolean isDup(int num) {
        for (int lottoNumber : lottoNumbers) {
            if (num == lottoNumber) {
                return true;
            }
        }
        return false;
    }

    public void printLottoNumbers() {
        System.out.print("로또번호 : ");
        for (int lottoNumber : lottoNumbers) {
            System.out.print(lottoNumber + " ");
        }
    }
}
