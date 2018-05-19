package com.gerenciador.Model.Aula;

import com.gerenciador.Model.Aluno.IAluno;
import com.gerenciador.Model.Disciplina.IDisciplina;
import com.gerenciador.Model.Model;
import com.gerenciador.Model.Professor.IProfessor;
import java.util.List;

abstract class AulaDAO extends Model {

    private Integer id;
    private IDisciplina disciplina;
    private IProfessor professor;
    private List<IAluno> alunos;
    private String data;

    
}
