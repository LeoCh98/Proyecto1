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
public class StudentCRUD extends AbstractCRUD {
    
    @Override
    public String updateProps(){
        return "UPDATE `bd_grupos`.`estudiante` SET grupo_id=? WHERE id=?";
    }

    @Override
    public String getListAllCmd() {
        return "SELECT * FROM `bd_grupos`.`estudiante`";
    }

    @Override
    public String getAddCmd() {
        return "INSERT INTO `bd_grupos`.`estudiante` (id, nrc, apellidos, nombre, secuencia, clave, ultimo_acceso, grupo_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    public String getRetrieveCmd() {
        return "SELECT * FROM `bd_grupos`.`estudiante` WHERE id = ?";
    }

    @Override
    public String getUpdateCmd() {
        return "UPDATE `bd_grupos`.`estudiante` SET nrc = ?, apellidos = ?, nombre = ?, secuencia = ?, clave = ?, ultimo_acceso = ? WHERE id = ?";
    }

    @Override
    public String getDeleteCmd() {
        return "DELETE FROM `bd_grupos`.`estudiante` WHERE id = ?";
    }
}
