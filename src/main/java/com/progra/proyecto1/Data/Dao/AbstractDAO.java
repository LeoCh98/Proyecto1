/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.proyecto1.Data.Dao;

import com.progra.proyecto1.Data.Dao.Crud.AbstractCRUD;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author leoch
 */
public abstract class AbstractDAO<K, V> implements DAO<K, V> {

    public AbstractDAO(DataSource db, AbstractCRUD crud) {
        this.db = db;
        this.crud = crud;
    }

    @Override
    public List<V> listAll() throws SQLException, IOException {
        List<V> r = new ArrayList<>();
        try (Connection cnx = db.getConnection();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(getCRUD().getListAllCmd())) {
            while (rs.next()) {
                r.add(getRecord(rs));
            }
        }
        return r;
    }

    @Override
    public void add(K id, V value) throws SQLException, IOException {
        try (Connection cnx = db.getConnection();
                PreparedStatement stm = cnx.prepareStatement(getCRUD().getAddCmd())) {
            stm.clearParameters();
            setAddParameters(stm, id, value);
            if (stm.executeUpdate() != 1) {
                throw new IllegalArgumentException(id.toString());
            }
        }
    }

    @Override
    public V retrieve(K id) throws SQLException, IOException {
        V r = null;
        try (Connection cnx = db.getConnection();
                PreparedStatement stm = cnx.prepareStatement(getCRUD().getRetrieveCmd())) {
            stm.clearParameters();
            stm.setObject(1, id);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = getRecord(rs);
                } else {
                    throw new IllegalArgumentException(id.toString());
                }
            }
        }
        return r;
    }

    @Override
    public void update(K id, V value) throws SQLException, IOException {
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
    public void delete(K id) throws SQLException, IOException {
        try (Connection cnx = db.getConnection();
                PreparedStatement stm = cnx.prepareStatement(getCRUD().getDeleteCmd())) {
            stm.clearParameters();
            stm.setObject(1, id);
            if (stm.executeUpdate() != 1) {
                throw new IllegalArgumentException(id.toString());
            }
        }
    }

    public abstract V getRecord(ResultSet rs) throws SQLException;

    public abstract void setAddParameters(PreparedStatement stm, K id, V value)
            throws SQLException;

    public abstract void setUpdateParameters(PreparedStatement stm, K id, V value)
            throws SQLException;

    public AbstractCRUD getCRUD() {
        return crud;
    }

    protected final DataSource db;
    protected final AbstractCRUD crud;
}