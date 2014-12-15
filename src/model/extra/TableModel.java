package model.extra;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * @author Lockland
 */
abstract class TableModel extends AbstractTableModel{

    protected List<String> colunas;

    public List<String> getColunas() {
        return colunas;
    }

    public void setColunas(List<String> colunas) {
        this.colunas = colunas;
    }
    
    abstract void setColunas();
       
    @Override
    public String getColumnName(int columnIndex){
        return colunas.get(columnIndex);
    }
    
    @Override
    public abstract int getRowCount();

    @Override
    public int getColumnCount() {
        return colunas.size();
    }
    
    @Override
    public abstract Object getValueAt(int rowIndex, int columnIndex);

}
