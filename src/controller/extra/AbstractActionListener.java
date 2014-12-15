package controller.extra;

import java.util.List;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

public abstract class AbstractActionListener{

    protected TableColumn getColumnFromTable(JTable table, int colIndex) {
        return table.getColumnModel().getColumn(colIndex);
    }

    protected void defineAlignment(TableColumn column, String align) {
        column.setCellRenderer(getAlign(align));
    }

    protected DefaultTableCellRenderer getAlign(String align) {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();

        switch (align) {
            case "esquerda":
                renderer.setHorizontalAlignment(SwingConstants.LEFT);
                break;
            case "centralizado":
                renderer.setHorizontalAlignment(SwingConstants.CENTER);
                break;
            case "direita":
                renderer.setHorizontalAlignment(SwingConstants.RIGHT);
                break;
        }
        return renderer;
    }
}
