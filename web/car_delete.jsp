<%-- 
    Document   : car_delete
    Created on : Oct 16, 2025, 12:37:44 PM
    Author     : tranq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Car Page</title>
    </head>
    <body>
        <h1>Delete</h1>
        <h2>Are you want to delete this?</h2>
        <h3>Car</h3>
        <div><strong style="display:inline-block; width:150px;">Car ID:</strong> ${CAR_DETAILS.carID}</div>
        <div><strong style="display:inline-block; width:150px;">Car Name:</strong> ${CAR_DETAILS.carName}</div>
        <div><strong style="display:inline-block; width:150px;">Manufacturer:</strong> ${CAR_DETAILS.manufacturer}</div>
        <div><strong style="display:inline-block; width:150px;">Price:</strong> $${CAR_DETAILS.price}</div>
        <div><strong style="display:inline-block; width:150px;">Released Year:</strong> ${CAR_DETAILS.releasedYear}</div>
        <form action="MainController" method="POST">
            <input type="hidden" name="CarID" value="${CAR_DETAILS.carID}"/>
            <%--Warning here, the value got a space to make a difference from the value at the car_management.jsp--%>
            <input type="submit" value="Delete " name="action" />
            <input type="submit" value="Back to List" name="action" />
        </form>
            ${ERROR}
    </body>
</html>
