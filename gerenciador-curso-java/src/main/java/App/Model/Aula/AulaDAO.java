package App.Model.Aula;

import App.Model.Aluno.Aluno;
import App.Model.Aluno.IAluno;
import App.Model.Disciplina.Disciplina;
import App.Model.Disciplina.IDisciplina;
import App.Model.Model;
import App.Model.Professor.IProfessor;
import App.Model.Professor.Professor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

abstract class AulaDAO extends Model {

    private Integer id;
    private IDisciplina disciplina;
    private IProfessor professor;
    private String data;

    public AulaDAO(IProfessor professor, IDisciplina disciplina) throws SQLException {
        super();
        TABELA = "aula";
        this.professor = professor;
        this.disciplina = disciplina;
        setCampos();
    }
    
    public AulaDAO() throws SQLException {
        super();
        TABELA = "aula";
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

    public void setDisciplina(IDisciplina disciplina) {
        this.disciplina = disciplina;
    }

    public void setProfessor(IProfessor professor) {
        this.professor = professor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<Aluno> getAlunos() throws SQLException {
        String query = "SELECT aula_aluno.id, aluno.nome, aluno.telefone, aluno.matricula, aluno.email, aluno.id as id_aluno FROM curso.aula_aluno as aula_aluno\n"
                + "INNER JOIN curso.aluno as aluno ON aluno.id = aula_aluno.fkAluno\n"
                + "where fkAula = ?";
        statement = connection.prepareStatement(query);
        statement.setInt(1, getId());
        ResultSet res = statement.executeQuery();
        List<Aluno> alunos = new ArrayList<>();
        while (res.next()) {
            IAluno aluno = new Aluno();
            aluno.setEmail(res.getString("email"));
            aluno.setId(res.getInt("id_aluno"));
            aluno.setMatricula(res.getString("matricula"));
            aluno.setNome(res.getString("nome"));
            aluno.setTelefone(res.getString("telefone"));
            alunos.add((Aluno) aluno);
        }
        return alunos;
    }

    @Override
    protected void setCampos() {
        colunasBD.add("fkDisciplina");
        colunasBD.add("fkProfessor");
        colunasBD.add("data");
    }

    /**
     *
     * @throws SQLException
     */
    @Override
    public void insert() throws SQLException {
        String query = getQueryInsert();
        statement = connection.prepareStatement(query);
        statement.setInt(1, getDisciplina().getId());
        statement.setInt(2, getProfessor().getId());
        statement.setString(3, getData());
        statement.execute();
    }

    @Override
    public void update() throws SQLException {
        String query = getQueryUpdate();
        statement = connection.prepareStatement(query);
        statement.setInt(1, getDisciplina().getId());
        statement.setInt(2, getProfessor().getId());
        statement.setString(3, getData());
        statement.setInt(4, getId());
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
     * @param id
     * @return @throws SQLException
     */
    @Override
    protected ResultSet findById(Integer id) throws SQLException {
        String query = join() + " WHERE (aula.id) = ?";
        statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        return statement.executeQuery();
    }

    /**
     *
     * @return
     */
    private String join() {
        String query = "SELECT aula.id, aula.fkProfessor, aula.fkDisciplina, aula.data,\n"
                + "prof.matricula, prof.nome, prof.endereco, prof.telefone, prof.valor_hora,\n"
                + "disc.carga_horaria, disc.codigo, disc.conteudo, disc.tipo\n"
                + "FROM curso.aula as aula\n"
                + "INNER JOIN curso.professor as prof ON prof.id = aula.fkProfessor\n"
                + "INNER JOIN curso.disciplina as disc ON disc.id = aula.fkDisciplina\n";
        return query;
    }

    /**
     *
     * @return @throws SQLException
     */
    public List<Aula> getAll() throws SQLException {

        ResultSet res = findAll();
        List<Aula> aulas = new ArrayList<>();
        while (res.next()) {
            IProfessor professor = new Professor();

            IDisciplina disciplina = new Disciplina();

            Aula aula = new Aula(professor, disciplina);
            aula.setAll(res);
            aulas.add(aula);
        }

        return aulas;
    }

    /**
     *
     * @return @throws SQLException
     */
    @Override
    public ResultSet findAll() throws SQLException {
        String query = join();
        statement = connection.prepareStatement(query);
        return statement.executeQuery();
    }

    /**
     *
     * @param res
     * @throws SQLException
     */
    protected void setAll(ResultSet res) throws SQLException {
        this.disciplina.setId(res.getInt("fkDisciplina"));
        this.disciplina.setTipo(res.getString("tipo"));
        this.disciplina.setConteudo(res.getString("conteudo"));
        this.disciplina.setCodigo(res.getString("codigo"));
        this.disciplina.setCargaHoraria(res.getDouble("carga_horaria"));

        this.professor.setId(res.getInt("fkProfessor"));
        this.professor.setValorHora(res.getDouble("valor_hora"));
        this.professor.setTelefone(res.getString("telefone"));
        this.professor.setNome(res.getString("nome"));
        this.professor.setMatricula(res.getString("matricula"));
        this.professor.setEndereco(res.getString("endereco"));

        setData(res.getString("data"));
        setId(res.getInt("id"));
    }
}
