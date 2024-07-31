package org.scoula.boardservlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet("/ex2")
public class Ex2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Random rand = new Random();
        List<String> lunchList = new ArrayList<String>();

        request.setAttribute("condition", rand.nextBoolean());
        request.setAttribute("msg1", "럭키비키!");
        request.setAttribute("msg2", "내일은 럭키비키!");

        lunchList.add("점심 메뉴 1");
        lunchList.add("점심 메뉴 2");
        lunchList.add("점심 메뉴 3");
        request.setAttribute("lunchList", lunchList);

        request.getRequestDispatcher("ex2.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}