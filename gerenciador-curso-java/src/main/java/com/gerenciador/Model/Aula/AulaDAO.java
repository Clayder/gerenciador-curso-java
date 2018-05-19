package com.gerenciador.Model.Aula;

import com.gerenciador.Model.Aluno.IAluno;
import com.gerenciador.Model.Disciplina.Disciplina;
import com.gerenciador.Model.Disciplina.IDisciplina;
import com.gerenciador.Model.Model;
import com.gerenciador.Model.Professor.IProfessor;
import com.gerenciador.Model.Professor.Professor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

abstract class AulaDAO extends Model {

    private Integer id;
    private IDisciplina disciplina;
    private IProfessor professor;
    private List<IAluno> alunos;
    private String data;

    public AulaDAO(IProfessor professor, IDisciplina disciplina) throws SQLException {
        TABELA = "aula";
        this.professor = professor;
        this.disciplina = disciplina;
        setCampos();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public IDisciplina getDisciplina() {
        return disciplina;
    }

    public IProfessor getProfessor() {
        return professor;
    }

    public List<IAluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(int alunoId) {
        this.alunos = alunos;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    protected void setCampos() {
        colunasBD.add("fkDisciplina");
        colunasBD.add("fkProfessor");
        colunasBD.add("data");
    }

    
}
