package com.gerenciador.Model.Professor;

import com.gerenciador.Model.Disciplina.Disciplina;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IProfessor {

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
    
    
    public Integer getId();

    public String getMatricula();

    public String getNome();

    public String getEndereco();

    public String getTelefone();

    public double getValorHora();

    public void setMatricula(String matricula);

    public void setNome(String nome);

    public void setEndereco(String endereco);

    public void setTelefone(String telefone);

    public void setValorHora(double valorHora);

    public void setId(Integer id);

    public void insert() throws SQLException;

    public void update() throws SQLException;
    
    public List<Disciplina> getDisciplinas() throws SQLException;

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
    public List<Professor> getAll() throws SQLException;

}
