import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class TelaPrincipal extends JFrame implements ActionListener
{
	// constrola pedido
	private boolean statusPedido;
	private String mensagemErro, mensagemPedidoSucesso;

	// formatação de double
	private DecimalFormat duas;

	// variável sobre
	private String sobre;
	private String[] colunas;
	int op = 1;

	// atributos para o menu
	private JMenu jmArquivo, jmIdioma, jmPedido, jmItem;
	private JMenuItem jmiSobre, jmiSair, jmiPortugues, jmiIngles, jmiEspanhol, jmiExibeItens, jmiNovoPedido;
	private JMenuBar jmbMenu;

	// atributo para manipulação de idiomas
	private ResourceBundle bn = null;

	// atributos para formulario
	private JLabel jlItem, jlQuantidade, jlNPedido, jlValorTotal, jlValorTotalResult, jlFilacircular;
	private JTextField jtfItem, jtfQuantidade, jtfNPedido;
	private JButton jbAdicionar, jbRemover, jbFecharPedido;

	// atributos paineis
	private JPanel jpForm, jbFooter, jpFormItens, jpFormItensButtons, jpTotalPedido, jpFecharPedido;

	// atributos para tabela
	private JTable jtTabela;
	private JScrollPane jsp;
	private TableModelPedido modelo;
	private FilaCircular filacircular;

	public TelaPrincipal()
	{
		// determina o idioma padrão para português
		bn = ResourceBundle.getBundle("idioma", new Locale("pt", "BR"));
		final Container c = getContentPane();// container
		c.setLayout(new BorderLayout());// instancia e atribui ao
										// layout border
		// instancia jmenu
		jmArquivo = new JMenu(bn.getString("telaprincipal.menu.arquivo"));
		jmIdioma = new JMenu(bn.getString("telaprincipal.menu.idioma"));
		jmPedido = new JMenu(bn.getString("telaprincipal.menu.pedido"));
		jmItem = new JMenu(bn.getString("telaprincipal.menu.item"));

		// instancia jmenuitem
		jmiSobre = new JMenuItem(bn.getString("telaprincipal.menuitem.sobre"));
		jmiSair = new JMenuItem(bn.getString("telaprincipal.menuitem.sair"));
		jmiPortugues = new JMenuItem(bn.getString("telaprincipal.menuitem.portugues"));
		jmiIngles = new JMenuItem(bn.getString("telaprincipal.menuitem.ingles"));
		jmiEspanhol = new JMenuItem(bn.getString("telaprincipal.menuitem.espanhol"));
		jmiExibeItens = new JMenuItem(bn.getString("telaprincipal.menuitem.exibe"));
		jmiNovoPedido = new JMenuItem(bn.getString("telaprincipal.menuitem.novopedido"));
		
		// instancia fila circular 
		filacircular = new FilaCircular(100);
		
		// instancia jmenubar
		jmbMenu = new JMenuBar();
		setJMenuBar(jmbMenu);

		// adiciona os jmenuitens ao jmenu
		jmArquivo.add(jmiSobre);
		jmArquivo.add(jmiSair);

		// adiciona jmenu ao jmenubar
		jmbMenu.add(jmArquivo);
		if (ReadLoginFile.isGerente())
		{
			// adiciona os jmenuitens ao jmenu
			jmIdioma.add(jmiPortugues);
			jmIdioma.add(jmiIngles);
			jmIdioma.add(jmiEspanhol);
			// adiciona jmenu ao jmenubar
			jmbMenu.add(jmIdioma);
		}
		jmbMenu.add(jmPedido);
		jmbMenu.add(jmItem);
		jmPedido.add(jmiNovoPedido);
		jmItem.add(jmiExibeItens);

		// edição mensagens
		sobre = bn.getString("telaprincipal.frame.title") + "\n" + bn.getString("telaprincipal.menu.sobre");
		setMensagemErro(bn.getString("telaprincipal.valida.novopedido"));
		setMensagemPedidoSucesso(bn.getString("telaprincipal.pedido.finalizado"));

		// adiciona evento aos itens de menu
		jmiSobre.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(null, sobre);
			}
		});
		jmiSair.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		jmiPortugues.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// atribui locale ao ResourceBundle
				bn = ResourceBundle.getBundle("idioma", new Locale("pt", "BR"));
				// altera jlabel
				jlItem.setText(bn.getString("telaprincipal.label.item") + ": ");
				jlQuantidade.setText(bn.getString("telaprincipal.label.quantidade") + ": ");
				jlNPedido.setText(bn.getString("telaprincipal.label.npedido") + ": ");
				jlValorTotal.setText(bn.getString("telaprincipal.label.vtotal") + ": ");
				jlFilacircular.setText(bn.getString("telaprincipal.label.filacircular"));

				// altera jbutton
				jbAdicionar.setText(bn.getString("telaprincipal.button.adicionar"));
				jbRemover.setText(bn.getString("telaprincipal.button.remover"));
				jbFecharPedido.setText(bn.getString("telaprincipal.button.fecharpedido"));

				// altera jmenu
				jmArquivo.setText(bn.getString("telaprincipal.menu.arquivo"));
				jmIdioma.setText(bn.getString("telaprincipal.menu.idioma"));
				jmPedido.setText(bn.getString("telaprincipal.menu.pedido"));
				jmItem.setText(bn.getString("telaprincipal.menu.item"));

				// altera jmenuitem
				jmiSobre.setText(bn.getString("telaprincipal.menuitem.sobre"));
				jmiSair.setText(bn.getString("telaprincipal.menuitem.sair"));
				jmiPortugues.setText(bn.getString("telaprincipal.menuitem.portugues"));
				jmiIngles.setText(bn.getString("telaprincipal.menuitem.ingles"));
				jmiEspanhol.setText(bn.getString("telaprincipal.menuitem.espanhol"));
				jmiExibeItens.setText(bn.getString("telaprincipal.menuitem.exibe"));
				jmiNovoPedido.setText(bn.getString("telaprincipal.menuitem.novopedido"));

				String[] colPortugues =
				{ bn.getString("tablemodelpedido.colunas.item"), bn.getString("tablemodelpedido.colunas.valor"),
						bn.getString("tablemodelpedido.colunas.quantidade"),
						bn.getString("tablemodelpedido.colunas.subtotal") };
				modelo.setColunas(colPortugues);

				// atualiza colunas
				String[] col =
				{ bn.getString("tablemodelpedido.colunas.item"), bn.getString("tablemodelpedido.colunas.valor"),
						bn.getString("tablemodelpedido.colunas.quantidade"),
						bn.getString("tablemodelpedido.colunas.subtotal") };
				setColunas(col);
				modelo.setColunas(getColunas());

				// atualiza mensagens
				sobre = bn.getString("telaprincipal.frame.title") + "\n" + bn.getString("telaprincipal.menu.sobre");
				setSobre(sobre);
				setMensagemErro(bn.getString("telaprincipal.valida.novopedido"));

				// atualiza title
				setTitle(bn.getString("telaprincipal.frame.title"));
			}
		});
		jmiIngles.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// atribui locale ao ResourceBundle
				bn = ResourceBundle.getBundle("idioma", Locale.US);
				// altera jlabel
				jlItem.setText(bn.getString("telaprincipal.label.item") + ": ");
				jlQuantidade.setText(bn.getString("telaprincipal.label.quantidade") + ": ");
				jlNPedido.setText(bn.getString("telaprincipal.label.npedido") + ": ");
				jlValorTotal.setText(bn.getString("telaprincipal.label.vtotal") + ": ");
				jlFilacircular.setText(bn.getString("telaprincipal.label.filacircular"));

				// altera jbutton
				jbAdicionar.setText(bn.getString("telaprincipal.button.adicionar"));
				jbRemover.setText(bn.getString("telaprincipal.button.remover"));
				jbFecharPedido.setText(bn.getString("telaprincipal.button.fecharpedido"));

				// altera jmenu
				jmArquivo.setText(bn.getString("telaprincipal.menu.arquivo"));
				jmIdioma.setText(bn.getString("telaprincipal.menu.idioma"));
				jmPedido.setText(bn.getString("telaprincipal.menu.pedido"));
				jmItem.setText(bn.getString("telaprincipal.menu.item"));

				// altera jmenuitem
				jmiSobre.setText(bn.getString("telaprincipal.menuitem.sobre"));
				jmiSair.setText(bn.getString("telaprincipal.menuitem.sair"));
				jmiPortugues.setText(bn.getString("telaprincipal.menuitem.portugues"));
				jmiIngles.setText(bn.getString("telaprincipal.menuitem.ingles"));
				jmiEspanhol.setText(bn.getString("telaprincipal.menuitem.espanhol"));
				jmiExibeItens.setText(bn.getString("telaprincipal.menuitem.exibe"));
				jmiNovoPedido.setText(bn.getString("telaprincipal.menuitem.novopedido"));

				// atualiza colunas
				String[] col =
				{ bn.getString("tablemodelpedido.colunas.item"), bn.getString("tablemodelpedido.colunas.valor"),
						bn.getString("tablemodelpedido.colunas.quantidade"),
						bn.getString("tablemodelpedido.colunas.subtotal") };
				setColunas(col);
				modelo.setColunas(getColunas());
				// repaint();

				// atualiza informações sobre o sistema
				sobre = bn.getString("telaprincipal.frame.title") + "\n" + bn.getString("telaprincipal.menu.sobre");

				// atualiza mensagens
				setSobre(sobre);
				setMensagemErro(bn.getString("telaprincipal.valida.novopedido"));
				setMensagemPedidoSucesso(bn.getString("telaprincipal.pedido.finalizado"));
				// atualiza title
				setTitle(bn.getString("telaprincipal.frame.title"));
			}
		});
		jmiEspanhol.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// atribui locale ao ResourceBundle
				bn = ResourceBundle.getBundle("idioma", new Locale("es", "ES"));
				// altera jlabel
				jlItem.setText(bn.getString("telaprincipal.label.item") + ": ");
				jlQuantidade.setText(bn.getString("telaprincipal.label.quantidade") + ": ");
				jlNPedido.setText(bn.getString("telaprincipal.label.npedido") + ": ");
				jlValorTotal.setText(bn.getString("telaprincipal.label.vtotal") + ": ");
				jlFilacircular.setText(bn.getString("telaprincipal.label.filacircular"));

				// altera jbutton
				jbAdicionar.setText(bn.getString("telaprincipal.button.adicionar"));
				jbRemover.setText(bn.getString("telaprincipal.button.remover"));
				jbFecharPedido.setText(bn.getString("telaprincipal.button.fecharpedido"));

				// altera jmenu
				jmArquivo.setText(bn.getString("telaprincipal.menu.arquivo"));
				jmIdioma.setText(bn.getString("telaprincipal.menu.idioma"));
				jmPedido.setText(bn.getString("telaprincipal.menu.pedido"));
				jmItem.setText(bn.getString("telaprincipal.menu.item"));

				// altera jmenuitem
				jmiSobre.setText(bn.getString("telaprincipal.menuitem.sobre"));
				jmiSair.setText(bn.getString("telaprincipal.menuitem.sair"));
				jmiPortugues.setText(bn.getString("telaprincipal.menuitem.portugues"));
				jmiIngles.setText(bn.getString("telaprincipal.menuitem.ingles"));
				jmiEspanhol.setText(bn.getString("telaprincipal.menuitem.espanhol"));
				jmiExibeItens.setText(bn.getString("telaprincipal.menuitem.exibe"));
				jmiNovoPedido.setText(bn.getString("telaprincipal.menuitem.novopedido"));

				// atualiza colunas
				String[] col =
				{ bn.getString("tablemodelpedido.colunas.item"), bn.getString("tablemodelpedido.colunas.valor"),
						bn.getString("tablemodelpedido.colunas.quantidade"),
						bn.getString("tablemodelpedido.colunas.subtotal") };
				setColunas(col);
				modelo.setColunas(getColunas());

				// atualiza informações sobre o sistema
				sobre = bn.getString("telaprincipal.frame.title") + "\n" + bn.getString("telaprincipal.menu.sobre");

				// atualiza mensagens
				setSobre(sobre);
				setMensagemErro(bn.getString("telaprincipal.valida.novopedido"));
				setMensagemPedidoSucesso(bn.getString("telaprincipal.pedido.finalizado"));

				// atualiza title
				setTitle(bn.getString("telaprincipal.frame.title"));
			}
		});
		jmiExibeItens.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				TelaItens ti = new TelaItens(null);
			}
		});
		jmiNovoPedido.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// se o pedido estiver em andamento ele não pode executar
				if (statusPedido == true)
				{
					JOptionPane.showMessageDialog(null, getMensagemErro());
				} else
				{

					// habilita o clique de botões
					jbAdicionar.setEnabled(true);
					jbRemover.setEnabled(true);

					// habilita edição campos de texto
					jtfItem.setEditable(true);
					jtfQuantidade.setEditable(true);

					// pedido em andamento
					statusPedido = true;
				}
			}
		});

		// instancia jlabel
		jlItem = new JLabel(bn.getString("telaprincipal.label.item") + ": ");
		jlQuantidade = new JLabel(bn.getString("telaprincipal.label.quantidade") + ": ");
		jlNPedido = new JLabel(bn.getString("telaprincipal.label.npedido") + ": ");
		jlValorTotal = new JLabel(bn.getString("telaprincipal.label.vtotal") + " :");
		jlValorTotalResult = new JLabel();
		jlFilacircular = new JLabel(bn.getString("telaprincipal.label.filacircular"));

		// instancia jtextfied
		jtfItem = new JTextField(15);
		jtfQuantidade = new JTextField(15);
		jtfNPedido = new JTextField(15);

		// instancia os botoes
		jbAdicionar = new JButton(bn.getString("telaprincipal.button.adicionar"));
		jbRemover = new JButton(bn.getString("telaprincipal.button.remover"));
		jbFecharPedido = new JButton(bn.getString("telaprincipal.button.fecharpedido"));

		// adiciona ação aos botões
		jbAdicionar.addActionListener(this);
		jbRemover.addActionListener(this);
		jbFecharPedido.addActionListener(this);

		// instancia os paineis
		jpForm = new JPanel();
		jbFooter = new JPanel();
		jpFormItens = new JPanel();
		jpFormItensButtons = new JPanel();
		jpTotalPedido = new JPanel();
		jpFecharPedido = new JPanel();

		// atribui layout para cada painel
		jpForm.setLayout(new GridLayout(5, 1, 5, 5));
		jbFooter.setLayout(new GridLayout(2, 1, 5, 5));
		jpFormItens.setLayout(new GridLayout(1, 4));
		jpFormItensButtons.setLayout(new GridLayout(1, 2));
		jpTotalPedido.setLayout(new GridLayout(1, 2));
		jpFecharPedido.setLayout(new GridLayout(1, 3));

		// adiciona elementos ao painel
		jpFormItens.add(jlItem);
		jpFormItens.add(jtfItem);
		jpFormItens.add(jlQuantidade);
		jpFormItens.add(jtfQuantidade);

		jpFormItensButtons.add(jbAdicionar);
		jpFormItensButtons.add(jbRemover);

		// jpForm.add(jspFilaCircular);
		jpForm.add(jlFilacircular);
		jpForm.add(jpFormItens);
		jpForm.add(jpFormItensButtons);

		jpTotalPedido.add(jlValorTotal);
		jpTotalPedido.add(jlValorTotalResult);

		jpFecharPedido.add(jlNPedido);
		jpFecharPedido.add(jtfNPedido);
		jpFecharPedido.add(jbFecharPedido);

		jbFooter.add(jpTotalPedido);
		jbFooter.add(jpFecharPedido);

		// instancia objeto formatação
		duas = new DecimalFormat("0.00");

		// instancia modelo
		modelo = new TableModelPedido();

		String[] col =
		{ bn.getString("tablemodelpedido.colunas.item"), bn.getString("tablemodelpedido.colunas.valor"),
				bn.getString("tablemodelpedido.colunas.quantidade"),
				bn.getString("tablemodelpedido.colunas.subtotal") };
		setColunas(col);
		modelo.setColunas(colunas);

		// instancia a table e atribui ao modelo criado
		jtTabela = new JTable(modelo);
		jtTabela.setFillsViewportHeight(true);

		// instancia RowSorter
		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modelo);
		jtTabela.setRowSorter(sorter);

		// instancia jscrollpane
		jsp = new JScrollPane(jtTabela);
		jsp.setPreferredSize(new Dimension(320, 250));

		// desabilita edição campos de texto
		jtfNPedido.setEditable(false);
		jtfItem.setEditable(false);
		jtfQuantidade.setEditable(false);

		// desabilita o clique de botões
		jbAdicionar.setEnabled(false);
		jbRemover.setEnabled(false);
		jbFecharPedido.setEnabled(false);

		// adiciona os paineis ao container
		c.add(BorderLayout.NORTH, jpForm);
		c.add(BorderLayout.CENTER, jsp);
		c.add(BorderLayout.SOUTH, jbFooter);

		// congifura o painel
		setVisible(true);
		setSize(650, 450);
		setLocation(350, 80);
		setTitle(bn.getString("telaprincipal.frame.title"));
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == jbAdicionar)
		{
			Item item = new Item();
			Connection conn = null;
			try
			{
				// obtem conexao com o banco
				AcessoBD bd = new AcessoBD();
				conn = bd.obtemConexao();
				// *** IMPORTANTE ***: Força o uso de transação.
				conn.setAutoCommit(false);

				item = item.getItemById(conn, Integer.parseInt(jtfItem.getText()));
				ItemPedido ip = new ItemPedido(item, Double.parseDouble(jtfQuantidade.getText()));

				modelo.addPedido(ip);
			} catch (Exception f)
			{
				f.printStackTrace();
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

			// habilita o clique de botões
			jbFecharPedido.setEnabled(true);

			// desabilita edição campos de texto
			jtfNPedido.setEditable(false);

			// atualiza o valor total da compra
			jlValorTotalResult.setText(duas.format(modelo.getValorTotalPedido()));

		}

		if (e.getSource() == jbRemover)
		{
			try
			{
				// chama a linha selecionada
				int linhaSelecionada = this.jtTabela.getSelectedRow();
				// exclui linha
				modelo.removePedido(linhaSelecionada);
				// atualiza o valor total da compra
				jlValorTotalResult.setText(duas.format(modelo.getValorTotalPedido()));
			} catch (Exception f)
			{
				JOptionPane.showMessageDialog(null, "Selecione um 'item de pedido' para que seja removido!");
			}
		}

		if (e.getSource() == jbFecharPedido)
		{
			// limpar pedidos do painel
			modelo.limparPedidos();

			// desabilita edição campos de texto
			jtfNPedido.setEditable(false);
			jtfItem.setEditable(false);
			jtfQuantidade.setEditable(false);

			// desabilita o clique de botões
			jbAdicionar.setEnabled(false);
			jbRemover.setEnabled(false);
			jbFecharPedido.setEnabled(false);

			// habilita edição campos de texto
			jtfNPedido.setEditable(true);

			// controle o estado do pedido
			statusPedido = false;
			
			// esvazia jtextfield
			jtfItem.setText("");
			jtfQuantidade.setText("");
			
			// esvazia jlabel
			jlValorTotalResult.setText("");
			
			// adiciona n° pedido na fila
			int iPedido = filacircular.geraItemFila();
			
			//mostra número do pedido
			jtfNPedido.setText(iPedido+"");
			
			// mensagem de confirmação
			JOptionPane.showMessageDialog(null, getMensagemPedidoSucesso());
			
			// atualiza fila circular
			jlFilacircular.setText(bn.getString("telaprincipal.label.filacircular")+filacircular.getFilaCircular());
		}
	}

	public String getSobre()
	{
		return sobre;
	}

	public void setSobre(String sobre)
	{
		this.sobre = sobre;
	}

	public String[] getColunas()
	{
		return colunas;
	}

	public void setColunas(String[] colunas)
	{
		this.colunas = colunas;
	}

	public String getMensagemErro()
	{
		return mensagemErro;
	}

	public void setMensagemErro(String mensagemErro)
	{
		this.mensagemErro = mensagemErro;
	}

	public String getMensagemPedidoSucesso()
	{
		return mensagemPedidoSucesso;
	}

	public void setMensagemPedidoSucesso(String mensagemPedidoSucesso)
	{
		this.mensagemPedidoSucesso = mensagemPedidoSucesso;
	}
}
