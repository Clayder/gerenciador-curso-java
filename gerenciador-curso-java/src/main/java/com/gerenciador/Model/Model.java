package com.gerenciador.Model;

import com.gerenciador.Dao.Dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
     * @return String "INSERT INTO " + TABELA + " (matricula, nome, endereco, telefone, valor_hora) VALUES (?, ?, ?, ?, ?)"
     */
    public String getQueryInsert(){
        String campos = "";
        String values = "";
        
        int tam  = this.colunasBD.size();
        
        for(String coluna : this.colunasBD){
            tam--;
            campos += coluna;
            values += "?";
            if(tam > 0){
                campos += ", ";
                values += ", ";
            }
        }
        
        String insert;
        
        insert = "INSERT INTO " + TABELA;
        insert += " (";
        insert += campos;
        insert += ")";
        insert += " VALUES (";
        insert += values;
        insert += ")";
        
        return insert;
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
    
    protected abstract void setCampos();
}
