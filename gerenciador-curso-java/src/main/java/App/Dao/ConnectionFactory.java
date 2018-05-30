package App.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author peter
 */
public class ConnectionFactory {
    private static final String BANCO = "curso";
    private static final String HOST = "localhost:3306/";
    private static final String URL = "jdbc:mysql://"+HOST+ BANCO +"?serverTimezone=UTC&autoReconnect=true&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "p1p2ls";
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    
    /**
     * 
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    private static Connection createConnection() throws SQLException, ClassNotFoundException{
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
    public static Connection getConnection() throws SQLException{
        try{
            return createConnection();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
}
