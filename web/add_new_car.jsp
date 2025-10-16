<%-- 
    Document   : add_new_car
    Created on : Sep 28, 2025, 6:44:27 PM
    Author     : Vader
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Car Page</title>
    </head>
    <body>
        <h1>Add New Car</h1>
        <form action="MainController " method="POST">
            CarID <input type="text" name="CarIDCreate" value="" /><br/>
            Car Name <input type="text" name="CarNameCreate" value="" /><br/>
            Manufacturer <input type="text" name="ManufacturerCreate" value="" /><br/>
            Price <input type="text" name="PriceCreate" value="" /><br/>
            Released Year <input type="text" name="ReleasedYearCreate" value="" /><br/>
            <input type="submit" value="Create New" name="action" />
            <input type="submit" value="Reset" />  
            <input type="submit" value="Back to List" name="action" />
            ${ADD_SUCCESS_MESSAGE}
        </form>

    </body>
</html>
