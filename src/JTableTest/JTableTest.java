package JTableTest;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class JTableTest extends JFrame
{
 
	public JTableTest()
	{
		intiComponent();
	}
 
	/**
	 * 初始化窗体组件
	 */
	private void intiComponent()
	{
		JTable table = new JTable(new MyTableModel());
 
		/* 用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看 */
		JScrollPane scroll = new JScrollPane(table);
		add(scroll);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
	}
 
	private class MyTableModel extends AbstractTableModel
	{
		/*
		 * 这里和刚才一样，定义列名和每个数据的值
		 */
		String[] columnNames =
		{ "姓名", "学号", "年龄", "成绩", "选择" };
		Object[][] data = new Object[2][5];
 
		/**
		 * 构造方法，初始化二维数组data对应的数据
		 */
		public MyTableModel()
		{
			for (int i = 0; i < 2; i++)
			{
				for (int j = 0; j < 5; j++)
				{
					if (0 == i)
					{
						switch (j)
						{
						case 0:
							data[i][j] = "邓光侨";
							break;
						case 1:
							data[i][j] = "2008415";
							break;
						case 2:
							data[i][j] = "18";
							break;
						case 3:
							data[i][j] = "90";
							break;
						case 4:
							data[i][j] = new Boolean(false);
							break;
						}
					}
					if (1 == i)
					{
						switch (j)
						{
						case 0:
							data[i][j] = "李洁璇";
							break;
						case 1:
							data[i][j] = "2008321";
							break;
						case 2:
							data[i][j] = "18";
							break;
						case 3:
							data[i][j] = "63";
							break;
						case 4:
							data[i][j] = new Boolean(false);
							break;
						}
					}
				}
			}
		}
 
		// 以下为继承自AbstractTableModle的方法，可以自定义
		/**
		 * 得到列名
		 */
		@Override
		public String getColumnName(int column)
		{
			return columnNames[column];
		}
		
		/**
		 * 重写方法，得到表格列数
		 */
		@Override
		public int getColumnCount()
		{
			return columnNames.length;
		}
 
		/**
		 * 得到表格行数
		 */
		@Override
		public int getRowCount()
		{
			return data.length;
		}
 
		/**
		 * 得到数据所对应对象
		 */
		@Override
		public Object getValueAt(int rowIndex, int columnIndex)
		{
			return data[rowIndex][columnIndex];
		}
 
		/**
		 * 得到指定列的数据类型
		 */
		@Override
		public Class<?> getColumnClass(int columnIndex)
		{
			return data[0][columnIndex].getClass();
		}
 
		/**
		 * 指定设置数据单元是否可编辑.这里设置"姓名","学号"不可编辑
		 */
		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex)
		{
			if (columnIndex < 2)
				return false;
			else
				return true;
		}
		
		/**
		 * 如果数据单元为可编辑，则将编辑后的值替换原来的值
		 */
		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex)
		{
			data[rowIndex][columnIndex] = aValue;
			/*通知监听器数据单元数据已经改变*/
			fireTableCellUpdated(rowIndex, columnIndex);
		}
 
	}
 
	public static void main(String[] args)
	{
		new JTableTest();
	}
}
