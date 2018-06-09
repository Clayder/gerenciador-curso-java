package App.View.Aluno;

import App.Controller.Aluno.AlunoController;
import App.Controller.Professor.ProfessorController;
import App.View.Menu;
import App.View.IView;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlunoView implements IView {

    @Override
    public void init() {
        Scanner teclado = new Scanner(System.in);
        System.out.println(" ****** 2.Aluno ****** ");
        System.out.println("1- Cadastrar");
        System.out.println("2- Listar");
        System.out.println("3- Editar");
        System.out.println("4- Voltar");
        int op2;
        op2 = Integer.parseInt(teclado.nextLine());
        AlunoController a = new AlunoController();
        switch (op2) {
            case 1:
                System.out.println("Cadastrar");
                System.out.println("Forneça a matrícula: ");
                String matricula = teclado.nextLine();
                 {
                    try {
                        while (AlunoController.existeMatricula(matricula)) {
                            System.out.println("A matrícula não pode ser repetida.");
                            System.out.println("Forneça a matrícula: ");
                            matricula = teclado.nextLine();
                        }
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                System.out.println("Forneça o nome: ");
                String nome = teclado.nextLine();
                System.out.println("Forneça o telefone: ");
                String telefone = teclado.nextLine();
                System.out.println("Forneça o e-mail: ");
                String email = teclado.nextLine();

                AlunoController aluno = new AlunoController(matricula, nome, telefone, email);
                 {
                    try {
                        aluno.add();
                    } catch (SQLException ex) {
                        Logger.getLogger(AlunoView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

            case 2:
                System.out.println("Listar");
                 {
                    try {
                        a.alunos();
                    } catch (SQLException ex) {
                        Logger.getLogger(AlunoView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

            case 3:
                System.out.println("Editar");
                 {
                    try {
                        a.alunos();
                        System.out.println("Forneça o id do aluno: ");
                        int id = Integer.parseInt(teclado.nextLine());
                        
                        System.out.println("Forneça o telefone: ");
                        String telefone2 = teclado.nextLine();
                        
                        System.out.println("Forneça o e-mail: ");
                        String email2 = teclado.nextLine();
                        
                        a.update(id, telefone2, email2);
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(AlunoView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

            default:
                Menu menu = new Menu();
                menu.init();
                break;
        }
    }
}
