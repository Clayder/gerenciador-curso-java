package com.gerenciador.Model.Aula;

import com.gerenciador.Model.Disciplina.IDisciplina;
import com.gerenciador.Model.Professor.IProfessor;
import java.sql.SQLException;

public class Aula extends AulaDAO implements IAula {

    public Aula(IProfessor p, IDisciplina d) throws SQLException {
        super(p, d);
    }
    
    public Aula() throws SQLException {
        super();
    }
}
