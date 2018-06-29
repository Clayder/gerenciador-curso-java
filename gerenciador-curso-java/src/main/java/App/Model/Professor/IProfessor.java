package App.Model.Professor;

import App.Model.Disciplina.Disciplina;
import App.Model.IModel;
import java.sql.SQLException;
import java.util.List;

public interface IProfessor extends IModel {

    public Integer getId();

    public String getMatricula();

    public String getNome();

    public String getEndereco();

    public String getTelefone();

    public double getValorHora();

    public void setMatricula(String matricula);

    public void setNome(String nome);

    public void setEndereco(String endereco);

    public void setTelefone(String telefone);

    public void setValorHora(double valorHora);

    public void setId(Integer id);
    
    public void setByMatricula(String matricula) throws SQLException;
    
    public List<Disciplina> getDisciplinas() throws SQLException;

    /**
     *
     * @return @throws SQLException
     */
    public List<Professor> getAll() throws SQLException;

}
