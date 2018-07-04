package App.Model.AulaAluno;

import java.sql.SQLException;

public class AulaAluno extends AulaAlunoDAO implements IAulaAluno {
    
    public AulaAluno(Integer fkAluno, Integer fkAula) throws SQLException {
        super(fkAluno, fkAula);
    }
    
    public AulaAluno() throws SQLException {
        super();
    }

}
