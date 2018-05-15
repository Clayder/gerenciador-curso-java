/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciador;

import com.gerenciador.Model.Professor.Professor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author peter
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Professor p = new Professor();
        
        /*
        p.setEndereco("Rua bangu");
        p.setMatricula("123458");
        p.setNome("Peter");
        p.setTelefone("21 971579961");
        p.setValorHora(100.00);
        p.insert();
        */
        
        System.out.println(p.getQueryUpdate());
       
       
        /*
        ArrayList<Professor> data = (ArrayList<Professor>) p.getAll();
        for (Professor movie : data) {
            System.out.println("Id: " + movie.getId());
            System.out.println("Name: " + movie.getNome());
        }
*/
    }

}
