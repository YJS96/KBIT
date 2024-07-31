<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@ include file="header.jsp" %>
    <h1>Condition 값에 따른 MSG 출력</h1>
    <c:if test="${condition}">
        ${msg1}
    </c:if>
    <c:if test="${!condition}">
        ${msg2}
    </c:if>

    <h1>lunchList 출력</h1>
    <ul>
        <c:forEach var="item" items="${lunchList}">
            <li>${item}</li>
        </c:forEach>
    </ul>
</body>
</html>
