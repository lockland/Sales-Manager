package model.extra;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import model.entidade.Produto;

/**
 * @author Lockland
 */
public class ProdutoTableModel extends TableModel implements Serializable{
    
    private List<Produto> linhas;
    
    public ProdutoTableModel(List<Produto> produtos) {
        this.linhas = produtos;
        setColunas();
        
    }

    public ProdutoTableModel() {
        setColunas();
    }

    @Override
    public void setColunas() {
        this.colunas = Arrays.asList("Código",
                                        "Título", 
                                        "Descrição", 
                                        "Preco Unitário",
                                        "Tarifa Entrega", 
                                        "Quantidade");
    }

    public List<Produto> getProdutos() {
        return linhas;
    }
    
    public Produto getProduto(int index) {
        return linhas.get(index);
    }

    public void setLinhas(List<Produto> produtos) {
        this.linhas = produtos;
    }
    
    @Override
    public int getRowCount() {
        return linhas.size();
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Produto produto = linhas.get(rowIndex);
        switch(columnIndex){
            case 0: return produto.getId();
            case 1: return produto.getTitulo();
            case 2: return produto.getDescricao();
            case 3: return String.format("%.2f", produto.getPrecoUnitario());
            case 4: return String.format("%.2f", produto.getTarifaEntregaUnidade());
            case 5: return produto.getQtdeEstoque();
        }
        
        return null;
    }

}
