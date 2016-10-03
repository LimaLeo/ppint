import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingConstants;

public class MenuFrameV2 extends JFrame {
	private final Color colorValues[] = { Color.BLACK, Color.BLUE, Color.RED, Color.GREEN };
	private JRadioButtonMenuItem colorItems[]; // itens do menu Color
	private JRadioButtonMenuItem fonts[]; // itens do menu Font
	private JCheckBoxMenuItem styleItems[]; // itens do menu Font Style
	private JLabel displayJLabel; // exibe texto de exemplo
	private ButtonGroup fontButtonGroup; // gerencia itens do menu Font
	private ButtonGroup colorButtonGroup; // gerencia itens do menu Color
	private int style; // utilizado para criar estilos de fontes
	private ResourceBundle bn = null;
	
	// construtor sem argumento para configurar a GUI

	public MenuFrameV2() {
		super("Using JMenus");
		bn = ResourceBundle.getBundle("trad", new Locale("pt", "BR"));
		
		JMenu fileMenu = new JMenu(bn.getString("tela2.file.jmenu")); // cria o menu File ou configura o Alt + F
		fileMenu.setMnemonic('F'); // configura o mnem�nico como F
		// cria item de menu About...
		JMenuItem aboutItem = new JMenuItem(bn.getString("tela2.about.jmenuitem"));
		aboutItem.setMnemonic('A'); // configura o mnem�nico com A
		fileMenu.add(aboutItem); // adiciona o item about ao menu File
		aboutItem.addActionListener(new ActionListener() // classe interna
															// an�nima
		{
			// exibe um di�logo de mensagem quando o usu�rio seleciona About...
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(MenuFrameV2.this, bn.getString("tela2.about.message"), bn.getString("tela2.about.title.message"),
						JOptionPane.PLAIN_MESSAGE);
			} // fim do m�todo actionPerformed
		} // fim da classe interna an�nima
		); // fim da chamada para addActionListener

		JMenuItem exitItem = new JMenuItem(bn.getString("tela2.exit.jmenuitem")); // cria o item exit
		exitItem.setMnemonic('x'); // configura o mnem�nico como x
		fileMenu.add(exitItem); // adiciona o item exit ao menu File
		exitItem.addActionListener(new ActionListener() // classe interna
														// an�nima
		{
			// termina o aplicativo quando o usu�rio clica exitItem
			public void actionPerformed(ActionEvent event) {
				System.exit(0); // encerra o aplicativo
			} // fim do m�todo actionPerformed
		} // fim da classe interna an�nima
		); // fim da chamada para addActionListener
		JMenuBar bar = new JMenuBar(); // cria a barra de menus
		setJMenuBar(bar); // adiciona uma barra de menus ao aplicativo
		bar.add(fileMenu); // adiciona o menu File � barra de menus
		JMenu formatMenu = new JMenu(bn.getString("tela2.format.jmenu")); // cria o menu Format
		formatMenu.setMnemonic('r'); // configura o mnem�nico como r
		// array listando cores de string
		String colors[] = { bn.getString("tela2.colors.black"), bn.getString("tela2.colors.blue"), bn.getString("tela2.colors.red"), bn.getString("tela2.colors.green") };
		JMenu colorMenu = new JMenu(bn.getString("tela2.color.jmenu")); // cria o menu Color
		colorMenu.setMnemonic('C'); // configura o mnem�nico como C
		// cria itens do menu Color com bot�es de op��o
		colorItems = new JRadioButtonMenuItem[colors.length];
		colorButtonGroup = new ButtonGroup(); // gerencia cores
		ItemHandler itemHandler = new ItemHandler(); // handler para cores
		// cria itens do menu Color com bot�es de op��o
		for (int count = 0; count < colors.length; count++) {
			colorItems[count] = new JRadioButtonMenuItem(colors[count]); // cria
																			// o
																			// item
			colorMenu.add(colorItems[count]); // adiciona o item ao menu Color
			colorButtonGroup.add(colorItems[count]); // adiciona ao grupo
			colorItems[count].addActionListener(itemHandler);
		} // fim do for
		colorItems[0].setSelected(true); // seleciona o primeiro item Color
		formatMenu.add(colorMenu); // adiciona o menu Color ao menu Format
		formatMenu.addSeparator(); // adiciona um separador no menu
		// array listando nomes de fonte
		String fontNames[] = { "Serif", "Monospaced", "SansSerif" };
		JMenu fontMenu = new JMenu(bn.getString("tela2.font.jmenu")); // cria a fonte do menu
		fontMenu.setMnemonic('n'); // configura o mnem�nico como n
		// cria itens do menu radiobutton para nomes de fonte
		fonts = new JRadioButtonMenuItem[fontNames.length];
		fontButtonGroup = new ButtonGroup(); // gerencia os nomes das fontes
		// criar itens do menu Font com bot�es de op��o
		for (int count = 0; count < fonts.length; count++) {
			fonts[count] = new JRadioButtonMenuItem(fontNames[count]);
			fontMenu.add(fonts[count]); // adiciona fonte ao menu Font
			fontButtonGroup.add(fonts[count]); // adiciona ao grupo de bot�es
			fonts[count].addActionListener(itemHandler); // adiciona handler
		} // fim do for
		fonts[0].setSelected(true); // seleciona o primeiro item do menu Font
		fontMenu.addSeparator(); // adiciona uma barra separadora ao menu Font
		String styleNames[] = { bn.getString("tela2.fonts.bold"), bn.getString("tela2.fonts.italic") }; // nomes dos estilos
		styleItems = new JCheckBoxMenuItem[styleNames.length];
		StyleHandler styleHandler = new StyleHandler(); // handler de estilo
		// criar itens do menu Style com caixas de sele��o
		for (int count = 0; count < styleNames.length; count++) {
			styleItems[count] = new JCheckBoxMenuItem(styleNames[count]); // para
																			// estilo
			fontMenu.add(styleItems[count]); // adiciona ao menu Font
			styleItems[count].addItemListener(styleHandler); // handler
		} // fim do for
		formatMenu.add(fontMenu); // adiciona o menu Font ao menu Format
		bar.add(formatMenu); // adiciona o menu Format � barra de menus
		
