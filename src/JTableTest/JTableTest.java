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
	 * ��ʼ���������
	 */
	private void intiComponent()
	{
		JTable table = new JTable(new MyTableModel());
 
		/* ��JScrollPaneװ��JTable������������Χ���оͿ���ͨ�����������鿴 */
		JScrollPane scroll = new JScrollPane(table);
		add(scroll);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
	}
 
	private class MyTableModel extends AbstractTableModel
	{
		/*
		 * ����͸ղ�һ��������������ÿ�����ݵ�ֵ
		 */
		String[] columnNames =
		{ "����", "ѧ��", "����", "�ɼ�", "ѡ��" };
		Object[][] data = new Object[2][5];
 
		/**
		 * ���췽������ʼ����ά����data��Ӧ������
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
							data[i][j] = "�˹���";
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
							data[i][j] = "����";
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
 
		// ����Ϊ�̳���AbstractTableModle�ķ����������Զ���
		/**
		 * �õ�����
		 */
		@Override
		public String getColumnName(int column)
		{
			return columnNames[column];
		}
		
		/**
		 * ��д�������õ��������
		 */
		@Override
		public int getColumnCount()
		{
			return columnNames.length;
		}
 
		/**
		 * �õ��������
		 */
		@Override
		public int getRowCount()
		{
			return data.length;
		}
 
		/**
		 * �õ���������Ӧ����
		 */
		@Override
		public Object getValueAt(int rowIndex, int columnIndex)
		{
			return data[rowIndex][columnIndex];
		}
 
		/**
		 * �õ�ָ���е���������
		 */
		@Override
		public Class<?> getColumnClass(int columnIndex)
		{
			return data[0][columnIndex].getClass();
		}
 
		/**
		 * ָ���������ݵ�Ԫ�Ƿ�ɱ༭.��������"����","ѧ��"���ɱ༭
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
		 * ������ݵ�ԪΪ�ɱ༭���򽫱༭���ֵ�滻ԭ����ֵ
		 */
		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex)
		{
			data[rowIndex][columnIndex] = aValue;
			/*֪ͨ���������ݵ�Ԫ�����Ѿ��ı�*/
			fireTableCellUpdated(rowIndex, columnIndex);
		}
 
	}
 
	public static void main(String[] args)
	{
		new JTableTest();
	}
}
