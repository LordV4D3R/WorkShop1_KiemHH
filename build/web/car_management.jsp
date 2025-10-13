<%-- 
    Document   : carManagement
    Created on : Sep 25, 2025, 2:45:48 PM
    Author     : Vader
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Product List - Using EL and JSTL</h3>
        <table border="1">
            <tr>
                <th>No</th>
                <th>ID</th>
                <th>Car Name</th>
                <th>Manufacturer Name</th>
                <th>Price</th>
                <th>Released Year</th>
                <th>Action</th>
            </tr>
            <c:forEach var="car" items="${LIST_CAR}" varStatus="counter">
                <tr>
                    <td>${counter.count}</td>
                    <td>${car.carID}</td>
                    <td>${car.carName}</td>
                    <td>${car.manufacturer}</td>
                    <td>$${car.price}</td>
                    <td>${car.releasedYear}</td>   
                    <td>
                        <form action="MainController" method="POST">
                            <input type="hidden" name="CarID" value="${car.carID}"/>
                            <input type="submit" value="Detail" name="action"/>
                            <input type="submit" value="Update" name="action"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
