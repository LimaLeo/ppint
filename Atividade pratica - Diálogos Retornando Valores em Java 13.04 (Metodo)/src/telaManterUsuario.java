
// Exemplo de Di�logo por M�todo - Teste
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class telaManterUsuario extends JFrame implements ActionListener
{
	// Bot�o
	JButton bCadastro;
	JButton bLogin;

	// M�todo Construtor
	public telaManterUsuario()
	{
		// Cria um Conteiner de Tela
		Container c = getContentPane();
		// Determina a tela como um FlowLayout
		c.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		// Cria um Bot�o com o texto "Cadastrar usu�rio"
		bCadastro = new JButton("Cadastrar usu�rio");
		// Adiona o Bot�o no Conteiner
		c.add(bCadastro);
		// Adiciona uma a��o ao Bot�o
		bCadastro.addActionListener(this);
		// Cria um Bot�o com o texto "Realizar login"
		bLogin = new JButton("Realizar login");
		// Adiona o Bot�o no Conteiner
		c.add(bLogin);
		// Adiciona uma a��o ao Bot�o
		bLogin.addActionListener(this);
		// Programa o tamanho inicial do FlowLayout em pxls
		setSize(350, 120);
		// Determina a localiza��o inicial do FlowLayout em pxls
		setLocation(470, 50);
		// Determina qual o t�tulo do FlowLayout
		setTitle("Manter usu�rio");
		// Estabelece que o FlowLayout ser� vis�vel inicialmente
		setVisible(true);
	}

	// M�todo de tratamento do evento da a��o do bot�o
	public void actionPerformed(ActionEvent e)
	{
		// Verifica se o evento pertence ao bot�o
		if (e.getSource() == bCadastro)
		{
			// Apresenta o atributo valor (de Dialogo)
			telaCadastro a = new telaCadastro(this);
		}
		// Verifica se o evento pertence ao bot�o
		if (e.getSource() == bLogin)
		{
			// Apresenta o atributo valor (de Dialogo)
			telaLogin b = new telaLogin(this);
		}
	}

	// M�todo Principal
	public static void main(String args[])
	{
		// Instancia um objeto de telaManterUsuario
		telaManterUsuario prog = new telaManterUsuario();
		// Programa encerramento do Frame no Sair (X)
		prog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}