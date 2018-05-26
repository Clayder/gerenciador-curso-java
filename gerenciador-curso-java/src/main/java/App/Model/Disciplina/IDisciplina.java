package App.Model.Disciplina;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IDisciplina {

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

    public void setId(Integer id);
    
    public Integer getId();

    public String getCodigo();

    public void setCodigo(String codigo);

    public String getConteudo();

    public void setConteudo(String conteudo);

    public double getCargaHoraria();

    public void setCargaHoraria(double cargaHoraria);

    public String getPRATICA();

    public String getTEORICA();

    public void setTipo(String tipo);

    /**
     *
     * @throws SQLException
     */
    public void insert() throws SQLException ;

    public void update() throws SQLException;

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
    public List<Disciplina> getAll() throws SQLException;


}
