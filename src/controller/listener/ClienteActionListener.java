package controller.listener;

import controller.extra.AbstractActionListener;
import dao.DataBaseSqLite;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.entidade.Cliente;
import model.entidadeDao.ClienteDao;
import model.extra.ClienteTableModel;
import view.extra.ShowMessageDialog;
import view.windows.ViewCliente;

/**
 * @author Lockland
 */
public class ClienteActionListener extends AbstractActionListener
        implements ActionListener,
        ListSelectionListener {

    private ViewCliente viewCliente;
    private List<Cliente> listClientes;
    private JTable tblClientes;

    public ClienteActionListener(ViewCliente viewCliente) {
        this.viewCliente = viewCliente;
        tblClientes = viewCliente.getTblClientes();
        populateJTable();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case "Cancelar":
                actionBtnCancelar();
                break;
            case "Salvar":
                actionBtnSalvar();
                break;
        }
    }

    private void actionBtnCancelar() {
        clearFields();
        tblClientes.getSelectionModel().clearSelection();
        viewCliente.setVisible(false);
    }

    private void actionBtnSalvar() {
        List<String> lcliente;
        try {
            lcliente = viewToList();
            saveOrUpdate(lcliente);
            populateJTable();
            clearFields();
        } catch (Exception e) {
            ShowMessageDialog.error(e.getMessage(), "Erro");
        } finally {
            lcliente = null;
            System.gc();
        }
    }

    protected List<String> viewToList() {
        String senha = new String(viewCliente.getPwd_senha().getPassword());
        String confirmsenha = new String(viewCliente.getPwd_confirmsenha().getPassword());

        List<String> cliente = new ArrayList<String>();
        cliente.add(viewCliente.getTxt_Nome().getText());
        cliente.add(viewCliente.getTxt_Email().getText());
        cliente.add(viewCliente.getTxt_CPF().getText());
        cliente.add(senha);
        cliente.add(confirmsenha);
        cliente.add(viewCliente.getTxt_limitecredito().getText());

        senha = null;
        confirmsenha = null;

        return cliente;
    }

    private void salvar(List<String> cliente) throws Exception {
        DataBaseSqLite db = new DataBaseSqLite();
        ClienteDao clienteDao = new ClienteDao(db);
        Cliente objCliente = parseStringListToObject(cliente);
        int id = clienteDao.salvar(objCliente);
        objCliente.setId(id);
        clienteDao = null;
        db = null;
    }

    private void saveOrUpdate(List<String> cliente) throws Exception {
        if (viewCliente.getClienteId() == 0) {
            salvar(cliente);
        } else {
            update(cliente);
        }
    }

    private void update(List<String> cliente) throws Exception {
        DataBaseSqLite db = new DataBaseSqLite();
        ClienteDao clienteDao = new ClienteDao(db);
        Cliente objCliente = parseStringListToObject(cliente);
        objCliente.setId(viewCliente.getClienteId());
        clienteDao.updateCliente(objCliente);
        clienteDao = null;
        db = null;
    }

    private Cliente parseStringListToObject(List<String> cliente) throws Exception {
        String nome, email, cpf, senha, confirmsenha;
        double limitecredito;

        nome = cliente.get(0);
        email = cliente.get(1);
        cpf = cliente.get(2);
        senha = cliente.get(3);
        confirmsenha = cliente.get(4);
        try{
            limitecredito = Double.valueOf(cliente.get(5).replaceAll(",", "."));
        } catch (Exception e){
            throw new Exception("Limite está vazio ou é inválido, preencha-o corretamente para continuar");
        }
        
        if (!senha.equals(confirmsenha)) {
            throw new Exception("Senhas nao conferem");
        }

        Cliente objCliente = new Cliente(nome, email, cpf, senha, limitecredito);
        nome = null;
        email = null;
        cpf = null;
        senha = null;
        confirmsenha = null;
        System.gc();

        return objCliente;
    }

    public void populateJTable() {
        DataBaseSqLite db = new DataBaseSqLite();
        ClienteDao clienteDao = new ClienteDao(db);
        ClienteTableModel model = new ClienteTableModel();

        try {
            listClientes = clienteDao.getListClientes();
        } catch (SQLException ex) {
            ShowMessageDialog.error("Impossivel gerar Lista de Clientes", "Error");
        }

        model.setLinhas(listClientes);
        tblClientes.setModel(model);
        defineAlignment(getColumnFromTable(tblClientes, 2), "direita");
        defineAlignment(getColumnFromTable(tblClientes, 3), "direita");
        defineAlignment(getColumnFromTable(tblClientes, 4), "direita");

        clienteDao = null;
        model = null;
        db = null;
    }

    protected void clearFields() {
        viewCliente.getTxt_Nome().setText("");
        viewCliente.getTxt_Email().setText("");
        viewCliente.getTxt_CPF().setText("");
        viewCliente.getPwd_senha().setText("");
        viewCliente.getPwd_confirmsenha().setText("");
        viewCliente.getTxt_limitecredito().setText("");
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int index = tblClientes.getSelectedRow();
        if ((!e.getValueIsAdjusting()) && (index >= 0)) {
            Cliente cliente = listClientes.get(index);
            objectToView(cliente);
            viewCliente.setClienteId(cliente.getId());
        }
    }

    private void objectToView(Cliente cliente) {
        viewCliente.getTxt_Nome().setText(cliente.getNome());
        viewCliente.getTxt_Email().setText(cliente.getEmail());
        viewCliente.getTxt_CPF().setText(cliente.getCpf());
        viewCliente.getPwd_senha().setText("");
        viewCliente.getPwd_confirmsenha().setText("");
        viewCliente.getTxt_limitecredito().setText(String.format("%.2f", cliente.getLimitecredito()));
    }
}
