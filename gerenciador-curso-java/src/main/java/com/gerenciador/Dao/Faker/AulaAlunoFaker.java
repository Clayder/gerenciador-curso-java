package com.gerenciador.Dao.Faker;

import com.gerenciador.Model.AulaAluno.AulaAluno;
import com.gerenciador.Model.AulaAluno.IAulaAluno;
import com.github.javafaker.Faker;
import java.sql.SQLException;

public class AulaAlunoFaker implements IFaker {

    @Override
    public void insert() throws SQLException {
        Faker faker = new Faker();
        for (int i = 0; i < 50; i++) {

            Integer idAula = faker.number().numberBetween(4, 100);
            Integer idAluno = faker.number().numberBetween(2, 150);

            IAulaAluno aulaAluno = new AulaAluno(idAluno, idAula);
            aulaAluno.insert();
        }
    }

}