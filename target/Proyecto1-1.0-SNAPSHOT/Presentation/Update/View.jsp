<%-- 
    Document   : Update
    Created on : 1 Oct 2023, 23:18:00
    Author     : leoch
--%>
<%@page import="com.progra.proyecto1.Presentation.Update.Model"%>
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
            <form name="form" action="Presentation/Update/Update" method="post" >
                <div class="panel" style="margin-top: 250px;">
                    <div class="row container">Change or Reset Password</div>
                    <div class="row">
                        <div class="label" style="display: inline-block;">New Password</div>
                        <div class="field"><input class="<%=inError("passOneFld", errors)%>" placeholder="Password" type="text" name="passOneFld" value="<%= (form.get("passOneFld")[0] != null) ? form.get("passOneFld")[0] : "" %>" title="<%=title("passOneFld", errors)%>"></div>
                    </div>
                    <div class="row">
                        <div class="label" style="display: inline-block;" >Confirm Password</div>
                        <div class="field"><input class="<%=inError("passTwoFld", errors)%>" placeholder="Password" type="password" name="passTwoFld" value="<%= (form.get("passTwoFld")[0] != null) ? form.get("passTwoFld")[0] : "" %>" title="<%=title("passTwoFld", errors)%>"></div>
                    </div>
                    <div class="row container">
                        <button class="btn-form">Save</button>
                    </div>
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
        values.put("passOneFld", new String[]{model.getPassOne()});
        values.put("passTwoFld", new String[]{model.getPassTwo()});
        return values;
    }
%> 