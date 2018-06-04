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
        System.out.println("1.2- Atribuir disciplina para um professor");
        System.out.println("1.3- Listar");
        System.out.println("1.3- Pesquisar");
        int op2;
        op2 = Integer.parseInt(teclado.nextLine());
        ProfessorController prof = new ProfessorController();
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
            case 2: {
                try {
                    prof.professores();
                } catch (SQLException ex) {
                    Logger.getLogger(ProfessorView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Forneça o id do professor: ");
            String idProfessor = teclado.nextLine();

             {
                try {
                    while (!prof.existeProfessor(idProfessor)) {
                        System.err.println("Professor não cadastrado.");
                        System.out.println("Forneça o id do professor: ");
                        idProfessor = teclado.nextLine();
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }

             {
                try {
                    prof.disciplinas();
                } catch (SQLException ex) {
                    Logger.getLogger(ProfessorView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            System.out.println("Forneça o id da disciplina: ");
            String idDisciplina = teclado.nextLine();
             {
                try {
                    while (!prof.existeDisciplina(idDisciplina)) {
                        System.err.println("Disciplina não cadastrada.");
                        System.out.println("Forneça o id da disciplina: ");
                        idDisciplina = teclado.nextLine();
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }

             {
                try {
                    prof.addProfessorDisciplina(Integer.parseInt(idProfessor), Integer.parseInt(idDisciplina));
                } catch (SQLException ex) {
                    Logger.getLogger(ProfessorView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 3:
                 {
                    try {
                        prof.professores();
                    } catch (SQLException ex) {
                        Logger.getLogger(ProfessorView.class.getName()).log(Level.SEVERE, null, ex);
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
