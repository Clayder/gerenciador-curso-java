package App.Model.Dao.Faker;

import App.Model.Professor.IProfessor;
import App.Model.Professor.Professor;
import com.github.javafaker.Faker;
import java.sql.SQLException;
import java.util.Locale;

public class ProfessorFaker implements IFaker{
    
    @Override
    public void insert() throws SQLException {

        Faker faker = new Faker();
        Faker fakerLocale = new Faker(new Locale("pt-BR"));
        for (int i = 0; i < 50; i++) {
            System.out.println(i);
            IProfessor professor = new Professor();
            professor.setNome(faker.name().fullName());
            professor.setTelefone(faker.phoneNumber().cellPhone());
            professor.setEndereco(fakerLocale.address().city());
            professor.setMatricula(faker.name().prefix() + faker.number().digits(5) + faker.name().suffix());
            String valorHora = faker.commerce().price().replace(",", ".");
            professor.setValorHora(Double.parseDouble(valorHora));
            professor.insert();
        }
    }
}
