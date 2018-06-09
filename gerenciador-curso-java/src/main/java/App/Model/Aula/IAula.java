package App.Model.Aula;

import App.Model.Aluno.Aluno;
import App.Model.Disciplina.IDisciplina;
import App.Model.IModel;
import App.Model.Professor.IProfessor;
import java.sql.SQLException;
import java.util.List;

public interface IAula extends IModel {

    public Integer getId();

    public IDisciplina getDisciplina();

    public IProfessor getProfessor();

    public String getData();

    public void setData(String data);

    public List<Aluno> getAlunos() throws SQLException;

    /**
     *
     * @return @throws SQLException
     */
    public List<Aula> getAll() throws SQLException;

    public void setDisciplina(IDisciplina disciplina);

    public void setProfessor(IProfessor professor);

}
