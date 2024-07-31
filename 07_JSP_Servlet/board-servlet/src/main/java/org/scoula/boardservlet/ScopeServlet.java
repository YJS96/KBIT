package org.scoula.boardservlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/scope")
public class ScopeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Request Scope
        request.setAttribute("request", "리퀘스트 스코프에 저장한 데이터");

        // Session Scope
        HttpSession session = request.getSession();
        session.setAttribute("session", "세션 스코프에 저장한 데이터");

        // Application Scope
        ServletContext context = getServletContext();
        context.setAttribute("application", "어플리케이션 범위에 저장된 데이터");

        // scope.jsp 파일로 이동
        request.getRequestDispatcher("scope.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}