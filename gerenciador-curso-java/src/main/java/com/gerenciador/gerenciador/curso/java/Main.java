/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciador.gerenciador.curso.java;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author peter
 */
public class Main {

    private static Connection CONNECTION = null;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        CONNECTION = new ConnectionFactory().getConnection();
        

    }

}
