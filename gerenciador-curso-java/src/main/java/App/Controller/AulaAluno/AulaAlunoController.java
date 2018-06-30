package App.Controller.AulaAluno;

import App.Model.AulaAluno.AulaAluno;
import App.Model.AulaAluno.IAulaAluno;
import java.sql.SQLException;

public class AulaAlunoController {

    /**
     * Exclui um registro específico, verificando se ele realmente pode ser
     * excluído.
     *
     * Se o aluno estiver vinculado a uma aula, retorna falso.
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public String excluir(int idAula, int idAluno) throws SQLException {
        String msg = "Aluno excluído com sucesso.";
        IAulaAluno a = new AulaAluno();
        a.excluir(idAula, idAluno);
        return msg;
    }
}
