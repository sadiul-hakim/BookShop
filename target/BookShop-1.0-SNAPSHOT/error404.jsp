<%-- 
    Document   : error404
    Created on : Jan 12, 2023, 11:06:57 AM
    Author     : Hakim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>404 Not Found</title>
        <link rel="stylesheet" href="css/bootstrap.css"/>
    </head>
    <body>
        <div class="container">
            <dir class="row">

                <div class="col-md-5 d-flex flex-column justify-content-center align-items-center mx-auto mt-5">
                    <img src="img/error404.png" width="350" height="250"/>
                    <h3 class="my-2">404 Not Found</h3>
                    <a href="index.jspx" class="btn btn-primary">Back To Home</a>
                </div>

            </dir>
        </div>
    </body>
</html>
