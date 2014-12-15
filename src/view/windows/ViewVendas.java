package view.windows;

import controller.listener.VendasActionListener;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class ViewVendas extends JPanel implements Serializable{
    
    VendasActionListener listener;
    int clienteId;

    /**
     * Creates new form Venda
     */
    public ViewVendas() {
        initComponents();
        this.setVisible(false);
        listener = new VendasActionListener(this);
        addListenerToButtons();
        clienteId = 0;
    }
    
    private void addListenerToButtons(){
        btn_pesCliente.addActionListener(listener);
        btn_pesProduto.addActionListener(listener);
        btn_ok.addActionListener(listener);
        rbtn_aVista.addActionListener(listener);
        rbtn_3x.addActionListener(listener);
        rbtn_4x.addActionListener(listener);
        rbtn_5x.addActionListener(listener);
        rbtn_6x.addActionListener(listener);
        btn_simular.addActionListener(listener);
        btn_comprar.addActionListener(listener);
        btn_cancelar.addActionListener(listener);
        txt_pesCliente.addKeyListener(listener);
        txt_pesProduto.addKeyListener(listener);
        txt_quantidade.addKeyListener(listener);
    }

    public JTextField getTxt_limiteCliente() {
        return txt_limiteCliente;
    }

    public void setTxt_limiteCliente(JTextField txt_limiteCliente) {
        this.txt_limiteCliente = txt_limiteCliente;
    }
    
    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public JButton getBtn_ok() {
        return btn_ok;
    }

    public void setBtn_ok(JButton btn_ok) {
        this.btn_ok = btn_ok;
    }

    public JButton getBtn_cancelar() {
        return btn_cancelar;
    }

    public void setBtn_cancelar(JButton btn_cancelar) {
        this.btn_cancelar = btn_cancelar;
    }

    public JButton getBtn_comprar() {
        return btn_comprar;
    }

    public void setBtn_comprar(JButton btn_comprar) {
        this.btn_comprar = btn_comprar;
    }

    public JButton getBtn_pesCliente() {
        return btn_pesCliente;
    }

    public void setBtn_pesCliente(JButton btn_pesCliente) {
        this.btn_pesCliente = btn_pesCliente;
    }

    public JButton getBtn_pesProduto() {
        return btn_pesProduto;
    }

    public void setBtn_pesProduto(JButton btn_pesProduto) {
        this.btn_pesProduto = btn_pesProduto;
    }

    public JButton getBtn_simular() {
        return btn_simular;
    }

    public void setBtn_simular(JButton btn_simular) {
        this.btn_simular = btn_simular;
    }

    public JRadioButton getRbtn_3x() {
        return rbtn_3x;
    }

    public void setRbtn_3x(JRadioButton rbtn_3x) {
        this.rbtn_3x = rbtn_3x;
    }

    public JRadioButton getRbtn_4x() {
        return rbtn_4x;
    }

    public void setRbtn_4x(JRadioButton rbtn_4x) {
        this.rbtn_4x = rbtn_4x;
    }

    public JRadioButton getRbtn_5x() {
        return rbtn_5x;
    }

    public void setRbtn_5x(JRadioButton rbtn_5x) {
        this.rbtn_5x = rbtn_5x;
    }

    public JRadioButton getRbtn_6x() {
        return rbtn_6x;
    }

    public void setRbtn_6x(JRadioButton rbtn_6x) {
        this.rbtn_6x = rbtn_6x;
    }

    public JRadioButton getRbtn_aVista() {
        return rbtn_aVista;
    }

    public void setRbtn_aVista(JRadioButton rbtn_aVista) {
        this.rbtn_aVista = rbtn_aVista;
    }

    public JTable getTblCompras() {
        return tbl_compras;
    }

    public void setTblCompras(JTable tbl_compras) {
        this.tbl_compras = tbl_compras;
    }

    public JTextField getTxt_cpf() {
        return txt_cpf;
    }

    public void setTxt_cpf(JTextField txt_cpf) {
        this.txt_cpf = txt_cpf;
    }

    public JTextField getTxt_descricao() {
        return txt_descricao;
    }

    public void setTxt_descricao(JTextField txt_descricao) {
        this.txt_descricao = txt_descricao;
    }

    public JTextField getTxt_email() {
        return txt_email;
    }

    public void setTxt_email(JTextField txt_email) {
        this.txt_email = txt_email;
    }

    public JTextField getTxt_nome() {
        return txt_nome;
    }

    public void setTxt_nome(JTextField txt_nome) {
        this.txt_nome = txt_nome;
    }

    public JTextField getTxt_pesCliente() {
        return txt_pesCliente;
    }

    public void setTxt_pesCliente(JTextField txt_pesCliente) {
        this.txt_pesCliente = txt_pesCliente;
    }

    public JTextField getTxt_precoUnitario() {
        return txt_precoUnitario;
    }

    public void setTxt_precoUnitario(JTextField txt_precoUnitario) {
        this.txt_precoUnitario = txt_precoUnitario;
    }

    public JTextField getTxt_quantidade() {
        return txt_quantidade;
    }

    public void setTxt_quantidade(JTextField txt_quantidade) {
        this.txt_quantidade = txt_quantidade;
    }

    public JTextField getTxt_subTotal() {
        return txt_subTotal;
    }

    public void setTxt_subTotal(JTextField txt_subTotal) {
        this.txt_subTotal = txt_subTotal;
    }

    public JTextField getTxt_valorParcelas() {
        return txt_valorParcelas;
    }

    public void setTxt_valorParcelas(JTextField txt_valorParcelas) {
        this.txt_valorParcelas = txt_valorParcelas;
    }

    public JTextField getTxt_pesProduto() {
        return txt_pesProduto;
    }

    public void setTxt_pesProduto(JTextField txt_pesProduto) {
        this.txt_pesProduto = txt_pesProduto;
    }

    public JTextField getTxt_valorCompra() {
        return txt_valorCompra;
    }

    public void setTxt_valorCompra(JTextField txt_valorCompra) {
        this.txt_valorCompra = txt_valorCompra;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        parcelas = new javax.swing.ButtonGroup();
        dadosCliente = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_pesCliente = new javax.swing.JTextField();
        btn_pesCliente = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txt_nome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_cpf = new javax.swing.JTextField();
        dadosProduto = new javax.swing.JPanel();
        btn_pesProduto = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txt_pesProduto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_quantidade = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_descricao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_precoUnitario = new javax.swing.JTextField();
        btn_ok = new javax.swing.JButton();
        dadosCompra = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPaneCompras = new javax.swing.JScrollPane();
        tbl_compras = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btn_simular = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txt_valorCompra = new javax.swing.JTextField();
        txt_valorParcelas = new javax.swing.JTextField();
        btn_cancelar = new javax.swing.JButton();
        rbtn_3x = new javax.swing.JRadioButton();
        btn_comprar = new javax.swing.JButton();
        rbtn_4x = new javax.swing.JRadioButton();
        txt_limiteCliente = new javax.swing.JTextField();
        rbtn_6x = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        rbtn_5x = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        rbtn_aVista = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        txt_subTotal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        dadosCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Cliente"));

        jLabel1.setText("Pesquisar:");

        txt_pesCliente.setToolTipText("Use nome, cpf ou email do cliente");
        txt_pesCliente.setName("txt_pesCliente"); // NOI18N

        btn_pesCliente.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        btn_pesCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/finder16.png"))); // NOI18N
        btn_pesCliente.setActionCommand("PesquisarC");
        btn_pesCliente.setMaximumSize(new java.awt.Dimension(30, 30));
        btn_pesCliente.setMinimumSize(new java.awt.Dimension(30, 30));

        jLabel2.setText("Nome:");

        txt_nome.setEditable(false);

        jLabel4.setText("Email:");

        txt_email.setEditable(false);

        jLabel14.setText("CPF: ");

        txt_cpf.setEditable(false);

        javax.swing.GroupLayout dadosClienteLayout = new javax.swing.GroupLayout(dadosCliente);
        dadosCliente.setLayout(dadosClienteLayout);
        dadosClienteLayout.setHorizontalGroup(
            dadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dadosClienteLayout.createSequentialGroup()
                        .addComponent(txt_email)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_cpf))
                    .addGroup(dadosClienteLayout.createSequentialGroup()
                        .addComponent(txt_pesCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_pesCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_nome))
                .addContainerGap())
        );
        dadosClienteLayout.setVerticalGroup(
            dadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(dadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_pesCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(btn_pesCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(dadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txt_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dadosProduto.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Produto"));

        btn_pesProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/finder16.png"))); // NOI18N
        btn_pesProduto.setActionCommand("PesquisarP");
        btn_pesProduto.setMaximumSize(new java.awt.Dimension(30, 30));
        btn_pesProduto.setMinimumSize(new java.awt.Dimension(30, 30));

        jLabel6.setText("Código:");

        txt_pesProduto.setToolTipText("Digite numeros inteiros");
        txt_pesProduto.setName("txt_pesProduto"); // NOI18N

        jLabel7.setText("Preço Un.");

        txt_quantidade.setToolTipText("Digite numeros inteiros");
        txt_quantidade.setName("txt_quantidade"); // NOI18N

        jLabel8.setText("Descrição:");

        txt_descricao.setEditable(false);

        jLabel5.setText("Quantidade: ");

        txt_precoUnitario.setEditable(false);
        txt_precoUnitario.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        btn_ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/icon_OK.png"))); // NOI18N
        btn_ok.setActionCommand("OK");

        javax.swing.GroupLayout dadosProdutoLayout = new javax.swing.GroupLayout(dadosProduto);
        dadosProduto.setLayout(dadosProdutoLayout);
        dadosProdutoLayout.setHorizontalGroup(
            dadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dadosProdutoLayout.createSequentialGroup()
                        .addComponent(txt_pesProduto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_pesProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_quantidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dadosProdutoLayout.createSequentialGroup()
                        .addComponent(txt_descricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_precoUnitario)))
                .addContainerGap())
        );
        dadosProdutoLayout.setVerticalGroup(
            dadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(dadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(dadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_pesProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGroup(dadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(btn_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btn_pesProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(dadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_precoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addGroup(dadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txt_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        dadosCompra.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados da Venda"));

        jScrollPaneCompras.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPaneCompras.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tbl_compras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Título 1", "Título 2", "Título 3", "Título 4"
            }
        ));
        tbl_compras.setMinimumSize(new java.awt.Dimension(300, 64));
        jScrollPaneCompras.setViewportView(tbl_compras);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneCompras)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneCompras, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_simular.setText("Simular");

        jLabel9.setText("Sub Total:");

        txt_valorCompra.setEditable(false);
        txt_valorCompra.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        txt_valorParcelas.setEditable(false);
        txt_valorParcelas.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txt_valorParcelas.setText("0,00");

        btn_cancelar.setText("Cancelar");

        parcelas.add(rbtn_3x);
        rbtn_3x.setText(" 3 vezes");
        rbtn_3x.setActionCommand("3x");

        btn_comprar.setText("Comprar");

        parcelas.add(rbtn_4x);
        rbtn_4x.setText(" 4 vezes");
        rbtn_4x.setActionCommand("4x");

        txt_limiteCliente.setEditable(false);
        txt_limiteCliente.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        parcelas.add(rbtn_6x);
        rbtn_6x.setText("6 vezes");
        rbtn_6x.setActionCommand("6x");

        jLabel13.setText("Parcelado:");

        jLabel12.setText("Forma de pagamento:");

        parcelas.add(rbtn_5x);
        rbtn_5x.setText("5 vezes");
        rbtn_5x.setActionCommand("5x");

        jLabel3.setText("Limite Cliente:");

        parcelas.add(rbtn_aVista);
        rbtn_aVista.setSelected(true);
        rbtn_aVista.setText("A vista");
        rbtn_aVista.setActionCommand("AVista");

        jLabel11.setText("Valor da Venda:");

        txt_subTotal.setEditable(false);
        txt_subTotal.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        jLabel10.setText("Valor Parcelas:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_valorParcelas)
                            .addComponent(txt_limiteCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_valorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_subTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 310, Short.MAX_VALUE)
                        .addComponent(btn_simular)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_comprar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cancelar))
                    .addComponent(jLabel12)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rbtn_aVista)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtn_3x)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtn_4x)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtn_5x)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtn_6x)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_valorParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txt_subTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_valorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel3)
                    .addComponent(txt_limiteCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtn_aVista)
                    .addComponent(jLabel13)
                    .addComponent(rbtn_3x)
                    .addComponent(rbtn_4x)
                    .addComponent(rbtn_5x)
                    .addComponent(rbtn_6x))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_comprar)
                    .addComponent(btn_cancelar)
                    .addComponent(btn_simular))
                .addContainerGap())
        );

        javax.swing.GroupLayout dadosCompraLayout = new javax.swing.GroupLayout(dadosCompra);
        dadosCompra.setLayout(dadosCompraLayout);
        dadosCompraLayout.setHorizontalGroup(
            dadosCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dadosCompraLayout.setVerticalGroup(
            dadosCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosCompraLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dadosCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dadosCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dadosProduto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dadosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dadosProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dadosCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleParent(this);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_comprar;
    private javax.swing.JButton btn_ok;
    private javax.swing.JButton btn_pesCliente;
    private javax.swing.JButton btn_pesProduto;
    private javax.swing.JButton btn_simular;
    private javax.swing.JPanel dadosCliente;
    private javax.swing.JPanel dadosCompra;
    private javax.swing.JPanel dadosProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPaneCompras;
    private javax.swing.ButtonGroup parcelas;
    private javax.swing.JRadioButton rbtn_3x;
    private javax.swing.JRadioButton rbtn_4x;
    private javax.swing.JRadioButton rbtn_5x;
    private javax.swing.JRadioButton rbtn_6x;
    private javax.swing.JRadioButton rbtn_aVista;
    private javax.swing.JTable tbl_compras;
    private javax.swing.JTextField txt_cpf;
    private javax.swing.JTextField txt_descricao;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_limiteCliente;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_pesCliente;
    private javax.swing.JTextField txt_pesProduto;
    private javax.swing.JTextField txt_precoUnitario;
    private javax.swing.JTextField txt_quantidade;
    private javax.swing.JTextField txt_subTotal;
    private javax.swing.JTextField txt_valorCompra;
    private javax.swing.JTextField txt_valorParcelas;
    // End of variables declaration//GEN-END:variables
}
