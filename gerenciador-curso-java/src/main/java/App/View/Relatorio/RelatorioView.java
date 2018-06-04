package App.View.Relatorio;

import App.View.Menu;
import App.View.IView;
import java.util.Scanner;

public class RelatorioView implements IView {

    @Override
    public void init() {
        Scanner teclado = new Scanner(System.in);
        System.out.println(" ****** 5.Relatório ****** ");
        System.out.println("1- Valor já arrecadado nas aulas (aulas realizadas)");
        System.out.println("2- Gasto já acontecido (pago aos professores)");
        System.out.println("3- Gasto ainda a acontecer (aulas agendadas)");
        System.out.println("4- Voltar");
        int op2;
        op2 = Integer.parseInt(teclado.nextLine());
        switch (op2) {
            case 1:
                System.out.println("Valor já arrecadado nas aulas (aulas realizadas");
                break;
            case 2:
                System.out.println("Gasto já acontecido (pago aos professores)");
                break;
            case 3:
                System.out.println("Gasto ainda a acontecer (aulas agendadas)");
                break;
            default:
                Menu menu = new Menu();
                menu.init();
                break;
        }
    }
}
