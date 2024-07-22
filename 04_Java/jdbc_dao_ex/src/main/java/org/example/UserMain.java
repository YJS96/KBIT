package org.example;

public class UserMain {
    public static void main(String[] args) {
        UserDao dao = new UserDao();

//        UserVo tetz = new UserVo(1, "tetz", "1234");
//        System.out.println(tetz);

//        dao.create("tetz2", "1234");
//        dao.getAllUsers();
        dao.getAllUsersWithName();
    }
}
