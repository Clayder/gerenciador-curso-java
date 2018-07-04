package App.Model.Dao.Faker;

import App.Model.Aluno.Aluno;
import App.Model.Aluno.IAluno;
import com.github.javafaker.Faker;
import java.sql.SQLException;

/**
 * Classe utilizada para gerar alunos falsos (apenas para teste). 
 * 
*/
public class AlunoFaker implements IFaker{

    @Override
    public void insert() throws SQLException {

        Faker faker = new Faker();
        for (int i = 0; i < 50; i++) {
            System.out.println(i);
            IAluno aluno = new Aluno();
            aluno.setNome(faker.name().fullName());
            aluno.setTelefone(faker.phoneNumber().cellPhone());
            aluno.setEmail(faker.name().fullName() + "@gmail.com");
            aluno.setMatricula(faker.name().prefix() + faker.number().digits(5) + faker.name().suffix());
            aluno.insert();
        }
    }
}
