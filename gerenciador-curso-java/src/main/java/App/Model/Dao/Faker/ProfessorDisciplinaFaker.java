package App.Model.Dao.Faker;

import App.Model.ProfessorDisciplina.IProfessorDisciplina;
import App.Model.ProfessorDisciplina.ProfessorDisciplina;
import com.github.javafaker.Faker;
import java.sql.SQLException;

/**
 * Classe utilizada para gerar dados falsos (apenas para teste). 
 * 
*/
public class ProfessorDisciplinaFaker implements IFaker {

    @Override
    public void insert() throws SQLException {
        Faker faker = new Faker();
        for (int i = 0; i < 50; i++) {

            Integer idProfessor = faker.number().numberBetween(6, 57);
            Integer idDisciplina = faker.number().numberBetween(4, 120);

            IProfessorDisciplina aulaAluno = new ProfessorDisciplina(idProfessor, idDisciplina);
            aulaAluno.insert();
        }
    }

}