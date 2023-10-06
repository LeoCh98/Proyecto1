<%-- 
    Document   : Users
    Created on : 6 Oct 2023, 01:02:24
    Author     : leoch
--%>
<%@page import="com.progra.proyecto1.Presentation.Menu.Model"%>
<%@page import="com.progra.proyecto1.Logic.Student"%>
<%@page import="java.util.List"%>

<%
    Model model = (Model) request.getAttribute("model");
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

            <table>
                <caption>All Students</caption>
                <tr>
                    <th>Sequence</th>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Lastname</th>
                    <th>NRC</th>
                    <th>Last connection</th>
                    <th>Group id</th>
                </tr>
                <% for (Student s : students) {%>
                <tr class="data">
                    <td> <%=s.getSequence()%> </td>
                    <td> <%=s.getId()%> </td>
                    <td> <%=s.getName()%> </td>
                    <td> <%=s.getLastname()%> </td>
                    <td> <%=s.getNrc()%> </td>
                    <td> <%=s.getTimeStamp()%> </td>
                    <td> <%=s.getGroup()%> </td>
                </tr>                    
                <%}%>
                </tbody>            
            </table>
            <%@ include file = "/Presentation/Footer.jsp" %>
        </div>
    </body>
</html>