import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MenuFrame extends JFrame
{

	// array listando tipos de camisetas
	private String tipos[] =
	{ "Camisa", "Camiseta", "Calça", "Vestido", "Saia" };
	private JRadioButtonMenuItem tipoItems[];// item menu tipo
	private ButtonGroup tipoButtonGroup;// gerencia item do menu tipo
	private String tipoString = "#tipo#";// guarda String

	// array listando generos de camisetas
	private String generos[] =
	{ "Masculino", "Feminino", "Unisex" };
	private JRadioButtonMenuItem genreItems[];// item menu genero
	private ButtonGroup genreButtonGroup;// gerencia item do menu genero
	private String generoString = "#genero#";// guarda String

	// array listando tamanhos camisteas
	private String tamanhos[] =
	{ "PP", "P", "M", "G", "GG", "XG" };
	private JRadioButtonMenuItem sizeItems[];// item menu tamanho
	private ButtonGroup sizeButtonGroup;// gerencia item no menu tamanho
	private String tamanhoString = "#tamanho#";// guarda string

	// array listando cores das camisetas
	private String cores[] =
	{ "Vermelha", "Preta", "Amarela" };
	private JRadioButtonMenuItem colorItems[];// item menu cor
	private ButtonGroup colorButtonGroup;// gerencia item no menu cor
	private String corString = "#cor#";// guarda string

	// array listando formas de pagamento
	private String pagamentos[] =
	{ "Cheque", "Dinheiro", "Cartão de crédito", "Cartão de débito" };
	private JRadioButtonMenuItem paymentItems[];// item menu pagamento
	private ButtonGroup paymentButtonGroup;// gerencia item no menu de pagamento
	private String pagamentoString = "#pagamento#";// guarda string

	private JTextField saidaJTextField;

	public MenuFrame()
	{
		super("Pedido - Configuração pedido roupas");
		JMenu fileMenu = new JMenu("Arquivo"); // cria o menu File ou configura
												// o Alt + F
		fileMenu.setMnemonic('F'); // configura o mnemônico como F
		// cria item de menu About...
		JMenuItem aboutItem = new JMenuItem("Sobre...");
		aboutItem.setMnemonic('A'); // configura o mnemônico com A
		fileMenu.add(aboutItem); // adiciona o item about ao menu File
		aboutItem.addActionListener(new ActionListener() // classe interna
															// anônima
		{
			// exibe um diálogo de mensagem quando o usuário seleciona About...
			public void actionPerformed(ActionEvent event)
			{
				JOptionPane.showMessageDialog(MenuFrame.this,
						"Pedido - Configuração pedido roupas" + "\nPreencha o JMenu para gerar o pedido em texto:"
								+ "\n\na- Tipo: Camisa, camiseta, calça, vestido, saia etc.;"
								+ "\nb- Gênero: Masculino, Feminino e Unisex;" + "\nc- Tamanho: PP, P, M, G, GG, XG;"
								+ "\nd- Cor: Vermelha, Preta, Amarela etc.;"
								+ "\ne- Pagamento: Cheque, Dinheiro, Cartão de Crédito ou Cartão de Débito.",
						"Sobre", JOptionPane.PLAIN_MESSAGE);
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
			public void actionPerformed(ActionEvent event)
			{
				System.exit(0); // encerra o aplicativo
			} // fim do método actionPerformed
		} // fim da classe interna anônima
		); // fim da chamada para addActionListener

		JMenuBar bar = new JMenuBar(); // cria a barra de menus
		setJMenuBar(bar); // adiciona uma barra de menus ao aplicativo
		bar.add(fileMenu);
		JMenu formatMenu = new JMenu("Editar"); // cria o menu Format
		; // adiciona o menu File à barra de menus
		formatMenu.setMnemonic('r'); // configura o mnemônico como r

		JMenu tipoMenu = new JMenu("Tipo");// cria opção no menu
		tipoMenu.setMnemonic('T');// adiciona atalho
		tipoItems = new JRadioButtonMenuItem[tipos.length];// instancia item
															// menu tipo
		tipoButtonGroup = new ButtonGroup();// instancia gerenciador de item
											// menu tipo
		ItemHandler itemHandler = new ItemHandler();// handler para tipo
		for (int count = 0; count < tipos.length; count++)
		{
			tipoItems[count] = new JRadioButtonMenuItem(tipos[count]); // cria
																		// o
																		// item
			tipoMenu.add(tipoItems[count]); // adiciona o item ao menu tipos
			tipoButtonGroup.add(tipoItems[count]); // adiciona ao grupo
			tipoItems[count].addActionListener(itemHandler);
		} // fim do for
		tipoItems[0].setSelected(true);// seleciona o primeiro item tipo
		formatMenu.add(tipoMenu);// adiciona um separador no menu
		formatMenu.addSeparator(); // adiciona um separador no menu

		JMenu generoMenu = new JMenu("Genero");// cria opção no menu
		generoMenu.setMnemonic('G');// adiciona atalho
		genreItems = new JRadioButtonMenuItem[generos.length];// instancia o
																// item menu
																// genero
		genreButtonGroup = new ButtonGroup();// instancia o gerenciador de item
												// menu genero
		for (int count = 0; count < generos.length; count++)
		{
			genreItems[count] = new JRadioButtonMenuItem(generos[count]); // cria
																			// o
																			// item
			generoMenu.add(genreItems[count]); // adiciona o item ao menu genero
			genreButtonGroup.add(genreItems[count]); // adiciona ao grupo
			genreItems[count].addActionListener(itemHandler);
		} // fim do for
		genreItems[0].setSelected(true);// seleciona o segundp item genero
		formatMenu.add(generoMenu);// adiciona um separador no menu
		formatMenu.addSeparator(); // adiciona um separador no menu

		JMenu tamanhoMenu = new JMenu("Tamanho");
		tamanhoMenu.setMnemonic('T');// adiciona atalho
		sizeItems = new JRadioButtonMenuItem[tamanhos.length];// instancia o
																// item menu
																// tamanho
		sizeButtonGroup = new ButtonGroup();// instancia o gerenciador de item
											// menu tamanho
		for (int count = 0; count < tamanhos.length; count++)
		{
			sizeItems[count] = new JRadioButtonMenuItem(tamanhos[count]); // cria
																			// o
																			// item
			tamanhoMenu.add(sizeItems[count]); // adiciona o item ao menu
												// tamanho
			sizeButtonGroup.add(sizeItems[count]); // adiciona ao grupo
			sizeItems[count].addActionListener(itemHandler);
		} // fim do for
		sizeItems[0].setSelected(true);// seleciona o segundp item tamanho
		formatMenu.add(tamanhoMenu);// adiciona um separador no menu
		formatMenu.addSeparator(); // adiciona um separador no menu

		JMenu corMenu = new JMenu("Cor");
		corMenu.setMnemonic('C');// adiciona atalho
		colorItems = new JRadioButtonMenuItem[cores.length];// instancia o item
															// menu cor
		colorButtonGroup = new ButtonGroup();
		for (int count = 0; count < cores.length; count++)
		{
			colorItems[count] = new JRadioButtonMenuItem(cores[count]); // cria
																		// o
																		// item
			corMenu.add(colorItems[count]); // adiciona o item ao menu cor
			colorButtonGroup.add(colorItems[count]); // adiciona ao grupo
			colorItems[count].addActionListener(itemHandler);
		} // fim do for
		colorItems[0].setSelected(true);// seleciona o segundp item cor
		formatMenu.add(corMenu);// adiciona um separador no menu
		formatMenu.addSeparator(); // adiciona um separador no menu

		JMenu pagamentoMenu = new JMenu("Pagamento");
		pagamentoMenu.setMnemonic('P');// adiciona atalho
		paymentItems = new JRadioButtonMenuItem[pagamentos.length];// instancia
																	// o item
																	// menu
																	// pagamento
		paymentButtonGroup = new ButtonGroup();
		for (int count = 0; count < pagamentos.length; count++)
		{
			paymentItems[count] = new JRadioButtonMenuItem(pagamentos[count]); // cria
			// o
			// item
			pagamentoMenu.add(paymentItems[count]); // adiciona o item ao menu
													// pagamento
			paymentButtonGroup.add(paymentItems[count]); // adiciona ao grupo
			paymentItems[count].addActionListener(itemHandler);
		} // fim do for
		paymentItems[0].setSelected(true);// seleciona o segundp item pagamento
		formatMenu.add(pagamentoMenu);// adiciona um separador no menu
		formatMenu.addSeparator(); // adiciona um separador no menu

		saidaJTextField = new JTextField(100);
		saidaJTextField.setEditable(false);
		saidaJTextField.setText(tipoString + " " + generoString + ", " + tamanhoString + ", " + corString
				+ "e pagamento em " + pagamentoString);

		add(saidaJTextField, BorderLayout.CENTER); // adiciona displayJLabel
		bar.add(formatMenu);
	}

	private class ItemHandler implements ActionListener
	{
		// processa seleções da camiseta
		public void actionPerformed(ActionEvent event)
		{
			// processa a seleção de tipo
			for (int count = 0; count < tipoItems.length; count++)
			{
				if (tipoItems[count].isSelected())
				{
					tipoString = tipos[count];
					saidaJTextField.setText(tipoString + " " + generoString + ", " + tamanhoString + ", " + corString
							+ " e pagamento em " + pagamentoString);
					break;
				} // fim do if
			} // fim do for
				// processa a seleção de genero
			for (int count = 0; count < genreItems.length; count++)
			{
				if (genreItems[count].isSelected())
				{
					generoString = generos[count];
					saidaJTextField.setText(tipoString + " " + generoString + ", " + tamanhoString + ", " + corString
							+ " e pagamento em " + pagamentoString);
					break;
				} // fim do if
			} // fim do for

			// processa a seleção de tamanho
			for (int count = 0; count < sizeItems.length; count++)
			{
				if (sizeItems[count].isSelected())
				{
					tamanhoString = tamanhos[count];
					saidaJTextField.setText(tipoString + " " + generoString + ", " + tamanhoString + ", " + corString
							+ " e pagamento em " + pagamentoString);
					break;
				} // fim do if
			} // fim do for

			// processa a seleção de cor
			for (int count = 0; count < colorItems.length; count++)
			{
				if (colorItems[count].isSelected())
				{
					corString = cores[count];
					saidaJTextField.setText(tipoString + " " + generoString + ", " + tamanhoString + ", " + corString
							+ " e pagamento em " + pagamentoString);
					break;
				} // fim do if
			} // fim do for

			// processa a seleção de pagamento
			for (int count = 0; count < paymentItems.length; count++)
			{
				if (paymentItems[count].isSelected())
				{
					pagamentoString = pagamentos[count];
					saidaJTextField.setText(tipoString + " " + generoString + ", " + tamanhoString + ", " + corString
							+ " e pagamento em " + pagamentoString);
					break;
				} // fim do if
			} // fim do for
		} // fim do método actionPerformed
	} // fim da classe ItemHandler
		// classe interna para tratar eventos dos itens de menu com caixa de
		// seleção
} // fim da classe MenuFrame
