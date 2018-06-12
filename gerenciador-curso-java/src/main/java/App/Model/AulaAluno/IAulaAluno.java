package App.Model.AulaAluno;

import App.Model.IModel;

public interface IAulaAluno extends IModel {

    public Integer getId();

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
