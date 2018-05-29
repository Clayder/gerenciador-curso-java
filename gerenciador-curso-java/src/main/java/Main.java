
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/App/View/Professor/Cadastrar.fxml"));

        Scene scene = new Scene(root);
        
        /**
         * abre a tela maximizada
         */
        stage.centerOnScreen();
        stage.setHeight(650);
        stage.setWidth(800);
        
        stage.setTitle("Cadastro de professores");
        
        

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
