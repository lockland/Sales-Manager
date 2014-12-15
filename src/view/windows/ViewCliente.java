/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.windows;

import controller.listener.ClienteActionListener;
import java.io.Serializable;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Lockland
 */
public class ViewCliente extends javax.swing.JPanel implements Serializable{

    private ClienteActionListener listener;
    private int clienteId;

    /**
     * Creates new form ViewCliente
     */
    public ViewCliente() {
        initComponents();
        this.setVisible(false);
        listener = new ClienteActionListener(this);
        addListenerToButtons();
        tblClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        addMaskaraToJFormatField();
        clienteId = 0;
    }

    public ClienteActionListener getClienteActionListener() {
        return listener;
    }
    
    private void addMaskaraToJFormatField(){
        try {
            txt_CPF.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
        } catch (ParseException ex) {
        }
    }
    
    private void addListenerToButtons(){
        btn_Cancelar.addActionListener(listener);
        btn_Salvar.addActionListener(listener);
        tblClientes.getSelectionModel()
                .addListSelectionListener(listener);
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public JButton getBtn_Cancelar() {
        return btn_Cancelar;
    }

    public void setBtn_Cancelar(JButton btn_Cancelar) {
        this.btn_Cancelar = btn_Cancelar;
    }

    public JButton getBtn_Salvar() {
        return btn_Salvar;
    }

    public void setBtn_Salvar(JButton btn_Salvar) {
        this.btn_Salvar = btn_Salvar;
    }

    public JPasswordField getPwd_confirmsenha() {
        return pwd_confirmsenha;
    }

    public void setPwd_confirmsenha(JPasswordField pwd_confirmsenha) {
        this.pwd_confirmsenha = pwd_confirmsenha;
    }

    public JPasswordField getPwd_senha() {
        return pwd_senha;
    }

    public void setPwd_senha(JPasswordField pwd_senha) {
        this.pwd_senha = pwd_senha;
    }

    public JTable getTblClientes() {
        return tblClientes;
    }

    public void setTblClientes(JTable tblClientes) {
        this.tblClientes = tblClientes;
    }

    public JTextField getTxt_CPF() {
        return txt_CPF;
    }

    public void setTxt_CPF(JFormattedTextField txt_CPF) {
        this.txt_CPF = txt_CPF;
    }

    public JTextField getTxt_Email() {
        return txt_Email;
    }

    public void setTxt_Email(JTextField txt_Email) {
        this.txt_Email = txt_Email;
    }

    public JTextField getTxt_Nome() {
        return txt_Nome;
    }

    public void setTxt_Nome(JTextField txt_Nome) {
        this.txt_Nome = txt_Nome;
    }

    public JTextField getTxt_limitecredito() {
        return txt_limitecredito;
    }

    public void setTxt_limitecredito(JTextField txt_limitecredito) {
        this.txt_limitecredito = txt_limitecredito;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pwd_senha = new javax.swing.JPasswordField();
        pwd_confirmsenha = new javax.swing.JPasswordField();
        lbl_confirmsenha = new javax.swing.JLabel();
        lbl_Senha = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lbl_Nome = new javax.swing.JLabel();
        lbl_CPF = new javax.swing.JLabel();
        txt_Nome = new javax.swing.JTextField();
        lbl_Email = new javax.swing.JLabel();
        txt_limitecredito = new javax.swing.JTextField();
        txt_Email = new javax.swing.JTextField();
        lbl_limitecredito = new javax.swing.JLabel();
        txt_CPF = new javax.swing.JFormattedTextField();
        btn_Cancelar = new javax.swing.JButton();
        btn_Salvar = new javax.swing.JButton();

        lbl_confirmsenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_confirmsenha.setText("Confirme a Senha:");

        lbl_Senha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_Senha.setText("Senha:");

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblClientes);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Cadastro Clientes"));

        lbl_Nome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_Nome.setText("Nome:");

        lbl_CPF.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_CPF.setText("CPF:");

        lbl_Email.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_Email.setText("E-mail:");

        txt_limitecredito.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txt_limitecredito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_limitecreditoKeyReleased(evt);
            }
        });

        lbl_limitecredito.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_limitecredito.setText("Limite Crédito:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_Nome)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_Email, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_CPF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_CPF, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_limitecredito)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_limitecredito, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Nome)
                    .addComponent(txt_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Email)
                    .addComponent(txt_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_CPF)
                    .addComponent(lbl_limitecredito)
                    .addComponent(txt_limitecredito, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_CPF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        btn_Cancelar.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        btn_Cancelar.setText("Cancelar");

        btn_Salvar.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        btn_Salvar.setText("Salvar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 524, Short.MAX_VALUE)
                        .addComponent(btn_Salvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_Cancelar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Cancelar)
                    .addComponent(btn_Salvar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_limitecreditoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_limitecreditoKeyReleased
        String key = "" + evt.getKeyChar();
        if (!key.matches("[\\d\\uffff\\,]")) {
            txt_limitecredito.setText(txt_limitecredito.getText().replace(key, ""));
        }
    }//GEN-LAST:event_txt_limitecreditoKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton btn_Salvar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_CPF;
    private javax.swing.JLabel lbl_Email;
    private javax.swing.JLabel lbl_Nome;
    private javax.swing.JLabel lbl_Senha;
    private javax.swing.JLabel lbl_confirmsenha;
    private javax.swing.JLabel lbl_limitecredito;
    private javax.swing.JPasswordField pwd_confirmsenha;
    private javax.swing.JPasswordField pwd_senha;
    private javax.swing.JTable tblClientes;
    private javax.swing.JFormattedTextField txt_CPF;
    private javax.swing.JTextField txt_Email;
    private javax.swing.JTextField txt_Nome;
    private javax.swing.JTextField txt_limitecredito;
    // End of variables declaration//GEN-END:variables
}
