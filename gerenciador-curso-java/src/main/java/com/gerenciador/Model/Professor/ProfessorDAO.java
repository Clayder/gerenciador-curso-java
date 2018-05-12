package com.gerenciador.Model.Professor;

import com.gerenciador.Model.Model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class ProfessorDAO extends Model {

    private Integer id;
    private String matricula;
    private String nome;
    private String endereco;
    private String telefone;
    private double valorHora;

    public ProfessorDAO() throws SQLException {
        super();
        TABELA = "professor";
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

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @throws SQLException
     */
    @Override
    public void insert() throws SQLException {
        String query = "INSERT INTO " + TABELA + " (matricula, nome, endereco, telefone, valor_hora) VALUES (?, ?, ?, ?, ?)";
        statement = connection.prepareStatement(query);
        statement.setString(1, getMatricula());
        statement.setString(2, getNome());
        statement.setString(3, getEndereco());
        statement.setString(4, getTelefone());
        statement.setDouble(5, getValorHora());
        statement.execute();
    }

    @Override
    public void update() throws SQLException {
        String query = "UPDATE " + TABELA + " SET matricula = ?, nome = ?, endereco = ?, telefone = ?, valor_hora = ? WHERE id = ?";
        statement = connection.prepareStatement(query);
        statement.setString(1, getMatricula());
        statement.setString(2, getNome());
        statement.setString(3, getEndereco());
        statement.setString(4, getTelefone());
        statement.setDouble(5, getValorHora());
        statement.setInt(6, getId());
        statement.execute();
    }

    /**
     *
     * @param id
     * @throws SQLException
     */
    public void get(Integer id) throws SQLException {
        ResultSet res = findById(id);
        while (res.next()) {
            setAll(res);
        }
    }

    /**
     *
     * @return @throws SQLException
     */
    public List<Professor> getAll() throws SQLException {
        ResultSet res = findAll();
        List<Professor> professores = new ArrayList<>();
        while (res.next()) {
            Professor professor = new Professor();
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
        setEndereco(res.getString("endereco"));
        setTelefone(res.getString("telefone"));
        setValorHora(res.getDouble("valor_hora"));
        setId(res.getInt("id"));
    }
}
