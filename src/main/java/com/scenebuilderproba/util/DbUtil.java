package com.scenebuilderproba.util;

import com.sun.rowset.CachedRowSetImpl;
import javax.sql.rowset.RowSetProvider;


import javax.sql.rowset.CachedRowSet;

import java.sql.*;

public class DbUtil {
    //declare JDBC driver
    private static final String JDBCDRIVER = "oracle.jdbc.driver.OracleDriver";
    //declare connection
    public static Connection dbConnection = null;
    //declare connection String connectionString="jdbc:oracle:thin:username/password@id:port/sid"
    private static final String CONNECTIONSTRING = "jdbc:oracle:thin:HR/passpass@localhost:49161/xe";

    //connection to DB
    public static void dbConnect() throws SQLException, ClassNotFoundException {
        try {
            Class.forName(JDBCDRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("where is your Oracle JDBC");
            e.printStackTrace();
            throw e;
        }

        System.out.println("Oracle Driver Registered");
        //establish Oracle Connection using Connection String
        try {
            dbConnection = DriverManager.getConnection(CONNECTIONSTRING);
        } catch (SQLException e) {
            System.out.println("connection failed" + e);
            e.printStackTrace();
            throw e;
        }
    }

    //closeConnection
    public static void dbDisconnect() throws SQLException {
        try {
            if (dbConnection != null && !dbConnection.isClosed()) {
                dbConnection.close();
            }

        } catch (Exception e) {
            throw e;
        }
    }

    //Db exec query operation
    public static ResultSet dbExecuteQuery(String queryStatement) throws SQLException, ClassNotFoundException {
        Statement statement = null;
        ResultSet resultSet = null;
        CachedRowSetImpl cachedRowSetImp = null;
        try {
            dbConnect();
            System.out.println("Select Statement:" + queryStatement + "\n");
            statement = dbConnection.createStatement();
            //execute query operation
            resultSet = statement.executeQuery(queryStatement);
            cachedRowSetImp = new CachedRowSetImpl();
            cachedRowSetImp.populate(resultSet);

        } catch (SQLException e) {
            System.out.println("problem execute query operation : " + e);
            throw e;
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            dbDisconnect();
        }
        return cachedRowSetImp;
    }

    public static void dbExecuteUpdate(String sqlStatement) throws SQLException, ClassNotFoundException {
        Statement statement = null;
        try {
            dbConnect();
            statement = dbConnection.createStatement();
            statement.executeUpdate(sqlStatement);
        } catch (SQLException e) {
            System.out.println("problem at execute update:" + e);
            throw e;
        } finally {
            if (statement != null) {
                statement.close();
            }
            dbDisconnect();
        }
    }
}