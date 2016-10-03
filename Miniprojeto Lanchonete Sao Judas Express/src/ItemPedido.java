
public class ItemPedido
{
	// atributos
	private Item item;
	private double quantidade;

	// construtores
	public ItemPedido()
	{
		item = new Item();
		quantidade = 0.0;
	}
	
	public ItemPedido(Item item, double quantidade)
	{
		setItem(item);
		setQuantidade(quantidade);
	}

	// metodos
	public Item getItem()
	{
		return item;
	}

	public void setItem(Item item)
	{
		this.item = item;
	}

	public double getQuantidade()
	{
		return quantidade;
	}

	public void setQuantidade(double quantidade)
	{
		this.quantidade = quantidade;
	}

	public double getSubtotal()
	{
		return getQuantidade() * item.getValor();
	}
}
