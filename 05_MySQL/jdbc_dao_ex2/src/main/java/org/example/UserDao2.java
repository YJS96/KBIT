package org.example;

import java.sql.*;

public class UserDao2 {
    public void addUser(UserVo2 userVo2) {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);

            String url = "jdbc:mysql://localhost:3306/user_ex";
            String user = "root";
            String password = "ajfzoa";
            Connection conn = DriverManager.getConnection(url, user, password);

            String sql = "insert into users (email, password) values(?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userVo2.getEmail());
            pstmt.setString(2, userVo2.getPassword());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("성공");
            } else {
                System.out.println("실패");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAllUsers() {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);

            String url = "jdbc:mysql://localhost:3306/user_ex";
            String user = "root";
            String password = "ajfzoa";
            Connection conn = DriverManager.getConnection(url, user, password);

            String sql = "select * from users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String userPassword = rs.getString("password");

                UserVo2 userVo2 = new UserVo2(id, email, userPassword);
                System.out.println(userVo2);
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void updateUser(int userId, String newEmail, String newPassword) {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            String url = "jdbc:mysql://localhost:3306/user_ex";
            String user = "root";
            String password = "ajfzoa";
            Connection conn = DriverManager.getConnection(url, user, password);
            String sql = "update users set email=?, password=? where id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newEmail);
            pstmt.setString(2, newPassword);
            pstmt.setInt(3, userId);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("성공");
            } else {
                System.out.println("실패");
            }
            pstmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int userId) {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            String url = "jdbc:mysql://localhost:3306/user_ex";
            String user = "root";
            String password = "ajfzoa";
            Connection conn = DriverManager.getConnection(url, user, password);
            String sql = "delete from users where id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("성공");
            } else {
                System.out.println("실패");
            }
            pstmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
