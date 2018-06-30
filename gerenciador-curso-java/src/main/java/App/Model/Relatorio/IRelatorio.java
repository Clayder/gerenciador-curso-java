package App.Model.Relatorio;

import java.sql.SQLException;

public interface IRelatorio {
    
    public double getValorAulas(Integer ano, Integer mes, boolean arrecadado) throws SQLException ;
    
    public void pagamentoProfessor(Integer ano, Integer mes) throws SQLException;
   
}
