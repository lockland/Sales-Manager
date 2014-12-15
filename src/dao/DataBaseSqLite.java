package dao;

import view.extra.ShowMessageDialog;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Adicionando o sqlite Driver ao netbeans
 * http://bloggerinme.wordpress.com/2011/11/02/how-to-use-sqlite-with-java-using-netbeans-ide/
 */
/**
 * Class to Manipuling DataBaseMysql
 */
public final class DataBaseSqLite {

    private String Driver;
    private String File;
    private String Url;
    private Connection conn;
    private PreparedStatement pstmt;
    private boolean transaction;

    public DataBaseSqLite() {
        /**
         * @TODO Padronizar a criação do banco no mesmo diretório da aplicação
         * http://stackoverflow.com/questions/227486/find-where-java-class-is-loaded-from
         * http://www.tutorialspoint.com/java/lang/class_getresource.htm
         */
        Driver = "org.sqlite.JDBC";
        //File = getClass().getResource("/").getPath();
        File = "DataBase.sqlite";
        Url = "jdbc:sqlite:" + File;
        conn = null;
        pstmt = null;
        transaction = false;
        create();
    }

    /**
     * Connect to a DataBaseMysql
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     * @return void
     */
    public Connection connect() throws SQLException {
        if (conn == null) {

            try {
                Class.forName(Driver);
            } catch (ClassNotFoundException e) {
                ShowMessageDialog.error(e.getMessage(), "Error");
            }
            this.conn = DriverManager.getConnection(this.Url);

            enableForeign_keys(true);
        }

        return conn;
    }

    public boolean isTransaction() {
        return transaction;
    }

    public void create() {
        try {
            connect();
            executeUpdate("pragma foreign_keys = 1");
            executeUpdate("CREATE TABLE IF NOT EXISTS produto (\n"
                    + "id integer PRIMARY KEY AUTOINCREMENT NOT NULL, \n"
                    + "titulo text NOT NULL, \n"
                    + "descricao text NOT NULL,  \n"
                    + "precounitario double NOT NULL,  \n"
                    + "tarifaentrega double NOT NULL,  \n"
                    + "qtidadeestoque integer NOT NULL)\n");

            executeUpdate("CREATE TABLE IF NOT EXISTS usuario(\n"
                    + "id integer PRIMARY KEY  NOT NULL, \n"
                    + "nome varchar NOT NULL, \n"
                    + "senha varchar NOT NULL, \n"
                    + "datacadastro varchar, \n"
                    + "cpf varchar NOT NULL, \n"
                    + "email varchar, \n"
                    + "limitecredito double NOT NULL)\n");

            executeUpdate("CREATE TABLE IF NOT EXISTS vendas (\n"
                    + "id integer PRIMARY KEY AUTOINCREMENT NOT NULL, \n"
                    + "valortotal double NOT NULL, \n"
                    + "parcelas integer NOT NULL, \n"
                    + "valorparcela double NOT NULL)\n");

            executeUpdate("CREATE TABLE IF NOT EXISTS vendasprodutos (\n"
                    + "idVenda integer NOT NULL, \n"
                    + "idUser integer NOT NULL, \n"
                    + "idProduto integer NOT NULL, \n"
                    + "qtdProduto integer NOT NULL, \n"
                    + "FOREIGN KEY (idVenda) references vendas (id) on DELETE CASCADE ON UPDATE CASCADE, \n"
                    + "FOREIGN KEY (idUser) references usuario (id) on DELETE CASCADE ON UPDATE CASCADE, \n"
                    + "FOREIGN KEY (idProduto) references produto (id) on DELETE CASCADE ON UPDATE CASCADE, \n"
                    + "PRIMARY KEY (idVenda, idUser, idProduto))\n");

            close();
        } catch (SQLException e) {
            ShowMessageDialog.error("Não foi possivel criar ou acessar o banco de dados", "Erro");
        }
    }

    public void enableForeign_keys(boolean isEnable) throws SQLException {
        int enable = (isEnable) ? 1 : 0;
        executeUpdate("pragma foreign_keys = " + enable + ";");
    }

    public void startTransaction() throws SQLException {
        this.conn.setAutoCommit(false);
        this.transaction = true;
    }

    public void commit() throws SQLException {
        this.conn.commit();
        this.transaction = false;
    }

    public void rollback() throws SQLException {
        this.conn.rollback();
        this.transaction = false;
    }

    public ResultSet executeQuery(String query, Object... fields)
            throws SQLException {

        this.pstmt = this.conn.prepareStatement(query);

        int i = 1;
        for (Object field : fields) {
            this.pstmt.setObject(i++, field);
        }

        ResultSet result = this.pstmt.executeQuery();
        return result;
    }

    public ResultSet executeQuery(String query)
            throws SQLException {
        this.pstmt = this.conn.prepareStatement(query);
        ResultSet result = this.pstmt.executeQuery();
        return result;
    }

    public int executeUpdateAndReturn(String query, Object... fields) throws SQLException {
        this.pstmt = this.conn.prepareStatement(
                query,
                Statement.RETURN_GENERATED_KEYS
        );

        int i = 1;
        for (Object field : fields) {
            this.pstmt.setObject(i++, field);
        }

        int b = this.pstmt.executeUpdate();
        int keyGenerated = lastId(); // para o mysql isso não é necessário.
        closePreparedStatement();
        return keyGenerated;
    }

    public void executeUpdate(String query, Object... fields) throws SQLException {
        this.pstmt = this.conn.prepareStatement(query);
        int i = 1;
        for (Object field : fields) {
            this.pstmt.setObject(i++, field);
        }

        this.pstmt.executeUpdate();
        closePreparedStatement();
    }

    public void executeUpdate(String query) throws SQLException {
        this.pstmt = this.conn.prepareStatement(query);
        this.pstmt.executeUpdate();
        closePreparedStatement();
    }

    public int lastId() throws SQLException {
        int lastId = 0;
        ResultSet rs = this.pstmt.getGeneratedKeys();
        while (rs.next()) {
            lastId = rs.getInt(1);
        }
        return lastId;
    }

    public void close() {
        closePreparedStatement();
        closeConnection();
    }

    private void closePreparedStatement() {
        if (this.pstmt != null) {
            try {
                this.pstmt.close();
                this.pstmt = null;
            } catch (SQLException ex) {
            }
        }
    }

    private void closeConnection() {
        if ((this.conn != null) && (this.transaction == false)) {
            try {
                this.conn.close();
                this.conn = null;
            } catch (SQLException ex) {
            }
        }
    }

    public PreparedStatement getPreparedStatement() {
        return pstmt;
    }

    public static void main(String[] args) {
        DataBaseSqLite db = new DataBaseSqLite();

        String query = "SELECT * FROM usuario "
                + "WHERE nome LIKE ? OR "
                + "cpf = ? OR "
                + "email = ?";

        String field = "fulano";
        String elemento;
        try {
            db.connect();
            ResultSet rs = db.executeQuery(query, "%" + field + "%", field, field);

            while (rs.next()) {
                System.out.println(rs.getString("nome"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataBaseSqLite.class.getName()).log(Level.SEVERE, null, ex);
        }

        db.close();
    }
}
