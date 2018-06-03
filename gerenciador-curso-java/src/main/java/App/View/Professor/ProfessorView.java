package App.View.Professor;

import App.Controller.Professor.ProfessorController;
import App.View.Menu;
import App.View.IView;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProfessorView implements IView {

    @Override
    public void init() {
        Scanner teclado = new Scanner(System.in);
        System.out.println(" ****** 1.Professor ****** ");
        System.out.println("1.1- Cadastrar");
        System.out.println("1.2- Listar");
        System.out.println("1.3- Pesquisar");
        int op2;
        op2 = Integer.parseInt(teclado.nextLine());
        switch (op2) {
            case 1:

                System.out.println("Cadastrar");
                System.out.println("Forneça a matrícula: ");
                String matricula = teclado.nextLine();
                 {
                    try {
                        while (ProfessorController.existeMatricula(matricula)) {
                            System.err.println("A matrícula não pode ser repetida.");
                            System.out.println("Forneça a matrícula: ");
                            matricula = teclado.nextLine();
                        }
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                System.out.println("Forneça o nome: ");
                String nome = teclado.nextLine();
                System.out.println("Forneça o endereço: ");
                String endereco = teclado.nextLine();
                System.out.println("Forneça o valor hora: ");
                Double valorHora = Double.parseDouble(teclado.nextLine());
                System.out.println("Forneça o telefone: ");
                String telefone = teclado.nextLine();
                ProfessorController professor = new ProfessorController(matricula, nome, endereco, telefone, valorHora);
                 {
                    try {
                        professor.add();
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
