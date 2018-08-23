package TestJTable;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TableRender extends DefaultTableCellRenderer {
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        if (row<0||column!=1)
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        else {
            JButton label = new JButton("button");
            label.setPreferredSize(new Dimension(table.getColumnModel().getColumn(column).getPreferredWidth(),20));
            return label;
        }       
    }
}