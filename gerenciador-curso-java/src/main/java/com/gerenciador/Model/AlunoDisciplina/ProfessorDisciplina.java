/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciador.Model.AlunoDisciplina;

import java.sql.SQLException;

public class ProfessorDisciplina extends ProfessorDisciplinaDAO implements IProfessorDisciplina {
    
    public ProfessorDisciplina(Integer fkProfessor, Integer fkDisciplina) throws SQLException {
        super(fkProfessor, fkDisciplina);
    }
    
    public ProfessorDisciplina() throws SQLException {
        super();
    }

}
