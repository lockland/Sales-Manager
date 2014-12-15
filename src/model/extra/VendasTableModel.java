package model.extra;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import model.entidade.Produto;

/**
 * @author Lockland
 * @FIXME Corrigir a herança de vendastablemodel e produto
 */

public class VendasTableModel extends ProdutoTableModel implements Serializable{
    
    public VendasTableModel(List<Produto> produtos) {
        setLinhas(produtos);
        setColunas();
    }

    public VendasTableModel() {
        setColunas();
    }

    @Override
    public void setColunas() {
        this.colunas = Arrays.asList("Código",
                                        "Descricao", 
                                        "Tarifa Entrega", 
                                        "Preco Unitario",
                                        "Quantidade",
                                        "Total");
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Produto produto = getProdutos().get(rowIndex);
        switch(columnIndex){
            case 0: return produto.getId();
            case 1: return produto.getDescricao();
            case 2: return String.format("%.2f", produto.getTarifaEntregaUnidade());
            case 3: return String.format("%.2f", produto.getPrecoUnitario());
            case 4: return produto.getQtdeEstoque();
            case 5: return String.format("%.2f", produto.getQtdeEstoque() * produto.getPrecoUnitario());
        }
        
        return null;
    }

}
