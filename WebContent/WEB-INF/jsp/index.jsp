<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
    <form action="index.html" method="POST">
        <label for="author">Name</label>
        <input type="text" name="author" id="author" value="${author}" required><br>
        <label for="message">Message</label>
        <input type="text" name="message" id="message" autofocus><br>
        <input type="submit" value="Submit">
    </form>
    <ul>
        <c:forEach var="message" items="${messages}">
        <li>${message.author}: ${message.message}</li>
        </c:forEach>
    </ul>
</body>
</html>