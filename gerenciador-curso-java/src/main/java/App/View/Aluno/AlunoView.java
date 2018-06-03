package App.View.Aluno;

import App.Controller.Aluno.AlunoController;
import App.Controller.Professor.ProfessorController;
import App.View.Menu;
import App.View.IView;
import java.sql.SQLException;
import java.util.Scanner;

public class AlunoView implements IView {

    @Override
    public void init() {
        Scanner teclado = new Scanner(System.in);
        System.out.println(" ****** 2.Aluno ****** ");
        System.out.println("2.1- Cadastrar");
        System.out.println("2.2- Listar");
        System.out.println("2.3- Pesquisar");
        int op2;
        op2 = Integer.parseInt(teclado.nextLine());
        switch (op2) {
            case 1:
                System.out.println("Cadastrar");
                System.out.println("Forneça a matrícula: ");
                String matricula = teclado.nextLine();
                 {
                    try {
                        while (AlunoController.existeMatricula(matricula)) {
                            System.err.println("A matrícula não pode ser repetida.");
                            System.out.println("Forneça a matrícula: ");
                            matricula = teclado.nextLine();
                        }
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                break;
            case 2:
                System.out.println("Listar");
                break;
            case 3:
                System.out.println("Pesquisar");
                break;
            default:
                Menu menu = new Menu();
                menu.init();
                break;
        }
    }
}
