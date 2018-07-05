package App.Model.ProfessorDisciplina;

import App.Model.IModel;

public interface IProfessorDisciplina extends IModel {

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

}
