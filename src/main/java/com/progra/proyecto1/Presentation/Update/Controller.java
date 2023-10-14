/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.progra.proyecto1.Presentation.Update;

import com.progra.proyecto1.Logic.Service;
import com.progra.proyecto1.Logic.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
* -------------------------------------------------------------------
*
* (c) 2023
*
* @author: Leonardo Chaves Hernández
*
* @version 1.0.0 2023-10-14
*
* --------------------------------------------------------------------
*/
@WebServlet(name = "ControllerUpdate", urlPatterns = {"/Presentation/Update/Show", "/Presentation/Update/Update"})
public class Controller extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("model", new Model());

        String viewUrl = "";
        switch (request.getServletPath()) {
            case "/Presentation/Update/Show":
                viewUrl = this.show(request);
                break;
            case "/Presentation/Update/Update":
                viewUrl = this.update(request);
                break;
        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    }

    public String show(HttpServletRequest request) {
        return this.showAction(request);
    }

    public String showAction(HttpServletRequest request) {
        try {
            Model model = (Model) request.getAttribute("model");
            HttpSession session = request.getSession(true);
            Student user = (Student) session.getAttribute("User");
            return "/Presentation/Update/View.jsp";
        } catch (Exception e) {
            return "/Presentation/Error.jsp";
        }
    }

    public String update(HttpServletRequest request) {
        try {
            Map<String, String> errors = this.checkErrors(request);
            if (errors.isEmpty()) {
                this.updateModel(request);
                return this.updateAction(request);
            } else {
                request.setAttribute("errors", errors);
                return "/Presentation/Update/View.jsp";
            }
        } catch (Exception e) {
            return "/Presentation/Error.jsp";
        }
    }

    public String updateAction(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        Service service = Service.instance();
        try {
            HttpSession session = request.getSession(true);
            Student user = (Student) session.getAttribute("User");
            user.setPassword(model.getPassOne());
            service.updateStudent(user.getId(), user);
            return "/Presentation/Login/Menu.jsp";
        } catch (IOException | SQLException ex) {
            Map<String, String> errors = new HashMap<>();
            request.setAttribute("errors", errors);
            errors.put("passOneFld", "Password required");
            errors.put("passTwoFld", "Password required");
            return "/Presentation/Update/View.jsp";
        }
    }

    void updateModel(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");       
        model.setPassOne(request.getParameter("passOneFld"));
        model.setPassTwo(request.getParameter("passTwoFld"));
    }

    Map<String, String> checkErrors(HttpServletRequest request) {
        Map<String, String> errors = new HashMap<>();
        if (request.getParameter("passOneFld").isEmpty()) {
            errors.put("passOneFld", "Password required");
        }
        if (request.getParameter("passTwoFld").isEmpty()) {
            errors.put("passTwoFld", "Password required");
        }
        if (request.getParameter("passOneFld").length() < 8) {
            errors.put("passOneFld", "The password must contain at least 8 characters.");
        }
        if (!request.getParameter("passOneFld").equals(request.getParameter("passTwoFld"))){
            errors.put("passOneFld", "The passwords must match.");
        }
        return errors;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
