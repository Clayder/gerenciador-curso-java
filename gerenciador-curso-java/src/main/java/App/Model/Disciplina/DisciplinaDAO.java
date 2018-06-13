package App.Model.Disciplina;

import App.Model.Model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class DisciplinaDAO extends Model {

    private Integer id;
    private String codigo;
    private String conteudo;
    private double cargaHoraria;
    private TipoDisciplina PRATICA = TipoDisciplina.PRATICA;
    private TipoDisciplina TEORICA = TipoDisciplina.TEORICA;
    private String tipo;
    private Integer idProfessorDisciplina;

    public DisciplinaDAO() throws SQLException {
        super();
        TABELA = "disciplina";
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
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return Integer
     */
    public Integer getIdProfessorDisciplina() {
        return idProfessorDisciplina;
    }

    /**
     * 
     * @param idProfessorDisciplina 
     */
    public void setIdProfessorDisciplina(int idProfessorDisciplina) {
        this.idProfessorDisciplina = idProfessorDisciplina;
    }

    /**
     * 
     * @return String
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * 
     * @param codigo 
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * 
     * @return String
     */
    public String getConteudo() {
        return conteudo;
    }

    /**
     * 
     * @param conteudo 
     */
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    /**
     * 
     * @return double
     */
    public double getCargaHoraria() {
        return cargaHoraria;
    }

    /**
     * 
     * @param cargaHoraria 
     */
    public void setCargaHoraria(double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

       /**
     * 
     * @return String
     */
    public String getPRATICA() {
        return PRATICA.getValor();
    }

       /**
     * 
     * @return String
     */
    public String getTEORICA() {
        return TEORICA.getValor();
    }

    /**
     * 
     * @param tipo 
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Informa o nome das colunas da tabela disciplina
     */
    @Override
    protected void setCampos() {
        colunasBD.add("codigo");
        colunasBD.add("conteudo");
        colunasBD.add("carga_horaria");
        colunasBD.add("tipo");
    }

    /**
     * 
     * @return String
     */
    public String getTipo() {
        return tipo;
    }

    /**
     *
     * @throws SQLException
     */
    @Override
    public void insert() throws SQLException {
        String query = getQueryInsert();
        statement = connection.prepareStatement(query);
        statement.setString(1, getCodigo());
        statement.setString(2, getConteudo());
        statement.setDouble(3, getCargaHoraria());
        statement.setString(4, getTipo());
        statement.execute();
    }

    @Override
    public void update() throws SQLException {
        String query = getQueryUpdate();
        statement = connection.prepareStatement(query);
        statement.setString(1, getCodigo());
        statement.setString(2, getConteudo());
        statement.setDouble(3, getCargaHoraria());
        statement.setString(4, getTipo());
        statement.setInt(5, getId());
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
     * @param codigo
     * @throws SQLException
     */
    public void setByCodigo(String codigo) throws SQLException {
        String query = "SELECT * FROM " + TABELA + " WHERE (codigo) = ?";
        statement = connection.prepareStatement(query);
        statement.setString(1, codigo);
        ResultSet res = statement.executeQuery();
        while (res.next()) {
            setAll(res);
        }
    }

    /**
     *
     * @return @throws SQLException
     */
    public List<Disciplina> getAll() throws SQLException {
        ResultSet res = findAll();
        List<Disciplina> disciplinas = new ArrayList<>();
        while (res.next()) {
            Disciplina disciplina = new Disciplina();
            disciplina.setAll(res);
            disciplinas.add(disciplina);
        }
        return disciplinas;
    }

    /**
     *
     * @param res
     * @throws SQLException
     */
    protected void setAll(ResultSet res) throws SQLException {
        setCodigo(res.getString("codigo"));
        setConteudo(res.getString("conteudo"));
        setCargaHoraria(res.getDouble("carga_horaria"));
        setTipo(res.getString("tipo"));
        setId(res.getInt("id"));
    }
}
