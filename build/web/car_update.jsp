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
            CarId <br/>
            <input type="text" readonly="true" name="UpdateCarID" value="${CAR_DETAILS.carID}" /><br/>
            Car Name <br/> 
            <input type="text" name="UpdateCarName" value="${CAR_DETAILS.carName}" /><br/>
            Manufacturer <br/>
            <input type="text" name="UpdateManufacturer" value="${CAR_DETAILS.manufacturer}" /><br/>
            Price <br/>
            <input type="text" name="UpdatePrice" value="${CAR_DETAILS.price}" /><br/>
            ReleasedYear <br/>
            <input type="text" name="UpdateReleasedYear" value="${CAR_DETAILS.releasedYear}" /><br/>
            <input type="submit" value="Save" name="action" />
            <input type="submit" value="Back to List" name="action" />
            ${UPDATE_SUCCESS_MESSAGE}
        </form>
    </body>
</html>
