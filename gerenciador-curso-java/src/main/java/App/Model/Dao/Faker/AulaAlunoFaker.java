package App.Model.Dao.Faker;

import App.Model.AulaAluno.AulaAluno;
import App.Model.AulaAluno.IAulaAluno;
import com.github.javafaker.Faker;
import java.sql.SQLException;

/**
 * Classe utilizada para gerar dados falsos (apenas para teste). 
 * 
*/
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