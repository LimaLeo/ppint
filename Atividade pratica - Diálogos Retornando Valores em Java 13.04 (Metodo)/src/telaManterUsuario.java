
// Exemplo de Diálogo por Método - Teste
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class telaManterUsuario extends JFrame implements ActionListener
{
	// Botão
	JButton bCadastro;
	JButton bLogin;

	// Método Construtor
	public telaManterUsuario()
	{
		// Cria um Conteiner de Tela
		Container c = getContentPane();
		// Determina a tela como um FlowLayout
		c.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		// Cria um Botão com o texto "Cadastrar usuário"
		bCadastro = new JButton("Cadastrar usuário");
		// Adiona o Botão no Conteiner
		c.add(bCadastro);
		// Adiciona uma ação ao Botão
		bCadastro.addActionListener(this);
		// Cria um Botão com o texto "Realizar login"
		bLogin = new JButton("Realizar login");
		// Adiona o Botão no Conteiner
		c.add(bLogin);
		// Adiciona uma ação ao Botão
		bLogin.addActionListener(this);
		// Programa o tamanho inicial do FlowLayout em pxls
		setSize(350, 120);
		// Determina a localização inicial do FlowLayout em pxls
		setLocation(470, 50);
		// Determina qual o título do FlowLayout
		setTitle("Manter usuário");
		// Estabelece que o FlowLayout será visível inicialmente
		setVisible(true);
	}

	// Método de tratamento do evento da ação do botão
	public void actionPerformed(ActionEvent e)
	{
		// Verifica se o evento pertence ao botão
		if (e.getSource() == bCadastro)
		{
			// Apresenta o atributo valor (de Dialogo)
			telaCadastro a = new telaCadastro(this);
		}
		// Verifica se o evento pertence ao botão
		if (e.getSource() == bLogin)
		{
			// Apresenta o atributo valor (de Dialogo)
			telaLogin b = new telaLogin(this);
		}
	}

	// Método Principal
	public static void main(String args[])
	{
		// Instancia um objeto de telaManterUsuario
		telaManterUsuario prog = new telaManterUsuario();
		// Programa encerramento do Frame no Sair (X)
		prog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}