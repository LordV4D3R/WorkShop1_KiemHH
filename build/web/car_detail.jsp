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
            CarId ${CAR_DETAILS.carID}<br/>
            CarName ${CAR_DETAILS.carName}<br/>
            Manufacturer ${CAR_DETAILS.manufacturer}<br/>
            Price ${CAR_DETAILS.price}<br/>
            ReleasedYear ${CAR_DETAILS.releasedYear}<br/>
            <input type="submit" value="Edit" name="action" />
            <input type="reset" value="Reset" />
            <input type="submit" value="Back to List" name="action" />
        </form>
    </body>
</html>
