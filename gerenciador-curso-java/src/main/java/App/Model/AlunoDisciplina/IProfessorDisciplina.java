package App.Model.AlunoDisciplina;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IProfessorDisciplina {

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

    public Integer getId();

    /**
     *
     * @param id
     */
    public void setId(Integer id);

    public Integer getFkProfessor();

    public void setFkProfessor(Integer fkProfessor);

    public Integer getFkDisciplina();

    public void setFkDisciplina(Integer fkDisciplina);

    /**
     *
     * @throws SQLException
     */
    public void insert() throws SQLException;

    public void update() throws SQLException;

    /**
     *
     * @param id
     * @throws SQLException
     */
    public void setById(Integer id) throws SQLException;

}
