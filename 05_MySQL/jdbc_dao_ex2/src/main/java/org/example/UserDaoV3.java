package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoV3 {
    static Connection conn = null;

    static {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            System.out.println("1. 드라이버 설정 OK");

            String url = "jdbc:mysql://localhost:3306/user_ex";
            String user = "root";
            String password = "ajfzoa";
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("2. DB연결 OK");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void getAllUsers() {
        List<UserVo> userList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM users";
            Statement stmt = conn.createStatement();
            System.out.println("3. SQL문 생성 OK");

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int userid = rs.getInt("id");
                String email = rs.getString("email");
                String userPassword = rs.getString("password");

                UserVo user = new UserVo(userid, email, userPassword);
                System.out.println(user);
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
