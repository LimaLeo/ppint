import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class TableModelItem extends AbstractTableModel
{

	// atributos
	private ArrayList<Item> alItem;
	private String[] colunas =
	{ "Id", "Nome", "Valor unitário" };

	// construtor
	public TableModelItem()
	{
		alItem = new ArrayList<Item>();
	}

	// adicionar ao arraylist
	public void addItem(Item item)
	{
		alItem.add(item);
		fireTableDataChanged();
	}

	public void removePedido(int rowIndex)
	{
		alItem.remove(rowIndex);
		fireTableDataChanged();
	}

	@Override
	public int getColumnCount()
	{
		return colunas.length;
	}

	@Override
	public int getRowCount()
	{
		return alItem.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		switch (columnIndex)
		{		
		case 0:
			return this.alItem.get(rowIndex).getId();
		case 1:
			return this.alItem.get(rowIndex).getNome();
		case 2:
			return this.alItem.get(rowIndex).getValor();
		default:
			return this.alItem.get(rowIndex);
		}
	}

	public void setColunas(String[] colunas)
	{
		this.colunas = colunas;
	}
	
	public void setAlItem(ArrayList<Item> alItem)
	{
		this.alItem = alItem;
		fireTableDataChanged();
	}
	
	public String getColumnName(int columnIndex)
	{
		return this.colunas[columnIndex];
	}

}
