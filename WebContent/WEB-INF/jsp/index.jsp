<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <style>
    body, html {
    margin: 0px;
    padding: 0px;
    background-color: lightgray;
    color: white;
    }
    div.header {
    width: 100%;
    background-color: black;
    }
    div.chat {
    color: black;
    }
    </style>
</head>
<body>
    <div class="header">
        <form action="index.html" method="POST">
            <label for="author">Name</label>
            <input type="text" name="author" id="author" value="${author}" required>
            <label for="message">Message</label>
            <input type="text" name="message" id="message" autofocus>
            <input type="submit" value="Submit">
        </form>
    </div>
    <div class="chat">
        <ul>
            <c:forEach var="message" items="${messages}">
            <li>${message.author}: ${message.message}</li>
            </c:forEach>
        </ul>
    </div>
</body>
</html>