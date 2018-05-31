package App.Model.Professor;

import java.sql.SQLException;

public class Professor extends ProfessorDAO implements IProfessor {

    public Professor() throws SQLException {
        super();
    }

    /**
     * 
     * @param matricula
     * @param nome
     * @param endereco
     * @param telefone
     * @param valorHora
     * @throws SQLException 
     */
    public Professor(String matricula, String nome, String endereco, String telefone, double valorHora) throws SQLException {
        super(matricula, nome, endereco, telefone, valorHora);
    }
}
