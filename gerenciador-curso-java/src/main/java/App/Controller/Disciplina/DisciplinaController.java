package App.Controller.Disciplina;

import App.Model.Disciplina.Disciplina;
import App.Model.Disciplina.IDisciplina;
import java.sql.SQLException;
import java.util.ArrayList;

public class DisciplinaController {

    public boolean existeDisciplina(String codigo) throws SQLException {
        IDisciplina aluno = new Disciplina();
        return aluno.existe(codigo, "codigo");
    }

    public void add(String codigo, String conteudo, Double cargaHoraria, String tipo) throws SQLException {
        IDisciplina disciplina = new Disciplina();
        disciplina.setCargaHoraria(cargaHoraria);
        disciplina.setCodigo(codigo);
        disciplina.setConteudo(conteudo);
        disciplina.setTipo(tipo);
        disciplina.insert();
    }

    public void disciplinas() throws SQLException {
        IDisciplina d = new Disciplina();
        ArrayList<Disciplina> data = (ArrayList<Disciplina>) d.getAll();
        System.out.println("---------------- Lista de disciplinas ----------------");
        for (Disciplina disciplina : data) {
            System.out.println("ID: " + disciplina.getId()
                    + "   |  Código: " + disciplina.getCodigo()
                    + "   |  Conteúdo: " + disciplina.getConteudo()
                    + "   |  Carga horária: " + disciplina.getCargaHoraria()
                    + "   |  Tipo: " + disciplina.getTipo()
            );
            System.out.println("----------------------------------------"
                    + "----------------------------------------------"
                    + "-------------------------------------------------------");
        }
    }
}
