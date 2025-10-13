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
        <form action="MainController " method="POST">
            CarID <input type="text" name="txtUsername" value="" /><br/>
            Car Name <input type="text" name="txtUsername" value="" /><br/>
            Manufacturer <input type="text" name="txtUsername" value="" /><br/>
            Price <input type="text" name="txtUsername" value="" /><br/>
            Released Year <input type="text" name="txtUsername" value="" /><br/>
            <input type="submit" value="Add New Car" name="btAction" />
            <input type="submit" value="Reset" />  
            ${ADD_SUCCESS_MESSAGE}
        </form>

    </body>
</html>
