/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciador.Model.AulaAluno;

import java.sql.SQLException;

public class AulaAluno extends AulaAlunoDAO implements IAulaAluno {
    
    public AulaAluno(Integer fkAluno, Integer fkAula) throws SQLException {
        super(fkAluno, fkAula);
    }
    
    public AulaAluno() throws SQLException {
        super();
    }

}
