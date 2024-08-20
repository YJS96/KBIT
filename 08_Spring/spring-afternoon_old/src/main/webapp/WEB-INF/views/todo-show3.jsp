<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@ include file="header.jsp"%>
    <ul>
        <li><b>할 일 리스트 3</b></li>
        <c:forEach var="todo" items="${todoList}">
            <li>${todo.todo}</li>
        </c:forEach>
    </ul>
</body>
</html>
