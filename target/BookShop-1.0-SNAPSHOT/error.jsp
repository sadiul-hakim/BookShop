<%-- 
    Document   : error
    Created on : Jan 12, 2023, 11:28:19 AM
    Author     : Hakim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
        <link rel="stylesheet" href="css/bootstrap.css"/>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-5 d-flex flex-column justify-content-center align-items-center mx-auto mt-5">
                    <img src="img/error.png" alt="error pic" width="350" height="250"/> 
                    <h3 class="my-2">Status : ${pageContext.errorData.statusCode}</h3>
                    <p>Oops, Error Occurred!</p>
                    <a href="index.jspx" class="btn btn-primary">Back To Home</a>
                </div>
            </div>
        </div>
    </body>
</html>
