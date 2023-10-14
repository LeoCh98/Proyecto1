/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.proyecto1.Data.Dao.Crud;

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
public abstract class AbstractCRUD {
    
    public abstract String updateProps(); // Created to update unique property...

    public abstract String getListAllCmd();

    public abstract String getAddCmd();

    public abstract String getRetrieveCmd();

    public abstract String getUpdateCmd();

    public abstract String getDeleteCmd();

}