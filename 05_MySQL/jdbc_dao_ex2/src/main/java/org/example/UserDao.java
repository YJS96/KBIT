package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public void addUser(UserVo newUser) {
        try {
            // 1. Driver 커넥터 설정
            String driver = "com.mysql.jc.jdbc.Driver";
            Class.forName(driver);
            System.out.println("1. 드라이버 설정 OK");

            // 2. DB 연결
            String url = "jdbc:mysql://localhost:3306/user_ex";
            String id = "root";
            String password = "ajfzoa";

            Connection conn = DriverManager.getConnection(url, id, password);
            System.out.println("2. DB 연결 OK");

            // 3. SQL문 생성
            String sql = "INSERT INTO users (email, password) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newUser.getEmail());
            pstmt.setString(2, newUser.getPassword());
            System.out.println("3. SQL문 생성 OK");

            // 4. SQL문 접속
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("회원 추가 성공");
            } else {
                System.out.println("회원 추가 실패");
            }

            // 5. 자원 해제
            pstmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAllUsers() {
        List<UserVo> userList = new ArrayList<>();

        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            System.out.println("1. 드라이버 설정 OK");

            String url = "jdbc:mysql://localhost:3306/user_ex";
            String id = "root";
            String password = "ajfzoa";
            Connection conn = DriverManager.getConnection(url, id, password);
            System.out.println("2. DB연결 OK");

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
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUser(int userid, String newEmail, String newPassword) {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            System.out.println("1. 드라이버 설정 OK");

            String url = "jdbc:mysql://localhost:3306/user_ex";
            String id = "root";
            String password = "ajfzoa";
            Connection conn = DriverManager.getConnection(url, id, password);
            System.out.println("2. 연결 OK");

            String sql = "UPDATE users SET email = ?, password = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newEmail);
            pstmt.setString(2, newPassword);
            pstmt.setInt(3, userid);
            System.out.println("3. SQL문 생성 OK");

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("회원 정보 수정 성공!");
            } else {
                System.out.println("회원 정보 수정 실패");
            }

            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUser (int userId) {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            System.out.println("1. 드라이버 설정 OK");

            String url = "jdbc:mysql://localhost:3306/user_ex";
            String id = "root";
            String password = "ajfzoa";
            Connection conn = DriverManager.getConnection(url, id, password);
            System.out.println("2. DB 연결 OK");

            String sql = "DELETE FROM users WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            System.out.println("3. SQL문 생성 OK");

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("회원 삭제 성공!");
            } else {
                System.out.println("회원 삭제 실패");
            }

            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAllUsersWithName() {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            System.out.println("1. 드라이버 설정 OK");

            String url = "jdbc:mysql://localhost:3306/user_ex";
            String id = "root";
            String password = "ajfzoa";
            Connection conn = DriverManager.getConnection(url, id, password);
            System.out.println("2. DB 연결 OK");

            String sql = "SELECT * FROM users as A JOIN user_info as B ON A.id = B.id";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("3. SQL문 생성 OK");

            while (rs.next()) {
                int userid = rs.getInt("id");
                String email = rs.getString("email");
                String userPassword = rs.getString("password");
                String name = rs.getString("name");

                System.out.printf("ID: %d, Email: %s, Password: %s, Name: %s\n", userid, email, userPassword, name);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
