package App.Model.Aluno;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IAluno {

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

    public String getMatricula();

    public String getNome();

    public String getEmail();

    public String getTelefone();
    
    public boolean existe(String valor, String campo) throws SQLException;

    public void setMatricula(String matricula);

    public void setNome(String nome);

    public void setEmail(String endereco);

    public void setTelefone(String telefone);

    public void setId(Integer id);

    public void insert() throws SQLException;

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
    public List<Aluno> getAll() throws SQLException;

}
