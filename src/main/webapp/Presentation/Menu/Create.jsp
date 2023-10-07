<%-- 
    Document   : NewGroup
    Created on : 7 Oct 2023, 00:22:45
    Author     : leoch
--%>
<%@page import="com.progra.proyecto1.Presentation.Menu.Model"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>

<% Model model = (Model) request.getAttribute("model"); %>
<% Map<String, String> errors = (Map<String, String>) request.getAttribute("errors"); %>
<% Map<String, String[]> form = (errors == null) ? this.getForm(model) : request.getParameterMap();%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@ include file = "/Presentation/Head.jsp" %>  
    </head>
    <body>
        <div id="wrapper">
            <%@ include file = "/Presentation/Header.jsp" %>
            <form name="form" action="Presentation/Menu/SaveGroup" method="post" >
                <div class="panel" style="margin-top: 250px;">
                    <div class="row container">Create a new Group</div>
                    <div class="row" style="margin-top: 25px;">
                        <div class="label" style="display: inline;">Name</div>
                        <div class="field"><input class="<%=inError("groupNameFld", errors)%>" placeholder="Group name" type="text" name="groupNameFld" value="<%= (form.get("groupNameFld")[0] != null) ? form.get("groupNameFld")[0] : "" %>" title="<%=title("groupNameFld", errors)%>"></div>
                    </div>
                    <div class="row container" style="margin-top: 25px;">
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
        values.put("groupNameFld", new String[]{model.getCurrent().getName()});
        return values;
    }
%> 