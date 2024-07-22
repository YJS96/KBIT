package org.scoula.user;

import org.scoula.common.JDBUtil;

import java.sql.*;
import java.util.ArrayList;

public class ManageUser {
    public void addUser(User newUser) {
        Connection conn = JDBUtil.getConnection();

        String sql = "INSERT INTO user_table (userid, name, password, age, membership) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newUser.getUserid());
            pstmt.setString(2, newUser.getName());
            pstmt.setString(3, newUser.getPassword());
            pstmt.setInt(4, newUser.getAge());
            pstmt.setBoolean(5, newUser.isMembership());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        System.out.println("회원이 성공적으로 추가 되었습니다!");
    }

    public void deleteUserById(int id) {
        Connection conn = JDBUtil.getConnection();

        String sql = "DELETE FROM user_table WHERE id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int row = pstmt.executeUpdate();
            if (row > 0) {
                System.out.println("ID가 " + id + "인 회원 정보가 성공적으로 제거 되었습니다");
            } else {
                System.out.println("ID가 " + id + "인 회원이 존재하지 않습니다!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);

        }

    }

    public void getAllUsers() {
        Connection conn = JDBUtil.getConnection();
        String sql = "SELECT * FROM user_table";

        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<User> users = new ArrayList<>();

            while (rs.next()) {

            }
        } catch (SQLException e) {

        }
    }
}