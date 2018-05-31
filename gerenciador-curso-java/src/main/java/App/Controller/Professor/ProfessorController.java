package App.Controller.Professor;

import App.Model.Professor.IProfessor;
import App.Model.Professor.Professor;
import java.sql.SQLException;

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
    
    public void add() throws SQLException{
        IProfessor professor = new Professor(this.matricula, this.nome, this.endereco, this.telefone, this.valorHora);
        professor.insert();
    }
    
    public static boolean existeMatricula(String matricula) throws SQLException{
        IProfessor professor = new Professor();
        return professor.existeMatricula(matricula);
    }
}
