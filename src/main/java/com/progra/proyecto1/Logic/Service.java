/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.proyecto1.Logic;

import com.progra.proyecto1.Data.Dao.Crud.AbstractCRUD;
import com.progra.proyecto1.Data.Dao.Crud.GroupCRUD;
import com.progra.proyecto1.Data.Dao.Crud.StudentCRUD;
import com.progra.proyecto1.Data.Dao.GroupDAO;
import com.progra.proyecto1.Data.Dao.StudentDAO;
import com.progra.proyecto1.Data.RelDatabase;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author leoch
 */
public class Service {

    private static Service uniqueInstance;

    public static Service instance() {
        if (uniqueInstance == null) {
            try {
                uniqueInstance = new Service();
            } catch (SQLException ex) {
                Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return uniqueInstance;
    }

    private DataSource datasource;
    private AbstractCRUD studentCRUD = new StudentCRUD();
    private AbstractCRUD groupCRUD = new GroupCRUD();
    private StudentDAO studentDAO;
    private GroupDAO groupDAO;

    private Service() throws SQLException {
        try {
            datasource = RelDatabase.getInstance();
            studentDAO = new StudentDAO(datasource, studentCRUD);
            groupDAO = new GroupDAO(datasource, groupCRUD);
        } catch (IOException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean validateLogin(String id, String password) {
        boolean access = false;
        try {
            Student student = this.getStudentById(id);
            if (student.getPassword().equals(password)) {
                access = true;
            }
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return access;
    }

    public List<Student> getAllStudents() throws SQLException, IOException {
        return studentDAO.listAll();
    }

    public void addStudent(Student student) throws SQLException, IOException {
        studentDAO.add(student);
    }

    public Student getStudentById(String id) throws SQLException, IOException {
        return studentDAO.retrieve(id);
    }

    public void updateStudent(String id, Student student) throws SQLException, IOException {
        studentDAO.update(id, student);
    }

    public void deleteStudent(String id) throws SQLException, IOException {
        studentDAO.delete(id);
    }

    public void addGroupToStudent(Student value, int group_id) throws SQLException, IOException {
        Group group = this.getGroupById(group_id);
        group.decreaseCapacity();
        this.updateGroup(group_id, group);
        studentDAO.addGroup(value, group_id);
    }

    public List<Group> getAllGroups() throws SQLException, IOException {
        return groupDAO.listAll();
    }

    public Group addGroup(Group group) throws SQLException, IOException {
        groupDAO.add(group);
        List<Group> groups = this.getAllGroups();
        for (Group iter : groups) {
            if (iter.getName().equals(group.getName())) {
                return iter;
            }
        }
        return null;
    }

    public Group getGroupById(int id) throws SQLException, IOException {
        return groupDAO.retrieve(id);
    }

    public void updateGroup(Integer id, Group group) throws SQLException, IOException {
        groupDAO.update(id, group);
    }

    public void deleteGroup(Integer id) throws SQLException, IOException {
        groupDAO.delete(id);
    }
}
