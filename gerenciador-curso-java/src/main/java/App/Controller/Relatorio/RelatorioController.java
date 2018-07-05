/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Controller.Relatorio;

import App.Model.Relatorio.IRelatorio;
import App.Model.Relatorio.Relatorio;
import java.sql.SQLException;

public class RelatorioController {

    /**
     * 
     * @param ano
     * @param mes
     * @return
     * @throws SQLException 
     */
    public double getValorAulasArrecadadas(Integer ano, Integer mes) throws SQLException {
        IRelatorio relatorio = new Relatorio();
        return relatorio.getValorAulas(ano, mes, true);
    }

    /**
     * 
     * @param ano
     * @param mes
     * @return
     * @throws SQLException 
     */
    public double getValorAulas(Integer ano, Integer mes) throws SQLException {
        IRelatorio relatorio = new Relatorio();
        return relatorio.getValorAulas(ano, mes, false);
    }

    /**
     * 
     * @param ano
     * @param mes
     * @return
     * @throws SQLException 
     */
    public double pagamentoProfessor(Integer ano, Integer mes) throws SQLException {
        IRelatorio relatorio = new Relatorio();
        return relatorio.pagamentoProfessor(ano, mes);
    }
}
