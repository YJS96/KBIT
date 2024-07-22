package org.scoula.user;

import org.scoula.common.JDBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ManageUserProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ManageUser manageUser = new ManageUser();
        System.out.print("삭제할 회원의 ID: ");

        int deleteId = scanner.nextInt();
        Connection conn = JDBUtil.getConnection();


        manageUser.deleteUserById(deleteId);

//        // 회원 정보 입력 받기
//        System.out.print("추가할 회원의 ID : ");
//        String userid = scanner.nextLine();
//
//        System.out.print("이름 : ");
//        String name = scanner.nextLine();
//
//        System.out.print("비밀번호 : ");
//        String password = scanner.nextLine();
//
//        System.out.print("나이 : ");
//        int age = scanner.nextInt();
//        scanner.nextLine();
//
//        System.out.print("맴버쉽 여부 (true / false) : ");
//        boolean membership = scanner.nextBoolean();
//        scanner.nextLine();
//
//        User newUser = new User(userid, name, password, age, membership);
//
//        // 데이터베이스 접속
//        Connection conn = JDBUtil.getConnection();
//
//        ManageUser manageUser = new ManageUser();
//        manageUser.addUser(newUser);
    }
}