/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciador.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class Dao {
    protected static Connection connection = null;
    protected static String TABELA;
    protected static PreparedStatement statement = null;
    
    public Dao() throws SQLException {
        connection = ConnectionFactory.getConnection();
    }
    
}
