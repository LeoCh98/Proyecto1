/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.proyecto1.Presentation.Menu;

import com.progra.proyecto1.Logic.Group;
import com.progra.proyecto1.Logic.Student;
import java.util.ArrayList;
import java.util.List;

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
public class Model {

    List<Student> students;
    List<Group> groups;
    Student currentStudent;
    Group currentGroup;

    public Model() {
        this.reset();
    }

    public void reset() {
        students = new ArrayList<>();
        groups = new ArrayList<>();
        currentStudent = new Student();
        currentGroup = new Group();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public Student getCurrentStudent() {
        return currentStudent;
    }

    public void setCurrentStudent(Student currentStudent) {
        this.currentStudent = currentStudent;
    }

    public Group getCurrentGroup() {
        return currentGroup;
    }

    public void setCurrentGroup(Group currentGroup) {
        this.currentGroup = currentGroup;
    }
}