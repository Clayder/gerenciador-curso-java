package com.gerenciador.Dao.Faker;

import com.gerenciador.Model.Aluno.Aluno;
import com.gerenciador.Model.Aluno.IAluno;
import com.gerenciador.Model.Aula.Aula;
import com.gerenciador.Model.Aula.IAula;
import com.gerenciador.Model.Disciplina.Disciplina;
import com.gerenciador.Model.Disciplina.IDisciplina;
import com.gerenciador.Model.Professor.IProfessor;
import com.gerenciador.Model.Professor.Professor;
import com.github.javafaker.Faker;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class AulaFaker implements IFaker {

    @Override
    public void insert() throws SQLException {
        Faker faker = new Faker();
        for (int i = 0; i < 50; i++) {
            IProfessor p = new Professor();
            int idProfessor = faker.number().numberBetween(5, 50);
            p.setById(idProfessor);

            IDisciplina d = new Disciplina();
            d.setById(faker.number().numberBetween(2, 122));

            IAula aula = new Aula(p, d);

            Random random = new Random();
            int minDay = (int) LocalDate.of(2017, 1, 1).toEpochDay();
            int maxDay = (int) LocalDate.of(2019, 1, 1).toEpochDay();
            long randomDay = minDay + random.nextInt(maxDay - minDay);

            LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
            String data = randomBirthDate.format(DateTimeFormatter.ISO_DATE);

            aula.setData(data);
            aula.insert();
        }
    }

}
