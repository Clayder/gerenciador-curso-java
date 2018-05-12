package com.gerenciador.gerenciador.curso.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author peter
 */
public class ConnectionFactory {
    private final String BANCO = "curso";
    private final String HOST = "localhost:3306/";
    private final String URL = "jdbc:mysql://"+HOST+ BANCO +"?serverTimezone=UTC";
    private final String USER = "root";
    private final String PASSWORD = "p1p2ls";
    private final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    
    /**
     * 
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    private Connection createConnection() throws SQLException, ClassNotFoundException{
        Connection connection = null;
        try{
            Class.forName(DRIVER_CLASS);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
    
    /**
     * 
     * @return
     * @throws SQLException 
     */
    public Connection getConnection() throws SQLException{
        try{
            return createConnection();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
}
