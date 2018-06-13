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

    /**
     * 
     * @param matricula
     * @param nome
     * @param endereco
     * @param telefone
     * @param valorHora 
     */
    public ProfessorController(String matricula, String nome, String endereco, String telefone, Double valorHora) {
        this.matricula = matricula;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.valorHora = valorHora;
    }

    public ProfessorController() {

    }

    /**
     * Envia os dados do professor para o model
     * 
     * @throws SQLException 
     */
    public void add() throws SQLException {
        IProfessor professor = new Professor(this.matricula, this.nome, this.endereco, this.telefone, this.valorHora);
        professor.insert();
    }

    /**
     * Adiciona uma disciplina em um professor específico (id).
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

    /**
     * Verifica se uma matricula do professor já existe
     * 
     * @param matricula
     * @return
     * @throws SQLException 
     */
    public static boolean existeMatricula(String matricula) throws SQLException {
        IProfessor professor = new Professor();
        return professor.existe(matricula, "matricula");
    }

    /**
     * Verifica se um professor específico já está cadastrado 
     * 
     * @param id
     * @return
     * @throws SQLException 
     */
    public boolean existeProfessor(String id) throws SQLException {
        IProfessor professor = new Professor();
        return professor.existe(id, "id");
    }

    /**
     * Verifica se uma disciplina específica já existe
     * 
     * @param id
     * @return
     * @throws SQLException 
     */
    public boolean existeDisciplina(String id) throws SQLException {
        IDisciplina disciplina = new Disciplina();
        return disciplina.existe(id, "id");
    }

    /**
     * Retorna uma string, com os codigos das disciplinas
     * 
     * @param disciplinas
     * @return 
     */
    public String listDisciplinasByProfessor(List<Disciplina> disciplinas) {
        String sDisciplinas = "";
        for (IDisciplina d : disciplinas) {
            sDisciplinas += d.getCodigo() + ", ";
        }
        return sDisciplinas;
    }

    /**
     * Retorna uma lista com todos os professores
     * 
     * @return
     * @throws SQLException 
     */
    public ArrayList<Professor> professores() throws SQLException {
        IProfessor p = new Professor();
        ArrayList<Professor> data = (ArrayList<Professor>) p.getAll();
        return data;
    }

    /**
     * Retorna uma lista com todas as disciplinas
     * 
     * @return
     * @throws SQLException 
     */
    public ArrayList<Disciplina> disciplinas() throws SQLException {
        IDisciplina d = new Disciplina();
        ArrayList<Disciplina> data = (ArrayList<Disciplina>) d.getAll();
        return data;
    }

    /**
     * Retorna uma lista com todas as disciplinas de um professor específico
     * 
     * @param idProfessor
     * @return
     * @throws SQLException 
     */
    public ArrayList<Disciplina> getDisciplinasByProfessor(int idProfessor) throws SQLException {
        IProfessor professor = new Professor();
        professor.setById(idProfessor);

        ArrayList<Disciplina> data = (ArrayList<Disciplina>) professor.getDisciplinas();

        return data;
    }

    /**
     * Exclui a disciplina de um professor específico, recebendo o id do registro da tabela 
     * professor_disciplinas
     * 
     * @param id
     * @throws SQLException 
     */
    public void excluir(int id) throws SQLException {
        IProfessorDisciplina pd = new ProfessorDisciplina();
        pd.removeById(id);
    }

    /**
     * Exclui um professor específico 
     * 
     * @param id
     * @return
     * @throws SQLException 
     */
    public String excluirProfessor(int id) throws SQLException {
        IProfessor p = new Professor();
        String msg = "";
        boolean existeProfessorDisciplina = p.existeByTabela(Integer.toString(id), "fkProfessor", "professor_disciplinas");
        boolean existeProfessorAula = p.existeByTabela(Integer.toString(id), "fkProfessor", "aula");
        if (existeProfessorDisciplina || existeProfessorAula) {
            msg = "Professor está vinculado a uma disciplina e/ou a alguma aula.";
        } else {
            msg = "Professor excluído com sucesso.";
            p.removeById(id);
        }
        return msg;
    }
}
