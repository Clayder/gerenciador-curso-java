/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciador;

import com.gerenciador.Model.Aluno.Aluno;
import com.gerenciador.Model.Aluno.IAluno;
import com.gerenciador.Model.Professor.IProfessor;
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

        IProfessor p = new Professor();
//
//        /*
//        p.setEndereco("Rua bangu");
//        p.setMatricula("123874598");
//        p.setNome("Peter");
//        p.setTelefone("21 971579961");
//        p.setValorHora(130.00);
//        p.insert();
//         */
//        p.setById(5);
//
//        System.out.println(p.getNome());
//
//        /*
//        ArrayList<Professor> data = (ArrayList<Professor>) p.getAll();
//        for (Professor movie : data) {
//            System.out.println("Id: " + movie.getId());
//            System.out.println("Name: " + movie.getNome());
//        }
//         */

/* ***************** Aluno ************************************* */
        IAluno a = new Aluno();
//        a.setEmail("peterclayder@gmail.com");
//        a.setMatricula("232323");
//        a.setNome("Peter");
//        a.setTelefone("21971579961");
//        a.insert();

//        a.setById(1);
//        System.out.println(a.getNome());
//        a.setNome("Pailo");
//        a.update();
//
//         ArrayList<Aluno> data = (ArrayList<Aluno>) a.getAll();
//        for (Aluno movie : data) {
//            System.out.println("Id: " + movie.getId());
//            System.out.println("Name: " + movie.getNome());
//        }

        
    }

}
