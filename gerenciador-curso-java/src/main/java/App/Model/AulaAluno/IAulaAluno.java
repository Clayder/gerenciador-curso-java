package App.Model.AulaAluno;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IAulaAluno {
     /**
     * 
     * @return @throws SQLException
     */
    public ResultSet findAll() throws SQLException;
    
    public boolean existe(String valor, String campo) throws SQLException;

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
    public void setId(Integer id) ;

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
    public Integer getFkAula() ;

    /**
     * 
     * @param fkAula 
     */
    public void setFkAula(Integer fkAula);

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
    
}
