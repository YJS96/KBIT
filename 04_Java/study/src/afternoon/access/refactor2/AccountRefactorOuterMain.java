package afternoon.access.refactor2;

import afternoon.access.refactor.AccountRefactor;

public class AccountRefactorOuterMain {
    public static void main(String[] args) {
        AccountRefactor account = new AccountRefactor("우리은행", "브론즈", "임준수", 1000);

        // public
        System.out.println(account.bank);

        // default
        // System.out.println(account.grade);
    }
}
