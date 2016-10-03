import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class telaCadastro extends JDialog implements ActionListener
{
	private JButton bt;
	private JTextField loginJText;
	private JPasswordField senhaJText;
	private JLabel loginJLabel;
	private JLabel senhaJLabel;

	private CreateLoginFile application;
	public telaCadastro(JFrame fr)
	{
		// Invoca o método construtor da superclasse
		super(fr, true);
		Container cx = getContentPane();
		cx.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		// Instânciação dos objetos
		bt = new JButton("Salvar");
		getRootPane().setDefaultButton(bt);
		loginJLabel = new JLabel("Login:  ");
		loginJText = new JTextField(15);
		senhaJLabel = new JLabel("Senha: ");
		senhaJText = new JPasswordField(15);

		application = new CreateLoginFile();
		application.openFile();
		
		// InclusÃ£o no container
		cx.add(loginJLabel);
		cx.add(loginJText);
		cx.add(senhaJLabel);
		cx.add(senhaJText);
		cx.add(bt);
		// Registro no listener dos objetos controlados
		bt.addActionListener(this);
		// Ajustes finais do frame
		setSize(273, 180);
		setLocation(600, 250);
		setTitle("Cadastrar usuário");
		setVisible(true);
	}

	// Implementacao do metodo da interface ActionListener
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == bt)
		{	
            String login = loginJText.getText();
            String senha = new String(senhaJText.getPassword()).trim();

			application.addRecords(login, senha);
			application.closeFile();
			dispose();
		}
	}
	
	// Método para acessar o atributo Valor
	static void cadastro(JFrame fr)
	{
		telaCadastro dc = new telaCadastro(fr);
	}
}
