<%-- 
    Document   : car_update
    Created on : Oct 13, 2025, 6:03:28 PM
    Author     : Vader
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Car</title>
    </head>
    <body>
            <form action="MainController " method="POST">
                CarID <input type="text" readonly="true" name="UpdateCarID" value="${CAR_DETAILS.carID}" /><br/>
            Car Name <input type="text" name="UpdateCarName" value="${CAR_DETAILS.carName}" /><br/>
            Manufacturer <input type="text" name="UpdateManufacturer" value="${CAR_DETAILS.manufacturer}" /><br/>
            Price <input type="text" name="UpdatePrice" value="${CAR_DETAILS.price}" /><br/>
            Released Year <input type="text" name="UpdateReleasedYear" value="${CAR_DETAILS.releasedYear}" /><br/>
            <input type="submit" value="Update Car" name="action" />
            <input type="submit" value="Reset" />  
            ${UPDATE_SUCCESS_MESSAGE}
        </form>
    </body>
</html>
