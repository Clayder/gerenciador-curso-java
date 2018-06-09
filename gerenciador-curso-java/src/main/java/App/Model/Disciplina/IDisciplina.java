package App.Model.Disciplina;

import App.Model.IModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IDisciplina extends IModel {

    public void setId(Integer id);

    public Integer getId();

    public String getCodigo();

    public void setCodigo(String codigo);

    public String getConteudo();

    public String getTipo();

    public void setConteudo(String conteudo);

    public double getCargaHoraria();

    public void setCargaHoraria(double cargaHoraria);

    public String getPRATICA();

    public String getTEORICA();

    public void setTipo(String tipo);

    /**
     *
     * @return @throws SQLException
     */
    public List<Disciplina> getAll() throws SQLException;

}
