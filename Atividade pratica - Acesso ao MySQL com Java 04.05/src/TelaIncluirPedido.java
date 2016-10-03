import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaIncluirPedido extends JDialog implements ActionListener
{
	Connection conn = null;
	private JButton bt;
	private JTextField idClienteJText, idJText, valorJText;
	private JLabel idClienteJLabel, idJLabel, valorJLabel;
	Cliente cl;
	Pedido pd;
	private DateFormat dateFormat;
	private Date date;

	public TelaIncluirPedido(JFrame fr)
	{
		// Invoca o método construtor da superclasse
		super(fr, true);
		Container cx = getContentPane();
		cx.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		// Instânciação dos objetos
		bt = new JButton("Salvar");
		getRootPane().setDefaultButton(bt);
		idClienteJLabel = new JLabel("Id cliente: ");
		idClienteJText = new JTextField(15);
		idJLabel = new JLabel("Id pedido: ");
		idJText = new JTextField(15);
		valorJLabel = new JLabel("Valor: ");
		valorJText = new JTextField(15);

		// instancia objeto data
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		date = new Date();

		// adiciona ao container
		cx.add(idClienteJLabel);
		cx.add(idClienteJText);
		cx.add(idJLabel);
		cx.add(idJText);
		cx.add(valorJLabel);
		cx.add(valorJText);
		cx.add(bt);
		// Registro no listener dos objetos controlados
		bt.addActionListener(this);
		// Ajustes finais do frame
		setSize(320, 210);
		setLocation(600, 250);
		setTitle("Incluir pedido");
		setVisible(true);
	}

	// Implementacao do metodo da interface ActionListener
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == bt)
		{
			String id = valorJText.getText();
			try
			{
				// obtem conexao com o banco
				AcessoBD bd = new AcessoBD();
				conn = bd.obtemConexao();
				// *** IMPORTANTE ***: Força o uso de transação.
				conn.setAutoCommit(false);
				
				int idCliente = Integer.parseInt(idClienteJText.getText());	
				
				int idPedido = Integer.parseInt(idJText.getText());
				Double valorPedido = Double.parseDouble(valorJText.getText());
				pd = new Pedido(idPedido, date, valorPedido);
				pd.incluir(idCliente, conn);
				conn.commit();
				dispose();
			} catch (Exception event)
			{
				event.printStackTrace();
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
			dispose();
		}
	}

	static void incluir(JFrame fr)
	{
		TelaIncluirPedido dc = new TelaIncluirPedido(fr);
	}
}
