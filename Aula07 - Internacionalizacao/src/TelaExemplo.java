import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaExemplo extends JFrame implements ActionListener {
	private JButton bt;
	private JTextField tx;
	private JLabel rt;
	private ResourceBundle bn = null;

	public TelaExemplo() { // Menu simples de escolha de idioma
		int op = Integer.parseInt(
				JOptionPane.showInputDialog("Idioma - Language - Langue\n\n1- Português\n2- English\n3- Française\n "));
		// Carga dos arquivos de internacionalização
		switch (op) {
		case 1:
			bn = ResourceBundle.getBundle("ex1", new Locale("pt", "BR"));
			break;
		case 2:
			bn = ResourceBundle.getBundle("ex1", Locale.US);
			break;
		case 3:
			bn = ResourceBundle.getBundle("ex1", Locale.FRANCE);
			break;
		default:
			bn = ResourceBundle.getBundle("ex1");
			break;
		}
		// Escolhe Layout do conteiner
		Container cx = getContentPane();
		cx.setLayout(new FlowLayout());
		// Instânciação dos objetos
		bt = new JButton(bn.getString("tela1.botao.calcular"));
		rt = new JLabel(bn.getString("tela1.rotulo.valor") + ":");
		tx = new JTextField(10);
		// InclusÃ£o no container
		cx.add(rt);
		cx.add(tx);
		cx.add(bt);
		// Registro no listener dos objetos controlados
		bt.addActionListener(this);
		// Ajustes finais do frame
		setTitle(bn.getString("tela1.titulo"));
		setSize(193, 104);
		setVisible(true);
	}

	// Implementacao do metodo da interface ActionListener
	public void actionPerformed(ActionEvent e) {
		if (tx.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, bn.getString("mensagem.valor.nulo"), bn.getString("tela1.erro.titulo"),
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void main(String args[]) {
		TelaExemplo exemplo = new TelaExemplo();
		exemplo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}