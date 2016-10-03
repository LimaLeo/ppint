import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class TelaPrincipal extends JFrame 
{
	public TelaPrincipal()
	{
		super("Tela principal");
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JMenu fileMenu = new JMenu("Arquivo"); // cria o menu File ou configura o Alt + F
		fileMenu.setMnemonic('F'); // configura o mnemônico como F
		// cria item de menu About...
		JMenuItem aboutItem = new JMenuItem("Sobre...");
		aboutItem.setMnemonic('A'); // configura o mnemônico com A
		fileMenu.add(aboutItem); // adiciona o item about ao menu File
		aboutItem.addActionListener(new ActionListener() // classe interna
															// anônima
		{
			// exibe um diálogo de mensagem quando o usuário seleciona About...
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(TelaPrincipal.this, "Sistema de vendas", "Sobre",
						JOptionPane.PLAIN_MESSAGE);
			} // fim do método actionPerformed
		} // fim da classe interna anônima
		); // fim da chamada para addActionListener

		JMenuItem exitItem = new JMenuItem("Sair"); // cria o item exit
		exitItem.setMnemonic('x'); // configura o mnemônico como x
		fileMenu.add(exitItem); // adiciona o item exit ao menu File
		exitItem.addActionListener(new ActionListener() // classe interna
														// anônima
		{
			// termina o aplicativo quando o usuário clica exitItem
			public void actionPerformed(ActionEvent event) {
				System.exit(0); // encerra o aplicativo
			} // fim do método actionPerformed
		} // fim da classe interna anônima
		); // fim da chamada para addActionListener
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		bar.add(fileMenu);
		
		JMenu ClienteMenu = new JMenu("Cliente"); 
		ClienteMenu.setMnemonic('C');
		
		JMenuItem incluirCliente = new JMenuItem("Incluir");
		incluirCliente.setMnemonic('I'); // configura o mnemônico com i
		ClienteMenu.add(incluirCliente);
		incluirCliente.addActionListener(new ActionListener() // classe interna
															// anônima
		{
			// exibe um diálogo de mensagem quando o usuário seleciona Incluir...
			public void actionPerformed(ActionEvent event) {
				TelaIncluirCliente.incluir(null);
			} // fim do método actionPerformed
		} 
		);
		
		JMenuItem deletarCliente = new JMenuItem("Deletar");
		deletarCliente.setMnemonic('A'); // configura o mnemônico com A
		ClienteMenu.add(deletarCliente); // adiciona o item about ao menu File
		deletarCliente.addActionListener(new ActionListener() // classe interna
															// anônima
		{
			// exibe um diálogo de mensagem quando o usuário seleciona Incluir...
			public void actionPerformed(ActionEvent event) {
				TelaDeletarCliente.carregar(null);
			} // fim do método actionPerformed
		} 
		);
		
		bar.add(ClienteMenu);
		
		JMenu pedidoMenu = new JMenu("Pedido"); 
		pedidoMenu.setMnemonic('P');
		
		JMenuItem incluirPedido = new JMenuItem("Incluir");
		incluirPedido.setMnemonic('I'); // configura o mnemônico com i
		pedidoMenu.add(incluirPedido);
		incluirPedido.addActionListener(new ActionListener() // classe interna
															// anônima
		{
			// exibe um diálogo de mensagem quando o usuário seleciona Incluir...
			public void actionPerformed(ActionEvent event) {
				TelaIncluirPedido.incluir(null);
			} // fim do método actionPerformed
		} 
		);
		
		bar.add(pedidoMenu);
		
		setSize(300, 100);
		setLocation(350, 200);
		setVisible(true);
	}
}
