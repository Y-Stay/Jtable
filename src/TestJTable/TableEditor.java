package TestJTable;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class TableEditor extends DefaultCellEditor {
    public TableEditor(JCheckBox checkBox) {
        super(checkBox);
    }
    public TableEditor(JComboBox comboBox) {
        super(comboBox);
    }
    public TableEditor(JTextField textField) {
        super(textField);
    }
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        if (row<0||column!=1)
            return super.getTableCellEditorComponent(table, value, isSelected,  row, column);
        else {
            JButton label = new JButton("button");
            label.addActionListener(new ActionListener(){
            	@Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    JOptionPane.showMessageDialog(null, "test");
                }               
            });
            label.setPreferredSize(new Dimension(table.getColumnModel().getColumn(column).getPreferredWidth(),20));
            return label;
        }
    }
}