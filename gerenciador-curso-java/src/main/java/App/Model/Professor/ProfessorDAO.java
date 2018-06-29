package App.Model.Professor;

import App.Model.Disciplina.Disciplina;
import App.Model.Disciplina.IDisciplina;
import App.Model.Model;
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
        setCampos();
    }

    /**
     *
     * @param matricula
     * @param nome
     * @param endereco
     * @param telefone
     * @param valorHora
     * @throws SQLException
     */
    public ProfessorDAO(String matricula, String nome, String endereco, String telefone, double valorHora) throws SQLException {
        super();
        this.matricula = matricula;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.valorHora = valorHora;

        TABELA = "professor";
        setCampos();
    }

    /**
     *
     * @return Integer
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @return String
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     *
     * @return String
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @return String
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     *
     * @return String
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * 
     * @return double
     */
    public double getValorHora() {
        return valorHora;
    }

    /**
     * 
     * @param matricula 
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * 
     * @param nome 
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * 
     * @param endereco 
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * 
     * @param telefone 
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * 
     * @param valorHora 
     */
    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Retorna as disciplinas vinculadas a um professor específico (getId)
     * 
     * @return
     * @throws SQLException 
     */
    public List<Disciplina> getDisciplinas() throws SQLException {
        String query = "SELECT prof_disc.id, prof_disc.fkProfessor, disciplina.carga_horaria, disciplina.codigo, disciplina.conteudo, disciplina.id as disciplina_id, disciplina.tipo\n"
                + "FROM curso.professor_disciplinas as prof_disc\n"
                + "INNER JOIN curso.disciplina as disciplina ON disciplina.id = prof_disc.fkDisciplina\n"
                + "where prof_disc.fkProfessor = ?";
        statement = connection.prepareStatement(query);
        statement.setInt(1, getId());
        ResultSet res = statement.executeQuery();
        List<Disciplina> disciplinas = new ArrayList<>();
        while (res.next()) {
            IDisciplina disc = new Disciplina();
            disc.setCargaHoraria(res.getDouble("carga_horaria"));
            disc.setCodigo(res.getString("codigo"));
            disc.setConteudo(res.getString("conteudo"));
            disc.setId(res.getInt("disciplina_id"));
            disc.setIdProfessorDisciplina(res.getInt("id"));
            disc.setTipo(res.getString("tipo"));
            disciplinas.add((Disciplina) disc);
        }
        return disciplinas;
    }

    /**
     * 
     */
    @Override
    protected void setCampos() {
        colunasBD.add("matricula");
        colunasBD.add("nome");
        colunasBD.add("endereco");
        colunasBD.add("telefone");
        colunasBD.add("valor_hora");
    }

    /**
     *
     * @throws SQLException
     */
    @Override
    public void insert() throws SQLException {
        String query = getQueryInsert(); // cria a string sql para fazer o insert
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
        String query = getQueryUpdate();
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
     * Método utilizado para popular um objeto ( atributos de uma classe )
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
     * Método utilizado para popular um objeto ( atributos de uma classe )
     * 
     * @param matricula
     * @throws SQLException
     */
    public void setByMatricula(String matricula) throws SQLException {
        String query = "SELECT * FROM " + TABELA + " WHERE (matricula) = ?";
        statement = connection.prepareStatement(query);
        statement.setString(1, matricula);
        ResultSet res = statement.executeQuery();
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
     * Método utilizado para popular um objeto ( atributos de uma classe )
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
