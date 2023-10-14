package com.progra.proyecto1.Data;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

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
public class RelDatabase extends MysqlDataSource {

    private RelDatabase() {
    }

    public static DataSource getInstance(String configurationPath)
            throws IOException {
        DataSource r;
        Properties p = loadConfiguration(RelDatabase.class.getResourceAsStream(configurationPath));

        try {
            InitialContext ctx = new InitialContext();
            r = (DataSource) ctx.lookup(p.getProperty("JNDI_name"));

            System.out.println("Using JNDI to access database..");

        } catch (NamingException | NullPointerException ex) {

            r = new RelDatabase();
            RelDatabase r0 = (RelDatabase) r;

            r0.setURL(String.format("%s//%s/%s",
                    p.getProperty("protocol"),
                    p.getProperty("server_url"),
                    p.getProperty("database")
            ));
            r0.setUser(p.getProperty("user"));
            r0.setPassword(p.getProperty("password"));
            r0.configuration = p;

            System.out.println("Using JDBC driver to access database..");
        }

        return r;
    }

    public static DataSource getInstance() throws IOException {
        return getInstance(DEFAULT_CONFIGURATION_PATH);
    }

    @Override
    public Connection getConnection() throws SQLException {
        return super.getConnection();
    }

    public String listConfigurationData() {
        StringBuilder r = new StringBuilder("{\n");
        configuration.stringPropertyNames().forEach(key -> {
            r.append(String.format("\t%s: '%s', %n",
                    key, configuration.getProperty(key)));
        });
        r.append("\n}");
        return r.toString();
    }

    @Override
    public String toString() {
        return String.format("%s: %s",
                getClass().getCanonicalName(),
                listConfigurationData());
    }

    public static final Properties loadConfiguration(InputStream in)
            throws IOException {
        Properties p = new Properties();
        p.loadFromXML(in);
        return p;
    }

    protected Properties getConfiguration() {
        return configuration;
    }

    protected static final String DEFAULT_CONFIGURATION_PATH = "./db.properties";
    private Properties configuration = null;
}