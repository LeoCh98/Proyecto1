<%-- 
    Document   : View.jsp
    Created on : 30 Sep 2023, 17:58:58
    Author     : leoch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@ include file = "/Presentation/Head.jsp" %>
    </head>
    <body>
        <div id="wrapper">
            <%@ include file = "/Presentation/Header.jsp" %>
            <div class="panel" style="margin-top: 250px;">
                    <a href="Presentation/Menu/Create" class="btn-link">New Group</a>
                    <a href="Presentation/Menu/Groups" class="btn-link">Show Groups</a>
                    <a href="Presentation/Menu/Users" class="btn-link">Show Users</a>
            </div>
            <%@ include file = "/Presentation/Footer.jsp" %>
        </div>
    </body>
</html>