package com.gerenciador.Model.Aluno;

import com.gerenciador.Model.Model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class AlunoDAO extends Model {

    private Integer id;
    private String matricula;
    private String nome;
    private String email;
    private String telefone;

    public AlunoDAO() throws SQLException {
        super();
        TABELA = "professor";
        setCampos();
    }

    public Integer getId() {
        return id;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    protected void setCampos() {
        colunasBD.add("matricula");
        colunasBD.add("nome");
        colunasBD.add("email");
        colunasBD.add("telefone");
    }

    /**
     *
     * @throws SQLException
     */
    @Override
    public void insert() throws SQLException {
        String query = getQueryInsert();
        statement = connection.prepareStatement(query);
        statement.setString(1, getMatricula());
        statement.setString(2, getNome());
        statement.setString(3, getEmail());
        statement.setString(4, getTelefone());
        statement.execute();
    }

    @Override
    public void update() throws SQLException {
        String query = getQueryUpdate();
        statement = connection.prepareStatement(query);
        statement.setString(1, getMatricula());
        statement.setString(2, getNome());
        statement.setString(3, getEmail());
        statement.setString(4, getTelefone());
        statement.setInt(5, getId());
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

    /**
     *
     * @return @throws SQLException
     */
    public List<Aluno> getAll() throws SQLException {
        ResultSet res = findAll();
        List<Aluno> professores = new ArrayList<>();
        while (res.next()) {
            Aluno professor = new Aluno();
            professor.setAll(res);
            professores.add(professor);
        }
        return professores;
    }

    /**
     *
     * @param res
     * @throws SQLException
     */
    protected void setAll(ResultSet res) throws SQLException {
        setMatricula(res.getString("matricula"));
        setNome(res.getString("nome"));
        setEmail(res.getString("email"));
        setTelefone(res.getString("telefone"));
        setId(res.getInt("id"));
    }
}
