<%-- 
    Document   : Header
    Created on : 12 Sep 2023, 23:09:17
    Author     : leoch
--%>

<%
    //Student user = (Student) session.getAttribute("user");
%>
<header>
    <div class="logo">
        <img src="/Proyecto1/Images/Logo.gif" alt=""/>
        <span> GroupTasker </span>
    </div>
    <div class="menu">  
        <ul>
            <li>
                <a href="/Proyecto1/Presentation/Index.jsp">Home</a>
            </li>
            <li>
                <a href="Presentation/Login/Show">Login</a>
            </li>
            <li>
                <a href="/Proyecto1/Presentation/Signup/show">Sign up</a> <!-- Change to Jsp/Signup/Show -->
            </li>
            <li>
                <a href="/Proyecto1/Presentation/About_us.jsp">About us</a>
            </li>
        </ul>


    </div>
</header>