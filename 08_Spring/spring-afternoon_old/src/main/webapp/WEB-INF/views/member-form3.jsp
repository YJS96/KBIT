<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@ include file="header.jsp" %>
    <h1>회원 추가 3</h1>
    <form method="get" action="/member/form/save">
        <label for="id">아이디 : </label>
        <input type="text" id="id" name="id" required>
        <br>
        <label for="name">이름 : </label>
        <input type="password" id="name" name="name" required>
        <br>
        <button type="submit">회원 추가</button>
    </form>
</body>
</html>