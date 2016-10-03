import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaDeletarCliente extends JDialog implements ActionListener
{
	Connection conn = null;
	private JButton bt;
	private JTextField idJText;
	private JLabel idJLabel;
	Cliente cl;

	public TelaDeletarCliente(JFrame fr)
	{
		// Invoca o método construtor da superclasse
		super(fr, true);
		Container cx = getContentPane();
		cx.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		// Instânciação dos objetos
		bt = new JButton("Excluir");
		getRootPane().setDefaultButton(bt);
		idJLabel = new JLabel("Id: ");
		idJText = new JTextField(15);

		// adiciona ao container
		cx.add(idJLabel);
		cx.add(idJText);
		cx.add(bt);
		// Registro no listener dos objetos controlados
		bt.addActionListener(this);
		// Ajustes finais do frame
		setSize(300, 140);
		setLocation(600, 250);
		setTitle("Deletar cliente");
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
				int id = Integer.parseInt(idJText.getText());
				cl = new Cliente(id);
				cl.carregar(conn);
				Object[] options = { "Confirmar", "Cancelar" };
				int resposta = JOptionPane.showOptionDialog(null, "Clique Confirmar para continuar", "Informação", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				if(resposta==0)
				{
					cl.excluir(conn);
		            conn.commit();
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Obrigado!");
					dispose();
				}
				
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
			dispose();
		}
	}
	
	static void carregar(JFrame fr)
	{
		TelaDeletarCliente dc = new TelaDeletarCliente(fr);
	}
}
