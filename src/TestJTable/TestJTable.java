package TestJTable;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class TestJTable {
    public static JTable table;   
    public static void main(String[] args) {
        JFrame frame = new JFrame("Test Table Header");
        table = new JTable(6,6);       
        TableRender render = new TableRender();
        table.setRowHeight(20);
        TableEditor editor = new TableEditor(new JTextField());
        table.getColumnModel().getColumn(1).setCellRenderer(render);
        table.getColumnModel().getColumn(1).setCellEditor(editor);
        editor.setClickCountToStart(0);
        JScrollPane pane = new JScrollPane(table);           
        frame.setContentPane(pane);
        frame.setPreferredSize(new Dimension(500,500));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);       
    }
}