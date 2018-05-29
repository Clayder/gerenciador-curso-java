package App.Controller.Professor;

import App.Model.Professor.IProfessor;
import App.Model.Professor.Professor;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;

public class CadastrarController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField inputNome;

    @FXML
    private Button btnAddProfessor;

    @FXML
    private TextField inputValorHora;

    @FXML
    private TextField inputEndereco;

    @FXML
    private TextField inputMatricula;

    @FXML
    private TextField inputTelefone;

    @FXML
    private TextField inputDisciplinas;

    @FXML
    void buttonCadastrar(ActionEvent event) throws SQLException {
        IProfessor professor = new Professor();
        professor.setEndereco(inputEndereco.getText());
        professor.setMatricula(inputMatricula.getText());
        professor.setTelefone(inputTelefone.getText());
        professor.setNome(inputNome.getText());
        String valorHora = inputValorHora.getText();
        professor.setValorHora(Double.parseDouble(valorHora));
        professor.insert();
    }
    
    @FXML
    void existeMatricula(InputMethodEvent event) {
        System.out.println(event.getEventType());
    }

    @FXML
    void initialize() {
        assert inputNome != null : "fx:id=\"inputNome\" was not injected: check your FXML file 'Cadastrar.fxml'.";
        assert btnAddProfessor != null : "fx:id=\"btnAddProfessor\" was not injected: check your FXML file 'Cadastrar.fxml'.";
        assert inputValorHora != null : "fx:id=\"inputValorHora\" was not injected: check your FXML file 'Cadastrar.fxml'.";
        assert inputEndereco != null : "fx:id=\"inputEndereco\" was not injected: check your FXML file 'Cadastrar.fxml'.";
        assert inputMatricula != null : "fx:id=\"inputMatricula\" was not injected: check your FXML file 'Cadastrar.fxml'.";
        assert inputTelefone != null : "fx:id=\"inputTelefone\" was not injected: check your FXML file 'Cadastrar.fxml'.";
        assert inputDisciplinas != null : "fx:id=\"inputDisciplinas\" was not injected: check your FXML file 'Cadastrar.fxml'.";
    
    }
}
