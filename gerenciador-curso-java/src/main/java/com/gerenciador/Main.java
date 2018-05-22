/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciador;

import com.gerenciador.Dao.Faker.AlunoFaker;
import com.gerenciador.Dao.Faker.AulaAlunoFaker;
import com.gerenciador.Dao.Faker.AulaFaker;
import com.gerenciador.Dao.Faker.DisciplinaFaker;
import com.gerenciador.Dao.Faker.IFaker;
import com.gerenciador.Dao.Faker.ProfessorFaker;
import com.gerenciador.Model.Aluno.Aluno;
import com.gerenciador.Model.Aluno.IAluno;
import com.gerenciador.Model.AlunoDisciplina.IProfessorDisciplina;
import com.gerenciador.Model.AlunoDisciplina.ProfessorDisciplina;
import com.gerenciador.Model.Aula.Aula;
import com.gerenciador.Model.Aula.IAula;
import com.gerenciador.Model.AulaAluno.AulaAluno;
import com.gerenciador.Model.AulaAluno.IAulaAluno;
import com.gerenciador.Model.Disciplina.Disciplina;
import com.gerenciador.Model.Disciplina.IDisciplina;
import com.gerenciador.Model.Professor.IProfessor;
import com.gerenciador.Model.Professor.Professor;
import com.github.javafaker.Faker;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author peter
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {

//        p.setEndereco("Rua bangu");
//        p.setMatricula("123874522298");
//        p.setNome("Peter");
//        p.setTelefone("21 971579961");
//        p.setValorHora(130.00);
//        p.insert();
//
//        p.setById(5);
//
//        System.out.println(p.getNome());
//        /*
//        ArrayList<Professor> data = (ArrayList<Professor>) p.getAll();
//        for (Professor movie : data) {
//            System.out.println("Id: " + movie.getId());
//            System.out.println("Name: " + movie.getNome());
//        }
//         */

        /* ***************** Aluno ************************************* */
//        IAluno a = new Aluno();
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
//        a.removeById(1);

        /* ***************** Disciplina ************************************* */
//        IDisciplina d = new Disciplina();
//        d.setCargaHoraria(23.4);
//        d.setCodigo("1111");
//        d.setConteudo("Tet ete te ttee");
//        d.setTipo(d.getPRATICA());
//        d.insert();
//          d.setById(1);
//          System.out.println("Name: " + d.getConteudo());
//          d.setTipo(d.getTEORICA());
//         d.setCargaHoraria(23.4);
//          d.update();
//        ArrayList<Disciplina> data = (ArrayList<Disciplina>) d.getAll();
//        for (Disciplina movie : data) {
//            System.out.println("Id: " + movie.getId());
//            System.out.println("Name: " + movie.getConteudo());
//        }
//          d.removeById(1);
//        Aulas 
        IProfessor p = new Professor();
        p.setById(5);
//    System.out.println(p.getNome());
//    
        IDisciplina d = new Disciplina();
        d.setById(2);
//    System.out.println(d.getConteudo());

        IAula al = new Aula(p, d);
//    al.setData("2018-03-02");
//    al.insert();
//    al.setById(3);
//    al.setData("2011-01-03");
//    al.update();
//      al.removeById(3);
//    IProfessor p1 = new Professor();
//    p1.setById(7);
//    
//    al.setProfessor(p1);

//    System.out.println(al.getDisciplina().getCargaHoraria());
//    
//    al.update();
//    System.out.println(al.getProfessor().getNome());
//
//        ArrayList<Aula> data = (ArrayList<Aula>) al.getAll();
//        for (Aula movie : data) {
//            System.out.println("Id: " + movie.getId());
//            System.out.println("Name: " + movie.getDisciplina().getConteudo());
//        }
// Aula Aluno
//        IAulaAluno aual = new AulaAluno(2, 1);
//        aual.insert();
//        IAulaAluno aual2 = new AulaAluno();
//        aual2.removeById(2);
//        aual2.setById(1);
//        System.out.println(aual2.getFkAula());
//        aual2.setFkAula(1);
//        aual2.update();
//        Faker faker = new Faker();
////        int idProfessor = faker.number().numberBetween(5, 50);
//        Random random = new Random();
//        int minDay = (int) LocalDate.of(2017, 1, 1).toEpochDay();
//        int maxDay = (int) LocalDate.of(2019, 1, 1).toEpochDay();
//        long randomDay = minDay + random.nextInt(maxDay - minDay);
//
//        LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
//
//        System.out.println(randomBirthDate);
//
//        IFaker fake;
////        AlunoFaker alFaker = new AlunoFaker();
////        alFaker.insert();
//
////        fake = new ProfessorFaker();
//        fake = new AulaAlunoFaker();
//        fake.insert();
// Professor Disciplina
//        IProfessorDisciplina profDisc = new ProfessorDisciplina(5, 2);
//        profDisc.insert();
        IProfessorDisciplina profDisc = new ProfessorDisciplina();
        profDisc.setById(1);
        profDisc.removeById(1);
        
    }

}
