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
 *
 * @author leoch
 */
public class Model {

    List<Student> students;
    List<Group> groups;
    Group current;

    public Model() {
        this.reset();
    }

    public void reset() {
        List<Student> students = new ArrayList<>();
        this.setStudents(students);
        setCurrent(new Group());
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

    public Group getCurrent() {
        return current;
    }

    public void setCurrent(Group current) {
        this.current = current;
    }
}