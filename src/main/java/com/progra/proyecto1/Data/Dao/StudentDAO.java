/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.proyecto1.Data.Dao;

import com.progra.proyecto1.Data.Dao.Crud.AbstractCRUD;
import com.progra.proyecto1.Logic.Student;
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
public class StudentDAO extends AbstractDAO<String, Student> implements DAO<String, Student> {

    public StudentDAO(DataSource db, AbstractCRUD crud) {
        super(db, crud);
    }

    @Override
    public Student getRecord(ResultSet rs) throws SQLException {
        return new Student(
            rs.getString("id"),
            rs.getInt("nrc"),
            rs.getString("apellidos"),
            rs.getString("nombre"),
            rs.getInt("secuencia"),
            rs.getString("clave"),
            rs.getTimestamp("ultimo_acceso"),
            rs.getInt("grupo_id")
        );
    }

    @Override
    public void setAddParameters(PreparedStatement stm, Student value) throws SQLException {
        stm.setString(1, value.getId());
        stm.setInt(2, value.getNrc());
        stm.setString(3, value.getLastname());
        stm.setString(4, value.getName());
        stm.setInt(5, value.getSequence());
        stm.setString(6, value.getPassword());
        stm.setTimestamp(7, value.getTimeStamp());
        stm.setInt(8, value.getGroup());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, String id, Student value) throws SQLException {
        stm.setInt(1, value.getNrc());
        stm.setString(2, value.getLastname());
        stm.setString(3, value.getName());
        stm.setInt(4, value.getSequence());
        stm.setString(5, value.getPassword());
        stm.setTimestamp(6, value.getTimeStamp());
        stm.setString(7, id);
    }

    @Override
    public List<Student> listAll() throws SQLException, IOException {
        List<Student> students = new ArrayList<>();
        try (Connection cnx = db.getConnection();
             PreparedStatement stm = cnx.prepareStatement(getCRUD().getListAllCmd());
             ResultSet rs = stm.executeQuery()) {
            while (rs.next()) {
                students.add(getRecord(rs));
            }
        }
        return students;
    }

    @Override
    public void add(Student value) throws SQLException, IOException {
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
    public Student retrieve(String id) throws SQLException, IOException {
        Student student = null;
        try (Connection cnx = db.getConnection();
             PreparedStatement stm = cnx.prepareStatement(getCRUD().getRetrieveCmd())) {
            stm.clearParameters();
            stm.setObject(1, id);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    student = getRecord(rs);
                } else {
                    throw new IllegalArgumentException(id.toString());
                }
            }
        }
        return student;
    }

    @Override
    public void update(String id, Student value) throws SQLException, IOException {
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
    public void delete(String id) throws SQLException, IOException {
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
