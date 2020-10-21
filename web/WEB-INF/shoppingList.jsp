<%-- 
    Document   : shoppingList
    Created on : Oct 21, 2020, 3:01:25 PM
    Author     : 832465
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List list of items</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello, ${username}</p> 
        <p><a href="ShoppingList?action=Logout">Logout</a></p>    
        
        <h2>List</h2>
        <form action="" method="POST">
            <label>Add item:</label>
            <input type="text" name="item"><input type=submit value="Add Item">
            <input type="hidden" name="action" value="add">
        </form>
        
        <form action="" method="POST">
            <c:forEach items="${itemsList}" var="item">
                <label><input type="radio" name="itemsAdded" value="${itemsAdded}"<c:out value="${itemsAdded}"/></label> 
            </c:forEach> 
            <input type="submit" value="Delete">
            <input type="hidden" name="action" value="delete">
        </form>
        
        
    </body>
</html>
