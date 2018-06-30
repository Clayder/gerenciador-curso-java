package App.Controller.Aula;

import App.Model.Aluno.Aluno;
import App.Model.Aluno.IAluno;
import App.Model.Aula.Aula;
import App.Model.Aula.IAula;
import App.Model.AulaAluno.AulaAluno;
import App.Model.AulaAluno.IAulaAluno;
import App.Model.Disciplina.Disciplina;
import App.Model.Disciplina.IDisciplina;
import App.Model.Professor.IProfessor;
import App.Model.Professor.Professor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AulaController {

    private String matriculaProfessor;
    private String codDisciplina;
    private String data;

    public AulaController(String matriculaProfessor, String codDisciplina, String data) {
        this.matriculaProfessor = matriculaProfessor;
        this.codDisciplina = codDisciplina;
        this.data = data;
    }

    public AulaController() {

    }

    public boolean existeProfessor(String id) throws SQLException {
        IProfessor professor = new Professor();
        return professor.existe(id, "id");
    }
    
    public boolean existeAula(String id) throws SQLException {
        IAula aula = new Aula();
        return aula.existe(id, "id");
    }
    
     public boolean existeAluno(String id) throws SQLException {
        IAluno aluno = new Aluno();
        return aluno.existe(id, "id");
    }

    public boolean existeDisciplina(String id) throws SQLException {
        IDisciplina disciplina = new Disciplina();
        return disciplina.existe(id, "id");
    }

    public void addAula() throws SQLException {

        IProfessor professor = new Professor();
        professor.setByMatricula(matriculaProfessor);

        IDisciplina disciplina = new Disciplina();
        disciplina.setByCodigo(codDisciplina);

        IAula aula = new Aula(professor, disciplina);
        aula.setData(data);
        aula.insert();

        System.out.println("Cadastrado a disciplina " + disciplina.getCodigo() + " para o professor " + professor.getNome());
    }

    public ArrayList<Professor> professores() throws SQLException {
        IProfessor p = new Professor();
        ArrayList<Professor> data = (ArrayList<Professor>) p.getAll();
        return data;
    }

    public ArrayList<Disciplina> disciplinas() throws SQLException {
        IDisciplina d = new Disciplina();
        ArrayList<Disciplina> data = (ArrayList<Disciplina>) d.getAll();
        return data;
    }

    public ArrayList<Aula> aulas() throws SQLException {
        IAula aulas = new Aula();
        ArrayList<Aula> data = (ArrayList<Aula>) aulas.getAll();
        return data;
    }

    public void alunos() throws SQLException {
        IAluno alunos = new Aluno();
        ArrayList<Aluno> data = (ArrayList<Aluno>) alunos.getAll();
        System.out.println("---------------- Lista de aulas ----------------");
        System.out.println("ID   |  Codigo disciplina  ");
        for (Aluno aluno : data) {
            System.out.println(aluno.getId() + "   |  " + aluno.getNome() + "  ");
        }
    }
    
    public List<Aluno> getAlunosByAula(int aulaId) throws SQLException {
        IAula aula = new Aula();
        aula.setById(aulaId);
        return aula.getAlunos();
    }
    
    public void addAlunoAula(Integer fkAula, String matricula) throws SQLException{
        IAluno aluno = new Aluno();
        aluno.setByMatricula(matricula);
        IAulaAluno aulaAluno = new AulaAluno(aluno.getId(), fkAula);
        aulaAluno.insert();
    }
    
    /**
     * Exclui um registro específico, verificando se ele realmente pode ser excluído.
     * 
     * Se o aluno estiver vinculado a uma aula, retorna falso.
     * 
     * @param id
     * @return
     * @throws SQLException 
     */
     public String excluir(int id) throws SQLException {
        IAula a = new Aula();
        String msg = "";
        boolean existeAulaAluno = a.existeByTabela(Integer.toString(id), "fkAula", "aula_aluno");
        if(existeAulaAluno){
            msg = "A aula está vinculada a um aluno.";
        }else{
            msg = "Aula excluída com sucesso.";
            a.removeById(id);
        }
        return msg;
    }
}
