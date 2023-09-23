/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.proyecto1.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author leoch
 */
public class RelDatabase {

    Connection cnx;

    public RelDatabase() throws SQLException {
        cnx = this.getConnection();
    }

    public Connection getConnection() throws SQLException {
        Connection cnx = null;
        try {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("jdbc/StudentsDBPool");
            cnx = ds.getConnection();
        } catch (NamingException ex) {
            cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_grupos", "root", "root");
        }
        return cnx;
    }
}
