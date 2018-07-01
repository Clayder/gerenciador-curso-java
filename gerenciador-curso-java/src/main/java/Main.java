
import App.View.Professor.ProfessorView;
import java.sql.SQLException;

public class Main {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        ProfessorView p = new ProfessorView();
        p.setVisible(true);
    }
}
