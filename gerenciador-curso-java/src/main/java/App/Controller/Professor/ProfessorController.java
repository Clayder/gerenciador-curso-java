package App.Controller.Professor;

import App.Model.Disciplina.Disciplina;
import App.Model.Disciplina.IDisciplina;
import App.Model.Professor.IProfessor;
import App.Model.Professor.Professor;
import App.Model.ProfessorDisciplina.IProfessorDisciplina;
import App.Model.ProfessorDisciplina.ProfessorDisciplina;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorController {

    private String matricula;
    private String nome;
    private String endereco;
    private String telefone;
    private Double valorHora;

    public ProfessorController(String matricula, String nome, String endereco, String telefone, Double valorHora) {
        this.matricula = matricula;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.valorHora = valorHora;
    }

    public ProfessorController() {

    }

    public void add() throws SQLException {
        IProfessor professor = new Professor(this.matricula, this.nome, this.endereco, this.telefone, this.valorHora);
        professor.insert();
    }

    /**
     *
     * @param idProfessor
     * @param idDisciplina
     * @throws SQLException
     */
    public void addProfessorDisciplinaByCodigo(int idProfessor, String codigoDisciplina) throws SQLException {
        IProfessor professor = new Professor();
        professor.setById(idProfessor);

        IDisciplina disciplina = new Disciplina();
        disciplina.setByCodigo(codigoDisciplina);

        IProfessorDisciplina profDisc = new ProfessorDisciplina(idProfessor, disciplina.getId());
        profDisc.insert();

    }

    public static boolean existeMatricula(String matricula) throws SQLException {
        IProfessor professor = new Professor();
        return professor.existe(matricula, "matricula");
    }

    public boolean existeProfessor(String id) throws SQLException {
        IProfessor professor = new Professor();
        return professor.existe(id, "id");
    }

    public boolean existeDisciplina(String id) throws SQLException {
        IDisciplina disciplina = new Disciplina();
        return disciplina.existe(id, "id");
    }

    public String listDisciplinasByProfessor(List<Disciplina> disciplinas) {
        String sDisciplinas = "";
        for (IDisciplina d : disciplinas) {
            sDisciplinas += d.getCodigo() + ", ";
        }
        return sDisciplinas;
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
    
    public ArrayList<Disciplina> getDisciplinasByProfessor(int idProfessor) throws SQLException {
        IProfessor professor = new Professor();
        professor.setById(idProfessor);
        
        ArrayList<Disciplina> data = (ArrayList<Disciplina>) professor.getDisciplinas();
        
        return data;
    }
}
