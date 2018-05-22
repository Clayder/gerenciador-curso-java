package com.gerenciador.Model.AlunoDisciplina;

import com.gerenciador.Model.Model;
import java.sql.ResultSet;
import java.sql.SQLException;

abstract public class ProfessorDisciplinaDAO extends Model {

    private Integer id;
    private Integer fkProfessor;
    private Integer fkDisciplina;

    /**
     *
     * @param fkProfesso
     * @param fkDisciplina
     * @throws SQLException
     */
    public ProfessorDisciplinaDAO(Integer fkProfessor, Integer fkDisciplina) throws SQLException {
        super();
        this.fkProfessor = fkProfessor;
        this.fkDisciplina = fkDisciplina;
        TABELA = "professor_disciplinas";
        setCampos();
    }

    public ProfessorDisciplinaDAO() throws SQLException {
        super();
        TABELA = "professor_disciplinas";
        setCampos();
    }

    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFkProfessor() {
        return fkProfessor;
    }

    public void setFkProfessor(Integer fkProfessor) {
        this.fkProfessor = fkProfessor;
    }

    public Integer getFkDisciplina() {
        return fkDisciplina;
    }

    public void setFkDisciplina(Integer fkDisciplina) {
        this.fkDisciplina = fkDisciplina;
    }

    /**
     *
     * @throws SQLException
     */
    @Override
    public void insert() throws SQLException {
        String query = getQueryInsert();
        statement = connection.prepareStatement(query);
        statement.setInt(1, getFkProfessor());
        statement.setInt(2, getFkDisciplina());
        statement.execute();
    }

    @Override
    public void update() throws SQLException {
        String query = getQueryUpdate();
        statement = connection.prepareStatement(query);
        statement.setInt(1, getFkProfessor());
        statement.setInt(2, getFkDisciplina());
        statement.setInt(3, getId());
        statement.execute();
    }

    /**
     *
     * @param id
     * @throws SQLException
     */
    @Override
    public void setById(Integer id) throws SQLException {
        ResultSet res = findById(id);
        while (res.next()) {
            setAll(res);
        }
    }

    @Override
    protected void setCampos() {
        colunasBD.add("fkProfessor");
        colunasBD.add("fkDisciplina");
    }

    /**
     *
     * @param res
     * @throws SQLException
     */
    protected void setAll(ResultSet res) throws SQLException {
        setFkProfessor(res.getInt("fkProfessor"));
        setFkDisciplina(res.getInt("fkDisciplina"));
        setId(res.getInt("id"));
    }

}
