package App.Model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 
 * Classe utilizada para realizar algumas configuração com o banco de dados.
 */
public abstract class Dao {
    
    /**
     * Recebe a conexão
     */
    protected Connection connection = null;
    
    /**
     * Recebe o nome da tabela do banco de dados
     */
    protected String TABELA;
    
    /**
     * Recebe o nome das colunas da TABELA do banco de dados
     */
    protected ArrayList<String> colunasBD;
    protected static PreparedStatement statement = null;
    
    public Dao() throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        connection = factory.getConnection();
        colunasBD = new ArrayList<>();
    }
    
    /**
     * Retorna uma lista com o nome das colunas da TABELA do banco de dados.
     * 
     * @return ArrayList<String>
     */
    public ArrayList<String> getColunasBD() {
        return colunasBD;
    }
    
}
