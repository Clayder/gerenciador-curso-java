package App.Model;

import App.Model.Dao.Dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;

/**
 * 
 * Classe utilizada para manipular os registros do banco de dados
 */
public abstract class Model extends Dao {

    /**
     * Utilizado para gerar arquivo de log, para testar código.
     */
    Logger log = Logger.getLogger(Model.class.getName());

    public Model() throws SQLException {
        super();
    }

    /**
     * Conta a quantidade de registros de uma tabela
     *
     * @return int
     * @throws SQLException
     */
    public int count() throws SQLException {
        String query = "SELECT count(*) as qtd FROM " + TABELA + ";";
        statement = connection.prepareStatement(query);

        ResultSet res = statement.executeQuery();
        int qtd = 0;
        while (res.next()) {
            qtd = res.getInt("qtd");
        }
        return qtd;
    }

    /**
     * Retorna todos os elementos de uma TABELA específica.
     * 
     * @return @throws SQLException
     */
    public ResultSet findAll() throws SQLException {
        String query = "SELECT * FROM " + TABELA;
        statement = connection.prepareStatement(query);
        return statement.executeQuery();
    }

    /**
     * Retorna os dados de um registro específico
     * 
     * @param id
     * @return @throws SQLException
     */
    protected ResultSet findById(Integer id) throws SQLException {
        String query = "SELECT * FROM " + TABELA + " WHERE (id) = ?";
        statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        return statement.executeQuery();
    }

    /**
     * Remove um registro específico, pelo id
     * 
     * @param id
     * @throws SQLException
     */
    public void removeById(Integer id) throws SQLException {
        String query = "DELETE FROM " + TABELA + " WHERE id = ?";

        statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        statement.execute();
    }

    /**
     * Cria a query insert utilizada para inserir registros no banco de dados.
     * 
     * Exemplo: "INSERT INTO " + TABELA + " (matricula, nome, endereco,
     * telefone, valor_hora) VALUES (?, ?, ?, ?, ?)"
     * 
     * @return String 
     */
    protected String getQueryInsert() {
        String campos = "";
        String values = "";

        int tam = this.colunasBD.size();

        for (String coluna : this.colunasBD) {
            tam--;
            campos += coluna;
            values += "?";
            if (tam > 0) {
                campos += ", ";
                values += ", ";
            }
        }

        String insert;

        insert = "INSERT INTO " + TABELA;
        insert += " (";
        insert += campos;
        insert += ")";
        insert += " VALUES (";
        insert += values;
        insert += ")";

        return insert;
    }

    /**
     * Retorna a query update, utilizada para atualizar um registro no banco de dados.
     * Ex: UPDATE tabela SET matricula = ?, nome = ?, endereco = ?,
     * telefone = ?, valor_hora = ? WHERE id = ?
     * 
     */
    protected String getQueryUpdate() {
        String campos = "";

        int tam = this.colunasBD.size();

        for (String coluna : this.colunasBD) {
            tam--;
            campos += coluna + " = ?";
            if (tam > 0) {
                campos += ", ";
            }
        }

        String insert = "";
        insert += "UPDATE " + TABELA + " SET ";
        insert += campos;
        insert += " WHERE id = ?";

        return insert;
    }

    /**
     * Verifica se um registro existe
     * 
     * @param valor Valor a ser pesquisado
     * @param campo Campo da tabela que possui esse valor
     * @return boolean
     * @throws SQLException
     */
    public boolean existe(String valor, String campo) throws SQLException {
        String query = "SELECT count( " + campo + " ) as qty FROM " + TABELA
                + " where " + campo + " = ?";
        
        return verificaExiste(query, valor);

    }

    /**
     * Executa a ação para verificar se existe um registro específico na base de dados.
     * 
     * @param query Query sql que vai ser executado.
     * @param valor Valor que vai ser pesquisado
     * @return boolean
     * @throws SQLException 
     */
    public boolean verificaExiste(String query, String valor) throws SQLException {
        statement = connection.prepareStatement(query);
        statement.setString(1, valor);
        ResultSet res = statement.executeQuery();
        int qty = 0;
        while (res.next()) {
            qty = res.getInt("qty");
        }
        if (qty == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Verifica se um registro existe, passando o nome da tabela por parametro.
     * 
     * @param valor Valor a ser pesquisado.
     * @param campo Coluna da tabela, que vai ser realizado essa busca.
     * @param tabela Tabela que a busca vai ser realizada. 
     * @return boolean
     * @throws SQLException 
     */
    public boolean existeByTabela(String valor, String campo, String tabela) throws SQLException {
        String query = "SELECT count( " + campo + " ) as qty FROM " + tabela
                + " where " + campo + " = ?";
        return verificaExiste(query, valor);
    }

    /**
     * Toda classe que herdar da Model, deverá implementar esse método.
     * Método utilizado para inserir registros na base de dados.
     * 
     * @throws SQLException
     */
    public abstract void insert() throws SQLException;

    /**
     * Toda classe que herdar da Model, deverá implementar esse método.
     * Método utilizado para atualizar um registro.
     * 
     * @throws SQLException
     */
    public abstract void update() throws SQLException;

    /**
     * Toda classe que herdar da Model, deverá implementar esse método.
     * Método utilizado para popular um objeto ( atributos de uma classe )
     * 
     * @param id
     * @throws SQLException
     */
    public abstract void setById(Integer id) throws SQLException;

    /**
     * Toda classe que herdar da Model, deverá implementar esse método.
     * Método utilizado para popular a lista colunasBD ( classe Dao )
     */
    protected abstract void setCampos();
}
