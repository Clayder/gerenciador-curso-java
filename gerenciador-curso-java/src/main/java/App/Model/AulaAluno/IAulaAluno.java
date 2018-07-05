package App.Model.AulaAluno;

import App.Model.IModel;
import java.sql.SQLException;

public interface IAulaAluno extends IModel {

    public Integer getId();
    
    /**
     * 
     * @param idAula
     * @param idAluno
     * @throws SQLException 
     */
    public void excluir(Integer idAula, Integer idAluno) throws SQLException;

    /**
     *
     * @return
     */
    public Integer getFkAluno();

    /**
     *
     * @param fkAluno
     */
    public void setFkAluno(Integer fkAluno);

    /**
     *
     * @return
     */
    public Integer getFkAula();

    /**
     *
     * @param fkAula
     */
    public void setFkAula(Integer fkAula);

}
