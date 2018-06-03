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

public class AulaController {

    private Integer idProfessor;
    private Integer idDisciplina;
    private String data;

    public AulaController(Integer idProfessor, Integer idDisciplina, String data) {
        this.idProfessor = idProfessor;
        this.idDisciplina = idDisciplina;
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

    public void addAula(Integer idProfessor, Integer idDisciplina, String data) throws SQLException {

        this.idProfessor = idProfessor;
        this.idDisciplina = idDisciplina;
        this.data = data;

        IProfessor professor = new Professor();
        professor.setById(idProfessor);

        IDisciplina disciplina = new Disciplina();
        disciplina.setById(idDisciplina);

        IAula aula = new Aula(professor, disciplina);
        aula.setData(data);
        aula.insert();

        System.out.println("Cadastrado a disciplina " + disciplina.getCodigo() + " para o professor " + professor.getNome());
    }

    public void professores() throws SQLException {
        IProfessor p = new Professor();
        ArrayList<Professor> data = (ArrayList<Professor>) p.getAll();
        System.out.println("---------------- Lista de professores ----------------");
        for (Professor professor : data) {
            System.out.println("---------------------------------------------------");
            System.out.println("Id: " + professor.getId() + "Nome: " + professor.getNome());
            System.out.println("---------------------------------------------------");
        }
    }

    public void disciplinas() throws SQLException {
        IDisciplina d = new Disciplina();
        ArrayList<Disciplina> data = (ArrayList<Disciplina>) d.getAll();
        System.out.println("---------------- Lista de disciplinas ----------------");
        System.out.println("ID   |  Codigo  ");
        for (Disciplina disciplina : data) {
            System.out.println(disciplina.getId() + "   |  " + disciplina.getCodigo() + "  ");
        }
    }

    public void aulas() throws SQLException {
        IAula aulas = new Aula();
        ArrayList<Aula> data = (ArrayList<Aula>) aulas.getAll();
        System.out.println("---------------- Lista de aulas ----------------");
        System.out.println("ID   |  Codigo disciplina  ");
        for (Aula aula : data) {
            System.out.println(aula.getId() + "   |  " + aula.getDisciplina().getCodigo() + "  ");
        }
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
    
    public void addAlunoAula(Integer fkAluno, Integer fkAula) throws SQLException{
        IAulaAluno aulaAluno = new AulaAluno(fkAluno, fkAula);
        aulaAluno.insert();
    }
}
