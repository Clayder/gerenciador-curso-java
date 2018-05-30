/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Dao {
    protected static Connection connection = null;
    protected String TABELA;
    protected ArrayList<String> colunasBD;
    protected static PreparedStatement statement = null;
    
    public Dao() throws SQLException {
        connection = ConnectionFactory.getConnection();
        colunasBD = new ArrayList<>();
    }
    
    public ArrayList<String> getColunasBD() {
        return colunasBD;
    }
    
}
