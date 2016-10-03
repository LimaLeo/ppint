import java.awt.BorderLayout;
import java.awt.Container;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaItens extends JDialog
{
	// atributos
	private TableModelItem modeloItem;
	private JTable tabelaItem;
	private JScrollPane jsp;

	public TelaItens(JFrame fr)
	{
		// Invoca o método construtor da superclasse
		super(fr, true);
		// Cria um Conteiner de Tela
		Container cp = getContentPane();
		Connection conn = null;
		Item item;

		cp.setLayout(new BorderLayout());

		try
		{
			// obtem conexao com o banco
			AcessoBD bd = new AcessoBD();
			conn = bd.obtemConexao();
			// *** IMPORTANTE ***: Força o uso de transação.
			conn.setAutoCommit(false);
			item = new Item();

			String[] col =
			{"Id", "Nome", "Valor"};
			
			modeloItem = new TableModelItem();
			modeloItem.setColunas(col);
			tabelaItem = new JTable(modeloItem);
			jsp = new JScrollPane(tabelaItem);

			modeloItem.setAlItem(item.getAllItem(conn));
			cp.add(BorderLayout.CENTER, jsp);

		} catch (Exception e)
		{
			e.printStackTrace();
			if (conn != null)
			{
				try
				{
					conn.rollback();
				} catch (SQLException e1)
				{
					System.out.print(e1.getStackTrace());
				}
			}
		} finally
		{
			if (conn != null)
			{
				try
				{
					conn.close();
				} catch (SQLException e1)
				{
					System.out.print(e1.getStackTrace());
				}
			}
		}

		// Programa o tamanho inicial do FlowLayout em pxls
		setSize(400, 250);
		// Determina a localização inicial do FlowLayout em pxls
		setLocation(500, 100);
		// Determina qual o título do FlowLayout
		setTitle("Itens para venda");
		// Estabelece que o FlowLayout será visível inicialmente
		setVisible(true);
	}
}
