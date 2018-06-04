package App.View.Disciplina;

import App.Controller.Disciplina.DisciplinaController;
import App.View.Menu;
import App.View.IView;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DisciplinaView implements IView {

    @Override
    public void init() {
        Scanner teclado = new Scanner(System.in);
        System.out.println(" ****** 4.Disciplina ****** ");
        System.out.println("4.1- Cadastrar");
        System.out.println("4.2- Listar");
        int op2;
        op2 = Integer.parseInt(teclado.nextLine());
        DisciplinaController disciplina = new DisciplinaController();
        switch (op2) {
            case 1:
                System.out.println("Cadastrar");

                System.out.println("Forneça o código: ");
                String codigo = teclado.nextLine();
                 {
                    try {
                        while (disciplina.existeDisciplina(codigo)) {
                            System.out.println("O código não pode ser repetido.");
                            System.out.println("Forneça o código: ");
                            codigo = teclado.nextLine();
                        }
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                System.out.println("Forneça o conteúdo: ");
                String conteudo = teclado.nextLine();

                System.out.println("Forneça a carga horaria: ");
                Double cargaHoraria = Double.parseDouble(teclado.nextLine());

                System.out.println("Forneça o tipo ( 1 para pratica ou 2 para teorica): ");
                int idTipo = Integer.parseInt(teclado.nextLine());

                while (idTipo != 1 && idTipo != 2) {
                    System.out.println("Tipo inválido: ");
                    System.out.println("Forneça o tipo ( 1 para pratica ou 2 para teorica):");
                    idTipo = Integer.parseInt(teclado.nextLine());
                }
                String tipo = "teorica";
                if (idTipo == 1) {
                    tipo = "pratica";
                }

                 {
                    try {
                        disciplina.add(codigo, conteudo, cargaHoraria, tipo);
                    } catch (SQLException ex) {
                        Logger.getLogger(DisciplinaView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            case 2: {
                try {
                    disciplina.disciplinas();
                } catch (SQLException ex) {
                    Logger.getLogger(DisciplinaView.class.getName()).log(Level.SEVERE, null, ex);
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
