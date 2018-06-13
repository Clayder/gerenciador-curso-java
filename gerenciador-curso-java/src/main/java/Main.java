
import App.Logg.Logg;
import App.View.IView;
import App.View.Menu;
import App.View.Professor.ProfessorView;
import App.View.Aluno.AlunoView;
import App.View.Disciplina.DisciplinaView;
import App.View.ProfessorDisciplina.ProfessorDisciplinaView;
import java.sql.SQLException;

public class Main {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
//        Logg.init();
//        
//        IView menu = new Menu();
//        menu.init();

        ProfessorView p = new ProfessorView();
        p.setVisible(true);
//        AlunoView a = new AlunoView();
//        a.setVisible(true);
//        ProfessorDisciplinaView pd = new ProfessorDisciplinaView();
//        pd.setVisible(true);
        
    }
}
