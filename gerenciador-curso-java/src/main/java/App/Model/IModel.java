package App.Model;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IModel {

    /**
     * 
     * @return
     * @throws SQLException 
     */
    public int count() throws SQLException;

    /**
     *
     * @return @throws SQLException
     */
    public ResultSet findAll() throws SQLException;
    
    public boolean existeByTabela(String valor, String campo, String tabela) throws SQLException;

    /**
     *
     * @param id
     * @throws SQLException
     */
    public void removeById(Integer id) throws SQLException;

    /**
     * 
     * @param valor
     * @param campo
     * @return
     * @throws SQLException 
     */
    public boolean existe(String valor, String campo) throws SQLException;

    /**
     * Método utilizado para popular um objeto ( atributos de uma classe )
     * 
     * @param id 
     */
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
