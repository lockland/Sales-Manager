package model.entidadeDao;

import dao.DataBaseSqLite;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.entidade.Produto;

/**
 * @author Lockland
 */
public class ProdutoDao {

    DataBaseSqLite db;

    public ProdutoDao(DataBaseSqLite db) {
        this.db = db;
    }
    
    public int salvar(Produto produto) throws SQLException {
        int cod = 0;
        String query = "INSERT INTO produto (titulo, descricao, precounitario, tarifaentrega, qtidadeestoque)"
                + "VALUES (?, ?, ? ,? ,?)";
        try {
            db.connect();
            cod = db.executeUpdateAndReturn(query,
                                            produto.getTitulo(),
                                            produto.getDescricao(),
                                            produto.getPrecoUnitario(),
                                            produto.getTarifaEntregaUnidade(),
                                            produto.getQtdeEstoque());
        } catch (SQLException ex) {
            throw new SQLException(ex);
        } finally {
            query = null;
            db.close();
        }
        return cod;
    }
    
    public void update(Produto produto) throws SQLException {
        String query = "UPDATE produto "
                + "SET titulo = ?, descricao = ?, precounitario = ?, tarifaentrega = ?, qtidadeestoque = ? "
                + "WHERE id = ?";
        try {
            db.connect();
            db.executeUpdate(query, 
                            produto.getTitulo(),
                            produto.getDescricao(),
                            produto.getPrecoUnitario(),
                            produto.getTarifaEntregaUnidade(),
                            produto.getQtdeEstoque(),
                            produto.getId());
            
        } catch (SQLException ex) {
            throw new SQLException(ex);
        } finally {
            query = null;
            db.close();
        }
    }

    public List<Produto> getListProdutos() throws SQLException {
        String query = "SELECT * FROM produto";
        ResultSet rs = null;
        List<Produto> lp = null;
        try {
            db.connect();
            rs = db.executeQuery(query);
            lp = mapperProduto(rs);
        } catch (SQLException ex) {
            throw new SQLException(ex);
        } finally {
            rs.close();
            db.close();
        }
        return lp;
    }

    public Produto getProdutoDoDb(int field) throws SQLException, Exception {
        String query = "SELECT * FROM produto WHERE id = ?";

        ResultSet rs = null;
        List<Produto> lp = null;
        try {
            db.connect();
            rs = db.executeQuery(query, field);
            lp = mapperProduto(rs);
        } finally {
            rs.close();
            db.close();
        }

        if (lp.size() <= 0) {
            throw new Exception("Nenhum produto encontrado");
        }
        return lp.get(0);
    }

    private List<Produto> mapperProduto(ResultSet resultSet) throws SQLException {
        List<Produto> lp = new ArrayList<Produto>();
        Produto p = null;

        if (resultSet != null) {
            while (resultSet.next()) {
                p = new Produto(resultSet.getInt("id"),
                                resultSet.getString("titulo"),
                                resultSet.getString("descricao"),
                                resultSet.getDouble("precounitario"),
                                resultSet.getDouble("tarifaentrega"),
                                resultSet.getInt("qtidadeestoque"));
                lp.add(p);
            }
        }

        return lp;
    }
    
}
