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
     * @param id
     * @return @throws SQLException
     */
    protected ResultSet findById(Integer id) throws SQLException {
        String query = "SELECT * FROM " + TABELA + " WHERE (id) = ?";
        statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        return statement.executeQuery();
    }

    /**
     *
     * @param id
     * @throws SQLException
     */
    public void removeById(Integer id) throws SQLException {
        String query = "DELETE FROM " + TABELA + " WHERE id = ?";

        statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        statement.execute();
    }
    
    /**
     * 
     * @throws SQLException 
     */
    public abstract void insert() throws SQLException;
    
    /**
     * 
     * @throws SQLException 
     */
    public abstract void update() throws SQLException;
    
    /**
     * 
     * @param id
     * @throws SQLException 
     */
    public abstract void get(Integer id) throws SQLException;
}
