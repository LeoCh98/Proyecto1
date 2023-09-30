<%-- 
    Document   : View
    Created on : 12 Sep 2023, 23:25:11
    Author     : leoch
--%>
<%@page import="com.progra.proyecto1.Presentation.Login.Model"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@ include file = "/Presentation/Head.jsp" %>
    </head>
    <body>
        <div id="wrapper">
            <%@ include file = "/Presentation/Header.jsp" %>
            <% Model model = (Model) request.getAttribute("model"); %>
            <% Map<String, String> errors = (Map<String, String>) request.getAttribute("errors"); %>
            <% Map<String, String[]> form = (errors == null) ? this.getForm(model) : request.getParameterMap();%>
            <form name="form" action="Presentation/Login/Login" method="post" >
                <div class="panel" style="margin-top: 250px;">
                    <div class="fila encabezado">Login</div>
                    <div class="fila">
                        <div class="etiqueta">Username</div>
                        <div class="campo"><input class="<%=inError("usernameFld", errors)%>" placeholder="Username" type="text" name="usernameFld" value="<%=form.get("usernameFld")[0]%>" title="<%=title("usernameFld", errors)%>"></div>
                    </div>
                    <div class="fila">
                        <div class="etiqueta">Password</div>
                        <div class="campo"><input class="<%=inError("passwordFld", errors)%>" placeholder="Password" type="password" name="passwordFld" value="<%=form.get("passwordFld")[0]%>" title="<%=title("passwordFld", errors)%>"></div>
                    </div>
                    <div class="fila encabezado"><button  style="margin-bottom: 15px">Log In</button> </div>
                </div>
            </form>
            <%@ include file = "/Presentation/Footer.jsp" %>
        </div>
    </body>
</html>
<%!
    private String inError(String field, Map<String, String> errors) {
        if ((errors != null) && (errors.get(field) != null)) {
            return "is-invalid";
        } else {
            return "";
        }
    }

    private String title(String field, Map<String, String> errors) {
        if ((errors != null) && (errors.get(field) != null)) {
            return errors.get(field);
        } else {
            return "";
        }
    }

    private Map<String, String[]> getForm(Model model) {
        Map<String, String[]> values = new HashMap<>();
        values.put("usernameFld", new String[]{model.getCurrent().getId()});
        values.put("passwordFld", new String[]{model.getCurrent().getPassword()});
        return values;
    }
%> 