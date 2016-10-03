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
	private Vetor v;
	public TelaPrincipal()
	{
		super("Tela principal");
		// instancia o container
		Container c = getContentPane();
		// edita para flow layout
		c.setLayout(new FlowLayout());

		// cria um t�pico menu
		JMenu vetor = new JMenu("Vetor");
		// configura mnemonico
		vetor.setMnemonic('V');

		// cria um item de menu
		JMenuItem dimensiona = new JMenuItem("Dimensiona");
		// adiciona item de menu ao t�pico menu
		vetor.add(dimensiona);
		dimensiona.addActionListener(new ActionListener() // classe interna
		// an�nima
		{
			public void actionPerformed(ActionEvent event)
			{	
				// informa o tamanho do vetor
				int tamanho = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o tamanho do vetor: ")
				);
				//instancia o vetor
				v = new Vetor(tamanho);
			} // fim do m�todo actionPerformed
		} // fim da classe interna an�nima
		);

		// cria um item de menu
		JMenuItem digita = new JMenuItem("Digita");
		// adiciona item de menu ao t�pico menu
		vetor.add(digita);
		digita.addActionListener(new ActionListener() // classe interna
		// an�nima
		{
			public void actionPerformed(ActionEvent event)
			{
				v.inserir();
			} // fim do m�todo actionPerformed
		} // fim da classe interna an�nima
		);

		// cria um item de menu
		JMenuItem apresenta = new JMenuItem("Apresenta");
		// adiciona item de menu ao t�pico menu
		vetor.add(apresenta);
		apresenta.addActionListener(new ActionListener() // classe interna
		// an�nima
		{
			public void actionPerformed(ActionEvent event)
			{
				v.mostrar();
			} // fim do m�todo actionPerformed
		} // fim da classe interna an�nima
		);

		// cria um t�pico menu
		JMenu probest = new JMenu("PROBEST");
		// configura mnemonico
		vetor.setMnemonic('P');

		// cria um item de menu
		JMenuItem media = new JMenuItem("M�dia");
		// configura mnemonic
		media.setMnemonic('M');
		// adiciona item de menu ao t�pico menu
		probest.add(media);
		media.addActionListener(new ActionListener() // classe interna
		// an�nima
		{
			public void actionPerformed(ActionEvent event)
			{
				double valor = v.media(v.getVetor());
				JOptionPane.showMessageDialog(null, "Media: " + valor);
			} // fim do m�todo actionPerformed
		} // fim da classe interna an�nima
		);

		// cria um item de menu
		JMenuItem desvioPadao = new JMenuItem("Desvio Padr�o");
		// configura mnemonic
		desvioPadao.setMnemonic('M');
		// adiciona item de menu ao t�pico menu
		probest.add(desvioPadao);
		desvioPadao.addActionListener(new ActionListener() // classe interna
		// an�nima
		{
			public void actionPerformed(ActionEvent event)
			{
				double valor = v.desvioPadao(v.getVetor());
				JOptionPane.showMessageDialog(null, "Desvio padr�o: " + valor);
			} // fim do m�todo actionPerformed
		} // fim da classe interna an�nima
		);

		// cria um item de menu
		JMenuItem variancia = new JMenuItem("Vari�ncia");
		// configura mnemonic
		variancia.setMnemonic('M');
		// adiciona item de menu ao t�pico menu
		probest.add(variancia);
		variancia.addActionListener(new ActionListener() // classe interna
		// an�nima
		{
			public void actionPerformed(ActionEvent event)
			{
				double valor = v.variancia(v.getVetor());
				JOptionPane.showMessageDialog(null, "Vari�ncia: " + valor);
			} // fim do m�todo actionPerformed
		} // fim da classe interna an�nima
		);

		// cria um item de menu
		JMenuItem mediana = new JMenuItem("Mediana");
		// configura mnemonic
		mediana.setMnemonic('M');
		// adiciona item de menu ao t�pico menu
		probest.add(mediana);
		mediana.addActionListener(new ActionListener() // classe interna
		// an�nima
		{
			public void actionPerformed(ActionEvent event)
			{
				double valor = v.mediana(v.getVetor());
				JOptionPane.showMessageDialog(null, "Mediana: " + valor);
			} // fim do m�todo actionPerformed
		} // fim da classe interna an�nima
		);

		// cria um item de menu
		JMenuItem coefAssimetria = new JMenuItem("Coef. Assimetria");
		// configura mnemonic
		coefAssimetria.setMnemonic('M');
		// adiciona item de menu ao t�pico menu
		probest.add(coefAssimetria);
		coefAssimetria.addActionListener(new ActionListener() // classe interna
		// an�nima
		{
			public void actionPerformed(ActionEvent event)
			{
				double valor = v.coefAssimetria(v.getVetor());
				JOptionPane.showMessageDialog(null, "Coef. Assimetria: " + valor);
			} // fim do m�todo actionPerformed
		} // fim da classe interna an�nima
		);

		// cria um item de menu
		JMenuItem coefVariacao = new JMenuItem("Coef. Varia��o");
		// configura mnemonic
		coefVariacao.setMnemonic('M');
		// adiciona item de menu ao t�pico menu
		probest.add(coefVariacao);
		coefVariacao.addActionListener(new ActionListener() // classe interna
		// an�nima
		{
			public void actionPerformed(ActionEvent event)
			{
				double valor = v.coefVariacao(v.getVetor());
				JOptionPane.showMessageDialog(null, "Coef. Varia��o: " + valor);
			} // fim do m�todo actionPerformed
		} // fim da classe interna an�nima
		);

		// cria um t�pico menu
		JMenu algesd = new JMenu("ALGESD");
		// configura mnemonico
		algesd.setMnemonic('C');

		// cria um item de menu
		JMenu ordenacao = new JMenu("Ordena��o");
		// configura mnemonic
		ordenacao.setMnemonic('O');
		// adiciona item de menu ao t�pico menu
		algesd.add(ordenacao);

		// cria um item de menu
		JMenu busca = new JMenu("Busca");
		// configura mnemonic
		busca.setMnemonic('B');
		// adiciona item de menu ao t�pico menu
		algesd.add(busca);

		// cria um item de menu
		JMenuItem trocas = new JMenuItem("Trocas");
		// configura mnemonic
		trocas.setMnemonic('T');
		// adiciona item de menu ao t�pico menu
		ordenacao.add(trocas);
		trocas.addActionListener(new ActionListener() // classe interna
		// an�nima
		{
			public void actionPerformed(ActionEvent event)
			{
				v.bolha(v.getVetor());
				JOptionPane.showMessageDialog(null, "Ordenado com sucesso!");
			} // fim do m�todo actionPerformed
		} // fim da classe interna an�nima
		);

		// cria um item de menu
		JMenuItem selecao = new JMenuItem("Sele��o");
		// configura mnemonic
		selecao.setMnemonic('S');
		// adiciona item de menu ao t�pico menu
		ordenacao.add(selecao);
		selecao.addActionListener(new ActionListener() // classe interna
		// an�nima
		{
			public void actionPerformed(ActionEvent event)
			{
				v.selecao(v.getVetor());
				JOptionPane.showMessageDialog(null, "Ordenado com sucesso!");
			} // fim do m�todo actionPerformed
		} // fim da classe interna an�nima
		);

		// cria um item de menu
		JMenuItem insercao = new JMenuItem("Inser��o");
		// configura mnemonic
		insercao.setMnemonic('I');
		// adiciona item de menu ao t�pico menu
		ordenacao.add(insercao);
		insercao.addActionListener(new ActionListener() // classe interna
		// an�nima
		{
			public void actionPerformed(ActionEvent event)
			{
				v.insercao(v.getVetor());
				JOptionPane.showMessageDialog(null, "Ordenado com sucesso!");
			} // fim do m�todo actionPerformed
		} // fim da classe interna an�nima
		);

		// cria um item de menu
		JMenuItem quick = new JMenuItem("Quick");
		// configura mnemonic
		quick.setMnemonic('Q');
		// adiciona item de menu ao t�pico menu
		ordenacao.add(quick);
		quick.addActionListener(new ActionListener() // classe interna
		// an�nima
		{
			public void actionPerformed(ActionEvent event)
			{
				v.quickSort(v.getVetor());
				JOptionPane.showMessageDialog(null, "Ordenado com sucesso!");
			} // fim do m�todo actionPerformed
		} // fim da classe interna an�nima
		);

		// cria um item de menu
		JMenuItem merge = new JMenuItem("Merge");
		// configura mnemonic
		merge.setMnemonic('M');
		// adiciona item de menu ao t�pico menu
		ordenacao.add(merge);
		merge.addActionListener(new ActionListener() // classe interna
		// an�nima
		{
			public void actionPerformed(ActionEvent event)
			{
				v.mergeSort(v.getVetor());
				JOptionPane.showMessageDialog(null, "Ordenado com sucesso!");
			} // fim do m�todo actionPerformed
		} // fim da classe interna an�nima
		);

		// cria um item de menu
		JMenuItem linearIterativa = new JMenuItem("Linear  Iterativa");
		// adiciona item de menu ao t�pico menu
		busca.add(linearIterativa);
		linearIterativa.addActionListener(new ActionListener() // classe interna
		// an�nima
		{
			public void actionPerformed(ActionEvent event)
			{
				double valor = Double.parseDouble(
						JOptionPane.showInputDialog("Informe o valor a ser procurado: ")
						);
				JOptionPane.showMessageDialog(null, v.buscaLinear(v.getVetor(), valor));
			} // fim do m�todo actionPerformed
		} // fim da classe interna an�nima
		);

		// cria um item de menu
		JMenuItem linearRecursiva = new JMenuItem("Linear  Recursiva");
		// adiciona item de menu ao t�pico menu
		busca.add(linearRecursiva);
		linearRecursiva.addActionListener(new ActionListener() // classe interna
		// an�nima
		{
			public void actionPerformed(ActionEvent event)
			{
				double valor = Double.parseDouble(
						JOptionPane.showInputDialog("Informe o valor a ser procurado: ")
						);
				JOptionPane.showMessageDialog(null, v.buscaLinearRecursiva(v.getVetor(), valor));
			} // fim do m�todo actionPerformed
		} // fim da classe interna an�nima
		);

		// cria um item de menu
		JMenuItem binariaIterativa = new JMenuItem("Bin�ria  Iterativa");
		// adiciona item de menu ao t�pico menu
		busca.add(binariaIterativa);
		binariaIterativa.addActionListener(new ActionListener() // classe
																// interna
		// an�nima
		{
			public void actionPerformed(ActionEvent event)
			{
				double valor = Double.parseDouble(
						JOptionPane.showInputDialog("Informe o valor a ser procurado: ")
						);
				JOptionPane.showMessageDialog(null, v.buscaBinaria(v.getVetor(), valor));
			} // fim do m�todo actionPerformed
		} // fim da classe interna an�nima
		);

		// cria um item de menu
		JMenuItem binariaRecursiva = new JMenuItem("Bin�ria Recursiva");
		// adiciona item de menu ao t�pico menu
		busca.add(binariaRecursiva);
		binariaRecursiva.addActionListener(new ActionListener() // classe
																// interna
		// an�nima
		{
			public void actionPerformed(ActionEvent event)
			{
				double valor = Double.parseDouble(
						JOptionPane.showInputDialog("Informe o valor a ser procurado: ")
						);
				JOptionPane.showMessageDialog(null, v.buscaBinariaRecursica(v.getVetor(), valor));
			} // fim do m�todo actionPerformed
		} // fim da classe interna an�nima
		);
		
		// cria um item de menu
		JMenu fileMenu = new JMenu("Arquivo");
		// configura mnemonic
		fileMenu.setMnemonic('F');
		// cria um item de menu
		JMenuItem exitItem = new JMenuItem("Sair");
		// configura mnemonic
		exitItem.setMnemonic('x');
		// adiciona item de menu ao t�pico menu
		fileMenu.add(exitItem);
		exitItem.addActionListener(new ActionListener() // classe interna
														// an�nima
		{
			// termina o aplicativo quando o usu�rio clica exitItem
			public void actionPerformed(ActionEvent event)
			{
				System.exit(0); // encerra o aplicativo
			} // fim do m�todo actionPerformed
		} // fim da classe interna an�nima
		); // fim da chamada para addActionListener
			// cria o menu

		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		// adiciona ao menu
		bar.add(vetor);
		bar.add(probest);
		bar.add(algesd);
		bar.add(fileMenu);
		
		setSize(300, 100);
		setLocation(350, 200);
		setVisible(true);
	}
}// fim da classe
