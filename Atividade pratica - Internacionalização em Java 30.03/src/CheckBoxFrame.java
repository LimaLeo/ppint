
// Fig. 11.17: CheckBoxFrame.java
// Creating JCheckBox buttons.
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;

public class CheckBoxFrame extends JFrame {
	private JTextField textField; // exibe o texto na altera��o de fontes
	private JCheckBox boldJCheckBox; // para selecionar/desselecionar negrito
	private JCheckBox italicJCheckBox; // para selecionar/desselecionar it�lico
	private ResourceBundle bn = null;
	
	private String idioma[] = {"Portugu�s", "English", "Fran�aise", "Italiano"}; 
	private JRadioButtonMenuItem idiomaItems[];//itens menu idioma
	private ButtonGroup idiomaButtonGroup;//gerencia os idiomas
	// construtor CheckBoxFrame adiciona JCheckBoxes ao JFrame
	public CheckBoxFrame() {
		int op = Integer.parseInt(
				JOptionPane.showInputDialog("Idioma - Language - Langue - Lingua\n\n1- Portugu�s\n2- English\n3- Fran�aise\n4- Italiano\n "));
		// Carga dos arquivos de internacionaliza��o
		switch (op) {
		case 1:
			bn = ResourceBundle.getBundle("trad", new Locale("pt", "BR"));
			break;
		case 2:
			bn = ResourceBundle.getBundle("trad", Locale.US);
			break;
		case 3:
			bn = ResourceBundle.getBundle("trad", Locale.FRANCE);
			break;
		case 4:
			bn = ResourceBundle.getBundle("trad", Locale.ITALY);
			break;
		default:
			bn = ResourceBundle.getBundle("trad");
			break;
		}

		setLayout(new FlowLayout()); // configura o layout de frame
		// configura JTextField e sua fonte
		textField = new JTextField(bn.getString("tela1.text.placeholder"), 20);
		textField.setFont(new Font("Serif", Font.PLAIN, 14));
		add(textField); // adiciona textField ao JFrame
		boldJCheckBox = new JCheckBox(bn.getString("tela1.fonts.bold")); // cria caixa de sele��o p/
												// negrito
		italicJCheckBox = new JCheckBox(bn.getString("tela1.fonts.italic")); // cria it�lico
		add(boldJCheckBox); // adiciona caixa de sele��o de negrito ao JFrame
		add(italicJCheckBox); // adiciona caixa de sele��o de it�lico ao JFrame
		// listeners registradores para JCheckBoxes
		CheckBoxHandler handler = new CheckBoxHandler();
		boldJCheckBox.addItemListener(handler);
		italicJCheckBox.addItemListener(handler);
		setTitle(bn.getString("tela1.titulo.header"));
	} // fim

	private class CheckBoxHandler implements ItemListener {
		private int valBold = Font.PLAIN; // controla o estilo de fonte negrito
		private int valItalic = Font.PLAIN; // controla o estilo de fonte
											// it�lico
		// responde aos eventos de caixa de sele��o

		public void itemStateChanged(ItemEvent event) {
			// processa eventos da caixa de sele��o de negrito
			if (event.getSource() == boldJCheckBox)
				valBold = boldJCheckBox.isSelected() ? Font.BOLD : Font.PLAIN;

			// processa eventos da caixa de sele��o de it�lico
			if (event.getSource() == italicJCheckBox)
				valItalic = italicJCheckBox.isSelected() ? Font.ITALIC : Font.PLAIN;
			// configura a fonte do campo de texto
			textField.setFont(new Font("Serif", valBold + valItalic, 14));
		} // fim do m�todo itemStateChanged
	} // fim da classe CheckBoxHandler interna private
} // fim da classe CheckBoxFrame