package App.View.Aula;

import App.Controller.Aula.AulaController;
import App.View.Menu;
import App.View.IView;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AulaTView implements IView {

    @Override
    public void init() {
        Scanner teclado = new Scanner(System.in);
        System.out.println(" ****** 3.Aula ****** ");
        System.out.println("1- Cadastrar Aula");
        System.out.println("2- Cadastrar alunos em uma aula");
        System.out.println("3- Listar");
        System.out.println("4- Voltar");
        int op2;
        op2 = Integer.parseInt(teclado.nextLine());
        AulaController aula = new AulaController();
        switch (op2) {
            case 1:
                System.out.println("Cadastrar aula");

                System.out.println("Forneça a data: ");
                String data = teclado.nextLine();
                 {
                    try {
                        aula.disciplinas();
                    } catch (SQLException ex) {
                        Logger.getLogger(AulaTView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                System.out.println("Forneça id da disciplina: ");
                String idDisciplina = teclado.nextLine();

                 {
                    try {
                        while (!aula.existeDisciplina(idDisciplina)) {
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
                        aula.professores();
                    } catch (SQLException ex) {
                        Logger.getLogger(AulaTView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                System.out.println("Forneça o id do professor: ");
                String idProfessor = teclado.nextLine();

                 {
                    try {
                        while (!aula.existeProfessor(idProfessor)) {
                            System.err.println("Esse professor não existe.");
                            System.out.println("Forneça o id do professor: ");
                            idProfessor = teclado.nextLine();
                        }
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                 {
                    try {
                        aula.addAula(Integer.parseInt(idProfessor), Integer.parseInt(idDisciplina), data);
                    } catch (SQLException ex) {
                        Logger.getLogger(AulaTView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                break;

            case 2:
                System.out.println("Cadastrar alunos em aula");

                 {
                    try {
                        aula.aulas();
                    } catch (SQLException ex) {
                        Logger.getLogger(AulaTView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                System.out.println("Forneça o id da aula: ");
                String idAula = teclado.nextLine();
                 {
                    try {
                        while (!aula.existeAula(idAula)) {
                            System.err.println("Essa aula não existe.");
                            System.out.println("Forneça o id da aula: ");
                            idAula = teclado.nextLine();
                        }
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                }

                 {
                    try {
                        aula.alunos();
                    } catch (SQLException ex) {
                        Logger.getLogger(AulaTView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                System.out.println("Forneça o id do aluno: ");
                String idAluno = teclado.nextLine();

                 {
                    try {
                        while (!aula.existeAluno(idAluno)) {
                            System.err.println("Esse aluno não existe.");
                            System.out.println("Forneça o id do aluno: ");
                            idAluno = teclado.nextLine();
                        }
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                 {
                    try {
                        aula.addAlunoAula(Integer.parseInt(idAluno), Integer.parseInt(idAula));
                    } catch (SQLException ex) {
                        Logger.getLogger(AulaTView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                System.out.println(" Cadastro realizado. ");
                break;
            case 3: {
                try {
                    aula.aulas();
                } catch (SQLException ex) {
                    Logger.getLogger(AulaTView.class.getName()).log(Level.SEVERE, null, ex);
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
