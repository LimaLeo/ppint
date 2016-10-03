
// Exemplo de Diálogo por Método
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DialogoM extends JDialog implements ActionListener
{
	// Rótulo
	JLabel lb;
	// Campo Texto
	JTextField tf;
	// Botão
	JButton bt;
	// Atributo de valor
	int valor;

	// Método Construtor
	private DialogoM(JFrame fr)
	{
		// Invoca o método construtor da superclasse
		super(fr, true);
		// Cria um Conteiner de Tela
		Container cp = getContentPane();
		// Determina a tela como um FlowLayout
		cp.setLayout(new FlowLayout());
		// Cria um Rótulo com o texto "Valor"
		lb = new JLabel("Valor:");
		// Adiciona o Rótulo no Conteiner
		cp.add(lb);
		// Cria um Campo Texto de largura 10 pxls
		tf = new JTextField(10);
		// Adiciona o Campo Texto no Conteiner
		cp.add(tf);
		// Cria um Botão com o texto "OK"
		bt = new JButton("OK");
		// Adiona o Botão no Conteiner
		cp.add(bt);
		// Adiciona uma ação ao Botão
		bt.addActionListener(this);
		getRootPane().setDefaultButton(bt);
		// bt.addKeyListener(new KeyListener()
		// {
		//
		// @Override
		// public void keyTyped(KeyEvent e)
		// {
		// // TODO Auto-generated method stub
		//// if(e.getKeyCode() == KeyEvent.VK_ENTER)
		//// System.out.println("key typed");
		// }
		//
		// @Override
		// public void keyReleased(KeyEvent e)
		// {
		// // TODO Auto-generated method stub
		// if(e.getKeyCode() == KeyEvent.VK_ENTER)
		// System.out.println("key released");
		// }
		//L
		// @Override
		// public void keyPressed(KeyEvent e)
		// {
		// // TODO Auto-generated method stub
		// if(e.getKeyCode() == KeyEvent.VK_ENTER)
		// System.out.println("key pressed");
		// }
		// };);
		// Programa o tamanho inicial do FlowLayout em pxls
		setSize(200, 100);
		// Determina a localização inicial do FlowLayout em pxls
		setLocation(200, 200);
		// Determina qual o título do FlowLayout
		setTitle("Valores");
		// Estabelece que o FlowLayout será visível inicialmente
		setVisible(true);
	}

	// Método de tratamento do evento da ação do botão
	public void actionPerformed(ActionEvent e)
	{
		// Verifica se o evento pertence ao botão
		if (e.getSource() == bt)
		{
			// Lê o valor constante no campo texto e o atribui a valor
			valor = Integer.parseInt(tf.getText());
			// Fecha e Libera o FlowLayout
			dispose();
		}
	}

	// Método para acessar o atributo Valor
	static int getValor(JFrame fr)
	{
		DialogoM dl = new DialogoM(fr);
		return dl.valor;
	}
}