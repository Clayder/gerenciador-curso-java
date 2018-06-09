package App.Model;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IModel {

    public int count() throws SQLException;

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

    public boolean existe(String valor, String campo) throws SQLException;

    public void setId(Integer id);

    public void insert() throws SQLException;

    public void update() throws SQLException;

    /**
     *
     * @param id
     * @throws SQLException
     */
    public void setById(Integer id) throws SQLException;
}
