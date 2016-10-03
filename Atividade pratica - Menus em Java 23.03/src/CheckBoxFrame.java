// Fig. 11.17: CheckBoxFrame.java
// Creating JCheckBox buttons.
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class CheckBoxFrame extends JFrame {
	private JTextField textField; // exibe o texto na alteração de fontes
	private JCheckBox boldJCheckBox; // para selecionar/desselecionar negrito
	private JCheckBox italicJCheckBox; // para selecionar/desselecionar itálico
	// construtor CheckBoxFrame adiciona JCheckBoxes ao JFrame

	public CheckBoxFrame() {
		super("Teste JCheckBox");
		setLayout(new FlowLayout()); // configura o layout de frame
		// configura JTextField e sua fonte
		textField = new JTextField("Veja a mudança do estilo da fonte", 20);
		textField.setFont(new Font("Serif", Font.PLAIN, 14));
		add(textField); // adiciona textField ao JFrame
		boldJCheckBox = new JCheckBox("Bold"); // cria caixa de seleção p/
												// negrito
		italicJCheckBox = new JCheckBox("Italic"); // cria itálico
		add(boldJCheckBox); // adiciona caixa de seleção de negrito ao JFrame
		add(italicJCheckBox); // adiciona caixa de seleção de itálico ao JFrame
		// listeners registradores para JCheckBoxes
		CheckBoxHandler handler = new CheckBoxHandler();
		boldJCheckBox.addItemListener(handler);
		italicJCheckBox.addItemListener(handler);
	} // fim do construtor CheckBoxFrame
		// classe interna private para tratamento de evento ItemListener

	private class CheckBoxHandler implements ItemListener {
		private int valBold = Font.PLAIN; // controla o estilo de fonte negrito
		private int valItalic = Font.PLAIN; // controla o estilo de fonte
											// itálico
		// responde aos eventos de caixa de seleção

		public void itemStateChanged(ItemEvent event) {
			// processa eventos da caixa de seleção de negrito
			if (event.getSource() == boldJCheckBox)
				valBold = boldJCheckBox.isSelected() ? Font.BOLD : Font.PLAIN;

			// processa eventos da caixa de seleção de itálico
			if (event.getSource() == italicJCheckBox)
				valItalic = italicJCheckBox.isSelected() ? Font.ITALIC : Font.PLAIN;
			// configura a fonte do campo de texto
			textField.setFont(new Font("Serif", valBold + valItalic, 14));
		} // fim do método itemStateChanged
	} // fim da classe CheckBoxHandler interna private
} // fim da classe CheckBoxFrame