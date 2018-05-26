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

    public DisciplinaDAO() throws SQLException {
        super();
        TABELA = "disciplina";
        setCampos();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public double getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getPRATICA() {
        return PRATICA.getValor();
    }

    public String getTEORICA() {
        return TEORICA.getValor();
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    @Override
    protected void setCampos() {
        colunasBD.add("codigo");
        colunasBD.add("conteudo");
        colunasBD.add("carga_horaria");
        colunasBD.add("tipo");
    }
    
    private String getTipo(){
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
