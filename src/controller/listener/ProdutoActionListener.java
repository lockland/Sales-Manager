package controller.listener;

import controller.extra.AbstractActionListener;
import dao.DataBaseSqLite;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import model.entidade.Produto;
import model.entidadeDao.ProdutoDao;
import model.extra.ProdutoTableModel;
import view.extra.ShowMessageDialog;
import view.windows.ViewProduto;

/**
 * @author Lockland
 */
public final class ProdutoActionListener extends AbstractActionListener implements ActionListener {

    private ViewProduto viewProduto;
    private JTable tblProdutos;

    public ProdutoActionListener(ViewProduto viewProduto) {
        this.viewProduto = viewProduto;
        this.tblProdutos = viewProduto.getTblProdutos();
        populateJTableProdutos();
    }

    public void actionPerformed(ActionEvent ae) {

        switch (ae.getActionCommand()) {
            case "Salvar":
                actionBtnSalvar();
                break;
        }
    }

    private void actionBtnSalvar() {
        List<String> produto;
        try {
            produto = viewToList();
            salvar(produto);
            populateJTableProdutos();
            clearFields();
        } catch (NumberFormatException e) {
            ShowMessageDialog.error(e.getMessage(), "Error");
        } catch (SQLException e) {
            ShowMessageDialog.error(e.getMessage(), "Salvar Produto");
        } finally {
            produto = null;
            System.gc();
        }
    }

    private void salvar(List<String> produto) throws NumberFormatException,
            SQLException {
        Produto objProduto = parseStringListToObject(produto);
        DataBaseSqLite db = new DataBaseSqLite();
        ProdutoDao pDao = new ProdutoDao(db);

        if (objProduto != null) {
            int cod = pDao.salvar(objProduto);
            objProduto.setId(cod);
        }
        
        db = null;
    }

    private Produto parseStringListToObject(List<String> produto) throws
            NumberFormatException {
        double tarifa = 0.00, precoUnitario = 0.00;
        int quantidade = 0;
        String titulo, descricao;

        titulo = produto.get(0);
        descricao = produto.get(1);

        Produto p;
        try {
            precoUnitario = Double.valueOf(produto.get(2).replace(",", "."));
            tarifa = Double.valueOf(produto.get(3).replace(",", "."));
            quantidade = Integer.parseInt(produto.get(4));
            p = new Produto(titulo, descricao, precoUnitario, tarifa, quantidade);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Um ou mais numeros estao em formato invalido");
        } finally {
            tarifa = 0;
            precoUnitario = 0;
            quantidade = 0;
            titulo = null;
            descricao = null;
            System.gc();
        }

        return p;
    }

    private List<String> viewToList() {
        List<String> produto = new ArrayList<String>();
        produto.add(viewProduto.getTxt_prodTitulo().getText());
        produto.add(viewProduto.getTxt_prodDescricao().getText());
        produto.add(viewProduto.getTxt_prodPrecoUnitario().getText());
        produto.add(viewProduto.getTxt_prodTarifa().getText());
        produto.add(viewProduto.getTxt_prodQuantidade().getText());
        return produto;
    }

    private void clearFields() {
        viewProduto.getTxt_prodTitulo().setText("");
        viewProduto.getTxt_prodDescricao().setText("");
        viewProduto.getTxt_prodPrecoUnitario().setText("");
        viewProduto.getTxt_prodTarifa().setText("");
        viewProduto.getTxt_prodQuantidade().setText("");
    }

    public void populateJTableProdutos() {
        DataBaseSqLite db = new DataBaseSqLite();
        ProdutoDao produtoDao = new ProdutoDao(db);
        ProdutoTableModel model = new ProdutoTableModel();

        List<Produto> produtos = null;

        try {
            produtos = produtoDao.getListProdutos();
        } catch (SQLException ex) {
            ShowMessageDialog.error("Impossivel gerar Lista de Produtos", "Error");
        }

        model.setLinhas(produtos);
        tblProdutos.setModel(model);
        configurarTamanhoColunasEAlinhamento();

        produtos = null;
        produtoDao = null;
        model = null;
        db = null;
        System.gc();
    }

    private void configurarTamanhoColunasEAlinhamento() {
        defineAlignment(getColumnFromTable(tblProdutos, 0), "centralizado");
        defineAlignment(getColumnFromTable(tblProdutos, 3), "direita");
        defineAlignment(getColumnFromTable(tblProdutos, 4), "direita");
        defineAlignment(getColumnFromTable(tblProdutos, 5), "direita");
        getColumnFromTable(tblProdutos, 0).setPreferredWidth(42);
        getColumnFromTable(tblProdutos, 1).setPreferredWidth(110);
        getColumnFromTable(tblProdutos, 2).setPreferredWidth(110);
        getColumnFromTable(tblProdutos, 3).setPreferredWidth(92);
        getColumnFromTable(tblProdutos, 4).setPreferredWidth(92);
        getColumnFromTable(tblProdutos, 5).setPreferredWidth(90);
    }
}