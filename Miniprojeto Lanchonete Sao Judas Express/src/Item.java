import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Item
{
	// atributos
	private int id;
	private String nome;
	private Double valor;

	// construtores
	public Item()
	{
		id = 0;
		nome = "Sem nome";
		valor = 0.0;
	}

	public Item(int id, String nome, Double valor)
	{
		setId(id);
		setNome(nome);
		setValor(valor);
	}

	// métodos
	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public Double getValor()
	{
		return valor;
	}

	public void setValor(Double valor)
	{
		this.valor = valor;
	}

	public static ArrayList<Item> getAllItem(Connection conn)
	{
		String sqlSelect = "SELECT * FROM item ORDER BY id;";
		PreparedStatement stm = null;
		ResultSet rs = null;
		ArrayList<Item> lp = new ArrayList<Item>();
		try {
			stm = conn.prepareStatement(sqlSelect);
			rs = stm.executeQuery();
			while (rs.next()) {
				Item i = new Item();
				i.setId(rs.getInt(1));
				i.setNome(rs.getString(2));
				i.setValor(rs.getDouble(3));
				lp.add(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
		return (lp);
	}
	
	public Item getItemById(Connection conn,int id)
	{
		String sqlSelect = "SELECT * FROM item where id = ?;";
		PreparedStatement stm = null;
		ResultSet rs = null;
		Item i = new Item();
		try {
			stm = conn.prepareStatement(sqlSelect);
			stm.setInt(1, id);
			rs = stm.executeQuery();
			while (rs.next()) {
				
				i.setNome(rs.getString(2));
				i.setValor(rs.getDouble(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
		return i;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

}
