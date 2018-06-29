package App.Controller.Disciplina;

import App.Model.Disciplina.Disciplina;
import App.Model.Disciplina.IDisciplina;
import java.sql.SQLException;
import java.util.ArrayList;

public class DisciplinaController {

    /**
     * Verifica se uma disciplina existe.
     * 
     * @param codigo
     * @return
     * @throws SQLException 
     */
    public static boolean existeDisciplina(String codigo) throws SQLException {
        IDisciplina aluno = new Disciplina();
        return aluno.existe(codigo, "codigo");
    }

    /**
     * Envia para o model os dados da disciplina.
     * 
     * @param codigo
     * @param conteudo
     * @param cargaHoraria
     * @param tipo
     * @throws SQLException 
     */
    public void add(String codigo, String conteudo, Double cargaHoraria, String tipo) throws SQLException {
        IDisciplina disciplina = new Disciplina();
        disciplina.setCargaHoraria(cargaHoraria);
        disciplina.setCodigo(codigo);
        disciplina.setConteudo(conteudo);
        disciplina.setTipo(tipo);
        disciplina.insert();
    }

    /**
     * Retorna uma lista com os dados de todos as disciplinas
     * 
     * @return
     * @throws SQLException 
     */
    public ArrayList<Disciplina> getAll() throws SQLException {
        IDisciplina d = new Disciplina();
        ArrayList<Disciplina> data = (ArrayList<Disciplina>) d.getAll();
        return data;
    }
    
    /**
     * Exclui a disciplina 
     * 
     * Se a disciplina estiver vinculado com um professor e/ou aula, retorna falso. 
     * 
     * @param id
     * @return
     * @throws SQLException 
     */
    public String excluir(int id) throws SQLException {
        IDisciplina d = new Disciplina();
        String msg = "";
        boolean existeProfessorDisciplina = d.existeByTabela(Integer.toString(id), "fkDisciplina", "professor_disciplinas");
        boolean existeProfessorAula = d.existeByTabela(Integer.toString(id), "fkDisciplina", "aula");
        if(existeProfessorDisciplina || existeProfessorAula){
            msg = "Disciplina está vinculada a um professor e/ou a alguma aula.";
        }else{
            msg = "Disciplina excluída com sucesso.";
            d.removeById(id);
        }
        return msg;
    }
}
