/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.proyecto1.Data.Dao.Crud;

/**
 *
 * @author leoch
 */
public class GroupCRUD extends AbstractCRUD {

    @Override
    public String getListAllCmd() {
        return "SELECT * FROM `bd_grupos`.`grupo`";
    }

    @Override
    public String getAddCmd() {
        return "INSERT INTO `bd_grupos`.`grupo` (nombre) VALUES (?)";
    }

    @Override
    public String getRetrieveCmd() {
        return "SELECT * FROM `bd_grupos`.`grupo` WHERE id = ?";
    }

    @Override
    public String getUpdateCmd() {
        return "UPDATE `bd_grupos`.`grupo` SET secuencia = ?, nombre = ?, cupo = ?, activo = ? WHERE id = ?";
    }

    @Override
    public String getDeleteCmd() {
        return "DELETE FROM `bd_grupos`.`grupo` WHERE id = ?";
    }
}
