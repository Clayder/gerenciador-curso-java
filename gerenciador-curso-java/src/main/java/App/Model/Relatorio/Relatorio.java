package App.Model.Relatorio;

import App.Model.Aluno.Aluno;
import App.Model.Model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Relatorio extends Model implements IRelatorio {

    public Relatorio() throws SQLException {
    }

    /**
     *
     * @param ano
     * @param mes
     * @param arrecadado
     * @return
     * @throws SQLException
     */
    @Override
    public double getValorAulas(Integer ano, Integer mes, boolean arrecadado) throws SQLException {
        String filtro = "";
        filtro += "year(aula.data) = ?";
        int status = 1;
        if (mes != null) {
            filtro += " AND month(aula.data) = ?";
        }
        if (arrecadado) {
            status = 0;
        }
        String query = this.query(status) + " where " + filtro + " \n";       
        statement = connection.prepareStatement(query);
        statement.setInt(1, ano);
        if (mes != null) {
            statement.setInt(2, mes);
        }
        ResultSet res = statement.executeQuery();
        double valor = 0;
        while (res.next()) {
            valor = res.getDouble("valor");
        }
        return valor;
    }

    private String query(int status) {
        String query = "SELECT format(sum(professor.valor_hora),2) as valor FROM curso.aula as aula\n"
                + "INNER JOIN curso.professor as professor ON professor.id = aula.fkProfessor "
                + "AND aula.status = " + status;
        return query;
    }

    @Override
    public void pagamentoProfessor(Integer ano, Integer mes) throws SQLException {
        String filtro = "";
        filtro += " AND year(aula.data) = ?";
        if (mes != null) {
            filtro += " AND month(aula.data) = ?";
        }
        String query = "SELECT format(sum(professor.valor_hora),2) as valor, professor.nome, aula.fkProfessor FROM curso.aula as aula\n"
                + "INNER JOIN curso.professor as professor ON professor.id = aula.fkProfessor\n"
                + "where aula.data <= now() \n"
                + filtro + "\n"
                + "AND aula.status = 1\n"
                + "group by aula.fkProfessor";

        statement = connection.prepareStatement(query);
        statement.setInt(1, ano);
        if (mes != null) {
            statement.setInt(2, mes);
        }
        ResultSet res = statement.executeQuery();
        while (res.next()) {
            System.out.println("******************************");
            System.out.println(res.getString("fkProfessor"));
            System.out.println(res.getString("nome"));
            System.out.println(res.getString("valor"));
            System.out.println("******************************");
        }
    }

    @Override
    public void insert() throws SQLException {
    }

    @Override
    public void update() throws SQLException {
    }

    @Override
    public void setById(Integer id) throws SQLException {
    }

    @Override
    protected void setCampos() {
    }
}
