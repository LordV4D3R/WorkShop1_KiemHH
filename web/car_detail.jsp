<%-- 
    Document   : carDetail
    Created on : Oct 13, 2025, 5:19:18 PM
    Author     : Vader
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="MainController" method="POST">
            <div><strong style="display:inline-block; width:150px;">Car ID:</strong> ${CAR_DETAILS.carID}</div>
            <div><strong style="display:inline-block; width:150px;">Car Name:</strong> ${CAR_DETAILS.carName}</div>
            <div><strong style="display:inline-block; width:150px;">Manufacturer:</strong> ${CAR_DETAILS.manufacturer}</div>
            <div><strong style="display:inline-block; width:150px;">Price:</strong> $${CAR_DETAILS.price}</div>
            <div><strong style="display:inline-block; width:150px;">Released Year:</strong> ${CAR_DETAILS.releasedYear}</div>
            <input type="submit" value="Edit" name="action" />
            <input type="submit" value="Back to List" name="action" />
        </form>
    </body>
</html>
