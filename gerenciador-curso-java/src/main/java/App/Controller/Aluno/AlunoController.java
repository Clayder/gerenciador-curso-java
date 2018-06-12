
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
    
    public ArrayList<Aluno> getAll() throws SQLException {
        IAluno a = new Aluno();
        ArrayList<Aluno> data = (ArrayList<Aluno>) a.getAll();
        return data;
    }
    
    public void update(int id, String telefone, String email) throws SQLException{
        IAluno a = new Aluno();
        a.setById(id);
        a.setTelefone(telefone);
        a.setEmail(email);
        a.update();
    }
}
