/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.proyecto1.Presentation.Login;

import com.progra.proyecto1.Logic.Student;

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
