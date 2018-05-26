package App.Model.Aula;

import App.Model.Disciplina.IDisciplina;
import App.Model.Professor.IProfessor;
import java.sql.SQLException;

public class Aula extends AulaDAO implements IAula {

    public Aula(IProfessor p, IDisciplina d) throws SQLException {
        super(p, d);
    }
    
}
