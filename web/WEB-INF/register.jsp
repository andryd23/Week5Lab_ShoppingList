<%-- 
    Document   : register
    Created on : Oct 21, 2020, 3:01:09 PM
    Author     : 832465
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List Registration</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="" method="POST">
            <label>Username:</label>
            <input type="text" name="username">
            <input type="hidden" name="action" value="register">
            <br>
            <input type="submt" value="Register name">
        </form>
    </body>
</html>
