package App.Controller.Professor;

import App.Model.Disciplina.Disciplina;
import App.Model.Disciplina.IDisciplina;
import App.Model.Professor.IProfessor;
import App.Model.Professor.Professor;
import App.Model.ProfessorDisciplina.IProfessorDisciplina;
import App.Model.ProfessorDisciplina.ProfessorDisciplina;
import java.sql.SQLException;
import java.util.ArrayList;

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
    public void addProfessorDisciplina(int idProfessor, int idDisciplina) throws SQLException {
        IProfessor professor = new Professor();
        professor.setById(idProfessor);

        IDisciplina disciplina = new Disciplina();
        disciplina.setById(idDisciplina);

        IProfessorDisciplina profDisc = new ProfessorDisciplina(idProfessor, idDisciplina);
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

    public void professores() throws SQLException {
        IProfessor p = new Professor();
        ArrayList<Professor> data = (ArrayList<Professor>) p.getAll();
        System.out.println("---------------- Lista de professores ----------------");
        for (Professor professor : data) {
            System.out.println(
                    "ID: " + professor.getId() + "   |   "
                    + "Matrícula: " + professor.getMatricula() + "   |   "
                    + "Nome: " + professor.getNome() + "   |   "
                    + "Endereço: " + professor.getEndereco() + "   |   "
                    + "Telefone: " + professor.getTelefone() + "   |   "
                    + "Valor Hora: " + professor.getValorHora()
            );
            System.out.println("Disciplinas: ");
            String disciplinas = "";
            for (Disciplina d : professor.getDisciplinas()) {
                disciplinas += d.getCodigo() + ", ";
            }
            System.out.println(disciplinas);
            System.out.println("----------------------------"
                    + "--------------------------------------------------"
                    + "------------------------------------------"
                    + "---------------------------------------"
                    + "--------------------------------");
        }
    }

    public void disciplinas() throws SQLException {
        IDisciplina d = new Disciplina();
        ArrayList<Disciplina> data = (ArrayList<Disciplina>) d.getAll();
        System.out.println("ID   |  Código  ");
        System.out.println("---------------- Lista de disciplinas ----------------");
        for (Disciplina disciplina : data) {
            System.out.println(disciplina.getId() + "   |   " + disciplina.getCodigo());
        }
    }
}
