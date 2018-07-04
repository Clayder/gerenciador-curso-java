package App.Model.ProfessorDisciplina;

import java.sql.SQLException;

public class ProfessorDisciplina extends ProfessorDisciplinaDAO implements IProfessorDisciplina {
    
    public ProfessorDisciplina(Integer fkProfessor, Integer fkDisciplina) throws SQLException {
        super(fkProfessor, fkDisciplina);
    }
    
    public ProfessorDisciplina() throws SQLException {
        super();
    }

}
