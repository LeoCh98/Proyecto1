/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.progra.proyecto1.Presentation.Login;

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
 *
 * @author leoch
 */
@WebServlet(name = "ControllerLogin", urlPatterns = {"/Presentation/Login/Show", "/Presentation/Login/Login", "/Presentation/Logout/Logout"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("model", new Model());

        String viewUrl = "";
        switch (request.getServletPath()) {
            case "/Presentation/Login/Show":
                viewUrl = "/Presentation/Login/View.jsp";
                break;
            case "/Presentation/Login/Login":
                viewUrl = this.login(request);
                break;
            case "/Presentation/Logout/Logout":
                break;
        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    }

    private String login(HttpServletRequest request) {
        try {
            Map<String, String> errors = this.validar(request);
            if (errors.isEmpty()) {
                this.updateModel(request);
                return this.loginAction(request);
            } else {
                request.setAttribute("errors", errors);
                return "/Presentation/Login/View.jsp";
            }
        } catch (SQLException e) {
            return "/Presentation/Error.jsp";
        }
    }

    public String loginAction(HttpServletRequest request) throws SQLException {
        Model model = (Model) request.getAttribute("model");
        Service service = Service.instance();
        HttpSession session = request.getSession(true);
        try {
            Student user = service.getStudentById(model.getCurrent().getId());//JAP
            session.setAttribute("User", user);
            
            return "/Proyecto1/Presentation/About_us.jsp"; //Just a proof...
        } catch (Exception ex) {
            Map<String, String> errors = new HashMap<>();
            request.setAttribute("errors", errors);
            errors.put("usernameFld", "Invalid login, please try again...");
            errors.put("passwordFld", "Invalid login, please try again...");
            return "/Presentation/Login/View.jsp";
        }
    }

    Map<String, String> validar(HttpServletRequest request) {
        Map<String, String> errors = new HashMap<>();
        if (request.getParameter("usernameFld").isEmpty()) {
            errors.put("usernameFld", "Username required");
        }
        if (request.getParameter("passwordFld").isEmpty()) {
            errors.put("passwordFld", "Password required");
        }
        return errors;
    }

    void updateModel(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        model.getCurrent().setId(request.getParameter("usernameFld"));
        model.getCurrent().setPassword(request.getParameter("passwordFld"));
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
