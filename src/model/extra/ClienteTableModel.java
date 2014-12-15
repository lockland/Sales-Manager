package model.extra;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import model.entidade.Cliente;

/**
 * @author Lockland
 */
public class ClienteTableModel extends TableModel implements Serializable{
    
    private List<Cliente> linhas;

    public ClienteTableModel(List<Cliente> clientes) {
        this.linhas = clientes;
        setColunas();
    }

    public ClienteTableModel() {
        setColunas();
    }
        
    @Override
    void setColunas() {
        this.colunas = Arrays.asList("Nome", 
                                    "Email", 
                                    "CPF", 
                                    "Data Cadastro", 
                                    "Limite Credito");
    }
    
    public void setLinhas(List<Cliente> clientes){
        this.linhas = clientes;
    }

    public List<Cliente> getClientes(){
        return linhas;
    }
    
    public Cliente getCliente(int index){
        return linhas.get(index);
    }
    
    @Override
    public int getRowCount() {
        return this.linhas.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = this.linhas.get(rowIndex);
        
        switch(columnIndex){
            case 0: return cliente.getNome();
            case 1: return cliente.getEmail();
            case 2: return cliente.getCpf();
            case 3: return cliente.getDataCadastro();
            case 4: return String.format("%.2f", cliente.getLimitecredito());
        }
        return null;
    }

}
