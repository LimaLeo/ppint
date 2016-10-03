import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class telaLogin extends JFrame implements ActionListener{
	private JButton bt;
	private JTextField loginJText;
	private JPasswordField senhaJText;
	private JLabel loginJLabel;
	private JLabel senhaJLabel;
	private ReadLoginFile application;
	public telaLogin() {
		Container cx = getContentPane();
		cx.setLayout(new FlowLayout());
		// Instânciação dos objetos
		bt = new JButton("Entrar");
		loginJLabel = new JLabel("Login:  ");
		loginJText = new JTextField(15);
		senhaJLabel = new JLabel("Senha: ");
		senhaJText = new JPasswordField(15);
		
		application = new ReadLoginFile();
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
		setTitle("Login");
		setSize(240, 125);
		setVisible(true);
		setLocation(600,250);
	}
	
	// Implementacao do metodo da interface ActionListener
	public void actionPerformed(ActionEvent e) {
	      if(e.getSource() == bt)
	      {
            String login = loginJText.getText();
            String senha = new String(senhaJText.getPassword()).trim();
	  		//application.readRecords();
	  		application.validaDadosLogin(login, senha);
			application.closeFile();
			System.exit(0);
	      }
	}	
}
