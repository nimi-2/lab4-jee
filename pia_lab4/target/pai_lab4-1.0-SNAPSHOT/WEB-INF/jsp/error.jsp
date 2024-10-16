<%-- 
    Document   : error
    Created on : 8 paź 2024, 15:05:02
    Author     : Emilia
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Strona błędu</title>
</head>
<body>
    <h1>Strona błędu</h1>
    <p>Nie udało się zrealizować żądania.</p>
    <p>Adres URL: ${url}</p>
    <p>Wyjątek: ${exception.message}</p>
    <c:forEach items="${exception.stackTrace}" var="ste">
        ${ste}<br>
    </c:forEach>
</body>
</html>
