
import App.Logg.Logg;
import App.View.IView;
import App.View.Menu;
import java.sql.SQLException;

public class Main {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        Logg.init();
        
        IView menu = new Menu();
        menu.init();
    }
}
