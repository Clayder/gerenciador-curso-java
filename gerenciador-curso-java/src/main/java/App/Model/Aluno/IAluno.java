package App.Model.Aluno;

import App.Model.IModel;
import java.sql.SQLException;
import java.util.List;

public interface IAluno extends IModel {

    public Integer getId();

    public String getMatricula();

    public String getNome();

    public String getEmail();

    public String getTelefone();

    public void setMatricula(String matricula);

    public void setNome(String nome);

    public void setEmail(String endereco);

    public void setTelefone(String telefone);

    /**
     *
     * @return @throws SQLException
     */
    public List<Aluno> getAll() throws SQLException;

}
