<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2024-07-29
  Time: 오전 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>로그인 정보 보기</h1>
<%
    String id = (String) session.getAttribute("userid");
    if (id == null) {
        response.sendRedirect("loginForm.html");
    } else {
        String pw = (String) session.getAttribute("Password");
        out.print("사용자 아이디값: " + id + "<br>");
        out.print("사용자 비밀번호값: " + pw + "<br>");
        out.print("<a href='logout.jsp'>로그아웃</a>");
    }
%>
<%--    <h1>로그인 입력 파라미터 출력</h1>--%>
<%--    <%--%>
<%--        String userid = request.getParameter("userid");--%>
<%--        String Password = request.getParameter("Password");--%>
<%--        String strAge = request.getParameter("age");--%>
<%--        int age = strAge != null ? Integer.parseInt(strAge) : -1;--%>

<%--    %>--%>
<%--    아이디값: <%= userid %><br>--%>
<%--    비밀번호: <%= Password %><br>--%>
<%--    나이: <%= age %>--%>
</body>
</html>
