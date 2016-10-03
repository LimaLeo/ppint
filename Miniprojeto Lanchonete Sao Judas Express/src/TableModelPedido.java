import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class TableModelPedido extends AbstractTableModel
{
	// atributos
	private ArrayList<ItemPedido> alItemPedido;
	private String[] colunas =
	{ "Item", "Valor Unitário", "Quantidade", "Subtotal" };

	// construtor
	public TableModelPedido()
	{
		alItemPedido = new ArrayList<ItemPedido>();
	}

	// adicionar ao arraylist
	public void addPedido(ItemPedido itemPedido)
	{
		alItemPedido.add(itemPedido);
		fireTableDataChanged();
	}

	public void removePedido(int rowIndex)
	{
		alItemPedido.remove(rowIndex);
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
		return alItemPedido.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		switch (columnIndex)
		{

		case 0:
			return this.alItemPedido.get(rowIndex).getItem().getNome();
		case 1:
			return this.alItemPedido.get(rowIndex).getItem().getValor();
		case 2:
			return this.alItemPedido.get(rowIndex).getQuantidade();
		case 3:
			return this.alItemPedido.get(rowIndex).getSubtotal();
		default:
			return this.alItemPedido.get(rowIndex);
		}
	}

	public void setColunas(String[] colunas)
	{
		this.colunas = colunas;
		fireTableDataChanged();
	}

	public void setAlItemPedido(ArrayList<ItemPedido> alItemPedido)
	{
		this.alItemPedido = alItemPedido;
	}

	public ArrayList<ItemPedido> getAlItemPedido()
	{
		return alItemPedido;
	}

	public String getColumnName(int columnIndex)
	{
		return this.colunas[columnIndex];
	}

	public void limparPedidos()
	{
		alItemPedido.clear();
	}

	public double getValorTotal()
	{
		double valorTotal = 0;
		for (ItemPedido ip : alItemPedido)
		{
			valorTotal += ip.getSubtotal();
		}
		return valorTotal;
	}

	public double getValorTotalPedido()
	{
		double valorTotal = 0.0;
		for (ItemPedido itemPedido : alItemPedido)
		{
			valorTotal += itemPedido.getSubtotal();
		}
		return valorTotal;
	}	
}
