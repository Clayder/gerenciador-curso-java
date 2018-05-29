package App.View.Disciplina;

import App.View.Menu;
import App.View.IView;
import java.util.Scanner;

public class DisciplinaView implements IView {

    @Override
    public void init() {
        Scanner teclado = new Scanner(System.in);
        System.out.println(" ****** 4.Disciplina ****** ");
        System.out.println("4.1- Cadastrar");
        System.out.println("4.2- Listar");
        System.out.println("4.3- Pesquisar");
        int op2;
        op2 = Integer.parseInt(teclado.nextLine());
        switch (op2) {
            case 1:
                System.out.println("Cadastrar");
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
