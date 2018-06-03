package App.View.Aula;

import App.Controller.Aula.AulaController;
import App.View.Menu;
import App.View.IView;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AulaView implements IView {

    @Override
    public void init() {
        Scanner teclado = new Scanner(System.in);
        System.out.println(" ****** 3.Aula ****** ");
        System.out.println("3.1- Cadastrar");
        System.out.println("3.2- Listar");
        System.out.println("3.3- Pesquisar");
        int op2;
        op2 = Integer.parseInt(teclado.nextLine());
        switch (op2) {
            case 1:
                System.out.println("Cadastrar aula");

                 {
                    try {
                        AulaController.disciplinas();
                    } catch (SQLException ex) {
                        Logger.getLogger(AulaView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                System.out.println("Forneça id da disciplina: ");
                String idDisciplina = teclado.nextLine();

                 {
                    try {
                        while (!AulaController.existeDisciplina(idDisciplina)) {
                            System.err.println("Essa disciplina não existe.");
                            System.out.println("Forneça o id da disciplina: ");
                            idDisciplina = teclado.nextLine();
                        }
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                }

                 {
                    try {
                        AulaController.professores();
                    } catch (SQLException ex) {
                        Logger.getLogger(AulaView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                System.out.println("Forneça o id do professor: ");
                String idProfessor = teclado.nextLine();

                 {
                    try {
                        while (!AulaController.existeProfessor(idProfessor)) {
                            System.err.println("Esse professor não existe.");
                            System.out.println("Forneça o id do professor: ");
                            idProfessor = teclado.nextLine();
                        }
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                }

                System.out.println("Forneça a data: ");
                String data = teclado.nextLine();

                AulaController aula = new AulaController(Integer.parseInt(teclado.nextLine()), Integer.parseInt(idDisciplina), data);

                 {
                    try {
                        aula.addAula();
                    } catch (SQLException ex) {
                        Logger.getLogger(AulaView.class.getName()).log(Level.SEVERE, null, ex);
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
