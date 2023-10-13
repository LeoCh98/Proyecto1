<%-- 
    Document   : Groups
    Created on : 10 Oct 2023, 00:46:33
    Author     : leoch
--%>
<%@page import="com.progra.proyecto1.Presentation.Menu.Model"%>
<%@page import="com.progra.proyecto1.Logic.Group"%>
<%@page import="com.progra.proyecto1.Logic.Student"%>
<%@page import="java.util.List"%>

<%
    Model model = (Model) request.getAttribute("model");
    List<Group> groups = model.getGroups();
    List<Student> students = model.getStudents();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@ include file = "/Presentation/Head.jsp" %>
    </head>
    <body>
        <div id="wrapper">
            <%@ include file = "/Presentation/Header.jsp" %>
            <div class="group-container">
                <% for (Group group : groups) { %>
                <div class="group">
                    <h2> Id: <%out.print(group.getId()); %> <%= group.getName() %></h2>
                    <% if (students.isEmpty()) { %>
                    <p>No students available.</p>
                    <% } else { %>
                    <ul class="members">
                        <% for (Student student : students) {
                            if (student.getGroup().equals(group.getId())) { %>
                        <li><% out.print(student.getName() +" "+ student.getLastname()); %></li>
                            <% }
                        } %>
                    </ul>
                    <% } %>
                </div>
                <% } %>
            </div>
            <%@ include file = "/Presentation/Footer.jsp" %>
        </div>
    </body>
</html>
