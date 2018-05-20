package com.gerenciador.Model.AulaAluno;

import com.gerenciador.Model.Aluno.IAluno;
import com.gerenciador.Model.Aula.IAula;
import com.gerenciador.Model.Model;
import java.sql.SQLException;

public class AulaAluno  extends Model {
    
    private Integer id;
    private IAluno aluno;
    private IAula aula;
    
    /**
     *
     * @throws SQLException
     */
    public AulaAluno(IAula aula, IAluno aluno) throws SQLException {
        super();
        this.aluno = aluno;
        this.aula = aula;
        TABELA = "aula-aluno";
        setCampos();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public IAluno getAluno() {
        return aluno;
    }

    public void setAluno(IAluno aluno) {
        this.aluno = aluno;
    }

    public IAula getAula() {
        return aula;
    }

    public void setAula(IAula aula) {
        this.aula = aula;
    }
    
    

    /**
     *
     * @throws SQLException
     */
    @Override
    public void insert() throws SQLException {
        String query = getQueryInsert();
        statement = connection.prepareStatement(query);
        statement.setInt(1, getAula().getId());
        statement.setInt(2, getAluno().getId());
        statement.execute();
    }

    @Override
    public void update() throws SQLException {
        String query = getQueryUpdate();
        statement = connection.prepareStatement(query);
        statement.setInt(1, getAula().getId());
        statement.setInt(2, getAluno().getId());
        statement.setInt(3, getId());
        statement.execute();
    }

    @Override
    public void setById(Integer id) throws SQLException {
        
    }

    @Override
    protected void setCampos() {
        colunasBD.add("fkAula");
        colunasBD.add("fkAluno");
    }
    
}
