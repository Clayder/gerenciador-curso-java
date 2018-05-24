package com.gerenciador.Model.Relatorio;

import com.gerenciador.Model.Aluno.Aluno;
import com.gerenciador.Model.Model;
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
    public String getValorAulas(Integer ano, Integer mes, boolean arrecadado) throws SQLException {
        String filtro = "";
        String sinal = ">";
        filtro += "year(aula.data) = ?";
        if (mes != null) {
            filtro += " AND month(aula.data) = ?";
        }
        if (arrecadado) {
            sinal = "<=";
        }
        String query = this.query() + "where " + filtro + " AND aula.data " + sinal + " now() \n";

        statement = connection.prepareStatement(query);
        statement.setInt(1, ano);
        if (mes != null) {
            statement.setInt(2, mes);
        }
        ResultSet res = statement.executeQuery();
        String valor = null;
        while (res.next()) {
            valor = res.getString("valor");
        }
        return valor;
    }

    private String query() {
        String query = "SELECT format(sum(professor.valor_hora),2) as valor FROM curso.aula as aula\n"
                + "INNER JOIN curso.professor as professor ON professor.id = aula.fkProfessor "
                + "AND aula.status = 1 ";
        return query;
    }

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
