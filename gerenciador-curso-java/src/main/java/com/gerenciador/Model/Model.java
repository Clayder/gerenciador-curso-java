package com.gerenciador.Model;

import com.gerenciador.Dao.Dao;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Model extends Dao{
    
    public Model() throws SQLException{
        super();
    }

    /**
     * 
     * @return @throws SQLException
     */
    public ResultSet findAll() throws SQLException {
        String query = "SELECT * FROM " + TABELA;
        statement = connection.prepareStatement(query);
        return statement.executeQuery();
    }

    /**
     *
     * @return @throws SQLException
     */
    public static ResultSet findById(Integer id) throws SQLException {
        String query = "SELECT * FROM " + TABELA + " WHERE (id) = ?";
        statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        return statement.executeQuery();
    }

    /**
     *
     * @param movie
     * @throws SQLException
     */
    public static void removeById(Integer id) throws SQLException {
        String query = "DELETE FROM " + TABELA + " WHERE id = ?";

        statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        statement.execute();
    }
}