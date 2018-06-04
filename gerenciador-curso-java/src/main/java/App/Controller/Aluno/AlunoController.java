
package App.Controller.Aluno;

import App.Model.Aluno.Aluno;
import App.Model.Aluno.IAluno;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlunoController {
    private String matricula;
    private String nome;
    private String telefone;
    private String email;

    public AlunoController(String matricula, String nome, String telefone, String email) {
        this.matricula = matricula;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }
    
    public AlunoController() {

    }
    
    public void add() throws SQLException{
        IAluno aluno = new Aluno(this.matricula, this.nome, this.telefone, this.email);
        aluno.insert();
    }
    
    public static boolean existeMatricula(String matricula) throws SQLException{
        IAluno aluno = new Aluno();
        return aluno.existe(matricula, "matricula");
    }
    
    public void alunos() throws SQLException {
        IAluno a = new Aluno();
        System.out.println("---------------- Lista de alunos ----------------");
        ArrayList<Aluno> data = (ArrayList<Aluno>) a.getAll();
        System.out.println("ID"+tab()+"Matrícula"+tab()+"Nome"+tab()+"Telefone"+tab()+"Email");
        for (Aluno aluno : data) {
            System.out.println(aluno.getId() + tab() + aluno.getMatricula() + tab() + aluno.getNome()+ tab() + aluno.getTelefone()+ tab() + aluno.getEmail());
        }
    }
    
    public String tab(){
        return "\t\t\t|\t\t\t";
    }
}
