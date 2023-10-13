/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.progra.proyecto1.Presentation.Menu;

import com.progra.proyecto1.Logic.Group;
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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leoch
 */
@WebServlet(name = "ControllerMenu", urlPatterns = {"/Presentation/Menu/Create", "/Presentation/Menu/SaveGroup", "/Presentation/Menu/Groups", "/Presentation/Menu/Users"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("model", new Model());
        String viewUrl = "";
        switch (request.getServletPath()) {
            case "/Presentation/Menu/Create":
                viewUrl = "/Presentation/Menu/Create.jsp";
                break;
            case "/Presentation/Menu/SaveGroup":
                viewUrl = this.save(request);
                break;
            case "/Presentation/Menu/Groups":
                viewUrl = this.showGroups(request);
                break;
            case "/Presentation/Menu/Users":
                viewUrl = this.showUsers(request);
                break;
        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    }

    public String showGroups(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        Service service = Service.instance();
        try {
            model.setGroups(service.getAllGroups());
            return "/Presentation/Menu/Groups.jsp";
        } catch (IOException | SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }
    
    public String save(HttpServletRequest request) {
        try {
            Map<String, String> errors = this.checkErrors(request);
            if (errors.isEmpty()) {
                this.updateModel(request);
                return this.saveAction(request);
            } else {
                request.setAttribute("errors", errors);
                return "/Presentation/Menu/Create.jsp";
            }
        } catch (Exception e) {
            return "/Presentation/Error.jsp";
        }
    }

    public String saveAction(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        HttpSession session = request.getSession(true);
        Service service = Service.instance();
        try {
            model.setCurrentStudent((Student)session.getAttribute("User"));
            Group group = service.addGroup(model.getCurrentGroup());
            model.setGroups(service.getAllGroups());
            
            
            service.addGroupToStudent(model.getCurrentStudent(), group.getId());
            
            return "/Presentation/Login/Menu.jsp";
        } catch (IOException | SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    public String showUsers(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        Service service = Service.instance();
        try {
            model.setStudents(service.getAllStudents());
            return "/Presentation/Menu/Users.jsp";
        } catch (IOException | SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    public Map<String, String> checkErrors(HttpServletRequest request) {
        Map<String, String> errors = new HashMap<>();
        if (request.getParameter("groupNameFld").isEmpty()) {
            errors.put("groupNameFld", "Group Name required");
        }
        return errors;
    }

    void updateModel(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        model.getCurrentGroup().setName((request.getParameter("groupNameFld")));
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
