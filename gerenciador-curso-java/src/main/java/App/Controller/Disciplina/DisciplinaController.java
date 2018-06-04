package App.Controller.Disciplina;

import App.Model.Disciplina.Disciplina;
import App.Model.Disciplina.IDisciplina;
import java.sql.SQLException;

public class DisciplinaController {

    public boolean existeDisciplina(String codigo) throws SQLException {
        IDisciplina aluno = new Disciplina();
        return aluno.existe(codigo, "codigo");
    }
    
    public void add(String codigo, String conteudo, Double cargaHoraria, String tipo) throws SQLException{
        IDisciplina disciplina = new Disciplina();
        disciplina.setCargaHoraria(cargaHoraria);
        disciplina.setCodigo(codigo);
        disciplina.setConteudo(conteudo);
        disciplina.setTipo(tipo);
        disciplina.insert();
    }
}
