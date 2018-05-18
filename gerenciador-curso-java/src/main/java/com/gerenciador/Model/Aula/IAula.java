package com.gerenciador.Model.Aula;

import com.gerenciador.Model.Aluno.*;
import com.gerenciador.Model.Disciplina.IDisciplina;
import com.gerenciador.Model.Professor.IProfessor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IAula {

     /**
     * 
     * @return @throws SQLException
     */
    public ResultSet findAll() throws SQLException;

    /**
     *
     * @param id
     * @throws SQLException
     */
    public void removeById(Integer id) throws SQLException;
    
    
    public Integer getId() ;

    public void setId(Integer id) ;

    public IDisciplina getDisciplina() ;

    public void setDisciplina(Integer disciplinaId) throws SQLException ;

    public IProfessor getProfessor() ;

    public void setProfessor(Integer professorId) throws SQLException ;

    public List<IAluno> getAlunos();

    public void setAlunos(int alunoId);

    public String getData() ;

    public void setData(String data);

    /**
     *
     * @throws SQLException
     */
    public void insert() throws SQLException;

    public void update() throws SQLException ;

    /**
     *
     * @param id
     * @throws SQLException
     */
    public void setById(Integer id) throws SQLException;

    /**
     *
     * @return @throws SQLException
     */
    public List<Aula> getAll() throws SQLException;

}
