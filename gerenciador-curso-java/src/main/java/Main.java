
import App.View.Professor.ProfessorView;
import java.sql.SQLException;

public class Main {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        /**
         * Inicializa a tela inicial
         */
        ProfessorView p = new ProfessorView();
        p.setVisible(true);
    }
}
