<!--
 ===================================================================
 *
 * (c) 2023
 *
 * Leonardo Chaves Hernández
 *
 * version 1.0.0 2023-10-14
 *
 ===================================================================
 -->
<%@page import="com.progra.proyecto1.Logic.Student"%>
<%
    Student user = (Student) session.getAttribute("User");
%>
<header>
    <div class="logo">
        <img src="/Proyecto1/Images/Logo.gif" alt=""/>
        <span> GroupTasker </span>
    </div>
    <div class="menu">  
        <ul>
            <% if(user == null){ %>
            <li>
                <a href="/Proyecto1/Presentation/Index.jsp">Home</a>
            </li>
            <li>
                <a href="Presentation/Login/Show">Login</a>
            </li>
            <% } else { %>
            <li>
                <a href="/Proyecto1/Presentation/Login/Menu.jsp">Home</a>
            </li>
            <li>
                <a href ="Presentation/Update/Show"> User: <% out.print(user.getName()); %> </a>
            </li>
            <li>
                <a href="Presentation/Logout/Logout">Logout</a>
            </li>
            <% } %>
            <li>
                <a href="/Proyecto1/Presentation/About_us.jsp">About us</a>
            </li>
        </ul>


    </div>
</header>