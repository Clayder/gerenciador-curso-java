package App.View;

import App.View.Professor.ProfessorView;
import App.View.Aula.AulaView;
import App.View.Aluno.AlunoView;
import App.View.Disciplina.DisciplinaView;
import App.View.Relatorio.RelatorioView;
import java.util.Scanner;

public class Menu implements IView {

    @Override
    public void init() {
        System.out.println("1- Professor");
        System.out.println("2- Aluno");
        System.out.println("3- Aula");
        System.out.println("4- Disciplina");
        System.out.println("5- Relatórios");
        System.out.println("6- Sair");
        Scanner teclado = new Scanner(System.in);
        int op;
        op = Integer.parseInt(teclado.nextLine());
        IView view;
        do {
            switch (op) {
                case 1:
                    view = new ProfessorView();
                    view.init();
                    break;
                case 2:
                    view = new AlunoView();
                    view.init();
                    break;
                case 3:
                    view = new AulaView();
                    view.init();
                    break;
                case 4:
                    view = new DisciplinaView();
                    view.init();
                    break;
                case 5:
                    view = new RelatorioView();
                    view.init();
                    break;
                   
                case 6:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção não encontrada");
                    init();
                    break;
            }
        } while (op != 6);
    }
}
