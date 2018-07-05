package App.Model.Aluno;

import java.sql.SQLException;

public class Aluno extends AlunoDAO implements IAluno {

    public Aluno() throws SQLException {
        super();
    }
    
    /**
     * 
     * @param matricula
     * @param nome
     * @param telefone
     * @param email
     * @throws SQLException 
     */
    public Aluno(String matricula, String nome, String telefone, String email) throws SQLException {
        super(matricula, nome, telefone, email);
    }

}
