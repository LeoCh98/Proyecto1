/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.proyecto1.Presentation.Menu;

import com.progra.proyecto1.Logic.Student;

/**
 *
 * @author leoch
 */
public class Model {
    
    Student current;
    
    public Model() {
        this.reset();
    }

    public void reset() {
        setCurrent(new Student());
    }

    public Student getCurrent() {
        return current;
    }

    public void setCurrent(Student current) {
        this.current = current;
    }
}