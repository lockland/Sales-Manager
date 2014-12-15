package controller.listener;

import controller.extra.AbstractActionListener;
import dao.DataBaseSqLite;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.entidade.Cliente;
import model.entidade.Venda;
import model.entidade.Produto;
import model.entidadeDao.ClienteDao;
import model.entidadeDao.VendasDao;
import model.entidadeDao.ProdutoDao;
import model.extra.VendasTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import view.extra.ShowMessageDialog;
import view.windows.ViewVendas;

/**
 * @author Lockland
 */
public final class VendasActionListener extends AbstractActionListener
        implements ActionListener, KeyListener {

    private ViewVendas viewVendas;
    private JTable tblCompras;
    private List<Produto> estoque;

    public VendasActionListener(ViewVendas viewCompras) {
        this.viewVendas = viewCompras;
        this.tblCompras = viewCompras.getTblCompras();
        estoque = new ArrayList<Produto>();
        populateJTableCompras(new ArrayList<Produto>());
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        JTextField field = (JTextField) ke.getSource();
        if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
            if (field.getName().equals("txt_pesCliente")) {
                actionBtnPesquisarC();
            }

            if (field.getName().equals("txt_pesProduto")) {
                actionBtnPesquisarP();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        JTextField field = (JTextField) ke.getSource();
        String key = "" + ke.getKeyChar();
        if (!key.matches("[\\d\\uffff]")) {
            if (field.getName().equals("txt_quantidade")) {
                viewVendas.getTxt_quantidade().setText(
                        viewVendas.getTxt_quantidade().getText().replace(key, "")
                );
            }

            if (field.getName().equals("txt_pesProduto")) {
                viewVendas.getTxt_pesProduto().setText(
                        viewVendas.getTxt_pesProduto().getText().replace(key, "")
                );
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        switch (ae.getActionCommand()) {
            case "PesquisarC":
                actionBtnPesquisarC();
                break;
            case "PesquisarP":
                actionBtnPesquisarP();
                break;
            case "OK":
                actionBtnOk();
                break;
            case "AVista":
                actionRbtnAVista();
                break;
            case "3x":
                actionRbtnAPrazo(3);
                break;
            case "4x":
                actionRbtnAPrazo(4);
                break;
            case "5x":
                actionRbtnAPrazo(5);
                break;
            case "6x":
                actionRbtnAPrazo(6);
                break;
            case "Simular":
                actionBtnSimular(true);
                break;
            case "Comprar":
                if (actionBtnSimular(false)) {
                    actionBtnComprar();
                }
                break;
            case "Cancelar":
                actionBtnCancelar();
                break;
        }
    }

    private void actionBtnPesquisarC() {
        DataBaseSqLite db = new DataBaseSqLite();
        ClienteDao clienteDao = new ClienteDao(db);
        String field = viewVendas.getTxt_pesCliente().getText();
        Cliente cliente;
        try {
            cliente = clienteDao.getClienteDoDB(field);
            viewVendas.setClienteId(cliente.getId());
            objectToView(cliente);
        } catch (SQLException e) {
            ShowMessageDialog.error(e.getMessage(), "Erro");
        } catch (Exception e) {
            ShowMessageDialog.error(e.getMessage(), "Erro");
        } finally {
            clienteDao = null;
            cliente = null;
            field = null;
            db = null;
            System.gc();
        }
    }

    private void actionBtnPesquisarP() {
        DataBaseSqLite db = new DataBaseSqLite();
        ProdutoDao produtoDao = new ProdutoDao(db);
        Produto produto;
        int field = 0;
        try {
            field = Integer.parseInt(viewVendas.getTxt_pesProduto().getText());
            produto = produtoDao.getProdutoDoDb(field);
            objectToView(produto);
        } catch (SQLException e) {
            ShowMessageDialog.error(e.getMessage(), "Erro");
        } catch (NumberFormatException e) {
            ShowMessageDialog.error("Código do produto é inválido", "Erro");
        } catch (Exception e) {
            ShowMessageDialog.error(e.getMessage(), "Erro");
        } finally {
            produtoDao = null;
            produto = null;
            db = null;
            System.gc();
        }
    }

    private void actionBtnOk() {
        try {
            coletaDadosEPopulaJTable();
            setDadosVenda();
            atualizaValorParcela();
        } catch (Exception e) {
            ShowMessageDialog.error(e.getMessage(), "Erro");
        }
    }

    private void setDadosVenda() {
        List<Produto> produtos = getListProdutos();
        double subtotal = 0;
        double total = 0;

        for (Produto produto : produtos) {
            subtotal += produto.getPrecoUnitario() * produto.getQtdeEstoque();
            total += produto.getTarifaEntregaUnidade() + subtotal;
        }

        viewVendas.getTxt_subTotal().setText(String.format("%.2f", subtotal));
        viewVendas.getTxt_valorCompra().setText(String.format("%.2f", total));
    }

    private void actionRbtnAVista() {
        viewVendas.getTxt_valorParcelas().setText(
                viewVendas.getTxt_valorCompra().getText()
        );
    }

    private void actionRbtnAPrazo(int meses) {
        String valorParcelas = String.format("%.2f", (getMontante(meses) / meses));
        viewVendas.getTxt_valorParcelas().setText(valorParcelas);
        valorParcelas = null;
    }

    private void actionBtnCancelar() {
        populateJTableCompras(new ArrayList<Produto>());
        estoque.removeAll(estoque);
        clearFields();
        viewVendas.getBtn_comprar().setEnabled(true);
        viewVendas.setVisible(false);
    }

    private boolean actionBtnSimular(boolean showSuccess) {
        double limiteCliente = 0;
        try {
            limiteCliente = Double.valueOf(
                    viewVendas.getTxt_limiteCliente().getText().replace(",", ".")
            );
        } catch (Exception e) {
            ShowMessageDialog.error("Nenhum Cliente Selecionado", "Erro");
            return false;
        }

        double valorCompra = 0;
        try {
            valorCompra = Double.valueOf(
                    viewVendas.getTxt_valorCompra().getText().replace(",", ".")
            );
        } catch (Exception e) {
            ShowMessageDialog.error("Nenhum produto Selecionado", "Erro");
            return false;
        }

        if ((limiteCliente < valorCompra) && !viewVendas.getRbtn_aVista().isSelected()) {
            ShowMessageDialog.error(
                    "Cliente está não apito a realizar a compra",
                    "Informação"
            );
            return false;
        } else {
            if (showSuccess) {
                ShowMessageDialog.success(
                        "Cliente está apito a realizar a compra",
                        "Informação"
                );
            }
            return true;
        }
    }

    @SuppressWarnings("UnusedAssignment")
    private void actionBtnComprar() {
        int uid = viewVendas.getClienteId();
        int qtdParcelas = getSelectedRbtn();
        double valorParcelas = Double.valueOf(
                viewVendas.getTxt_valorParcelas().getText().replace(",", ".")
        );
        int id = 0;

        DataBaseSqLite db = new DataBaseSqLite();
        VendasDao vendasDao = new VendasDao(db);
        Venda venda = new Venda(qtdParcelas, valorParcelas);
        Connection conn;

        try {
            id = vendasDao.salvar(
                    uid,
                    getListaProdutosComprasOtimizada(),
                    estoque,
                    venda
            );
            venda.setId(id);
            //actionJDialog();
            //db.connect();
            GenerateReport(uid, id, db);

            clearFields();
            estoque = new ArrayList<Produto>();
            populateJTableCompras(new ArrayList<Produto>());

        } catch (SQLException ex) {
            ShowMessageDialog.error(ex, "Erro");
        }

        vendasDao = null;
        venda = null;
        db = null;
        System.gc();
    }

    private void GenerateReport(int user_id, int venda_id, DataBaseSqLite db) {

        try {

            String report = db.getClass().getResource("/report/sales_manager.jrxml").getPath();
            String imagePath = report.replace("/sales_manager.jrxml", "");
            
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("CliID", user_id);
            params.put("VendaID", venda_id);
            params.put("imagePath", imagePath);
            
            JasperReport jr = JasperCompileManager.compileReport(report);
            JasperPrint jp = JasperFillManager.fillReport(jr, params, db.connect());
            JasperViewer.viewReport(jp);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (JRException ex) {
            System.out.println(ex.getMessage());
        }

    }

    private void actionJDialog() {
        /*
         int resposta = ShowMessageDialog.questionDialog(
         "Deseja realizar outra venda?",
         "Informação"
         );
         if (resposta == ShowMessageDialog.YES_OPTION) {
         clearFields();
         estoque = new ArrayList<Produto>();
         populateJTableCompras(new ArrayList<Produto>());
         } else {
         viewVendas.getBtn_comprar().setEnabled(false);
         }
         */
        ShowMessageDialog.success(
                "Venda efetuada com sucesso",
                "Informação"
        );
        clearFields();
        estoque = new ArrayList<Produto>();
        populateJTableCompras(new ArrayList<Produto>());

    }

    //private 
    private int getSelectedRbtn() {
        ViewVendas c = viewVendas;
        if (c.getRbtn_3x().isSelected()) {
            return 3;
        } else if (c.getRbtn_4x().isSelected()) {
            return 4;
        } else if (c.getRbtn_5x().isSelected()) {
            return 5;
        } else if (c.getRbtn_6x().isSelected()) {
            return 6;
        }
        return 1;
    }

    @SuppressWarnings("UnusedAssignment")
    private List<Produto> getListaProdutosComprasOtimizada() {
        List<Produto> produtos = new ArrayList<Produto>();
        List<Produto> listProdutos = getListProdutos();

        for (Produto produto : listProdutos) {
            boolean inList = ProductIsInList(produto, produtos);
            if (inList) {
                somaQuantidadeDoProduto(produto, produtos);
                inList = false;
            } else {
                produtos.add(new Produto(produto));
            }
        }
        return produtos;
    }

    private boolean ProductIsInList(Produto produto, List<Produto> produtos) {
        int size = produtos.size();
        for (int i = 0; i < size; i++) {
            if (produto.getId() == produtos.get(i).getId()) {
                return true;
            }
        }

        return false;
    }

    private void somaQuantidadeDoProduto(Produto produto, List<Produto> produtos) {
        int size = produtos.size();
        for (int i = 0; i < size; i++) {
            if (produto.getId() == produtos.get(i).getId()) {
                produtos.get(i).setQtdeEstoque(
                        produtos.get(i).getQtdeEstoque() + produto.getQtdeEstoque()
                );
                break;
            }
        }
    }

    private void clearFields() {
        viewVendas.getTxt_pesCliente().setText("");
        viewVendas.getTxt_nome().setText("");
        viewVendas.getTxt_email().setText("");
        viewVendas.getTxt_cpf().setText("");
        viewVendas.getTxt_limiteCliente().setText("");

        viewVendas.getTxt_pesProduto().setText("");
        viewVendas.getTxt_quantidade().setText("");
        viewVendas.getTxt_descricao().setText("");
        viewVendas.getTxt_precoUnitario().setText("");

        viewVendas.getTxt_valorParcelas().setText("0,00");
        viewVendas.getTxt_subTotal().setText("");
        viewVendas.getTxt_valorCompra().setText("");

        viewVendas.getRbtn_aVista().setSelected(true);
    }

    private void atualizaValorParcela() {
        ViewVendas c = viewVendas;
        if (c.getRbtn_3x().isSelected()) {
            actionRbtnAPrazo(3);
        } else if (c.getRbtn_4x().isSelected()) {
            actionRbtnAPrazo(4);
        } else if (c.getRbtn_5x().isSelected()) {
            actionRbtnAPrazo(5);
        } else if (c.getRbtn_6x().isSelected()) {
            actionRbtnAPrazo(6);
        } else {
            actionRbtnAVista();
        }
    }

    private double getMontante(int meses) {
        double valorCompra = 0.00;

        if (!viewVendas.getTxt_valorCompra().getText().equals("")) {
            valorCompra = Double.valueOf(
                    viewVendas.getTxt_valorCompra().getText().replace(",", ".")
            );
        }

        double taxa = 0.02;
        double montante = valorCompra * Math.pow((1 + taxa), meses);

        return montante;
    }

    @SuppressWarnings({"UnusedAssignment", "empty-statement"})
    private void coletaDadosEPopulaJTable() throws SQLException, Exception {
        Integer[] array;
        array = converteProdutoIdEQuantidade();

        DataBaseSqLite db = new DataBaseSqLite();
        ProdutoDao produtoDao = new ProdutoDao(db);
        Produto pView = produtoDao.getProdutoDoDb(array[0]);;
        Produto pEstoque = new Produto(pView);
        List<Produto> produtos = getListProdutos();

        addProdutoFromDBInEstoque(pEstoque);
        validaQuantidade(pView.getQtdeEstoque(), array[1]);
        isProdutoInEstoque(pView, array[1]);

        pView.setQtdeEstoque(array[1]);
        produtos.add(pView);
        populateJTableCompras(produtos);

        array = null;
        produtoDao = null;
        pView = null;
        produtos = null;
        pEstoque = null;
        db = null;
        System.gc();
    }

    private void isProdutoInEstoque(Produto produto, int quantidade)
            throws Exception {
        int i = 0;
        for (Produto pEstoque : estoque) {
            if (pEstoque.getId() == produto.getId()) {
                i = validaQuantidadeEAbateDoEstoque(pEstoque, quantidade);
            }

            if (i == -1) {
                throw new Exception("Não há unidades deste produto em estoque");
            }

            if (i == -2) {
                throw new Exception("Não há unidades suficientes deste produto em estoque");
            }
        }
    }

    private int validaQuantidadeEAbateDoEstoque(Produto pEstoque, int quantidade) {
        if (pEstoque.getQtdeEstoque() <= 0) {
            return -1;
        } else if (pEstoque.getQtdeEstoque() < quantidade) {
            return -2;
        } else if ((pEstoque.getQtdeEstoque() > 0) && (pEstoque.getQtdeEstoque() >= quantidade)) {
            pEstoque.abateProdutosDoEstoque(quantidade);
        }
        return 0;
    }

    private void validaQuantidade(int qtdProduto, int qtdDigitada)
            throws Exception {
        if (qtdProduto < qtdDigitada) {
            throw new Exception("Quantidade excede o valor em estoque");
        } else if (qtdProduto <= 0) {
            throw new Exception("Quantidade excede o valor em estoque");
        }
    }

    private void addProdutoFromDBInEstoque(Produto produto) {
        for (Produto p : estoque) {
            if (p.getId() == produto.getId()) {
                return;
            }
        }
        estoque.add(produto);
    }

    private List<Produto> getListProdutos() {
        VendasTableModel m = (VendasTableModel) tblCompras.getModel();
        List<Produto> produtos = m.getProdutos();

        m = null;
        return produtos;
    }

    private Integer[] converteProdutoIdEQuantidade() throws NumberFormatException {
        Integer[] array = new Integer[2];
        try {
            array[0] = Integer.parseInt(viewVendas.getTxt_pesProduto().getText());
            array[1] = Integer.parseInt(viewVendas.getTxt_quantidade().getText());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Produto não possui valores válidos");
        }

        return array;
    }

    private void populateJTableCompras(List<Produto> produtos) {
        VendasTableModel model = new VendasTableModel(produtos);
        tblCompras.setModel(model);
        configurarTamanhoColunasEAlinhamento();
    }

    private void configurarTamanhoColunasEAlinhamento() {
        defineAlignment(getColumnFromTable(tblCompras, 0), "centralizado");
        defineAlignment(getColumnFromTable(tblCompras, 1), "esquerda");
        defineAlignment(getColumnFromTable(tblCompras, 2), "direita");
        defineAlignment(getColumnFromTable(tblCompras, 3), "direita");
        defineAlignment(getColumnFromTable(tblCompras, 4), "direita");
        defineAlignment(getColumnFromTable(tblCompras, 5), "direita");

        getColumnFromTable(tblCompras, 0).setPreferredWidth(42);
        getColumnFromTable(tblCompras, 1).setPreferredWidth(220);
        getColumnFromTable(tblCompras, 2).setPreferredWidth(60);
        getColumnFromTable(tblCompras, 3).setPreferredWidth(93);
        getColumnFromTable(tblCompras, 4).setPreferredWidth(50);
        getColumnFromTable(tblCompras, 5).setPreferredWidth(65);
    }

    private void objectToView(Produto produto) {
        viewVendas.getTxt_descricao().setText(produto.getDescricao());
        viewVendas.getTxt_precoUnitario().setText(
                String.format("%.2f", produto.getPrecoUnitario())
        );
    }

    private void objectToView(Cliente cliente) {
        viewVendas.getTxt_nome().setText(cliente.getNome());
        viewVendas.getTxt_email().setText(cliente.getEmail());
        viewVendas.getTxt_cpf().setText(cliente.getCpf());
        viewVendas.getTxt_limiteCliente().setText(
                String.format("%.2f", cliente.getLimitecredito())
        );
    }

}
