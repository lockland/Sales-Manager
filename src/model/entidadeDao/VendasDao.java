package model.entidadeDao;

import dao.DataBaseSqLite;
import java.sql.SQLException;
import java.util.List;
import model.entidade.Cliente;
import model.entidade.Venda;
import model.entidade.Produto;

public class VendasDao {

    DataBaseSqLite db;

    public VendasDao(DataBaseSqLite db) {
        this.db = db;
    }
    
    public int salvar(int idCliente, List<Produto> produtosCompra, 
                       List<Produto> estoque, Venda venda) throws SQLException{
        int cod = 0;
        String query = "INSERT INTO vendas (valortotal, parcelas, valorparcela)"
                + "VALUES (?, ?, ?)";
        try{
            db.connect();
            db.startTransaction();
            cod = db.executeUpdateAndReturn(query, 
                                            venda.getValorTotal(),
                                            venda.getQtdParcelas(),
                                            venda.getValorParcelas());
            
            inserirTabelaVendasProduto(cod, idCliente, produtosCompra);
            updateLimiteCliente(idCliente, venda.getValorParcelas(), venda.getQtdParcelas());
            updateQtdProdutosEmEstoque(estoque);
            db.commit();
        } catch (SQLException ex) {
            db.rollback();
            throw new SQLException(ex);
        } finally {
            query = null;
            db.close();
        }
        
        return cod;
    }
    
    private void inserirTabelaVendasProduto(int idCompra, int idCliente, 
                                               List<Produto> produtos) throws SQLException {
        
        String query = "INSERT INTO vendasprodutos (idVenda, idUser, idProduto, qtdProduto)"
                + "VALUES (?, ?, ?, ?)";
        
        for (Produto produto : produtos) {
            db.executeUpdate(query, 
                    idCompra,
                    idCliente,
                    produto.getId(),
                    produto.getQtdeEstoque());
        }
        
    }
    
    private void updateLimiteCliente(int id, double valorParcela, int qtdParcelas) throws SQLException{
        ClienteDao clienteDao = new ClienteDao(db);
        Cliente cliente = null;
        
        try {
            cliente = clienteDao.getClienteDoDB("" + id);
            double limiteCliente = (qtdParcelas > 1) ? cliente.getLimitecredito() - valorParcela 
                                                     : cliente.getLimitecredito();
            cliente.setLimitecredito(limiteCliente);
            clienteDao.updateCliente(cliente);
        } catch (Exception ex) {
        }
        
        cliente = null;
        clienteDao = null;
    }
    
    private void updateQtdProdutosEmEstoque(List<Produto> estoque) throws SQLException{
        ProdutoDao produtoDao = new ProdutoDao(db);
        
        for (Produto produto : estoque) {
            produtoDao.update(produto);
            //System.out.println(produto);
        }
        //throw new SQLException("My erro");
    }
}
