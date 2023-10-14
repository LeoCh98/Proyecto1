/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.proyecto1.Presentation.Update;

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

    String PassOne;
    String PassTwo;
    
    public Model() {
        this.reset();
    }

    public void reset() {
        setPassOne("");
        setPassTwo("");
    }

    public String getPassOne() {
        return PassOne;
    }

    public void setPassOne(String PassOne) {
        this.PassOne = PassOne;
    }

    public String getPassTwo() {
        return PassTwo;
    }

    public void setPassTwo(String PassTwo) {
        this.PassTwo = PassTwo;
    }
}