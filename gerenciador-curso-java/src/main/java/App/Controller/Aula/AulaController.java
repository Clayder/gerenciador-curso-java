package App.Controller.Aula;

import App.Model.Aula.Aula;
import App.Model.Aula.IAula;
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
    
    public static boolean existeProfessor(String id) throws SQLException{
        IProfessor professor = new Professor();
        return professor.existe(id, "id");
    }
    
    public static boolean existeDisciplina(String id) throws SQLException{
        IDisciplina disciplina = new Disciplina();
        return disciplina.existe(id, "id");
    }

    public void addAula() throws SQLException {
        IProfessor professor = new Professor();
        professor.setById(idProfessor);

        IDisciplina disciplina = new Disciplina();
        disciplina.setById(idDisciplina);

        IAula aula = new Aula(professor, disciplina);
        aula.setData(data);
        aula.insert();

        System.out.println("Cadastrado a disciplina " + disciplina.getCodigo() + " para o professor " + professor.getNome());
    }

    public static void professores() throws SQLException {
        IProfessor p = new Professor();
        ArrayList<Professor> data = (ArrayList<Professor>) p.getAll();
        System.out.println("---------------- Lista de professores ----------------");
        for (Professor professor : data) {
            System.out.println("---------------------------------------------------");
            System.out.println("Id: " + professor.getId() + "Nome: " + professor.getNome());
            System.out.println("---------------------------------------------------");
        }
    }
    
    public static void disciplinas() throws SQLException {
        IDisciplina d = new Disciplina();
        ArrayList<Disciplina> data = (ArrayList<Disciplina>) d.getAll();
        System.out.println("---------------- Lista de disciplinas ----------------");
        System.out.println("ID   |  Codigo  ");
        for (Disciplina disciplina : data) {
            System.out.println(disciplina.getId() + "   |  " + disciplina.getCodigo()+"  ");
        }
         
    }
}
