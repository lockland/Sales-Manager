package model.entidadeDao;

import dao.DataBaseSqLite;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.entidade.Cliente;

/**
 * @author Lockland
 */
public class ClienteDao {

    DataBaseSqLite db;

    public ClienteDao(DataBaseSqLite db) {
        this.db = db;
    }   

    public int salvar(Cliente cliente) throws SQLException {
        int cod = 0;
        String query = "INSERT INTO usuario (nome, email, cpf, senha, limitecredito, datacadastro)"
                + "VALUES (?, ?, ? ,? ,?, ?)";
        try {
            db.connect();
            cod = db.executeUpdateAndReturn(query,
                    cliente.getNome(),
                    cliente.getEmail(),
                    cliente.getCpf(),
                    cliente.getSenha(),
                    cliente.getLimitecredito(),
                    cliente.getDatePtBr());
        } catch (SQLException ex) {
            throw new SQLException(ex);
        } finally {
            query = null;
            db.close();
        }
        return cod;
    }

    public void updateCliente(Cliente cliente) throws SQLException {
        String query = "UPDATE usuario "
                + "SET nome = ?, email = ?, cpf = ?, senha = ?, limitecredito = ? "
                + "WHERE id = ?";
        try {
            db.connect();
            db.executeUpdate(query,
                    cliente.getNome(),
                    cliente.getEmail(),
                    cliente.getCpf(),
                    cliente.getSenha(),
                    cliente.getLimitecredito(),
                    cliente.getId());
        } catch (SQLException ex) {
            throw new SQLException(ex);
        } finally {
            query = null;
            db.close();
        }
    }

    public List<Cliente> getListClientes() throws SQLException {
        String query = "SELECT * FROM usuario";
        ResultSet rs = null;
        List<Cliente> lp = null;
        try {
            db.connect();
            rs = db.executeQuery(query);
            lp = mapperCliente(rs);
        } finally {
            rs.close();
            db.close();
        }
        return lp;
    }

    public Cliente getClienteDoDB(String field) throws SQLException, Exception {

        String sfield = (field.length() <= 0) ? "-" : field;
        String query = "SELECT * FROM usuario "
                        + "WHERE id = ? OR "
                        + "nome LIKE ? OR "
                        + "cpf = ? OR "
                        + "email = ?";
        ResultSet rs = null;
        List<Cliente> lp = null;
        try {
            db.connect();
            rs = db.executeQuery(query, sfield, sfield + "%", sfield, sfield);
            lp = mapperCliente(rs);
        }finally {
            sfield = null;
            query = null;
            rs.close();
            db.close();
        }
        if (lp.size() <= 0) {
            throw new Exception("Nenhum cliente encontrado");
        }
        return lp.get(0);
    }

    private List<Cliente> mapperCliente(ResultSet resultSet) throws SQLException {
        List<Cliente> lp = new ArrayList<Cliente>();
        Cliente c = null;

        if (resultSet != null) {
            while (resultSet.next()) {
                c = new Cliente(resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("email"),
                        resultSet.getString("cpf"),
                        resultSet.getString("senha"),
                        resultSet.getString("datacadastro"),
                        resultSet.getDouble("limitecredito"));
                lp.add(c);
            }
        }

        return lp;
    }
}