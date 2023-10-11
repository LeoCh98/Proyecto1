/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.proyecto1.Data.Dao;

import com.progra.proyecto1.Data.Dao.Crud.AbstractCRUD;
import com.progra.proyecto1.Logic.Group;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author leoch
 */
public class GroupDAO extends AbstractDAO<Integer, Group> implements DAO<Integer, Group> {

    public GroupDAO(DataSource db, AbstractCRUD crud) {
        super(db, crud);
    }

    @Override
    public Group getRecord(ResultSet rs) throws SQLException {
        return new Group(
            rs.getInt("id"),
            rs.getInt("secuencia"),
            rs.getString("nombre"),
            rs.getInt("cupo"),
            true//All Groups have to be active
        );
    }
    
    @Override
    public void setAddParameters(PreparedStatement stm, Group value) throws SQLException {
        stm.setString(1, value.getName());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, Integer id, Group value) throws SQLException {
        stm.setInt(1, value.getSequence());
        stm.setString(2, value.getName());
        stm.setInt(3, value.getCapacity());
        stm.setBoolean(4, value.isActive());
        stm.setInt(5, id);
    }

    @Override
    public List<Group> listAll() throws SQLException, IOException {
        List<Group> groups = new ArrayList<>();
        try (Connection cnx = db.getConnection();
             PreparedStatement stm = cnx.prepareStatement(getCRUD().getListAllCmd());
             ResultSet rs = stm.executeQuery()) {
            while (rs.next()) {
                groups.add(getRecord(rs));
            }
        }
        return groups;
    }

    @Override
    public void add(Group value) throws SQLException, IOException {
        try (Connection cnx = db.getConnection();
             PreparedStatement stm = cnx.prepareStatement(getCRUD().getAddCmd())) {
            stm.clearParameters();
            setAddParameters(stm, value);
            if (stm.executeUpdate() != 1) {
                throw new IllegalArgumentException(value.toString());
            }
        }
    }

    @Override
    public Group retrieve(Integer id) throws SQLException, IOException {
        Group groups = null;
        try (Connection cnx = db.getConnection();
             PreparedStatement stm = cnx.prepareStatement(getCRUD().getRetrieveCmd())) {
            stm.clearParameters();
            stm.setObject(1, id);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    groups = getRecord(rs);
                } else {
                    throw new IllegalArgumentException(id.toString());
                }
            }
        }
        return groups;
    }

    @Override
    public void update(Integer id, Group value) throws SQLException, IOException {
        try (Connection cnx = db.getConnection();
             PreparedStatement stm = cnx.prepareStatement(getCRUD().getUpdateCmd())) {
            stm.clearParameters();
            setUpdateParameters(stm, id, value);
            if (stm.executeUpdate() != 1) {
                throw new IllegalArgumentException(id.toString());
            }
        }
    }

    @Override
    public void delete(Integer id) throws SQLException, IOException {
        try (Connection cnx = db.getConnection();
             PreparedStatement stm = cnx.prepareStatement(getCRUD().getDeleteCmd())) {
            stm.clearParameters();
            stm.setObject(1, id);
            if (stm.executeUpdate() != 1) {
                throw new IllegalArgumentException(id.toString());
            }
        }
    }
}