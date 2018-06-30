package App.Model.AulaAluno;

import App.Model.Model;
import java.sql.ResultSet;
import java.sql.SQLException;

abstract public class AulaAlunoDAO  extends Model {
    
    private Integer id;
    private Integer fkAluno;
    private Integer fkAula;
    
    /**
     *
     * @param fkAluno
     * @param fkAula
     * @throws SQLException
     */
    public AulaAlunoDAO(Integer fkAluno, Integer fkAula) throws SQLException {
        super();
        this.fkAluno = fkAluno;
        this.fkAula = fkAula;
        TABELA = "aula_aluno";
        setCampos();
    }
    
      public AulaAlunoDAO() throws SQLException {
        super();
        TABELA = "aula_aluno";
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
    public Integer getFkAluno() {
        return fkAluno;
    }

    /**
     * 
     * @param fkAluno 
     */
    public void setFkAluno(Integer fkAluno) {
        this.fkAluno = fkAluno;
    }

    /**
     * 
     * @return Integer
     */
    public Integer getFkAula() {
        return fkAula;
    }

    /**
     * 
     * @param fkAula 
     */
    public void setFkAula(Integer fkAula) {
        this.fkAula = fkAula;
    }

    /**
     *
     * @throws SQLException
     */
    @Override
    public void insert() throws SQLException {
        String query = getQueryInsert();
        statement = connection.prepareStatement(query);
        statement.setInt(1, getFkAula());
        statement.setInt(2, getFkAluno());
        statement.execute();
    }

    /**
     * 
     * @throws SQLException 
     */
    @Override
    public void update() throws SQLException {
        String query = getQueryUpdate();
        statement = connection.prepareStatement(query);
        statement.setInt(1, getFkAula());
        statement.setInt(2, getFkAluno());
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

    /**
     * Informa o nome das colunas da tabela aula_aluno
     */
    @Override
    protected void setCampos() {
        colunasBD.add("fkAula");
        colunasBD.add("fkAluno");
    }
    
    /**
     *
     * @param res
     * @throws SQLException
     */
    protected void setAll(ResultSet res) throws SQLException {
        setFkAula(res.getInt("fkAula"));
        setFkAluno(res.getInt("fkAluno"));
        setId(res.getInt("id"));
    }
    
       /**
     * Remove um registro específico, pelo id
     * 
     * @param id
     * @throws SQLException
     */
    public void excluir(Integer idAula, Integer idAluno) throws SQLException {
        String query = "DELETE FROM " + TABELA + " WHERE fkAula = ? AND fkAluno = ?";

        statement = connection.prepareStatement(query);
        statement.setInt(1, idAula);
        statement.setInt(2, idAluno);
        statement.execute();
    }
    
}
