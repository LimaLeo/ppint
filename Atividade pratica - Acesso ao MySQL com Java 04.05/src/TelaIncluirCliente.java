import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaIncluirCliente extends JDialog implements ActionListener
{
	Connection conn = null;
	private JButton bt;
	private JTextField idJText, nomeJText, telefoneJText;
	private JLabel idJLabel, nomeJLabel, telefoneJLabel;
	Cliente cl;

	public TelaIncluirCliente(JFrame fr)
	{
		// Invoca o método construtor da superclasse
		super(fr, true);
		Container cx = getContentPane();
		cx.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		// Instânciação dos objetos
		bt = new JButton("Salvar");
		getRootPane().setDefaultButton(bt);
		idJLabel = new JLabel("Id:  ");
		idJText = new JTextField(15);
		nomeJLabel = new JLabel("Nome:  ");
		nomeJText = new JTextField(15);
		telefoneJLabel = new JLabel("Telefone: ");
		telefoneJText = new JTextField(15);

		// adiciona ao container
		cx.add(idJLabel);
		cx.add(idJText);
		cx.add(nomeJLabel);
		cx.add(nomeJText);
		cx.add(telefoneJLabel);
		cx.add(telefoneJText);
		cx.add(bt);
		// Registro no listener dos objetos controlados
		bt.addActionListener(this);
		// Ajustes finais do frame
		setSize(300, 220);
		setLocation(600, 250);
		setTitle("Incluir cliente");
		setVisible(true);
	}
	// Implementacao do metodo da interface ActionListener
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == bt)
		{	
			try {
				// obtem conexao com o banco
				AcessoBD bd = new AcessoBD();
				conn = bd.obtemConexao();
				// *** IMPORTANTE ***: Força o uso de transação.
				conn.setAutoCommit(false);
				String nome = nomeJText.getText();
	            String telefone = telefoneJText.getText();
	            int idCliente = Integer.parseInt(idJText.getText());
	            cl = new Cliente(idCliente,nome, telefone);
	            cl.incluir(conn);
	            conn.commit();
				dispose();
			} catch (Exception event) {
				event.printStackTrace();
				if (conn != null) {
					try {
						conn.rollback();
					} catch (SQLException e1) {
						System.out.print(e1.getStackTrace());
					}
				}
			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e1) {
						System.out.print(e1.getStackTrace());
					}
				}
			}
		}
	}
	
	static void incluir(JFrame fr)
	{
		TelaIncluirCliente dc = new TelaIncluirCliente(fr);
	}
}
