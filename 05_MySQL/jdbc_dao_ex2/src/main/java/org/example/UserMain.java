package org.example;

public class UserMain {
    public static void main(String[] args) {

//        UserDao userDao = new UserDao();
//        UserDaoV2 userDaoV2 = new UserDaoV2();
//        UserDaoV3 userDaoV3 = new UserDaoV3();
        UserDao2 userDao2 = new UserDao2();

//        UserVo2 newUser = new UserVo2(40, "ddd", "dddd");
//        userDao2.addUser(newUser);
        userDao2.getAllUsers();
        userDao2.deleteUser(5);
        userDao2.getAllUsers();
//        userDao2.updateUser(2, "gggg", "123123");
//        UserVo newUser = new UserVo(0, "tetz2", "1234");
//        userDao.addUser(newUser);

//        userDao.getAllUsers();
//        userDao.updateUser(4, "tetz3", "3216");
//        userDao.deleteUser(4);
//        userDao.getAllUsersWithName();
//        userDaoV2.getAllUsers();
//        userDaoV2.close();

//        userDaoV3.getAllUsers();
//        UserVo newUser = new UserVo(1, "ddd", "dddd");
//        anbogo.addUser(newUser);
    }
}