		JMenu idiomaMenu = new JMenu("Idiomas"); // cria o menu
		idiomaMenu.setMnemonic('I'); // configura o mnem�nic como I
		// cria item de menu idioma
		JMenuItem portuguesItems = new JMenuItem("Portugu�s");
		portuguesItems.setMnemonic('P');// configura atalho

		idiomaMenu.add(portuguesItems); // adiciona o menu Font ao menu Format
		bar.add(idiomaMenu); // adiciona o menu Format � barra de menus
		portuguesItems.addActionListener(new ActionListener() // classe interna
				// an�nima
		{
			// exibe um di�logo de mensagem quando o usu�rio seleciona About...
			public void actionPerformed(ActionEvent event) {
				bn = ResourceBundle.getBundle("trad", new Locale("pt", "BR"));
			} // fim do m�todo actionPerformed
		} // fim da classe interna an�nima
		); // fim da chamada para addActionListener
		
		JMenuItem englishItems = new JMenuItem("English");
		englishItems.setMnemonic('E');// configura atalho

		idiomaMenu.add(englishItems); // adiciona o menu Font ao menu Format
		englishItems.addActionListener(new ActionListener() // classe interna
				// an�nima
		{
			// exibe um di�logo de mensagem quando o usu�rio seleciona About...
			public void actionPerformed(ActionEvent event) {
				bn = ResourceBundle.getBundle("trad", Locale.US);
			} // fim do m�todo actionPerformed
		} // fim da classe interna an�nima
		); // fim da chamada para addActionListener
		
		JMenuItem francaiseItems = new JMenuItem("Fran�aise");
		francaiseItems.setMnemonic('F');// configura atalho

		idiomaMenu.add(francaiseItems); // adiciona o menu Font ao menu Format
		francaiseItems.addActionListener(new ActionListener() // classe interna
				// an�nima
		{
			// exibe um di�logo de mensagem quando o usu�rio seleciona About...
			public void actionPerformed(ActionEvent event) {
				bn = ResourceBundle.getBundle("trad", Locale.FRANCE);
			} // fim do m�todo actionPerformed
		} // fim da classe interna an�nima
		); // fim da chamada para addActionListener
		
		JMenuItem italianoItems = new JMenuItem("Italiano");
		italianoItems.setMnemonic('P');// configura atalho

		idiomaMenu.add(italianoItems); // adiciona o menu Font ao menu Format
		italianoItems.addActionListener(new ActionListener() // classe interna
				// an�nima
		{
			// exibe um di�logo de mensagem quando o usu�rio seleciona About...
			public void actionPerformed(ActionEvent event) {
				bn = ResourceBundle.getBundle("trad", new Locale("pt", "BR"));
			} // fim do m�todo actionPerformed
		} // fim da classe interna an�nima
		); // fim da chamada para addActionListener
		
		
		// configura o r�tulo para exibir texto
		displayJLabel = new JLabel(bn.getString("tela2.sampletext.jlabel"), SwingConstants.CENTER);
		displayJLabel.setForeground(colorValues[0]);
		displayJLabel.setFont(new Font("Serif", Font.PLAIN, 72));
		getContentPane().setBackground(Color.CYAN); // configura o fundo
		add(displayJLabel, BorderLayout.CENTER); // adiciona displayJLabel
		setTitle(bn.getString("tela2.titulo.header"));
	} // fim do construtor de MenuFrame
		// classe interna para tratar eventos de a��o dos itens de menu

	private class ItemHandler implements ActionListener {
		// processa sele��es de cor e fonte
		public void actionPerformed(ActionEvent event) {
			// processa a sele��o de cor
			for (int count = 0; count < colorItems.length; count++) {
				if (colorItems[count].isSelected()) {
					displayJLabel.setForeground(colorValues[count]);
					break;
				} // fim do if
			} // fim do for
				// processa a sele��o de fonte
			for (int count = 0; count < fonts.length; count++) {
				if (event.getSource() == fonts[count]) {
					displayJLabel.setFont(new Font(fonts[count].getText(), style, 72));
				} // fim do if
			} // fim do for
			repaint(); // redesenha o aplicativo
		} // fim do m�todo actionPerformed
	} // fim da classe ItemHandler
		// classe interna para tratar eventos dos itens de menu com caixa de
		// sele��o

	private class StyleHandler implements ItemListener {
		// processa sele��es de estilo da fonte
		public void itemStateChanged(ItemEvent e) {
			style = 0; // inicializa o estilo
			// verifica se negrito foi selecionado
			if (styleItems[0].isSelected())
				style += Font.BOLD; // adiciona negrito ao estilo
			// verifica se it�lico foi selecionado
			if (styleItems[1].isSelected())
				style += Font.ITALIC; // adiciona it�lico ao estilo
			displayJLabel.setFont(new Font(displayJLabel.getFont().getName(), style, 72));
			repaint(); // redesenha o aplicativo
		} // fim do m�todo itemStateChanged
	} // fim da classe StyleHandler
} // fim da classe MenuFrame
