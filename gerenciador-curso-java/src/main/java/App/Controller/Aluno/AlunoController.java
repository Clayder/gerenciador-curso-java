
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

    /**
     * 
     * @param matricula
     * @param nome
     * @param telefone
     * @param email 
     */
    public AlunoController(String matricula, String nome, String telefone, String email) {
        this.matricula = matricula;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }
    
    public AlunoController() {

    }
    
    /**
     * Acessa o model aluno, para realizar a inserção no banco de dados.
     * 
     * @throws SQLException 
     */
    public void add() throws SQLException{
        IAluno aluno = new Aluno(this.matricula, this.nome, this.telefone, this.email);
        aluno.insert();
    }
    
    /**
     * Verifica se uma matrícula específica existe.
     * 
     * @param matricula
     * @return
     * @throws SQLException 
     */
    public static boolean existeMatricula(String matricula) throws SQLException{
        IAluno aluno = new Aluno();
        return aluno.existe(matricula, "matricula");
    }
    
    /**
     * Retorna uma lista com os dados de todos os alunos
     * 
     * @return
     * @throws SQLException 
     */
    public ArrayList<Aluno> getAll() throws SQLException {
        IAluno a = new Aluno();
        ArrayList<Aluno> data = (ArrayList<Aluno>) a.getAll();
        return data;
    }
    
    /**
     * Atualiza um registro específico
     * 
     * @param id
     * @param telefone
     * @param email
     * @throws SQLException 
     */
    public void update(int id, String telefone, String email) throws SQLException{
        IAluno a = new Aluno();
        a.setById(id);
        a.setTelefone(telefone);
        a.setEmail(email);
        a.update();
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
        IAluno a = new Aluno();
        String msg = "";
        boolean existeAulaAluno = a.existeByTabela(Integer.toString(id), "fkAluno", "aula_aluno");
        if(existeAulaAluno){
            msg = "O aluno está vinculado a uma aula.";
        }else{
            msg = "Aluno excluído com sucesso.";
            a.removeById(id);
        }
        return msg;
    }
}
