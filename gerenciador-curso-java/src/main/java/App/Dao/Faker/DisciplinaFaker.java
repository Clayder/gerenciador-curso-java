package App.Dao.Faker;

import App.Model.Disciplina.Disciplina;
import App.Model.Disciplina.IDisciplina;
import com.github.javafaker.Faker;
import java.sql.SQLException;

public class DisciplinaFaker implements IFaker{

    @Override
    public void insert() throws SQLException {
        Faker faker = new Faker();
        for (int i = 0; i < 70; i++) {
            IDisciplina dis= new Disciplina();
            dis.setCargaHoraria(faker.number().numberBetween(20, 40));
            dis.setCodigo(faker.name().prefix() + faker.number().digits(5) + faker.name().suffix());
            dis.setConteudo(faker.lorem().characters(15));
            dis.setTipo(dis.getTEORICA());
            dis.insert();
        }
    }
    
}
